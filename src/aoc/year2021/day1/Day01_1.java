package aoc.year2021.day1;

import java.io.IOException;
import java.util.List;

import static aoc.year2021.AocUtils.getAllIntegerLines;

public class Day01_1 {

	public static void main(String[] args) throws IOException {
		List<Integer> depths = getAllIntegerLines("day1");

		System.out.println("Result is: " + countDeeperDepths(depths));
	}

	public static int countDeeperDepths(List<Integer> depths) {
		int counter = 0;
		for (int i=1; i<depths.size(); i++) {
			if (depths.get(i) > depths.get(i-1)) {
				counter++;
			}
		}
		return counter;
	}
}
