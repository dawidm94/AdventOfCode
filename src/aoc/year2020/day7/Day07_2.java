package aoc.year2020.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getInputFile;

public class Day07_2 {

	private static final String EXPECTED_BAG = "shiny gold";
	private static int finalResult = 0;

	public static void main(String[] args) throws FileNotFoundException {
		File file = getInputFile("day7");
		findAndCount(EXPECTED_BAG, file, 1);

		System.out.println("Result: " + finalResult);
	}

	private static void findAndCount(String findingBag, File file, int multiplyNumber) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String lineRegex = "(\\d) (.+) bag";
		Pattern pattern = Pattern.compile(lineRegex);
		while (sc.hasNextLine()) {
			String actualLine = sc.nextLine();
			String[] cutLine = actualLine.split("bags contain");
			String bagThatContain = cutLine[0].trim();
			if (bagThatContain.contains(findingBag)) {
				String[] list = cutLine[1].split(",");
				for (String bag : list) {
					Matcher matcher = pattern.matcher(bag);
					if (matcher.find()) {
						int number = Integer.parseInt(matcher.group(1));
						finalResult = finalResult + (multiplyNumber * number);
						String locatedBag = matcher.group(2);
						System.out.println("Szukajac " + findingBag + " mnoze " + multiplyNumber + " razy " + number + " bag:" +  locatedBag);
						findAndCount(locatedBag, file, multiplyNumber * number);
					}
				}
			}
		}
	}
}
