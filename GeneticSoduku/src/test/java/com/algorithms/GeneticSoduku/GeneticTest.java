package com.algorithms.GeneticSoduku;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GeneticTest{
	
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
}
