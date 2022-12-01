package aoc.year2022.day1;

import aoc.AocUtils;

import java.io.IOException;
import java.util.List;

import static aoc.model.AocDay.DAY_1;
import static aoc.model.AocYear.YEAR2022;

public class Day01_1 {

	public static void main(String[] args) throws IOException {
		List<String> lines = AocUtils.getAllStringLines(YEAR2022, DAY_1);
		lines.add("");

		System.out.println("Result is: " + getMostCarriedElfCalories(lines));
	}

	public static int getMostCarriedElfCalories(List<String> caloriesLines) {
		int elfMostCarriedCalories = 0;
		int elfCalories = 0;

		for (String calories: caloriesLines) {
			if (calories == null || calories.trim().length() == 0) {
				elfMostCarriedCalories = Math.max(elfCalories, elfMostCarriedCalories);
				elfCalories = 0;

			} else {
				elfCalories += Integer.parseInt(calories);
			}

			elfMostCarriedCalories = Math.max(elfCalories, elfMostCarriedCalories);
		}

		return elfMostCarriedCalories;
	}
}
