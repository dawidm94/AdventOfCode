package aoc.year2020.day5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static aoc.year2020.AocUtils.getInputFile;

public class Day05_1 {

	private static final int MIN_ROW_NUMBER = 0;
	private static final int MAX_ROW_NUMBER = 127;
	private static final int MIN_COLUMN_NUMBER = 0;
	private static final int MAX_COLUMN_NUMBER = 7;

	public static void main(String[] args) throws IOException {
		int highestSeatId = 0;
		File file = getInputFile("day5");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String actualLine = sc.nextLine();
			String rowCode = actualLine.substring(0,7);
			String columnCode = actualLine.substring(7);
			int rowNumber = calculateNumber(MIN_ROW_NUMBER, MAX_ROW_NUMBER, rowCode);
			int columnNumber = calculateNumber(MIN_COLUMN_NUMBER, MAX_COLUMN_NUMBER, columnCode);
			int seatId = rowNumber * 8 + columnNumber;

			if (seatId > highestSeatId) {
				highestSeatId = seatId;
			}
		}
		System.out.println("The highest seat ID is " + highestSeatId);
	}

	private static int calculateNumber(double minNumber, double maxNumber, String code) {
		char actualChar =  code.charAt(0);
		double range = maxNumber - minNumber;
		if (actualChar == 'L' || actualChar == 'F') {
			maxNumber = maxNumber - Math.ceil(range/2.0);
		} else {
			minNumber = minNumber + Math.ceil(range/2.0);
		}

		if (code.length() > 1) {
			code = code.substring(1);
			return calculateNumber(minNumber, maxNumber, code);
		}
			return (int) maxNumber;
	}

}
