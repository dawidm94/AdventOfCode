package aoc.year2020.day9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day09_2 {

	private static final int PREAMBLE_NUMBER = 25;

	public static void main(String[] args) throws IOException {
		List<String> fileLines = getAllInputLines("day9");
		List<Long> longFileLines = fileLines.stream().map(Long::parseLong).collect(Collectors.toList());
		for (int i = PREAMBLE_NUMBER; i < fileLines.size(); i++) {
			long summedNumber = Long.parseLong(fileLines.get(i));
			boolean numberIsSummed = checkIfNumberIsSummed(fileLines, summedNumber, i);
			if (!numberIsSummed) {
				List<Long> numberList = findContiguousSumNumber(summedNumber, longFileLines);
				if (numberList != null) {
					Optional<Long> minNumber = numberList.stream().min(Long::compareTo);
					Optional<Long> maxNumber = numberList.stream().max(Long::compareTo);
					System.out.println("Found list: " + numberList.toString());
					System.out.println("Min number: " + minNumber.get());
					System.out.println("Max number: " + maxNumber.get());
					System.out.println("Sum and the result of task 2 is: " + (minNumber.get() + maxNumber.get()));
					break;
				}
			}
		}
	}

	private static List<Long> findContiguousSumNumber (long summedNumber, List<Long> longFileLines) {
		for (int i=0; i<longFileLines.size(); i++) {
			boolean sumIsLessThanNumber = true;
			int lastSearchingNumberIndex = i;
			long sumOfNumbers = longFileLines.get(i);
			List<Long> summedNumbers = new ArrayList<>();
			while (sumIsLessThanNumber) {
				Long newNumber = longFileLines.get(lastSearchingNumberIndex);
				summedNumbers.add(newNumber);
				if (lastSearchingNumberIndex != i) {
					sumOfNumbers += newNumber;
				}
				if (sumOfNumbers == summedNumber) {
					return summedNumbers;
				}
				if (sumOfNumbers > summedNumber) {
					sumIsLessThanNumber = false;
				}
				lastSearchingNumberIndex++;
			}
		}
		return null;
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
