package com.algorithms.GeneticSoduku;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
*/
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;


public class SudokuTest extends TestCase {
    
    public void testFitnessPositive(){
    	int[] gene = new int[]{5,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	Sudoku.setInitialGene(gene);
    	Sudoku sudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));
        assertEquals(0, sudoku.getFitnessValue());
    }
    
    public void testFitnessNegative(){
    	int[] gene = new int[]{3,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
    	Sudoku.setInitialGene(gene);
    	Sudoku sudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));
        assertEquals(3, sudoku.getFitnessValue());
    }
    
    public void testOneDim2TwoDim(){
    	int[] gene = new int[]{1, 0, 0, 4, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0};
    	int[][] dim2 = new int[][]{{1, 0, 0, 4},{0, 0, 0, 0},{ 0, 3, 2, 0},{ 0, 0, 0, 0}};
    	assertArrayEquals(dim2,Sudoku.oneDToTwoD(gene));
    }
    
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

    	assertEquals(sudokus.get(2), Sudoku.bestSelection(sudokus));
    	
    }
    
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

    	assertNotNull(Sudoku.rouletteSelection(sudokus));
    	
    }
    
}
