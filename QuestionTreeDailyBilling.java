import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class QuestionTreeDailyBilling {
    private static JSONArray jsonReport = null;

    public static void main(String[] args) {
        double lowerBilling = 0.0, higherBilling = 0.0, totalSumOrMonthlyAverage = 0.0;
        int countDays = 0;
        
        readerJson();

        for (int i = 0 ; i < jsonReport.size() ; i++) {
            JSONObject dailyBilling = ( (JSONObject) jsonReport.get(i) );
            double value = jsonObjectToDailyBilling(dailyBilling).getValue();

            if (i == 0) {
                lowerBilling = value;
                higherBilling = value;
            } else if (lowerBilling > value) {
                lowerBilling = value;
            } else if (higherBilling < value) {
                higherBilling = value;
            }

            if (value > 0.0) {
                totalSumOrMonthlyAverage += value;
                countDays++;
            }
        }

        // • O menor valor de faturamento ocorrido em um dia do mês;
            System.out.println("Lower Billing: " + lowerBilling);

	    // • O maior valor de faturamento ocorrido em um dia do mês;
            System.out.println("Higher Billing: " + higherBilling);

	    // • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
            totalSumOrMonthlyAverage = totalSumOrMonthlyAverage / countDays;
            for (int i = 0 ; i < jsonReport.size() ; i++) {
                JSONObject dailyBilling = ( (JSONObject) jsonReport.get(i) );
                double value = jsonObjectToDailyBilling(dailyBilling).getValue();
                if (value > 0 && value <= totalSumOrMonthlyAverage) countDays--;
            }
            System.out.println( "Number of Days With Highest Hilling: " + countDays );
    }

    private static void readerJson() {
        JSONParser jsonParser = new JSONParser();

        try ( FileReader reader = new FileReader("./dados.json") ) {
            jsonReport = (JSONArray) jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static DailyBilling jsonObjectToDailyBilling(JSONObject obj) {
        DailyBilling dailyBilling = new DailyBilling();
        double value = Double.parseDouble( obj.get("valor").toString() );
        dailyBilling.setValue(value);
        return dailyBilling;
    }
}
