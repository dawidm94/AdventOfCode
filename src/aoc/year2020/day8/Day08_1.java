package aoc.year2020.day8;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day08_1 {

	private static final String INSTRUCTION_REGEX = "([a-z]{3})[\\s+]*(-?\\d+)";

	public static void main(String[] args) throws IOException {
		int accumulatorNumber = 0;
		Set<Integer> usedInstructions = new HashSet<>();
		List<String> fileLines = getAllInputLines("day8");
		Pattern p = Pattern.compile(INSTRUCTION_REGEX);
		for (int i=0; i<fileLines.size(); i++) {
			boolean infinitiveLoop = checkIfInstructionWasUsed(usedInstructions, i);
			if (infinitiveLoop) {
				break;
			}
			Matcher m = p.matcher(fileLines.get(i));
			if (m.find()) {
				String instruction = m.group(1);
				int number = Integer.parseInt(m.group(2));
				if ("acc".equals(instruction)) {
					accumulatorNumber+=number;

				} else if ("jmp".equals(instruction)) {
					i += number - 1;
				}
			}
		}
		System.out.println("Acumulator number: " + accumulatorNumber);
	}

	private static boolean checkIfInstructionWasUsed(Set<Integer> usedInstructions, int i) {
		if (usedInstructions.contains(i)) {
			return true;
		} else {
			usedInstructions.add(i);
			return false;
		}
	}

}
