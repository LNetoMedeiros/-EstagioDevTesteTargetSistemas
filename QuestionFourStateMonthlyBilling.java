import java.util.Map;
import java.util.HashMap;

public class QuestionFourStateMonthlyBilling {
    public static void main(String[] args) throws Exception {
        Map<String, Double> stateMonthlyBilling = new HashMap<>();
        stateMonthlyBilling.put("SP", 67836.43);
        stateMonthlyBilling.put("RJ", 36678.66);
        stateMonthlyBilling.put("MG", 29229.88);
        stateMonthlyBilling.put("ES", 27165.48);
        stateMonthlyBilling.put("Outros", 19849.53);

        System.out.printf("Percentage of SP = %.2f%n", calculateRepresentation("SP", stateMonthlyBilling));
        System.out.printf("Percentage of RJ = %.2f%n", calculateRepresentation("RJ", stateMonthlyBilling));
        System.out.printf("Percentage of MG = %.2f%n", calculateRepresentation("MG", stateMonthlyBilling));
        System.out.printf("Percentage of ES = %.2f%n", calculateRepresentation("ES", stateMonthlyBilling));
        System.out.printf("Percentage of Outros = %.2f%n", calculateRepresentation("Outros", stateMonthlyBilling));
    }

    private static Double calculateRepresentation(String state, Map<String, Double> map) {
        Double sum = 0.0;
        for ( String key : map.keySet() ) {
            sum += map.get(key);
        }
        try {
            return (map.get(state) * 100) / sum;
        } catch (Exception e) {
            return null; // return null if invalid key
        }
    }
}
