package aoc.year2020.day11;

import java.io.IOException;
import java.util.List;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day11_1 {

	private static int SEAT_ROWS = 0;
	private static int SEAT_COLUMNS = 0;
	private static final Character OCCUPIED_SEAT = '#';
	private static final Character EMPTY_SEAT = 'L';
	private static Character[][] seatMap;

	public static void main(String[] args) throws IOException {
		List<String> inputList = getAllInputLines("day11");
		SEAT_ROWS = inputList.size();
		SEAT_COLUMNS = inputList.get(0).length();
		seatMap = prepareSeatMap(inputList);
		int occupiedSeatsCounter = countOccupiedSeats();
		while (true) {
			Character[][] newSeatMap = new Character[SEAT_ROWS][SEAT_COLUMNS];
			for (int i=0; i<SEAT_ROWS; i++) {
				for (int j=0; j<SEAT_COLUMNS; j++) {
					newSeatMap[i][j] = processNewSeat(i, j);
				}
			}
			seatMap = newSeatMap;
			int newOccupiedSeatsCounter = countOccupiedSeats();

			if (occupiedSeatsCounter == newOccupiedSeatsCounter) {
				break;
			} else {
				occupiedSeatsCounter = newOccupiedSeatsCounter;
			}
		}
		System.out.println("Result - occupied seats: " + occupiedSeatsCounter);
	}

	private static int countOccupiedSeats() {
		int occupiedSeatsCounter = 0;
		for (Character[] row : seatMap) {
			for (Character singleChar : row) {
				if (OCCUPIED_SEAT == singleChar) {
					occupiedSeatsCounter++;
				}
			}
		}
		return occupiedSeatsCounter;
	}

	private static Character processNewSeat(int rowNumber, int colNumber) {
		Character seat = seatMap[rowNumber][colNumber];
		if (EMPTY_SEAT == seat && countAdjacentSeats(rowNumber, colNumber) == 0) {
			return OCCUPIED_SEAT;
		} else if (OCCUPIED_SEAT == seat && countAdjacentSeats(rowNumber, colNumber) >= 4) {
			return EMPTY_SEAT;
		} else {
			return seat;
		}
	}

	private static Integer countAdjacentSeats(int rowNumber, int colNumber) {
		Integer adjacentSeatsCounter = 0;

		if (rowNumber != 0) {
			if (colNumber != 0) {
				adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber - 1, colNumber - 1);
			}

			adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber - 1, colNumber);

			if (colNumber != SEAT_COLUMNS - 1) {
				adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber - 1, colNumber + 1);
			}
		}
		if (colNumber != 0) {
			adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber, colNumber - 1);
		}
		if (colNumber != SEAT_COLUMNS - 1) {
			adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber, colNumber + 1);
		}
		if (rowNumber != SEAT_ROWS - 1) {
			if (colNumber != 0) {
				adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber + 1, colNumber - 1);
			}

			adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber + 1, colNumber);

			if (colNumber != SEAT_COLUMNS - 1) {
				adjacentSeatsCounter = addIfIsOccupied(adjacentSeatsCounter, rowNumber + 1, colNumber + 1);
			}
		}
		return adjacentSeatsCounter;
	}

	private static Integer addIfIsOccupied(Integer occupiedSeatsCounter, int rowNumber, int colNumber) {
		if (seatMap[rowNumber][colNumber] == OCCUPIED_SEAT) {
			return occupiedSeatsCounter + 1;
		} else {
			return occupiedSeatsCounter;
		}
	}

	private static Character[][] prepareSeatMap(List<String> inputList) {
		Character[][] seatMap = new Character[SEAT_ROWS][SEAT_COLUMNS];
		for (int i = 0; i < inputList.size(); i++) {
			char[] rowChars = inputList.get(i).toCharArray();
			for (int j = 0; j < rowChars.length; j++) {
				seatMap[i][j] = rowChars[j];
			}
		}
		return  seatMap;
	}
}