import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks in the subject SSIC: ");
        int SSIC = scanner.nextInt();
        System.out.print("Enter marks in the subject OS: ");
        int OS = scanner.nextInt();
        System.out.print("Enter marks in the subject AT: ");
        int AT = scanner.nextInt();
        System.out.print("Enter marks in the subject WP: ");
        int WP = scanner.nextInt();
        System.out.print("Enter marks in the subject CNS: ");
        int CNS = scanner.nextInt();

        int totalMarks = SSIC+OS+AT+WP+CNS;

        float average = (float) totalMarks /5;
        System.out.println("Your totals marks are: "+totalMarks);
        System.out.println("Average of your marks is: "+average);

        if(average>80){
            System.out.println("You have obtain A grade");
        } else if (average>60 && average<80) {
            System.out.println("You have obtain B grade");
        } else if (average>40 && average<60) {
            System.out.println("You have obtain C grade");
        }
        else{
            System.out.println("Sorry, you have failed");
        }
        scanner.close();
    }
}
