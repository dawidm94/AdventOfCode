package aoc.year2022.day4;

import aoc.AocUtils;

import java.io.IOException;
import java.util.List;

import static aoc.model.AocDay.DAY_4;
import static aoc.model.AocYear.YEAR2022;

public class Day04_1 {

	public static void main(String[] args) throws IOException {
		int result = 0;

		List<String> lines = AocUtils.getAllStringLines(YEAR2022, DAY_4);

		for (String line: lines) {
			String[] pairs = line.split(",");

			String[] firstPairMemberSections = pairs[0].split("-");

			int fromSectionOfFirstMember = Integer.parseInt(firstPairMemberSections[0]);
			int toSectionOfFirstMember = Integer.parseInt(firstPairMemberSections[1]);

			String[] secondPairMemberSections = pairs[1].split("-");

			int fromSectionSecondMember = Integer.parseInt(secondPairMemberSections[0]);
			int toSectionOfSecondMember = Integer.parseInt(secondPairMemberSections[1]);

			if (fromSectionOfFirstMember >= fromSectionSecondMember && toSectionOfFirstMember <= toSectionOfSecondMember) {
				result ++;
				continue;
			}

			if (fromSectionSecondMember >= fromSectionOfFirstMember && toSectionOfSecondMember <= toSectionOfFirstMember) {
				result ++;
			}
		}

		System.out.println("Result is: " + result);
	}
}
