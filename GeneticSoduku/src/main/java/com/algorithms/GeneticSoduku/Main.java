package com.algorithms.GeneticSoduku;

import java.util.Random;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
    	long timeStart = System.currentTimeMillis();
    	
        Random random = new Random();
        int populationSize = 5000;
        int maxIterations = 100000;
        int iteration = 0;
        Sudoku.setInitialGene(new int[]{5,3,0,0,7,0,0,0,0,6,0,0,1,9,5,0,0,0,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,0,0,8,0,0,7,9});
        Sudoku currentSudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));

        while (currentSudoku.getFitnessValue() != 0 && iteration < maxIterations) {
        	if(iteration%100==0)
        		System.out.println("current: " + currentSudoku + ", iteration: " + iteration);
        	
            Vector<Sudoku> population = new Vector<>();
            for (int i = 0; i < populationSize; i++) 
            	population.add(new Sudoku(currentSudoku.getGene().clone()));

            for (int i = 0; i < population.size(); i++) {
                if (random.nextBoolean())
                    population.get(i).mutation();
                else
                    population.get(i).crossover(population.get(random.nextInt(population.size())));
            }
            
           if (random.nextBoolean())
                currentSudoku = Sudoku.bestSelection(population);
            else
                currentSudoku = Sudoku.rouletteSelection(population);
            iteration++;
        }


        System.out.println("goal: " + currentSudoku + ", iteration: " + iteration);
        System.out.println("Total Time (Sec) " + (System.currentTimeMillis() - timeStart)/1000);
    }


}
