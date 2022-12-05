package aoc.year2022.day3;

import aoc.AocUtils;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import static aoc.model.AocDay.DAY_3;
import static aoc.model.AocYear.YEAR2022;

public class Day03_2 {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) throws IOException {
		int result = 0;
		List<String> lines = AocUtils.getAllStringLines(YEAR2022, DAY_3);

		ListIterator<String> linesIterator = lines.listIterator();
		
		while (linesIterator.hasNext()) {
			String firstRucksacks = linesIterator.next();
			String secondRucksack = linesIterator.next();
			String thirdRucksacks = linesIterator.next();

			for (Character sign: firstRucksacks.toCharArray()) {
				if (secondRucksack.contains(sign.toString())) {
					if (thirdRucksacks.contains(sign.toString())) {
						result += (ALPHABET.indexOf(sign) + 1);
						break;
					}
				}
			}
		}

		System.out.println("Result is: " + result);
	}
}
