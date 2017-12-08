package com.algorithms.GeneticSoduku.Threads;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

import com.algorithms.GeneticSoduku.Sudoku;

public class Mutate implements Runnable {

	CountDownLatch latch;
	CopyOnWriteArrayList<Sudoku> list;
	
	
	public Mutate(CountDownLatch latch,	CopyOnWriteArrayList<Sudoku> list) {
		this.latch = latch;
		this.list=list;
	}
	@Override
	public void run() {
		while(latch.getCount()>0){
			Sudoku sudoku = list.get(Math.toIntExact(latch.getCount()));
			int dimensions = (int) Math.sqrt(sudoku.getGene().length);
	        int[] mutation = mutation(sudoku.getGene(), new Random().nextInt(sudoku.getGene().length), new Random().nextInt(dimensions) + 1);
	        sudoku.setGene(mutation);
		}
	}
	
    public static int[] mutation(int[] gene, int index, int value) {
        gene[index] = value;
        return gene;
    }

	
}
