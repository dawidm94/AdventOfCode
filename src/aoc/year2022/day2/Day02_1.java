package aoc.year2022.day2;

import aoc.AocUtils;

import java.io.IOException;
import java.util.List;

import static aoc.model.AocDay.DAY_2;
import static aoc.model.AocYear.YEAR2022;

public class Day02_1 {

	public static void main(String[] args) throws IOException {
		List<String> lines = AocUtils.getAllStringLines(YEAR2022, DAY_2);
		int myPoints = 0;

		for (String line : lines) {
			char[] chars = line.toCharArray();

			Shape opponentShape = Shape.of(chars[0]);
			Shape myShape = Shape.of(chars[2]);

			myPoints += myShape.fightWith(opponentShape);
		}

		System.out.println("Result is: " + myPoints);
	}
}
