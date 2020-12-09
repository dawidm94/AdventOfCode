package aoc.year2020.day9;

import java.io.IOException;
import java.util.List;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day09_1 {

	private static final int PREAMBLE_NUMBER = 25;

	public static void main(String[] args) throws IOException {
		List<String> fileLines = getAllInputLines("day9");
		for (int i = PREAMBLE_NUMBER; i < fileLines.size(); i++) {
			long summedNumber = Long.parseLong(fileLines.get(i));
			boolean numberIsSummed = checkIfNumberIsSummed(fileLines, summedNumber, i);
			if (!numberIsSummed) {
				System.out.println("The number that couldn't find sum of two numbers is " + summedNumber);
				break;
			}
		}
	}

	private static boolean checkIfNumberIsSummed(List<String> fileLines, long summedNumber, int rowNumber) {
		for (int j = rowNumber - PREAMBLE_NUMBER; j<rowNumber; j++) {
			for (int k = rowNumber - PREAMBLE_NUMBER; k<rowNumber; k++) {
				if (j!=k) {
					long firstNumber = Long.parseLong(fileLines.get(j));
					long secondNumber = Long.parseLong(fileLines.get(k));
					if (firstNumber + secondNumber == summedNumber) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
