# Simulation Design Final
### Names

## Team Roles and Responsibilities

 * Team Member #1 Franklin Boampong

    - Responsibility: Game View including buttons, sliders, linechart, subscenes; Exceptions; 
    individual simulations including Fire


 * Team Member #2 Michelle Tai

    - Responsibility: XML parsing, reading, XML exception, saving configurations to XML, individual simulation Percolation


 * Team Member #3 Lucy Gu

    - Responsibility: Grid super class, RectGrid and TriGrid; Cell super class, RectCell and TriCell; Simulation super class, 
    individual simulations including Game of Life, WaTor, Segregation, RockPaperScissor, Sugarscape


## Design goals

Our overall design goals were to not pass around our grid and adhere to the open/close principle. We 
aimed to only give out crucial information between classes and not pass every bit of information. We later
learned about the possibility of others changing the information in objects that are passed in as parameters, so
we adjusted our grid to reflect that. We also wanted to make it easy to add new types of grids and simulations, 
and by creating a superclass/abstract class for the grid and the simulation, it is easy to add different simulations
besides the ones we have created. 

#### What Features are Easy to Add
- Add a new simulation
- Add a new possible grid layout

## High-level Design

- Our Cell class holds the information about an individual cell's current and next state, mainly for the purpose of 
recording information and updating the colors to help the visualization of the simulation
in the view. The Cell class isn't dependent on any other classes.

- The Grid class holds an arraylist of arraylist of cells, and is in charge of changing the cell's next state and 
updating the grid of cells by calling methods inside the cell class. It is also in charge of finding the neighbours 
of a cell at a particular index, with different methods that return the index of said neighbours or the states of 
said neighbours. These methods are mainly called in Simulation to access the individual cell's information without the 
simulation classes actually accessing the arraylist or the individual cells (for the purpose of hiding data implementation).

- The Simulation classes represents the logic behind each Cellular Autonoma. The simulation class is in charge of creating 
the grid, obtaining information from the Grid, deciding what the grid should look like in the next round, and command the 
grid to update its configurations. Each simulation types extends the Simulation superclass.

- The SimulationXMLFileChooser opens up a file chooser, and upon the user choosing a file, the XMLParser class parses
the information from the XML file and stores the information into a SimulationXML object. This object returns the information in 
each of the fields of the XML tags.

- The SimulationViewSubscene then takes the SimulationXML object and uses the information to render the correct
simulation and initial configuration.

#### Core Classes

- Cell
- Grid
- Simulation
- SimulationXMLFileChooser
- SimulationXML
- SimulationViewSubscene


## Assumptions that Affect the Design
- We assumed that there would only be two types of neighborhoods for each cell, ie the direct neighbours and the all-neighbours 
configuration
- We assumed that the grid and simulation will always be displayed as a rectangle shape. 
- We currently have thresholds and probabilities for simulations coded into respective classes instead of
having it parsed by the XML/being put into the XML files, but it's not difficult to add in another tag
into the XML and parse that information. 

#### Features Affected by Assumptions

- Some features that are affected by these assumptions are the addition of new cell-types. For example, it will 
be difficult if the user all of a sudden want an image of a flower to be the view of a cell.
- If someone wanted to have the probability of a tree catching on fire change in Fire or change the 
satisfaction threshold in Segregation, they would need to go into the code and change those values. 

## New Features HowTo

#### Easy to Add Features

- It should be relatively easy to add a new simulation. 
The steps would include creating a new simulation class with working logic that 
extends the simulation super class, adding the simulation title to the allTitle string array
in the SimulationViewSubscene class, and adding an else if statement around line 177 that creates 
the new simulation in the makeNewSim method.

- The calculation required for adding a new grid will be tedious, but in function it is 
easy to achieve. For example, if you want to add a hexagonal configuration, you need to create 
a hexagon grid class extending the Grid class that is able to calculate the index of neighbours of a hexagon cell, 
as well as a matching hexagon cell class extending the Cell super class that contains the constructor of a  hexagon 
shape. Then, add the new possible grid and its matching String input tag on line 34 in the Simulation super class, 
and the program should be able to run with the new design.

- It would be pretty easy to add in an xml tag so that the threshold/probabilities of simulations can be
set by the user instead of set within the code. The SimulationXML class would just need to add another
identifier into its list of tag identifiers and create a getter for the threshold/probability values. 


#### Other Features not yet Done

- We began working on "saving current configuration to XML file" but wasn't able to finish it. Although the branch containing
the code for this was merged to the master branch, it's not there; however, it was in the works.

- We didn't complete the "loading in a style" through XML due to time contraints. 

- We didn't complete many of the new proposed simulation. The Sugarscape simulation only adapted the first preset, and 
we didn't have time to start ant or lanton's loop

- We didn't have time to implement the ability to freely select all configurations of neighbours to check. 

- Some data for the simulations are hard coded into the source code, such as the satisfactory rate of Segregation, 
initial energy and reproduction cycle number for WaTor; if there were more time we would've created an XML tag for these 
data and thus allow users to be able to control it without changing the source code.

