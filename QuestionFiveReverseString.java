import java.util.Locale;
import java.util.Scanner;

public class QuestionFiveReverseString {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scann = new Scanner(System.in);
        String phrase = scann.nextLine();
        for (int i = phrase.length() - 1 ; i >= 0  ; i --)
            System.out.print(phrase.charAt(i));
        System.out.println();
        scann.close();
    }
}
