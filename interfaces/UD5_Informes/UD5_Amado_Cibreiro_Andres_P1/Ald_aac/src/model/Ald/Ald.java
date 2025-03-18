package model.Ald;

import java.util.ArrayList;
import java.util.HashMap;

public class Ald {

    private String name;
    private String address;
    private String phoneNumber;
    private int numberOfEmployees;
    private static HashMap<String, Computer> computerList = null;
    private static Ald ald = null;

    private Ald() {
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        this.numberOfEmployees = 0;
        this.computerList = new HashMap<>();
    }

    public static Ald getModel() {
        if (Ald.ald == null) {
            Ald.ald = new Ald();
        }

        return Ald.ald;
    }

    public void addComputer(Computer computer) {
        this.computerList.put(computer.getSerialNumber(), computer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumEmployees() {
        return numberOfEmployees;
    }

    public void setNumEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public HashMap<String, Computer> getComputerList() {
        return computerList;
    }

    public Computer getComputer(String key) {
        return computerList.get(key);
    }

    public void deleteComputer(String key) {
        computerList.remove(key);
    }

    public boolean isComputerInTheList(String key) {
        if (computerList.containsKey(key)) {
            return true;
        }

        return false;
    }
}
