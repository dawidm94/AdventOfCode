package aoc.year2020.day13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day13_1 {

	public static void main(String[] args) throws IOException {
		List<String> inputList = getAllInputLines("day13");
		long earliestTimestampNumber = Long.parseLong(inputList.get(0));
		List<Long> busNumbers = getOnlyNumbers(inputList.get(1));
		boolean foundClosestNumber = false;
		long tempTimestampNumber = earliestTimestampNumber;
		long myBusNumber = 0;
		while (!foundClosestNumber) {
			for (Long busNumber: busNumbers) {
				if (tempTimestampNumber % busNumber == 0) {
					foundClosestNumber = true;
					myBusNumber = busNumber;
					break;
				}
			}
			if (!foundClosestNumber) {
				tempTimestampNumber++;
			}
		}
		System.out.println((tempTimestampNumber - earliestTimestampNumber) * myBusNumber);
	}

	private static List<Long> getOnlyNumbers(String line) {
		List<Long> numberList = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\d+");
		for (String field : line.split(",")) {
			Matcher matcher = pattern.matcher(field);
			if (matcher.find()) {
				numberList.add(Long.parseLong(field));
			}
		}
		return numberList;
	}
}