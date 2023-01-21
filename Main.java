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
        // Array of Korean numbers
        String[] koreanNumbers = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
        // Array of Korean tens
        String[] koreanTens = {"", "십", "백", "천"};
        // Array of Korean big numbers
        String[] koreanBigNumbers = {"", "만", "억", "조", "경"};
        int count = 0;
        String koreanNumber = "";
        // Recursively translate large numbers
        if (number >= 10000) {
            koreanNumber = getKoreanNumber(number / 10000) + koreanBigNumbers[++count];
            number = number % 10000;
        }
        // Translate the rest of the number
        while (number > 0) {
            int n = number % 10;
            if (n != 0) {
                koreanNumber = koreanNumbers[n] + koreanTens[count % 4] + koreanNumber;
            }
            count++;
            number /= 10;
        }
        return koreanNumber;
    }
}