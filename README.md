# Labyrinth Solver using Recursion

This project is a solution to the **IN1010 v23– Obligatory Assignment 7**, where the goal is to create a program that solves mazes using recursion. The program reads labyrinths from files and uses recursive search to find all possible exits from a given start point. The program is designed to work with both cyclic and acyclic mazes and handles various maze configurations.

## Description

In this assignment, a maze is represented as a grid of squares, where each square can either be passable (`.`) or blocked (`#`). The task is to use recursion to find paths from a starting square to any exit (open squares on the boundary of the maze).

The program is designed to handle:
- **Recursive pathfinding**: Using a recursive approach, the program searches for paths from a start square to an exit.
- **Polymorphism**: The `find` method is implemented using polymorphism, allowing different types of squares (white, black, and openings) to behave differently during the search process.
- **Acyclic mazes**: The solution ensures that only acyclic mazes are solved by avoiding circular paths.
- **Exit discovery**: The program identifies and prints all exits reachable from a given start square.

## Features

- **Recursive Search**: The `find` method explores all possible paths recursively to find exits.
- **Cyclic and Acyclic Maze Support**: The program can handle both cyclic and acyclic mazes, with special logic for each case.
- **Interactive Command Line Interface**: The program prompts the user to input start coordinates, then finds and prints all exits from that position.
- **Maze Representation**: The maze is represented as a 2D array of objects, where each object is a `Square` (which can be either `WhiteSquare`, `BlackSquare`, or `Opening`).
- **Exit Tracking**: The program tracks all found exits and ensures that no exits are missed.

## File Format

The maze is read from a file with the following format:
- The first line contains two integers, representing the number of rows and columns.
- The subsequent lines contain a grid of `#` (blocked squares) and `.` (passable squares).

Example of a maze:
7 9 ######### #........ #.####### #.......# #######.# ........# #########

## Classes and Structure

- **Maze**: The main class that stores the grid of squares and provides functionality to find exits.
- **Square**: The base class for all types of squares. It holds the coordinates and references to neighboring squares.
- **WhiteSquare** and **BlackSquare**: Subclasses of `Square`, representing passable and blocked squares respectively.
- **Opening**: A subclass of `WhiteSquare`, representing exit points in the maze.

## Notes

- The program uses **recursion** to explore paths and avoid revisiting already explored squares.
- The solution guarantees that only **acyclic mazes** are solved correctly, as cyclic paths are avoided.
- You can experiment with different labyrinths by providing various `.in` files.

## Authors

- **Shahi Ftah**
