import java.util.*;

public class QuestionTwoFibonacci {
    public static void main(String [] args) throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        try {
            Integer num = sc.nextInt();
            Boolean belongs = belongsSequentialFibonacci(num);
            if (belongs) {
                System.out.println("Belongs...");
            } else {
                System.out.println("Not Belong...");
            }
        } catch(InputMismatchException e) {
            System.out.println("Informe um inteiro válido!");
        } finally {
            sc.close();
        }
    }

    // O design do método foi feita tendo em vista a implementação de um cenário de testes.
    private static Integer a = 0, b = 1;
    private static Boolean belongsSequentialFibonacci(Integer num) {
        if (num.intValue() == a.intValue() ) {
            return true;
        } else if (num.intValue()  < a.intValue() ) {
            return false;
        } else {
            int aux = a;
            a = b;
            b += aux;
            return belongsSequentialFibonacci(num);
        }
    }
}
