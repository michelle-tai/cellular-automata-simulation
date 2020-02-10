package IndividualSimulations;

import cellsociety.Simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * game of life simulation
 */
public class GoL2 extends Simulation{
    private int DEAD = 0;
    private int ALIVE = 1;
    //private Grid grid;

    /**
     * Create new game of life grid
     * @param row               row number of cell
     * @param col               column number of cell
     * @param neighbourNumber   true = all neighbours, false = only immediate
     * @param shape             String that tells if should be triangle or rectangle
     */
    public GoL2(int row, int col, boolean neighbourNumber, String shape){
        super(row, col, neighbourNumber, false, shape);
        grid.iniState(new int[]{DEAD, ALIVE});
        createIndices(row, col);
    }


    /**
     * ask grid to find the number of ALIVE and DEAD cell
     * @return      hashmap with the information
     */
    public HashMap<String, Integer> frequency() {
        HashMap<String, Integer>ret = new HashMap<>();
        ret.put("DEAD", grid.getFreq(DEAD));
        ret.put("ALIVE", grid.getFreq(ALIVE));

        return ret;
    }


    /**
     * check current cell status and update according to how many neighbours
     * if cell is alive and there are 2 to 3 alive neighbours, stay alive
     * if cell is dead and there are exactly 3 alive neighbours, become alive
     * else just die
     * @param curCellStatus     the cell we're checking
     * @param neighbours        list of integers of neighbour status
     * @return                  the cell's next status
     */
    public int checkAndReact(int curCellStatus, List<Integer> neighbours){
        int alive = 0;
        int nextStatus;
        for(int neighbourStatus:neighbours){
            if(neighbourStatus==ALIVE) alive++;
        }
        if(curCellStatus==DEAD && alive==3) nextStatus = ALIVE;
        else if(curCellStatus==ALIVE && (alive==3 || alive==2)) nextStatus = ALIVE;
        else nextStatus = DEAD;
        return nextStatus;
    }

}
