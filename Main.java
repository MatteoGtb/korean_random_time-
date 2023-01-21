import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create a new Scanner object to get input from the user
        Scanner input = new Scanner(System.in);
        // Create a new Random object to generate random numbers
        Random rand = new Random();

        // Prompt the user to enter the number of random times to generate
        System.out.println("Enter the number of random times to generate: ");
        int numTimes = input.nextInt();

        // Generate the specified number of random times
        for (int i = 0; i < numTimes; i++) {
            // Generate a random hour, minute, and second
            int hour = rand.nextInt(24);
            int minute = rand.nextInt(60);
            int second = rand.nextInt(60);
            // Print out the generated time
            System.out.println("Random time " + (i + 1) + ": " + hour + ":" + minute + ":" + second);

            // Ask the user if they want to translate the time into Korean
            System.out.println("Do you want to translate this time into Korean? (yes/no)");
            String translate = input.next();
            // If the user wants to translate the time
            if (translate.equalsIgnoreCase("yes")) {
                // Translate the hour, minute, and second into Korean
                String koreanHour = getKoreanNumber(hour) + " 시 ";
                String koreanMinute = getKoreanNumber(minute) + " 분 ";
                String koreanSecond = getKoreanNumber(second) + " 초";
                // Print out the translated time
                System.out.println("The time in Korean: " + koreanHour + koreanMinute + koreanSecond);
            }
        }
    }

    // Method to translate a number into Korean
    public static String getKoreanNumber(int number) {
        // Array of Korean numbers from 0 to 9
        String[] koreanNumbers = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
        // Array of Korean tens, like 10, 20, 30, etc
        String[] koreanTens = {"", "십", "백", "천"};
        // Array of Korean big numbers, like 10k, 100M, 1B
        String[] koreanBigNumbers = {"", "만", "억", "조", "경"};
        int count = 0;
        String koreanNumber = "";
        // loop through the number
        while (number > 0) {
            // get the last digit of the number
            int n = number % 10;
            // check if the last digit is not zero
            if (n != 0) {
                // add the corresponding number in the koreanNumbers array
                koreanNumber = koreanNumbers[n] + koreanTens[count % 4] + koreanNumber;
            }
            count++;
            number /= 10;
        }
        // return the korean number
        return koreanNumber;
    }
}