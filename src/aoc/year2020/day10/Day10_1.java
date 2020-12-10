package aoc.year2020.day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day10_1 {

	public static void main(String[] args) throws IOException {
		List<Integer> inputList = getAllInputLines("day10").stream().map(Integer::parseInt).collect(Collectors.toList());
		Integer maxNumber = inputList.stream().max(Integer::compareTo).get();
		int countDifferenceOf1 = 0;
		int countDifferenceOf3 = 0;
		List<Integer> inputSortedList = new ArrayList<>(inputList);
		inputSortedList.add(0);
		inputSortedList.add(maxNumber + 3);
		inputSortedList = inputSortedList.stream().sorted().collect(Collectors.toList());

		for (int i = 1; i < inputSortedList.size(); i++) {
			if (inputSortedList.get(i) - inputSortedList.get(i - 1) == 3) {
				countDifferenceOf3++;
			} else if (inputSortedList.get(i) - inputSortedList.get(i - 1) == 1) {
				countDifferenceOf1++;
			} else {
				System.out.printf("Something wrong! The difference between %d and %d is not 1 or 3.", inputSortedList.get(i - 1), inputSortedList.get(i));
			}
		}
		System.out.println(countDifferenceOf1 * countDifferenceOf3);
	}
}