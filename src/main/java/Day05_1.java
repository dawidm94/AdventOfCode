package main.java;

import java.util.Arrays;
import java.util.List;

public class Day05_1 {

    private static List<Integer> input = Arrays
        .asList(3,225,1,225,6,6,1100,1,238,225,104,0,1101,40,71,224,1001,224,-111,224,4,224,1002,223,8,223,101,7,224,224,1,224,223,223,1102,66,6,225,1102,22,54,225,1,65,35,224,1001,224,-86,224,4,224,102,8,223,223,101,6,224,224,1,224,223,223,1102,20,80,225,101,92,148,224,101,-162,224,224,4,224,1002,223,8,223,101,5,224,224,1,224,223,223,1102,63,60,225,1101,32,48,225,2,173,95,224,1001,224,-448,224,4,224,102,8,223,223,1001,224,4,224,1,224,223,223,1001,91,16,224,101,-79,224,224,4,224,1002,223,8,223,101,3,224,224,1,224,223,223,1101,13,29,225,1101,71,70,225,1002,39,56,224,1001,224,-1232,224,4,224,102,8,223,223,101,4,224,224,1,223,224,223,1101,14,59,225,102,38,143,224,1001,224,-494,224,4,224,102,8,223,223,101,3,224,224,1,224,223,223,1102,30,28,224,1001,224,-840,224,4,224,1002,223,8,223,101,4,224,224,1,223,224,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,107,677,226,224,1002,223,2,223,1005,224,329,1001,223,1,223,8,226,226,224,102,2,223,223,1006,224,344,101,1,223,223,7,226,677,224,1002,223,2,223,1005,224,359,101,1,223,223,1007,677,226,224,1002,223,2,223,1005,224,374,1001,223,1,223,1007,677,677,224,1002,223,2,223,1006,224,389,101,1,223,223,1008,226,226,224,1002,223,2,223,1005,224,404,1001,223,1,223,108,677,226,224,1002,223,2,223,1006,224,419,1001,223,1,223,1108,677,226,224,102,2,223,223,1006,224,434,1001,223,1,223,108,226,226,224,1002,223,2,223,1005,224,449,101,1,223,223,7,677,677,224,1002,223,2,223,1006,224,464,1001,223,1,223,8,226,677,224,1002,223,2,223,1005,224,479,1001,223,1,223,107,226,226,224,102,2,223,223,1006,224,494,101,1,223,223,1007,226,226,224,1002,223,2,223,1005,224,509,1001,223,1,223,1107,226,677,224,102,2,223,223,1005,224,524,1001,223,1,223,108,677,677,224,1002,223,2,223,1005,224,539,101,1,223,223,1107,677,226,224,102,2,223,223,1005,224,554,1001,223,1,223,107,677,677,224,1002,223,2,223,1005,224,569,101,1,223,223,8,677,226,224,102,2,223,223,1005,224,584,1001,223,1,223,7,677,226,224,102,2,223,223,1006,224,599,101,1,223,223,1008,677,677,224,1002,223,2,223,1005,224,614,101,1,223,223,1008,677,226,224,102,2,223,223,1006,224,629,1001,223,1,223,1108,677,677,224,102,2,223,223,1006,224,644,101,1,223,223,1108,226,677,224,1002,223,2,223,1005,224,659,1001,223,1,223,1107,226,226,224,102,2,223,223,1006,224,674,1001,223,1,223,4,223,99,226);
    private static final int DEFAULT_INPUT_INTEGER = 1;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < input.size(); i++) {
            Integer firstParam;
            Integer secondParam;
            Integer thirdParam;
            Integer nextParamValue;
            Integer modeOfFirstParam = 0;
            Integer modeOfSecondParam = 0;
            Integer modeOfThirdParam = 0;
            boolean isInstruction;

            if (input.get(i) == 99) {
                break;

            } else {
                Integer oppcode = input.get(i);

                if (oppcode.toString().length() > 2) {
                    String instruction = String.format("%05d", oppcode).replaceAll("-","0");
                    modeOfThirdParam = Integer.parseInt(instruction.substring(0,1));
                    modeOfSecondParam = Integer.parseInt(instruction.substring(1,2));
                    modeOfFirstParam = Integer.parseInt(instruction.substring(2, 3));
                    oppcode = Integer.parseInt(instruction.substring(3,5));
                    isInstruction = true;

                } else {
                    isInstruction = false;
                }

                firstParam = getValueAtIndex(input.get(i+1), modeOfFirstParam == 1);
                nextParamValue = input.get(i+1);


                if (oppcode == 1 || oppcode == 2) {
                    secondParam = getValueAtIndex(input.get(i+2), modeOfSecondParam == 1);
                    thirdParam = modeOfThirdParam == 1 ? i+3 : input.get(i+3);

                    if (oppcode == 1) {
                        input.set(thirdParam, firstParam + secondParam);
                    } else {
                        input.set(thirdParam, firstParam * secondParam);
                    }

                } else if (oppcode == 3) {
                    input.set(nextParamValue, DEFAULT_INPUT_INTEGER);

                } else if (oppcode == 4) {
                    Integer inputValue = getValueAtIndex(nextParamValue, isInstruction);
                    System.out.println(inputValue);

                } else {
                    throw new Exception("Wrong oppcode (" + oppcode + ") at " + i + "line.");

                }
                i = increaseIndex(i, isInstruction, oppcode);
            }
        }
    }

    private static int increaseIndex(int index, boolean isInstruction, Integer oppcode) {

        if (oppcode == 1 || oppcode == 2) {
            index += 3;
        } else {
            index += 1;
        }
        return index;
    }

    private static int getValueAtIndex(Integer index, boolean isImmediateMode) {
        return isImmediateMode ? index : input.get(index);
    }
}
