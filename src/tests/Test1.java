package tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test1 {

	/*
	 * This problem was made to calculate the maximum price that a person can buy
	 * with a coupon. Given some items the code will calculate the maximum price.
	 * For the items below you will get that the maximum value is 451. The
	 * difference with the Test2 is this won't calculate what are the products you
	 * can buy, only the price
	 */

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("Logger");
		Map<String, Float> items = new HashMap<>();
		items.put("1", 450.0f);
		items.put("2", 100.0f);
		items.put("3", 200.0f);
		items.put("4", 151.0f);
		float amount = 500;
		logger.log(Level.INFO, "El maximo valor que cumplen el cupo es : {0} ",
				getTheBestValues(items, amount, items.size() - 1));

	}

	static int getTheBestValues(Map<String, Float> items, Float amount, int n) {

		if (amount == 0 || n < 0)
			return 0;

		if (Float.parseFloat(items.values().toArray()[n].toString()) > amount)
			return getTheBestValues(items, amount, n - 1);

		return (int) Math.max(
				Float.parseFloat(items.values().toArray()[n].toString()) + getTheBestValues(items,
						amount - Float.parseFloat(items.values().toArray()[n].toString()), n - 1),
				getTheBestValues(items, amount, n - 1));
	}

	static List<String> addElement(String id, List<String> response) {
		if (!response.contains(id)) {
			response.add(id);
		}

		return response;

	}

	static List<String> removeElement(String id, List<String> response) {
		if (response.contains(id)) {
			response.remove(id);
		}

		return response;

	}

}
