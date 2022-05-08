package pl.interview.tasks;

public class Main {

    /**
     Created by xciechan
     on 2022-05-07

     The application finds the smallest positive integer x,
     such that 2x, 3x, 4x, 5x, 6x, contain the same digits.
     */

    public static void main(String[] args) {
        int rangeOfSearch = 1000000;

        if (smallestPositiveIntegerX(rangeOfSearch) != 0)
            System.out.println("Smallest positive integer x = " + smallestPositiveIntegerX(rangeOfSearch));
        else
            System.out.println("Such number x does not exist in this range");

    }

    public static int smallestPositiveIntegerX (int rangeOfSearch){
        String[] arrayOfNumber = new String[6]; // [x, 2x, 3x, 4x ,5x, 6x]
        String digitsOfNumberX;

        for (int count=1; count<rangeOfSearch; count++) {
            int numberX = count;

            for (int i = 0; i < arrayOfNumber.length; i++) {
                arrayOfNumber[i] = String.valueOf(numberX * (i + 1));
            }

            while (numberX > 0) {
                digitsOfNumberX = String.valueOf(numberX % 10);
                for (int i = 0; i < arrayOfNumber.length; i++) {
                    arrayOfNumber[i] = arrayOfNumber[i].replaceFirst(digitsOfNumberX, "#");
                }
                numberX /= 10;
            }

            int countOfTrueCondition = 0;
            for (int i = 0; i < arrayOfNumber.length; i++) {
                if (arrayOfNumber[0].equals(arrayOfNumber[i])) {
                    countOfTrueCondition += 1;
                }
            }

            if (countOfTrueCondition == 6) {
                return count;
            }
        }

        return 0;
    }
}

