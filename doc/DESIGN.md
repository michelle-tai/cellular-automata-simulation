# Simulation Design Final
### Names

## Team Roles and Responsibilities

 * Team Member #1 Franklin Boampong

    - Responsibility: Game View including buttons, sliders, linechart, subscenes, Exceptions, 
    individual simulations including Fire

 * Team Member #2 Michelle Tai

    - Responsibility: XML parsing, reading, XML exception, saving configurations to XML, individual simulation Percolation

 * Team Member #3 Lucy Gu

    - Responsibility: Grid super class, RectGrid and TriGrid, Simulation super class, 
    individual simulations including Game of Life, WaTor, Segregation, RockPaperScissor, Sugarscape

## Design goals
Our overall design goals were to not pass around our grid and adhere to the open/close principle. We 
aimed to only give out crucial information between classes and not pass every but of information. We later
learned about the possibility of others changing the information in objects that are passed in as parameters, so
we adjusted our grid to reflect that. We also wanted to make it easy to add new types of grids and simulations, 
and by creating a superclass/abstract class for the grid and the simulation, it is easy to add different simulations
besides the ones we have created. 

#### What Features are Easy to Add
- Add a new simulation
- Add a new possible grid layout

## High-level Design

Our Cell class holds the information about cells mainly to update the colors and help the visualization of the simulation
in the view. The cells also hold the shape of the cells, and interacts with the Grid class to display the cell shape 
and color. The Grid class holds the 

The SimulationXMLFileChooser opens up a file chooser, and upon the user choosing a file, the XMLParser class parses
the information from the XML file and stores the information into a SimulationXML object. This object returns the information in 
each of the fields of the XML tags.

The SimulationViewSubscene then takes the SimulationXML object and uses the information to render the correct
simulation and initial configuration. 

#### Core Classes


## Assumptions that Affect the Design
We assumed that there would only be 3 (idk how many actually) types of neighborhoods for each cell, and that we
would only have rectangular and triangular cells. We also assumed that the grid and simulation  will always be displayed as a rectangle
shape.

#### Features Affected by Assumptions
Some features that are affected by these assumptions are the addition of new types of cell shapes

## New Features HowTo

#### Easy to Add Features

- It should be relatively easy to add a new simulation. 
The steps would include creating a new simulation class with working logic that 
extends the simulation super class, adding the simulation title to the allTitle 
in the SimulationViewSubscene class, and adding an else if statement that creates 
the new simulation in the makeNewSim method.

- The calculation required for adding a new grid will be tedious, but in function it is 
easy to achieve. For example, if you want to add a hexagonal configuration, you need to create 
a hexagon grid class that is able to calculate the index of neighbours of a hexagon cell, as well 
as a hexagon cell that contains a hexagon with index required for the cell.

#### Other Features not yet Done

- We began working on "saving current configuration to XML file" but wasn't able to finish it. Although the branch containing
the code for this was merged to the master branch, it's not there; however, it was in the works
- We didn't think of the new simulation ideas

