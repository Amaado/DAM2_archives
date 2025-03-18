package model.Ald;

public class DesktopComputer extends Computer {
    
    private String powerSupply;
    
    public DesktopComputer(String serialNumber, String brand, String model, String powerSupply) {
        super(serialNumber, brand, model);
        this.powerSupply = powerSupply;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }
    
    
}