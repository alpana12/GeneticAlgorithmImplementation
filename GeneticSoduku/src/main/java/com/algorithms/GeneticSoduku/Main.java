package com.algorithms.GeneticSoduku;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

	public static int populationSize = 1500;

	public static void main(String[] args) {

		long timeStart = System.currentTimeMillis();
		LOGGER.info("Started at ::"+new Date(timeStart).toLocaleString());


		Random random = new Random(9);

		int maxIterations =  100000;
		int iteration = 0;
		Sudoku.setInitialGene(new int[]{5,3,0,0,7,0,0,1,0,6,0,0,1,9,5,0,4,8,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,5,0,8,0,0,7,9});
		//Sudoku.setInitialGene(new int[]{1, 0, 0, 4, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0});
		Sudoku currentSudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));
		Sudoku solution = null;
		while (currentSudoku.getFitnessValue() != 0 && iteration < maxIterations) {
			//if(iteration%100==0)
			LOGGER.info("current: " + currentSudoku + ", iteration: " + iteration);

			List<Sudoku> population = new ArrayList<>();

			for (int i = 0; i < populationSize; i++) 
				population.add(new Sudoku(currentSudoku.getGene().clone()));

			//         GeneticOperators.population = new CopyOnWriteArrayList<>(population);

			for (int i = 0; i < population.size(); i++) {
				if (random.nextBoolean())
					population.get(i).mutation();
				else
					population.get(i).crossover(population.get(random.nextInt(population.size())));

				if(population.get(i).getFitnessValue()==0){
					LOGGER.info("**********Found Solution");
					solution = population.get(i);
					break;
				}

			}


			/*			ExecutorService executor = Executors.newFixedThreadPool(10);

			Callable<Sudoku> bestFitSelection = new BestFitSelection();
			Future<Sudoku> bestFitFuture = executor.submit(bestFitSelection);

			Callable<Sudoku> rouletteSelection = new BestFitSelection();
			Future<Sudoku> rouletteFuture = executor.submit(rouletteSelection);
			 */


			if(solution==null){
				if (random.nextBoolean() )
					currentSudoku = Sudoku.bestSelection(population);
				else
					currentSudoku = Sudoku.rouletteSelection(population);				
			}else{
				currentSudoku = solution;
				break;
			}


			iteration++;
		}


		LOGGER.info("goal: " + currentSudoku + ", iteration: " + iteration);
		System.out.println("Total Time (Sec) " + (System.currentTimeMillis() - timeStart)/1000);
		LOGGER.info("Finished at ::"+new Date(System.currentTimeMillis() - timeStart).toLocaleString());
	}


}
