package aoc.year2020.day7;

import java.io.IOException;
import java.util.*;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day07_1 {

	public static void main(String[] args) throws IOException {
		List<String> fileLines = getAllInputLines("day7");
		Set<String> expectedKindOfBagSet = new HashSet<>();
		expectedKindOfBagSet.add("shiny gold");
		Set<String> finalResult = new HashSet<>();
		countBags(finalResult, fileLines, expectedKindOfBagSet);

		System.out.println("Result: " + finalResult.size());
	}

	private static void countBags(Set<String> finalResult, List<String> fileLines, Set<String> searchingBags) {
		Set<String> foundBags = new HashSet<>();

		for (String line : fileLines) {
			boolean isFoundBags = false;
			String lineWithContainedBags = line.substring(line.indexOf("contain"));
			String bagThatContainsBags = line.substring(0, line.indexOf("bag"));
			for (String searchingBag : searchingBags) {
				if (lineWithContainedBags.contains(searchingBag)) {
					isFoundBags = true;
					break;
				}
			}
			if (isFoundBags) {
				foundBags.add(bagThatContainsBags);
			}
		}
		finalResult.addAll(foundBags);
		if (!foundBags.isEmpty()) {
			countBags(finalResult, fileLines, foundBags);
		}
	}
}
