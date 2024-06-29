import java.util.Scanner;

public class Quiz {
    private static final int NUM_QUESTIONS = 5;
    private static final int TIME_LIMIT = 60; // in seconds

    private static String[] questions = {
        "What is the capital of France?",
        "Who wrote 'To Kill a Mockingbird'?",
        "What is the chemical symbol for water?",
        "What is the tallest mammal?",
        "Who painted the Mona Lisa?"
    };

    private static String[][] options = {
        {"A. London", "B. Paris", "C. Rome", "D. Berlin"},
        {"A. Mark Twain", "B. Harper Lee", "C. J.K. Rowling", "D. Charles Dickens"},
        {"A. H", "B. O", "C. W", "D. A"},
        {"A. Elephant", "B. Giraffe", "C. Rhinoceros", "D. Hippopotamus"},
        {"A. Leonardo da Vinci", "B. Vincent van Gogh", "C. Pablo Picasso", "D. Michelangelo"}
    };

    private static char[] answers = {'B', 'B', 'C', 'B', 'A'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have " + TIME_LIMIT + " seconds to complete " + NUM_QUESTIONS + " questions.");

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000; // Convert milliseconds to seconds

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + NUM_QUESTIONS);
        System.out.println("Time taken: " + totalTime + " seconds");

        if (totalTime > TIME_LIMIT) {
            System.out.println("You exceeded the time limit!");
        }
    }
}