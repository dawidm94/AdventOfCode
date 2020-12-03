package aoc.year2020.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day03_2 {
	private static final SlopeMove[] moves = new SlopeMove[] {
				new SlopeMove(1,1),
				new SlopeMove(3,1),
				new SlopeMove(5,1),
				new SlopeMove(7,1),
				new SlopeMove(1,2)
	};
	private static final char TREE_SIGN = '#';

	public static void main(String[] args) throws IOException {
		long multipliedTreesCounter = 0;
		List<char[]> roadMap = prepareRoadMap();
		for (SlopeMove move: moves) {
			long treeCounter = countTrees(roadMap, move);

			if (multipliedTreesCounter == 0) {
				multipliedTreesCounter = treeCounter;
			} else {
				multipliedTreesCounter *= treeCounter;
			}
		}

		System.out.printf("Multiplied trees -> %d", multipliedTreesCounter);
	}

	private static long countTrees(List<char[]> roadMap, SlopeMove move) {
		int treeCounter = 0;
		int actualRowPosition = 0;
		int actualColumnPosition = 0;
		for (char[] row : roadMap) {
			if (actualColumnPosition % move.getDownMove() == 0) {
				if (row[actualRowPosition%row.length] == TREE_SIGN) {
					treeCounter++;
				}
				actualRowPosition += move.getRightMove();
			}
			actualColumnPosition++;
		}
		return treeCounter;
	}

	private static List<char[]> prepareRoadMap() throws IOException {
		List<String> inputLines = getAllInputLines("day3");
		List<char[]> roadMap = new ArrayList<>();
		for (String line : inputLines) {
			roadMap.add(line.toCharArray());
		}
		return roadMap;
	}

	static class SlopeMove {
		final int rightMove;
		final int downMove;

		SlopeMove(int rightMove, int downMove) {
			this.rightMove = rightMove;
			this.downMove = downMove;
		}

		public int getRightMove() {
			return rightMove;
		}

		public int getDownMove() {
			return downMove;
		}
	}
}
