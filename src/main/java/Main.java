import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter text:");
        String simpleText = scanner.nextLine();

        String[] sentences = simpleText.split("[.!?]");
        int maxWords = 0;
        for (String sentence : sentences) {
            int words = sentence.split("[\\s,]+").length;
            if (words > maxWords) {
                maxWords = words;
            }
        }

        System.out.println("Sentence with max words contain: " + maxWords + " words");
// ----------------------------------------------------
        System.out.println("Please enter phone number: ");

        String phoneNumberInput = scanner.nextLine();

        String phoneNumber = phoneNumberInput.replaceAll("[ \\-]+", "");
        String[] phoneNumberResult = phoneNumber.split("(?<=\\G...)");
        String lastDigits = phoneNumberResult[phoneNumberResult.length - 1];
        if (lastDigits.length() == 1) {
            phoneNumberResult[phoneNumberResult.length - 1] = phoneNumberResult[phoneNumberResult.length - 2].charAt(2) + lastDigits;
            phoneNumberResult[phoneNumberResult.length - 2] = phoneNumberResult[phoneNumberResult.length - 2].substring(0, 2);
        }
        System.out.println("Converted phone number is: " + String.join("-", phoneNumberResult));
//-----------------------------------------------------
        System.out.println("Please array of enter integer numbers separated by space:");

        int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arrayNumbers);
        int minInteger = 0;
        if (arrayNumbers[0] > 1 || arrayNumbers[arrayNumbers.length - 1] <= 0) {
            minInteger = 1;
        } else {
            for (int i = 0; i < arrayNumbers.length - 1; i++) {
                if (arrayNumbers[i] < arrayNumbers[i + 1] - 1) {
                    if (arrayNumbers[i] <= 0 && arrayNumbers[i + 1] > 1) {
                        minInteger = 1;
                    } else {
                        minInteger = arrayNumbers[i] + 1;
                    }
                    if (minInteger >= 1) {
                        break;
                    }
                }
            }
        }
        if (minInteger == 0) {
            minInteger = arrayNumbers[arrayNumbers.length - 1] + 1;
        }
        System.out.println("Minimal integer is: " + minInteger);
    }
}
