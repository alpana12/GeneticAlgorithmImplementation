# Genetic Algorithm Implementation
Implementation of Genetic Algorithm to solve a N*N sudoku puzzle for course INFO6250.

# Problem Statement:
  To solve a sudoku puzzle using genetic algorithm.
# Sudoku puzzle:
Sudoku is a logic-based, combinatorial number-placement puzzle. The objective is to fill a 9×9 grid with digits so that each column, each row, and each of the nine 3×3 nonets (sub-grids) that compose the grid contains all of the digits from 1 to 9 without repetition of any single digit in their respective row / column / nonet. The puzzle setter provides a partially filled grid, which ideally has a single solution.

You can read more about it at: https://en.wikipedia.org/wiki/Sudoku

Note: the application designed to support any sudoku board with size NxN, when the sqrt(N) is a natural number.
# Genetic Algorithm:
	To understand genetic algorithm, let us consider the life on Earth as we know it:
-	Every organism is built up from tiny amino acids known as genes, which are connected together into long strings called chromosomes.
-	Each gene represents a specific trait of the organism. These genes and their settings are usually referred to as genotype.
-	The physical expression of the genotype – the organism itself – is called the phenotype.
-	When two organisms mate, they share their genes. The resultant offspring may end up having half the genes from one parent and the other half from another parent. This process is called recombination / crossover.
-	Sometimes, a gene may be mutated, and it can be expressed as a new trait.
-	Life on Earth has evolved based on survival of the fittest, through the process of natural selection, crossover and mutation (Darwin’s theory).

Genetic Algorithms are a way of solving problems by mimicking the same processes nature uses. They use the same combination of selection, recombination and mutation to evolve a solution to the problem.

You can read more about it at: https://en.wikipedia.org/wiki/Genetic_algorithm

# Approach:
The program is developed using Test Driven Development approach by using Logger to understand the flow and Junit4 framework to develop test cases.
We are providing the partially filled sudoku puzzle to the program. 
- Gene: An integer array that takes the values of the puzzle.
- Population: Integer, indicating number of genes in each generation.
- Fitness function: scores a gene based on whether it is repeated in its respective row / column / sub-grid. Least fitness value is the best solution in our case.
- Mutation function: Performs mutation by swapping the digits in the gene array.
- Crossover: Performs crossover of two selected genes and produces a new gene.
- Selection: Here, we are randomly using either Tournament selection or Roulette Selection.
  In tournament selection, we choose the fittest gene for crossover. 
  In Roulette selection, we divide the genes based on fitness on a huge wheel and just spin it. We select whatever gene is being pointed   at. That means, the gene with more fitness value has a probability of getting selected easily.

# Running the program:
To run the program, we can directly run the Main method.

The following parameters can be modified in main method, which will affect the program working:
- Population size : number of genes to consider in a population.

  int populationSize = 1500;
- Initial Gene : the partially filled puzzle passed as an integer array.

  Sudoku.setInitialGene(new int[]{5,3,0,0,7,0,0,1,0,6,0,0,1,9,5,0,4,8,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,5,0,8,0,0,7,9});
- Iterations : Generations of chromosomes.

  int maxIterations =  10000;

# Running the Unit Tests:

Unit Tests have been developed for checking the following test cases:

For Sudoku :
- Testing the fitness function.
- Testing the function that converts one dimensional array to two dimensional array.
- Testing the tournament selection (best selection) function.
- Testing the roulette wheel selection function.

For Genetic : 
- Testing the mutation function.
- Testing the crossover function.

# Screenshots:
For a standard 9 * 9 sudoku puzzle, the program takes 100 to 200 seconds. The final ouput can be seen in logs\app-info.log file. 

Below are the sample screenshots.

