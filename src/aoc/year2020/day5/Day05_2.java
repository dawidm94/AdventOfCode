package aoc.year2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static aoc.year2020.AocUtils.getInputFile;

public class Day05_2 {

	private static final int MIN_ROW_NUMBER = 0;
	private static final int MAX_ROW_NUMBER = 127;
	private static final int MIN_COLUMN_NUMBER = 0;
	private static final int MAX_COLUMN_NUMBER = 7;
	private static final int MIN_SEAT_ID = MIN_ROW_NUMBER * MIN_COLUMN_NUMBER;
	private static final int MAX_SEAT_ID = MAX_ROW_NUMBER * 8 + MAX_COLUMN_NUMBER;

	public static void main(String[] args) throws IOException {
		File file = getInputFile("day5");
		List<Integer> seatIdList = getSeatIdList(file);
		Integer santaSeatId = getSantaSeat(seatIdList);
		System.out.println("Santa's seat ID is " + santaSeatId);
	}

	private static Integer getSantaSeat(List<Integer> seatIdList) {
		for (int i = MIN_SEAT_ID + 1; i < MAX_SEAT_ID; i++) {
			if (!seatIdList.contains(i)) {
				if (seatIdList.contains(i-1) && seatIdList.contains(i+1)) {
					return i;
				}
			}
		}
		return null;
	}

	private static List<Integer> getSeatIdList(File file) throws FileNotFoundException {
		List<Integer> seatIdList = new ArrayList<>();
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String actualLine = sc.nextLine();
			String rowCode = actualLine.substring(0,7);
			String columnCode = actualLine.substring(7);
			int rowNumber = calculateNumber(MIN_ROW_NUMBER, MAX_ROW_NUMBER, rowCode);
			int columnNumber = calculateNumber(MIN_COLUMN_NUMBER, MAX_COLUMN_NUMBER, columnCode);
			seatIdList.add(rowNumber * 8 + columnNumber);
		}
		return seatIdList;
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
