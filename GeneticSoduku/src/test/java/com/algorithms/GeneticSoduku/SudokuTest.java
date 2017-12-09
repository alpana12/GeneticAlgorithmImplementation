package com.algorithms.GeneticSoduku;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SudokuTest {
    
	@Test
    public void testFitnessPositive(){
    	int[] gene = new int[]{5,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	Sudoku.setInitialGene(gene);
    	Sudoku sudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));
        assertEquals(0, sudoku.getFitnessValue());
    }
    
	@Test
    public void testFitnessNegative(){
    	int[] gene = new int[]{3,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	Sudoku.setInitialGene(gene);
    	Sudoku sudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));
        assertEquals(3, sudoku.getFitnessValue());
    }
    
	@Test
    public void testOneDim2TwoDim(){
    	int[] gene = new int[]{1, 0, 0, 4, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0};
    	int[][] dim2 = new int[][]{{1, 0, 0, 4},{0, 0, 0, 0},{ 0, 3, 2, 0},{ 0, 0, 0, 0}};
    	assertArrayEquals("One dimensional to two dimensional transformation successful ", dim2, Sudoku.oneDToTwoD(gene));
    }
    
	@Test
    public void testBestSelection(){
    	Sudoku.setInitialGene(new int[81]);
    	List<Sudoku> sudokus = new ArrayList<>();
    	
    	int[] gene = new int[]{5,3,0,0,7,0,0,1,0,6,0,0,1,9,5,0,4,8,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,5,0,8,0,0,7,9};
    	Sudoku sudoku = new Sudoku(gene);
    	Sudoku.setInitialGene(gene);
    	sudokus.add(sudoku);
    	
    	gene = new int[]{3,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	sudoku = new Sudoku(gene);
    	//Sudoku.setInitialGene(gene);
    	sudokus.add(sudoku);
    	
    	gene = new int[]{5,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	sudoku = new Sudoku(gene);
    	//Sudoku.setInitialGene(gene);
    	sudokus.add(sudoku);

    	assertEquals("Best selection function ran successfully", sudokus.get(2), Sudoku.bestSelection(sudokus));
    	
    }
    
	@Test
    public void testRouletteSelection(){
    	Sudoku.setInitialGene(new int[81]);
    	List<Sudoku> sudokus = new ArrayList<>();
    	
    	int[] gene = new int[]{5,3,0,0,7,0,0,1,0,6,0,0,1,9,5,0,4,8,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,5,0,8,0,0,7,9};
    	Sudoku sudoku = new Sudoku(gene);
    	Sudoku.setInitialGene(gene);
    	sudokus.add(sudoku);
    	
    	gene = new int[]{3,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	sudoku = new Sudoku(gene);
    	sudokus.add(sudoku);
    	
    	gene = new int[]{5,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	sudoku = new Sudoku(gene);
    	sudokus.add(sudoku);

    	assertNotNull("Roulette Selection selects a gene successfully", Sudoku.rouletteSelection(sudokus));
    }
	
	@Test
	public void testMutation(){
		int[] gene = new int[]{5,3,0,0,7,0,0,1,0,6,0,0,1,9,5,0,4,8,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,5,0,8,0,0,7,9};
    	int[] mutatedGene =  new int[]{5,3,0,0,5,0,0,1,0,6,0,0,1,9,5,0,4,8,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,5,0,8,0,0,7,9};
    	assertArrayEquals("Mutation successful", GeneticOperators.mutation(gene, 4, 5), mutatedGene);
	}
	
	@Test
	public void testCrossover(){
		int[] gene1 = new int[]{5,3,0,0,7,0,0,1,0,6,0,0,1,9,5,0,4,8,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,5,0,8,0,0,7,9};
    	int[] gene2 = new int[]{5,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	int[][] gene3 = GeneticOperators.crossover(gene1, gene2, 1, 6);
    	int[][] gene4 = new int[][] {{5, 3, 4, 6, 7, 8, 9, 1, 0, 6, 0, 0, 1, 9, 5, 0, 4, 8, 0, 9, 8, 0, 0, 0, 0, 6, 0, 8, 0, 0, 0, 6, 0, 0, 0, 3, 4, 0, 0, 8, 0, 3, 0, 0, 1, 7, 0, 0, 0, 2, 0, 0, 0, 6, 0, 6, 0, 0, 0, 0, 2, 8, 0, 0, 0, 0, 4, 1, 9, 0, 0, 5, 0, 0, 5, 0, 8, 0, 0, 7, 9}, {5, 3, 0, 0, 7, 0, 0, 1, 2, 6, 7, 2, 1, 9, 5, 3, 4, 8, 1, 9, 8, 3, 4, 2, 5, 6, 7, 8, 5, 9, 7, 6, 1, 4, 2, 3, 4, 2, 6, 8, 5, 3, 7, 9, 1, 7, 1, 3, 9, 2, 4, 8, 5, 6, 9, 6, 1, 5, 3, 7, 2, 8, 4, 2, 8, 7, 4, 1, 9, 6, 3, 5, 3, 4, 5, 2, 8, 6, 1, 7, 9}};
    	assertArrayEquals("Crossover successful between two genes", gene4, gene3);
	}
	
//	@Test
//	public void testFitness(){
//		int[] gene = new int[]{5,3,4,6,7,8,9,1,2,6,1,7,1,9,5,3,4,8,2,9,8,3,4,2,5,6,7,8,5,1,9,6,7,4,2,3,4,6,2,8,5,3,7,9,1,7,3,9,1,2,4,8,5,6,9,6,7,5,3,1,2,8,4,1,2,8,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
//    	Sudoku.setInitialGene(gene);
//    	Sudoku sudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));
//        assertEquals(9, sudoku.getFitnessValue());
//	}
}
