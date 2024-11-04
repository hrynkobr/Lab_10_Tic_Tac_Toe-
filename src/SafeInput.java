import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear the newline
                validInput = true;
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0.0;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the newline
                validInput = true;
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter a double.");
            }
        } while (!validInput);
        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear the newline
                if (retVal >= low && retVal <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter an integer between " + low + " and " + high + ".");
                }
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return retVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0.0;
        boolean validInput = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the newline
                if (retVal >= low && retVal <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a double between " + low + " and " + high + ".");
                }
            } else {
                pipe.nextLine(); // clear the invalid input
                System.out.println("Invalid input. Please enter a double.");
            }
        } while (!validInput);
        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        boolean validInput = false;
        boolean result = false;
        do {
            System.out.print(prompt + " [y/n]: ");
            response = pipe.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                validInput = true;
                result = true;
            } else if (response.equals("n")) {
                validInput = true;
                result = false;
            } else {
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            }
        } while (!validInput);
        return result;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine().trim();
            if (response.matches(regEx)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please match the pattern: " + regEx);
            }
        } while (!validInput);
        return response;
    }
    public static void prettyHeader(String msg) {
        int width = 60;
        int stars = 3;
        int padding = (width - msg.length() - (stars * 2)) / 2;

        // Top border
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Middle row with message
        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Bottom border
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
