import java.util.Locale;
import java.util.Scanner;

public class QuestionTwoFibonacci {
    public static void main(String [] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        Boolean belongs = belongsSequential(num, 0, 1);
        if (belongs) {
            System.out.println("Belongs...");
        }
        else {
            System.out.println("Not Belong...");
        }
        sc.close();
    }

    private static Boolean belongsSequential(Integer num, Integer a, Integer b) {
        if (num.intValue() == a.intValue()) {
            return true;
        } else if (num.intValue() < a.intValue()) {
            return false;
        } else {
            System.out.println(a);
            return belongsSequential(num, b, b + a);
        }
    }
}