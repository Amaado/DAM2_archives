package model.Ald;

public class AllInOne extends Computer {
    private String screenResolution; 
    
    public AllInOne(String serialNumber, String brand, String model, String screenResolution) {
        super(serialNumber, brand, model);
        this.screenResolution = screenResolution;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }
    
    
    
}

