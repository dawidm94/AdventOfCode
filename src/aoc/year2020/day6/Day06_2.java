package aoc.year2020.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static aoc.year2020.AocUtils.getInputFile;

public class Day06_2 {

	public static void main(String[] args) throws FileNotFoundException {
		long questionAnsweredByEveryoneSum = 0;
		File file = getInputFile("day6");
		Scanner sc = new Scanner(file);
		StringBuffer sb = new StringBuffer();
		int peopleInGroup = 0;
		while (sc.hasNextLine()) {
			String actualLine = sc.nextLine();
			if (actualLine.isEmpty() || !sc.hasNextLine()) {
				if (!sc.hasNextLine()) {
					peopleInGroup++;
					sb.append(actualLine);
				}
				int groupPositiveAnswersNumber = countPositiveAnswersFromByWholeGroup(sb.toString(), peopleInGroup);
				questionAnsweredByEveryoneSum += groupPositiveAnswersNumber;
				sb = new StringBuffer();
				peopleInGroup = 0;
			} else {
				peopleInGroup++;
				sb.append(actualLine);
			}
		}
		System.out.println("Question answered by everyone sum: " + questionAnsweredByEveryoneSum);
	}

	private static int countPositiveAnswersFromByWholeGroup(String positiveAnswers, int peopleInGroup) {
		Map<Character, Integer> questionAnsweredNumber = new HashMap<>();
		int questionAnsweredByEveryone = 0;
		for (char question :positiveAnswers.toCharArray()) {
			addQuestionIntoMap(questionAnsweredNumber, question);
		}

		for (Map.Entry<Character, Integer> entry : questionAnsweredNumber.entrySet()) {
			if (entry.getValue() == peopleInGroup) {
				questionAnsweredByEveryone++;
			}
		}
		return questionAnsweredByEveryone;
	}

	private static void addQuestionIntoMap(Map<Character, Integer> questionAnsweredNumber, char question) {
		questionAnsweredNumber.merge(question, 1, Integer::sum);
	}

}
