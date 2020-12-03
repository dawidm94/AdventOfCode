package aoc.year2020.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getInput;

public class Day02_2 {

	private final static String PASSWORD_POLICY_REGEX = "^(\\d+)-(\\d+)\\s(.):\\s(.+)$";

	public static void main(String[] args) throws FileNotFoundException {
		File file = getInput("day2");
		int numberOfValidPasswords = 0;
		int numberOfInvalidPasswords = 0;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			boolean isValid = processPassword(scanner.nextLine());
			if (isValid) {
				numberOfValidPasswords++;
			} else {
				numberOfInvalidPasswords++;
			}
		}
		System.out.println("CHECKED ALL PASSWORDS");
		System.out.printf("VALID: %d \r\n", numberOfValidPasswords);
		System.out.printf("INVALID: %d", numberOfInvalidPasswords);

	}

	private static boolean processPassword(String nextLine) {
		Pattern r = Pattern.compile(PASSWORD_POLICY_REGEX);
		Matcher m = r.matcher(nextLine);
		if (m.find()) {
			int firstPosition = Integer.parseInt(m.group(1)) - 1;
			int secondPosition = Integer.parseInt(m.group(2)) - 1;
			char expectedChar = m.group(3).charAt(0);
			String password = m.group(4);
			return validPassword(firstPosition, secondPosition, expectedChar, password);
		} else {
			System.out.printf("Something wrong. Could find regex '%s' for line '%s'", PASSWORD_POLICY_REGEX, nextLine);
			return false;
		}
	}

	private static boolean validPassword(int firstPosition, int secondPosition, char expectedChar, String password) {
		boolean firstValidation = password.charAt(firstPosition) == expectedChar;
		boolean secondValidation = password.charAt(secondPosition) == expectedChar;
		return firstValidation != secondValidation;
	}
}
