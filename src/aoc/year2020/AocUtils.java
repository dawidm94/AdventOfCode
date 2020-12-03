package aoc.year2020;

import java.io.File;

public class AocUtils {

	private static final String AOC_2020_SRC = "src/aoc/year2020/";
	private static final String INPUT_FILE_NAME = "/input.txt";

	public static File getInput(String dayName) {
		return new File(AOC_2020_SRC + dayName + INPUT_FILE_NAME);
	}
}
