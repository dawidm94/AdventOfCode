package aoc.year2022.day1;

import aoc.AocUtils;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static aoc.model.AocDay.DAY_1;
import static aoc.model.AocYear.YEAR2022;

public class Day01_2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = AocUtils.getAllStringLines(YEAR2022, DAY_1);

		int top3SumCalories = getElfCaloriesList(lines).stream()
				.sorted(Comparator.comparingInt(Integer::intValue).reversed())
				.limit(3)
				.mapToInt(Integer::intValue)
				.sum();

		System.out.println("Result is: " + top3SumCalories);
	}

	public static List<Integer> getElfCaloriesList(List<String> caloriesLines) {
		List<Integer> elfCaloriesList = new LinkedList<>();
		int elfCalories = 0;

		for (String calories : caloriesLines) {
			if (calories == null || calories.trim().length() == 0) {
				elfCaloriesList.add(elfCalories);
				elfCalories = 0;

			} else {
				elfCalories += Integer.parseInt(calories);
			}
		}
		elfCaloriesList.add(elfCalories);

		return elfCaloriesList;
	}
}
