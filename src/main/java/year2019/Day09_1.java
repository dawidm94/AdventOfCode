package main.java.year2019;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day09_1 {

	// https://www.reddit.com/r/adventofcode/comments/e8dr6o/intcode_immediate_write_mode_demonstration/
	//jest get value read and get value write, bo imiditli w write nadpisuje nastepna wartosc
	private static List<Long> input = Arrays
			.asList(11101L,1L,0L,0L,4L,3L,101L,0L,2L,1L,101L,0L,3L,2L,10101L,-1L,17L,64L,1005L,17L,0L,99L
			);
	private static List<Long> inputList;
	private static final Long INPUT_VALUE = 1L;
	private static Long relativeBase = 0L;

	public static void main(String[] args) {
		inputList = input;
//		inputList = parseIntListToLongList(input);
		calculate(inputList);
	}

	private static List<Long> parseIntListToLongList(List<Integer> list) {
		return list.stream()
				.mapToLong(Integer::longValue)
				.boxed()
				.collect(Collectors.toList());
	}

	private static void calculate(List<Long> inputList) {
		int i=0, length = inputList.size();
		dance: while (i < length) {
			Long nexValue = inputList.get(i);
			String instruction = String.format("%05d", nexValue).replaceAll("-","0");
			int firstParamMode = Integer.parseInt(instruction.substring(2, 3));
			int secondParamMode = Integer.parseInt(instruction.substring(1,2));
			int thirdParamMode = Integer.parseInt(instruction.substring(0,1));
			int opCode = Integer.parseInt(instruction.substring(3,5));
			Long firstParam, secondParam, thirdParam, thirdParamValue;

			switch (opCode) {
				case 1:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					secondParam = getParam(inputList.get(i+2), secondParamMode);
					thirdParam = getParam(inputList.get(i+3), thirdParamMode);
					inputList.set(thirdParam.intValue(), firstParam+secondParam);
					i+=4;
					break;

				case 2:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					secondParam = getParam(inputList.get(i+2), secondParamMode);
					thirdParam = getParam(inputList.get(i+3), thirdParamMode);
					inputList.set(thirdParam.intValue(), firstParam*secondParam);
					i+=4;
					break;

				case 3:
					firstParam = inputList.get(i+1);
					inputList.set(firstParam.intValue(), INPUT_VALUE);
					i+=2;
					break;

				case 4:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					System.out.println("OUTPUT: " + firstParam);
					i+=2;
					break;

				case 5:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					if (firstParam != 0) {
						i = getParam(inputList.get(i+2), secondParamMode).intValue();
					} else {
						i+=3;
					}
					break;

				case 6:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					if (firstParam == 0) {
						i = getParam(inputList.get(i+2), secondParamMode).intValue();
					} else {
						i+=3;
					}
					break;

				case 7:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					secondParam = getParam(inputList.get(i+2), secondParamMode);
					thirdParam = getParam(inputList.get(i+3), thirdParamMode);
					if (firstParam < secondParam) {
						inputList.set(thirdParam.intValue(), 1L);
					} else {
						inputList.set(thirdParam.intValue(), 0L);
					}
					i+=4;
					break;

				case 8:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					secondParam = getParam(inputList.get(i+2), secondParamMode);
					thirdParam = getParam(inputList.get(i+3), thirdParamMode);
					if (firstParam.equals(secondParam)) {
						inputList.set(thirdParam.intValue(), 1L);
					} else {
						inputList.set(thirdParam.intValue(), 0L);
					}
					i+=4;
					break;

				case 9:
					firstParam = getParam(inputList.get(i+1), firstParamMode);
					relativeBase += firstParam;
					i+=2;
					break;

				case 99:
					break dance; // (° ͜ʖ °)
			}
		}
	}

	private static Long getParam(Long index, int paramMode) {
		if (paramMode == 0) {
			return inputList.get(index.intValue());
		} else if (paramMode == 1) {
			return index;
		} else {
			Long indexWithRelativeBase = index + relativeBase;
			return inputList.get(indexWithRelativeBase.intValue());
		}
	}
}
