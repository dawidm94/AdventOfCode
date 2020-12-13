package aoc.year2020.day12;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day12_1 {
	private static final String COMMAND_REGEX = "^(\\D)(\\d+)$";
	private static final String LEFT_COMMAND = "L";
	private static final String RIGHT_COMMAND = "R";
	private static final String FORWARD_COMMAND = "F";
	private static long eastUnit = 0;
	private static long northUnit = 0;
	private static Direction actualDirection = Direction.EAST;

	public static void main(String[] args) throws IOException {
		List<String> inputList = getAllInputLines("day12");
		Pattern p = Pattern.compile(COMMAND_REGEX);
		for (String row : inputList) {
			Matcher matcher = p.matcher(row);
			if (matcher.find()) {
				String command = matcher.group(1);
				int number = Integer.parseInt(matcher.group(2));

				if (LEFT_COMMAND.equals(command) || RIGHT_COMMAND.equals(command)) {
					Direction.changeDirection(command, number);
				} else if (FORWARD_COMMAND.equals(command)) {
					Direction.move(actualDirection.command, number);
				} else {
					Direction.move(command, number);
				}
				System.out.println("Command was " + command+number + ", so North: " + northUnit + " East: " + eastUnit + " actualDirection = " + actualDirection);
			}
		}
		System.out.println("Manhattan distance is " + (Math.abs(northUnit) + Math.abs(eastUnit)));
	}

	enum Direction {
		NORTH(0, "N"),
		EAST(1, "E"),
		SOUTH(2, "S"),
		WEST(3, "W");

		Direction(int code, String command) {
			this.code = code;
			this.command = command;
		}
		protected int code;
		protected String command;

		public static void changeDirection(String command, int degree) {
			int moveCode = degree/90;
			int tempCode;
			if (LEFT_COMMAND.equals(command)) {
				tempCode = actualDirection.code - moveCode;
			} else {
				tempCode = actualDirection.code + moveCode;
			}
			int newActualCode = (4 + tempCode) % 4;
			for (Direction dir : Direction.values()) {
				if (dir.code == newActualCode) {
					actualDirection = dir;
				}
			}
		}

		public static void move(String command, int number) {
			if (NORTH.command.equals(command)) {
				northUnit += number;
			} else if (EAST.command.equals(command)) {
				eastUnit += number;
			} else if (WEST.command.equals(command)) {
				eastUnit -= number;
			} else if (SOUTH.command.equals(command)) {
				northUnit -= number;
			}
		}
	}
}