package aoc.year2020.day13;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static aoc.year2020.AocUtils.getAllInputLines;

public class Day13_2 {

	public static void main(String[] args) throws IOException {
		List<String> inputList = getAllInputLines("day13");
		List<String> busSchedule = Arrays.asList(inputList.get(1).split(","));
		Long firstBusNumber = Long.parseLong(busSchedule.get(0));
		Long checkTime = firstBusNumber;
		boolean foundResult = false;
		while (!foundResult) {
			long tempTime = checkTime;
			for (String busNumber : busSchedule) {
				if (!busNumber.equals("x")) {
					Long busNumberLong = Long.parseLong(busNumber);
					if (tempTime % busNumberLong != 0) {
						break;
					}
					if (busNumber.equals(busSchedule.get(busSchedule.size()-1))) {
						System.out.println("FOUND! " + checkTime);
						foundResult = true;
					}
				}
				tempTime++;
			}
			checkTime += firstBusNumber;
			System.out.println(checkTime);
		}
	}
}