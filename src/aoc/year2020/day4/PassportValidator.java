package aoc.year2020.day4;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportValidator {
	private static final int MIN_BIRTH_YEAR = 1920;
	private static final int MAX_BIRTH_YEAR = 2002;
	private static final int MIN_ISSUE_YEAR = 2010;
	private static final int MAX_ISSUE_YEAR = 2020;
	private static final int MIN_EXPIRATION_YEAR = 2020;
	private static final int MAX_EXPIRATION_YEAR = 2030;
	private static final int MIN_CM_HEIGHT = 150;
	private static final int MAX_CM_HEIGHT = 193;
	private static final int MIN_IN_HEIGHT = 59;
	private static final int MAX_IN_HEIGHT = 76;
	private static final String COLOR_REGEX = "^#[0-9a-f]{6}$";
	private static final String PASSPORT_ID_REGEX = "^[0-9]{9}$";
	private static final List<String> EYE_COLORS = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

	public static boolean validBirthYear(String birthYear) {
		return birthYear != null
				&& Integer.parseInt(birthYear) >= MIN_BIRTH_YEAR
				&& Integer.parseInt(birthYear) <= MAX_BIRTH_YEAR;
	}

	public static boolean validIssueYear(String issueYear) {
		return issueYear != null
				&& Integer.parseInt(issueYear) >= MIN_ISSUE_YEAR
				&& Integer.parseInt(issueYear) <= MAX_ISSUE_YEAR;
	}
	public static boolean validExpirationYear(String expirationYear) {
		return expirationYear != null
				&& Integer.parseInt(expirationYear) >= MIN_EXPIRATION_YEAR
				&& Integer.parseInt(expirationYear) <= MAX_EXPIRATION_YEAR;
	}

	public static boolean validHeight(String height) {
		if (height == null) {
			return false;
		}
		String heightUnit = height.substring(height.length() - 2);
		int heightNumber = Integer.parseInt(height.substring(0, height.length()-2));
		return heightUnit.equals("cm")
				? heightNumber >= MIN_CM_HEIGHT && heightNumber <= MAX_CM_HEIGHT
				: heightNumber >= MIN_IN_HEIGHT && heightNumber <= MAX_IN_HEIGHT;
	}

	public static boolean validHairColor(String hairColor) {
		if (hairColor != null ) {
			Pattern p = Pattern.compile(COLOR_REGEX);
			Matcher m = p.matcher(hairColor);
			return m.find();

		} else {
			return false;
		}
	}
	public static boolean validPassportId(String passportId) {
		if (passportId != null) {
			Pattern p = Pattern.compile(PASSPORT_ID_REGEX);
			Matcher m = p.matcher(passportId);
			return m.find();

		} else {
			return false;
		}
	}

	public static boolean validEyeColor(String eyeColor) {
		return eyeColor != null && EYE_COLORS.contains(eyeColor);
	}
}
