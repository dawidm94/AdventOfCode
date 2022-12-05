package aoc.year2022.day3;

import aoc.AocUtils;

import java.io.IOException;
import java.util.List;

import static aoc.model.AocDay.DAY_3;
import static aoc.model.AocYear.YEAR2022;

public class Day03_1 {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) throws IOException {
		int result = 0;
		List<String> lines = AocUtils.getAllStringLines(YEAR2022, DAY_3);

		for (String line: lines) {
			int lineLength = line.length();
			String firstCompartment = line.substring(0, lineLength / 2);
			String secondCompartment = line.substring(lineLength / 2, lineLength);

			for (Character sign: firstCompartment.toCharArray()) {
				if (secondCompartment.contains(sign.toString())) {
					result += (ALPHABET.indexOf(sign) + 1);
					break;
				}
			}
		}

		System.out.println("Result is: " + result);
	}
}
