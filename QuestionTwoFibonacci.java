import java.util.*;

public class QuestionTwoFibonacci {
    public static void main(String [] args) throws Exception {
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        Boolean belongs = belongsSequentialFibonacci(num);
        if (belongs.booleanValue()) {
            System.out.println("Belongs...");
        } else {
            System.out.println("Not Belong...");
        }

        sc.close();
    }

    // Refatoração do método "belongsSequentialFibonacci" para possuir apenas um parâmetro;
<<<<<<< HEAD
    // A mudança no design do método foi realizada tendo em vista a implementação de um possível cenário de testes. 
=======
    // A mudança no design foi feita tendo em vista a implementação de um possível cenário de testes. 
>>>>>>> 35310c039593eac18a246a0df497dcb201d8f344
    private static Integer a = 0, b = 1;
    private static Boolean belongsSequentialFibonacci(Integer num) {
        if (num.intValue() == a) {
            return true;
        } else if (num < a) {
            return false;
        } else {
            int aux = a;
            a = b;
            b += aux;
            return belongsSequentialFibonacci(num);
        }
    }
}
