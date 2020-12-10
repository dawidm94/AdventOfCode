package aoc.year2020.day10;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day10_2 {

	private static Long COUNT_POSSIBILITY_MOVES = 0L;
	private static List<Integer> listOfNumbers;
	private static final int MAX_DIFFERENCE = 3;
	private static int MAX_NUMBER;

	public static void main(String[] args) throws IOException {
		listOfNumbers = getAllInputLines("day10").stream().map(Integer::parseInt).collect(Collectors.toList());
		MAX_NUMBER = listOfNumbers.stream().max(Integer::compareTo).get();
		findNextPossibilities(0);
		System.out.println(COUNT_POSSIBILITY_MOVES);
	}

	private static void findNextPossibilities(int actualNumber) {
		for (int i=actualNumber+1; i<=actualNumber+MAX_DIFFERENCE; i++) {
			if (i == MAX_NUMBER) {
				COUNT_POSSIBILITY_MOVES++;
			} else if (listOfNumbers.contains(i)) {
				findNextPossibilities(i);
			}
		}
	}
}