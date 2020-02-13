# Simulation Design Final
### Names

## Team Roles and Responsibilities

 * Team Member #1 Franklin Boampong

    - Responsibility: Game View including buttons, sliders, linechart, subscenes, Exceptions, 
    individual simulations including Fire

 * Team Member #2 Michelle Tai

    - Responsibility: XML parsing, reading, XML exception, saving configurtions to XML, individual simulation Percolation

 * Team Member #3 Lucy Gu

    - Responsibility: Grid super class, RectGrid and TriGrid, Simulation super class, 
    individual simulations including Game of Life, WaTor, Segregation, RockPaperScissor, Sugarscape

## Design goals

#### What Features are Easy to Add

- Add a new simulation
- Add a new possible grid layout


## High-level Design

#### Core Classes


## Assumptions that Affect the Design

#### Features Affected by Assumptions


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

- We began working on "saving current configuration to XML file" but wasn't able to finish it
- We didn't of the new simulation ideas

