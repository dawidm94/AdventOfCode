package aoc;

import aoc.model.AocDay;
import aoc.model.AocYear;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AocUtils {

	private static final String AOC_SRC = "src/aoc/";
	private static final String INPUT_FILE_NAME = "/input.txt";

	public static File getInputFile(AocYear year, AocDay day) {
		return new File(getPathName(year, day));
	}

	public static List<String> getAllStringLines(AocYear year, AocDay day) throws IOException {
		return Files.readAllLines(Paths.get(getPathName(year, day)));
	}
	public static List<Integer> getAllIntegerLines(AocYear year, AocDay day) throws IOException {
		return Files.readAllLines(Paths.get(getPathName(year, day)))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static String getPathName(AocYear year, AocDay day) {
		return AOC_SRC + year + "/" + day + "/" + INPUT_FILE_NAME;
	}
}
