package aoc.year2021.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static aoc.year2021.AocUtils.getAllIntegerLines;

public class Day01_2 {

	private static final int NUMBER_OF_SUMMED_NEXT_NUMBERS = 3;

	public static void main(String[] args) throws IOException {
		List<Integer> depths = getAllIntegerLines("day1");
		List<Integer> sumList = new ArrayList<>();

		for (int i=NUMBER_OF_SUMMED_NEXT_NUMBERS; i<depths.size(); i++) {
			int singleSum = 0;
			for (int j=i; j>i-NUMBER_OF_SUMMED_NEXT_NUMBERS; j--) {
				singleSum += depths.get(j);
			}
			sumList.add(singleSum);
		}
		System.out.println("Result is: " + Day01_1.countDeeperDepths(sumList));
	}

}
