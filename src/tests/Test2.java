package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test2 {
	
	
	/*
	 *This problem was made to calculate the maximum price that a person can buy with a coupon. Given some items the code will calculate the maximum price.
	 *For the items below you will get that the maximum value is 451 and you can buy 4 (2,3,4,5) of them. 
	 */

	static float bestValue = 0.0f;

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("Logger");

		Map<String, Float> items = new HashMap<>();
		items.put("1", 450.0f);
		items.put("2", 100.0f);
		items.put("3", 100.0f);
		items.put("4", 151.0f);
		items.put("5", 100.0f);
		float amount = 500;
		int[] solution = new int[items.size()];
		int[] finalSolution = new int[items.size()];
		createSolution(solution, finalSolution, items, amount, 0);
		logger.log(Level.INFO, " {0} ", createResponse(bestValue, finalSolution, items));


	}

	private static Response createResponse(float bestValue2, int[] finalSolution, Map<String, Float> items) {
		List<String> ids = new ArrayList<>();

		for (int i = 0; i < finalSolution.length; i++) {
			if (finalSolution[i] == 1) {
				ids.add(items.keySet().toArray()[i].toString());
			}
		}

		return new Response(ids, bestValue2);
	}

	static void createSolution(int[] solution, int[] finalSolution, Map<String, Float> items, Float amount, int n) {
		int i = 0;

		do {
			solution[n] = i;
			if (validSolution(solution, items, amount)) {
				if (n == items.size() - 1) {
					getThesolution(solution, items, finalSolution, amount);
				} else {
					createSolution(solution, finalSolution, items, amount, n + 1);
				}

			}
			i++;

		} while (solution[n] != 1);
		solution[n] = -1;
	}

	private static boolean validSolution(int[] solution, Map<String, Float> items, Float amount) {
		float currentAmount = 0.0f;
		for (int i : solution) {
			if (i == 1)
				currentAmount += Float.parseFloat(items.values().toArray()[i].toString());

		}
		return currentAmount < amount;
	}

	private static void getThesolution(int[] solution, Map<String, Float> items, int[] finalSolution, Float amount) {
		int currentValue = 0;
		int newValue = 0;

		for (int i = 0; i < finalSolution.length; i++) {

			if (solution[i] == 1)
				newValue += Float.parseFloat(items.values().toArray()[i].toString());

			if (finalSolution[i] == 1)
				currentValue += Float.parseFloat(items.values().toArray()[i].toString());

		}

		if (newValue > currentValue && newValue < amount) {
			bestValue = newValue;
			System.arraycopy(solution, 0, finalSolution, 0, solution.length);

		}

	}
}
