package aoc.year2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AocUtils {

	private static final String AOC_2020_SRC = "src/aoc/year2020/";
	private static final String INPUT_FILE_NAME = "/input.txt";

	public static File getInputFile(String dayName) {
		return new File(AOC_2020_SRC + dayName + INPUT_FILE_NAME);
	}

	public static List<String> getAllInputLines(String dayName) throws IOException {
		return Files.readAllLines(Paths.get(AOC_2020_SRC + dayName + INPUT_FILE_NAME));
	}
}
