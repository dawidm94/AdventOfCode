package aoc.year2020.day4;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getInputFile;
import static aoc.year2020.day4.PassportValidator.*;

public class Day04_2 {

	public static void main(String[] args) throws IOException {
		int validPassportNumber = 0;
		File file = getInputFile("day4");
		Scanner sc = new Scanner(file);
		StringBuffer sb = new StringBuffer();
		while (sc.hasNextLine()) {
			String actualLine = sc.nextLine();
			if (actualLine.isEmpty() || !sc.hasNextLine()) {
				if (!sc.hasNextLine()) {
					sb.append(" ").append(actualLine);
				}
				boolean isValidPassport = validPassport(sb);
				if (isValidPassport) {
					validPassportNumber++;
				}
				sb = new StringBuffer();
			} else {
				sb.append(" ").append(actualLine);
			}
		}
		System.out.println("Number of valid passports: " + validPassportNumber);
	}

	private static boolean validPassport(StringBuffer sb) {
		Map<String, String> passportMap = processLineIntoMap(sb);
		return validPassportMap(passportMap);
	}

	private static boolean validPassportMap(Map<String, String> passportMap) {
		return  validBirthYear(passportMap.get("byr"))
				&& validIssueYear(passportMap.get("iyr"))
				&& validExpirationYear(passportMap.get("eyr"))
				&& validHeight(passportMap.get("hgt"))
				&& validHairColor(passportMap.get("hcl"))
				&& validEyeColor(passportMap.get("ecl"))
				&& validPassportId(passportMap.get("pid"));
	}

	private static Map<String, String> processLineIntoMap(StringBuffer sb) {
		String keyValueRegex = "(\\S+):(\\S+)";
		Pattern p = Pattern.compile(keyValueRegex);
		Matcher m = p.matcher(sb.toString());
		Map<String, String> passportMap = new HashMap<>();
		while (m.find()) {
			passportMap.put(m.group(1), m.group(2));
		}
		return passportMap;
	}
}
