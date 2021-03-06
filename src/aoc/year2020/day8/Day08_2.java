package aoc.year2020.day8;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day08_2 {

	private static final String INSTRUCTION_REGEX = "([a-z]{3})[\\s+]*(-?\\d+)";

	public static void main(String[] args) throws IOException {
		int accumulatorNumber = 0;
		List<String> fileLines = getAllInputLines("day8");
		for (int i=0; i<fileLines.size(); i++) {
			String changedLine;
			if (fileLines.get(i).contains("jmp")) {
				changedLine = fileLines.get(i).replace("jmp", "nop");
			} else if (fileLines.get(i).contains("nop")) {
				changedLine = fileLines.get(i).replace("nop", "jmp");

			} else {
				continue;
			}
			List<String> modifiedFile = new ArrayList<>(fileLines);
			modifiedFile.set(i, changedLine);
			accumulatorNumber = checkIfTheInstructionsAreInfinitiveLoop(modifiedFile);
			if (accumulatorNumber != 0) {
				break;
			}
		}
		System.out.println("Acc number: " + accumulatorNumber);
	}

	private static int checkIfTheInstructionsAreInfinitiveLoop(List<String> fileLines) {
		int accumulatorNumber = 0;
		Set<Integer> usedInstructions = new HashSet<>();
		Pattern p = Pattern.compile(INSTRUCTION_REGEX);
		for (int i=0; i<fileLines.size(); i++) {
			boolean infinitiveLoop = checkIfInstructionWasUsed(usedInstructions, i);
			if (infinitiveLoop) {
				return 0;
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
		return accumulatorNumber;
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
