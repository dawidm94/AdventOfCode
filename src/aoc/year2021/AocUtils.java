package aoc.year2021;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AocUtils {

	private static final String AOC_2021_SRC = "src/aoc/year2021/";
	private static final String INPUT_FILE_NAME = "/input.txt";

	public static File getInputFile(String dayName) {
		return new File(AOC_2021_SRC + dayName + INPUT_FILE_NAME);
	}

	public static List<String> getAllStringLines(String dayName) throws IOException {
		return Files.readAllLines(Paths.get(AOC_2021_SRC + dayName + INPUT_FILE_NAME));
	}
	public static List<Integer> getAllIntegerLines(String dayName) throws IOException {
		return Files.readAllLines(Paths.get(AOC_2021_SRC + dayName + INPUT_FILE_NAME))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
