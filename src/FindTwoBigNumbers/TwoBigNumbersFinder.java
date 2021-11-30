package FindTwoBigNumbers;

import java.util.InputMismatchException;
import java.util.Scanner;

class TwoBigNumbersFinder extends DataStorage {
    Scanner scannerObject = new Scanner(System.in);

    public void getTheSizeOfTheListFromTheUser() {
        System.out.println("\nI will find the two big numbers from the given list...\n");
        System.out.println("Enter the number as a List size which is above 2: ");
        try {
            int sizeOfTheList = scannerObject.nextInt();
            if (sizeOfTheList <= 2) {
                System.out.println("Oops, Enter the List size above 2...");
                System.out.println("Enter the List size again:");
                sizeOfTheList = scannerObject.nextInt();
            }
            setSizeOfTheList(sizeOfTheList);
        } catch (InputMismatchException exceptionInSize) {
            System.out.println("Oops, List size must be a number..");
        }
    }

    public void getTheListElementsFromTheUser() {
        if (getSizeOfTheList() != 0) {
            System.out.println("\nEnter the numbers into the list:");
            try {
                int[] listOfNumbers = new int[getSizeOfTheList()];
                for (int indexOfTheList = 0; indexOfTheList < getSizeOfTheList(); indexOfTheList++) {
                    listOfNumbers[indexOfTheList] = scannerObject.nextInt();
                }
                setListOfNumbers(listOfNumbers);
            } catch (InputMismatchException exceptionInListElements) {
                System.out.println("Oops, only numbers are allowed as List elements..");
            }
        }
    }

    public void findTwoBigNumbers() {
        if (getListOfNumbers() != null) {
            int maximumOne = Integer.MIN_VALUE;
            int maximumTwo = Integer.MIN_VALUE;
            for (int number : getListOfNumbers()) {
                if (number > maximumOne) {
                    maximumTwo = maximumOne;
                    maximumOne = number;
                } else if (number > maximumTwo) {
                    maximumTwo = number;
                }
            }
            System.out.println("The Biggest Number: " + maximumOne);
            System.out.println("The Second Biggest Number: " + maximumTwo);
        }
    }
}
