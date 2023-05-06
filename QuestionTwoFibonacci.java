import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class QuestionTwoFibonacci {
    public static void main(String[] args) throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        long num = 1;
        while (num >= 0) {
            try {
                num = sc.nextLong();
                Boolean belongs = belongsSequentialFibonacci(num);
                if (belongs) {
                    System.out.println("Belongs...");
                } else {
                    System.out.println("Not Belong...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Informe um inteiro positivo válido!");
                sc.next();
            }
        }
        sc.close();
    }


    private static List<Long> memoryList = new ArrayList<>(Arrays.asList(0L, 1L, 1L));
    private static int indexList = 3;
    
    // O design do método foi elaborado tendo em vista testes automatizados.
    private static boolean belongsSequentialFibonacci(long num) {
        if (num >= 0 && num <= 2) {
            return true;
        } else {
            for ( ; memoryList.get(indexList-1) < num; indexList++) {
                memoryList.add(indexList, memoryList.get(indexList-1) + memoryList.get(indexList-2));
            }
            return memoryList.get(indexList-1) == num;
        }
    }
}
