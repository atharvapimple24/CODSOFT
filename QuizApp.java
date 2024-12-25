import java.util.*;

class QuizApp {
    private static class Question {
        String questionText;
        List<String> options;
        int correctOption;

        Question(String questionText, List<String> options, int correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    private static final List<Question> questions = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        setupQuestions();
        System.out.println("Welcome to the Quiz App! Answer the questions within the time limit.");

        int questionNumber = 1;
        for (Question question : questions) {
            System.out.println("\nQuestion " + questionNumber++ + ":");
            boolean answeredCorrectly = askQuestion(question);
            if (answeredCorrectly) {
                score++;
            }
        }

        displayResults();
    }

    private static void setupQuestions() {
        questions.add(new Question(
                "Who is the current no.1 ODI batsman in world?",
                Arrays.asList("Warner", "Babar", "Rohit", "Virat"),
                3
        ));

        questions.add(new Question(
                "Which planet is known as the Red Planet?",
                Arrays.asList("Earth", "Mars", "Jupiter", "Venus"),
                2
        ));

        questions.add(new Question(
                "Who wrote 'Hamlet'?",
                Arrays.asList("Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"),
                2
        ));
    }

    private static boolean askQuestion(Question question) {
        System.out.println(question.questionText);

        for (int i = 0; i < question.options.size(); i++) {
            System.out.println((i + 1) + ". " + question.options.get(i));
        }

        long startTime = System.currentTimeMillis();
        long timeLimit = 10 * 1000; // 10 seconds
        int userAnswer = 0;

        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime > timeLimit) {
                System.out.println("Time's up! Moving to the next question.");
                return false;
            }

            System.out.print("Your answer (1-" + question.options.size() + "): ");
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
                if (userAnswer >= 1 && userAnswer <= question.options.size()) {
                    break;
                } else {
                    System.out.println("Please select a valid option.");
                }
            } else {
                scanner.next(); // Consume invalid input
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        if (userAnswer == question.correctOption) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Wrong! The correct answer was: " + question.options.get(question.correctOption - 1));
            return false;
        }
    }

    private static void displayResults() {
        System.out.println("\nQuiz Over! Here are your results:");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (questions.size() - score));

        System.out.println("\nSummary:");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            System.out.println("Your Answer: " + (i + 1 == score ? "Correct" : "Incorrect"));
        }

        System.out.println("\nYour Final Score: " + score + "/" + questions.size());
    }
}
