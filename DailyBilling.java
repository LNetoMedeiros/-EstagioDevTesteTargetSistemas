public class DailyBilling {
    private Double value = null;
    
    public DailyBilling() {}
    public DailyBilling(Double value) {
        this.value = value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    
    public Double getValue() {
        return value;
    }
}
