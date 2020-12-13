package aoc.year2020.day12;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day12_2 {
	private static final String COMMAND_REGEX = "^(\\D)(\\d+)$";
	private static final String LEFT_COMMAND = "L";
	private static final String RIGHT_COMMAND = "R";
	private static final String FORWARD_COMMAND = "F";
	private static long waypointFirstUnit = 10;
	private static Direction waypointFirstDirection = Direction.EAST;
	private static Direction waypointSecondDirection = Direction.NORTH;
	private static long waypointSecondUnit = 1;
	private static long shipEastUnit = 0;
	private static long shipNorthUnit = 0;

	public static void main(String[] args) throws IOException {
		List<String> inputList = getAllInputLines("day12");
		Pattern p = Pattern.compile(COMMAND_REGEX);
//		System.out.println("START WAYPOINT[" + waypointSecondUnit + " " + waypointSecondDirection + "  " + waypointFirstUnit + waypointFirstDirection + "] SHIP [ North: " + shipNorthUnit + " East: " + shipEastUnit );

		for (String row : inputList) {
			Matcher matcher = p.matcher(row);
			if (matcher.find()) {
				String command = matcher.group(1);
				int number = Integer.parseInt(matcher.group(2));

				if (LEFT_COMMAND.equals(command) || RIGHT_COMMAND.equals(command)) {
					waypointFirstDirection = Direction.changeDirection(waypointFirstDirection, command, number);
					waypointSecondDirection = Direction.changeDirection(waypointSecondDirection, command, number);
				} else if (FORWARD_COMMAND.equals(command)) {
					moveShip(number);
				} else {
					Direction.move(command, number);
				}
				System.out.println("BOAT (" + shipEastUnit + ", " + (shipNorthUnit *-1) + ") WAYPOINT ("+ waypointSecondUnit + ", " + waypointFirstUnit + ")");
//				System.out.println("Command was " + command+number + ", so WAYPOINT[" + waypointSecondUnit + " " + waypointSecondDirection + "  " + waypointFirstUnit + waypointFirstDirection + "] SHIP [ North: " + shipNorthUnit + " East: " + shipEastUnit );
			}
		}
		System.out.println(shipEastUnit);
		System.out.println(shipNorthUnit);
		System.out.println("Manhattan distance is " + (Math.abs(shipNorthUnit) + Math.abs(shipEastUnit)));
	}

	private static void moveShip(int number) {
		if (Direction.EAST == waypointFirstDirection) {
			shipEastUnit += waypointFirstUnit * number;
		} else if (Direction.EAST == waypointSecondDirection) {
			shipEastUnit += waypointSecondUnit * number;
		} else if (Direction.WEST == waypointFirstDirection) {
			shipEastUnit -= waypointFirstUnit * number;
		} else {
			shipEastUnit -= waypointSecondUnit * number;
		}

		if (Direction.NORTH == waypointFirstDirection) {
			shipNorthUnit += waypointFirstUnit * number;
		} else if (Direction.NORTH == waypointSecondDirection) {
			shipNorthUnit += waypointSecondUnit * number;
		} else if (Direction.SOUTH == waypointFirstDirection) {
			shipNorthUnit -= waypointFirstUnit * number;
		} else {
			shipNorthUnit -= waypointSecondUnit * number;
		}
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

		public static Direction changeDirection(Direction direction, String command, int degree) {
			int moveCode = degree/90;
			int tempCode;
			if (LEFT_COMMAND.equals(command)) {
				tempCode = direction.code - moveCode;
			} else {
				tempCode = direction.code + moveCode;
			}
			int newActualCode = (4 + tempCode) % 4;
			for (Direction dir : Direction.values()) {
				if (dir.code == newActualCode) {
					return dir;
				}
			}
			return null;
		}

		public static void move(String command, int number) {
			if (NORTH.command.equals(command)) {
				if (Direction.NORTH == waypointFirstDirection) {
					waypointFirstUnit += number;
				} else if (Direction.SOUTH == waypointFirstDirection) {
					waypointFirstUnit -= number;
				} else if (Direction.NORTH == waypointSecondDirection){
					waypointSecondUnit += number;
				} else {
					waypointSecondUnit -= number;
				}
			} else if (EAST.command.equals(command)) {
				if (Direction.EAST == waypointFirstDirection) {
					waypointFirstUnit += number;
				} else if (Direction.WEST == waypointFirstDirection){
					waypointFirstUnit -= number;
				} else if (Direction.WEST == waypointSecondDirection) {
					waypointSecondUnit -= number;
				} else {
					waypointSecondUnit += number;
				}
			} else if (WEST.command.equals(command)) {
				if (Direction.EAST == waypointFirstDirection) {
					waypointFirstUnit -= number;
				} else if (Direction.WEST == waypointFirstDirection){
					waypointFirstUnit += number;
				} else if (Direction.WEST == waypointSecondDirection) {
					waypointSecondUnit += number;
				} else {
					waypointSecondUnit -= number;
				}
			} else if (SOUTH.command.equals(command)) {
				if (Direction.NORTH == waypointFirstDirection) {
					waypointFirstUnit -= number;
				} else if (Direction.SOUTH == waypointFirstDirection) {
					waypointFirstUnit += number;
				} else if (Direction.NORTH == waypointSecondDirection){
					waypointSecondUnit -= number;
				} else {
					waypointSecondUnit += number;
				}
			}
		}
	}
}