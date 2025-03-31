package model.Ald;

public class Laptop extends Computer {
    private String keyboardLayout;
    
    public Laptop(String serialNumber, String brand, String model, String keyboardLayout) {
        super(serialNumber, brand, model);
        this.keyboardLayout = keyboardLayout;
    }

    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    public void setKeyboardLayout(String keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }
    
    
    
}

