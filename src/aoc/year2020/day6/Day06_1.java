package aoc.year2020.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static aoc.year2020.AocUtils.getInputFile;

public class Day06_1 {
	public static void main(String[] args) throws FileNotFoundException {
		long positiveNumbersSum = 0;
		File file = getInputFile("day6");
		Scanner sc = new Scanner(file);
		StringBuffer sb = new StringBuffer();
		while (sc.hasNextLine()) {
			String actualLine = sc.nextLine();
			if (actualLine.isEmpty() || !sc.hasNextLine()) {
				if (!sc.hasNextLine()) {
					sb.append(actualLine);
				}
				int groupPositiveAnswersNumber = countPositiveAnswers(sb.toString());
				positiveNumbersSum += groupPositiveAnswersNumber;
				sb = new StringBuffer();
			} else {
				sb.append(actualLine);
			}
		}
		System.out.println("Sum of positive numbers: " + positiveNumbersSum);
	}

	private static int countPositiveAnswers(String positiveAnswers) {
		Set<Character> positiveAnswersSet = new HashSet<>();
		char[] questionsArray = positiveAnswers.toCharArray();
		for (char question : questionsArray) {
			positiveAnswersSet.add(question);
		}
		return  positiveAnswersSet.size();
	}
}
