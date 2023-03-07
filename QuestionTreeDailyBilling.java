import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class DailyBilling {
    private Integer day = null;
    private Double value = null;
    
    public DailyBilling() {
    }

    public DailyBilling(Integer day, Double value) {
        this.day = day;
        this.value = value;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    
    public Integer getDay() {
        return day;
    }
    
    public Double getValue() {
        return value;
    }

}

public class QuestionTreeDailyBilling {
    public static void main(String[] args) {

        DailyBilling[] report = new DailyBilling[30];
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Users/netom/Downloads/dados.json")) {
            JSONArray jsonReport = (JSONArray) jsonParser.parse(reader);
            jsonReport.forEach(dailyBilling -> jsonParserDailyBilling( (JSONObject) dailyBilling, report));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Double lowerBilling = 0.0, higherBilling = 0.0, sum = 0.0, monthlyAverage = 0.0;
        Integer countDaysAvarege = 0, countDaysGreater = 0;

        for ( int i = 0 ; i < report.length ; i++ ) {
            Double value = report[i].getValue();
            if ( i == 0 ) {
                lowerBilling = value;
                higherBilling = value;
            } else if ( lowerBilling > value ) {
                lowerBilling = value;
            } else if (higherBilling < value ) {
                higherBilling = value;
            }

            if ( value > 0.0 ) {
                sum += value;
                countDaysAvarege++;
            }
        }

        // • O menor valor de faturamento ocorrido em um dia do mês;
            System.out.println("Lower Billing: " + lowerBilling);

	    // • O maior valor de faturamento ocorrido em um dia do mês;
            System.out.println("Higher Billing: " + higherBilling);

	    // • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
            monthlyAverage = sum / countDaysAvarege;
            //System.out.println(monthlyAverage);
            for (int i = 0 ; i < 30 ; i ++) {
                if (report[i].getValue() > monthlyAverage) countDaysGreater++;
            }
            System.out.println("Number of Days With Highest Hilling: " + countDaysGreater);

    }

    /**
     * @param obj    JSONObject que representa o faturamento diário.
     * @param report Um vetor que corresponde ao relatório de faturamento do mês.
     * @apiNote      O objetivo desse método é armazenar os dias de faturamento no vetor de relatório de vendas.
     */
    private static void jsonParserDailyBilling(JSONObject obj, DailyBilling[] report) {
        DailyBilling d = new DailyBilling();
        Integer day = Integer.parseInt(obj.get("dia").toString());
        Double value = Double.parseDouble(obj.get("valor").toString());
        d.setDay(day); d.setValue(value);
        report[day - 1] = d;
    }
}
