package aoc.year2019;

public class Day04 {

    public static void main(String[] args) {
        int startRange = 240298;
        int endRange = 784956;
        int counter = 0;

        for (int i = startRange; i <= endRange; i++) {
            if(factsAboutPasswordAreCorrect(i)) {
                counter++;
            }
        }
        System.out.println("Possible passwords: " + counter);
    }

    private static boolean factsAboutPasswordAreCorrect(int number) {
        String integerWord = Integer.toString(number);
        boolean adjacentDigitsAreTheSame = false;
        boolean thereAreOnlyTwoSameAdjacentDigits = false;
        boolean digitsNeverDecrease = true;

        char[] digitsArray = integerWord.toCharArray();
        for (int i=1; i<digitsArray.length; i++) {
//            PART 1
//            if (digitsArray[i-1] == digitsArray[i]) {
//                adjacentDigitsAreTheSame = true;
//            }

//            PART 2
            if ((digitsArray[i-1] == digitsArray[i])) {
                int wordLength = integerWord.length();
                int wordLengthWithoutCurrentChar = integerWord.replaceAll(Character.toString(digitsArray[i]), "").length();
                adjacentDigitsAreTheSame = true;
                if (wordLength - wordLengthWithoutCurrentChar == 2) {
                    thereAreOnlyTwoSameAdjacentDigits = true;
                }
            }

            if (Character.getNumericValue(digitsArray[i-1]) > Character.getNumericValue(digitsArray[i])) {
                digitsNeverDecrease = false;
                break;
            }
        }
        return adjacentDigitsAreTheSame && digitsNeverDecrease && thereAreOnlyTwoSameAdjacentDigits;
    }
}
