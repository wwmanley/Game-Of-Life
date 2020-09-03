# Game Of Life
This project is an assignment from [Hyperskill](https://hyperskill.org/projects/54). The program simulates John Conway's [Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) with a GUI that was made with Swing. With this particular simulation, we will be working with a 10x10 grid, or "universe".

## Demo

![Gif of program running](https://i.imgur.com/7J2dE29.gif)

# Installation

1. Navigate to where you want to install the project
2. ``` git clone https://github.com/wwmanley/Game-Of-Life ```
3. Navigate into the src folder
4. ``` javac life/Main.java life/GameOfLife.java life/Universe.java life/Generations.java ```
5. ``` java life/Main ```

## Rules

Each square, or "cell", within the grid can be in one of two states, dead or alive. In order to generate the initial grid, the program applies the Random function to every cell. Once the initial grid is generated, it constantly evolves based on two rules.

1. An alive cell survives if it has two or three alive neighbors
2. A dead cell is reborn if it has exactly three alive neighbors.

A neighbor of a cell is defined as any cell that is touching it, including diagonals. The following is an illustration of this:

![Picture of Cell Neighbors](https://i.imgur.com/94Iqk6k.png)

If the cell is on the border of the grid, then the rules work as follows: 

![Picture of Cell on Border](https://i.imgur.com/w1XCZVa.png)
