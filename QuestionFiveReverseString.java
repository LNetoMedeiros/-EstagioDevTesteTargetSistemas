import java.util.*;

public class QuestionFiveReverseString {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner scann = new Scanner(System.in);
        String phrase = scann.nextLine();
        System.out.println( reverseString(phrase.toCharArray()) ); 
  
        scann.close();
    }

    private static String reverseString(char[] s) {
        int halfSize = s.length/2;
        for (int i = 1 ; i <= halfSize ; i++) {
            char aux = s[i-1];
            s[i-1] = s[s.length-i];
            s[s.length-i] = aux;
        }
        return new String(s);
    }
}
