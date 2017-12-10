package com.algorithms.GeneticSoduku;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import com.algorithms.GeneticSoduku.Threads.BestFitSelection;
import com.algorithms.GeneticSoduku.Threads.CrossOver;
import com.algorithms.GeneticSoduku.Threads.Mutate;

public class GeneticOperators {

	static CopyOnWriteArrayList<Sudoku> list;
	static CountDownLatch latch = new CountDownLatch(Main.populationSize);
	static Random random = Main.random;

	
	public static void mutateOrCross(Vector<Sudoku> sudokus) throws InterruptedException{
		list = new CopyOnWriteArrayList<>(sudokus);
		new Thread(new Mutate(latch,list)).start();
		new Thread(new CrossOver(latch,list)).start();
		latch.await();
	}
	
    public static int[] initialize(int[] gene) {
        int dimensions = (int) Math.sqrt(gene.length);

        for (int i = 0; i < gene.length; i++) {
            if (gene[i] == 0) gene[i] = new Random().nextInt(dimensions) + 1;
        }

        return gene;
    }

    public static int[] randomMutation(int[] gene) {
        int dimensions = (int) Math.sqrt(gene.length);
        int[] mutation = gene;
        int rand = random.nextInt(gene.length);
        for (int i = 0; i < rand; i++)
            mutation = mutation(gene, random.nextInt(gene.length), random.nextInt(dimensions) + 1);


        return mutation;
    }

    public static int[] mutation(int[] gene) {
        int dimensions = (int) Math.sqrt(gene.length);
        int[] mutation = mutation(gene, random.nextInt(gene.length), random.nextInt(dimensions) + 1);

        return mutation;
    }


    public static int[] mutation(int[] gene, int index, int value) {
        gene[index] = value;

        return gene;
    }

    public static int[][] crossover(int[] gene1, int[] gene2) {
        int start = random.nextInt(gene1.length);
        int end = random.nextInt(gene1.length - start) + start;

        return crossover(gene1, gene2, start, end);
    }

    public static int[][] crossover(int[] gene1, int[] gene2, boolean singlePoint) {
        int start = (singlePoint) ? 0 : random.nextInt(gene1.length);
        int end = random.nextInt(gene1.length - start) + start;

        return crossover(gene1, gene2, start, end);
    }

    public static int[][] crossover(int[] gene1, int[] gene2, int start, int end) {
        int[][] newGene = new int[2][gene1.length];
        for (int i = 0; i < gene1.length; i++) {
            newGene[0][i] = (i >= start && i <= end) ? gene2[i] : gene1[i];
            newGene[1][i] = (i >= start && i <= end) ? gene1[i] : gene2[i];
        }
        return newGene;
    }
}
