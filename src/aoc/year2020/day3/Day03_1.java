package aoc.year2020.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day03_1 {
	private static int RIGHT_MOVE = 3;
	private static char TREE_SIGN = '#';

	public static void main(String[] args) throws IOException {
		List<char[]> roadMap = prepareRoadMap();
		int treeCounter = countTrees(roadMap);
		System.out.printf("Found %d trees", treeCounter);
	}

	private static int countTrees(List<char[]> roadMap) {
		int treeCounter = 0;
		int actualRowPosition = 0;
		for (char[] row : roadMap) {
			if (row[actualRowPosition%row.length] == TREE_SIGN) {
				treeCounter++;
			}
			actualRowPosition += RIGHT_MOVE;
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
}
