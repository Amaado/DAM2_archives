package controller.computersManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Ald.Ald;
import model.Ald.AllInOne;
import model.Ald.Computer;
import model.Ald.DesktopComputer;
import model.Ald.Laptop;
import view.computersManagement.ComputersManagementDialog;


public class ComputersManagementController {
    private final ComputersManagementDialog view;
    private Ald ald;

    public ComputersManagementController(ComputersManagementDialog view, Ald ald) {
        this.view = view;
        this.ald = ald;
        this.view.addRemoveButtonActionListener(this.getRemoveButtonActionListener());
        this.view.addEditButtonActionListener(this.getEditButtonActionListener());
        this.view.addAddButtonActionListener(this.getAddButtonActionListener());
        this.view.addSaveButtonActionListener(this.getSaveButtonActionListener());
        this.view.addClearButtonActionListener(this.getClearButtonActionListener());
        this.view.addCancelButtonActionListener(this.getCancelButtonActionListener());
        this.view.addTypeComboBox(this.getTypeComboBox());
        this.view.addComputersTableMouseListener(this.getComputersTableMouseListener());
        this.view.addComputersScrollPaneMouseListener(this.getComputersScrollPaneMouseListener());
        this.initComponents();
    }
    
    private void initComponents(){
        view.setDisable("remove", true);
        view.setDisable("edit", true);
        view.setDisable("add", false);
        view.setDisable("table", false);
        view.setDisable("scrollPane", false);
        view.updateTypeLabel();
        view.disableForm();
        view.hideForm();
        view.clearTable();
        fillTable();
    }
    
    private ActionListener getRemoveButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(view, "Are you sure that you want to delete this computer?",
                        "Delete Computer", JOptionPane.INFORMATION_MESSAGE);
                if (option == 0) {
                    ald.deleteComputer(view.getComputerInfo(view.getSelectedRow(), 0));
                    JOptionPane.showMessageDialog(view, "Computer deleted succesfully.", "Computer deleted", JOptionPane.INFORMATION_MESSAGE);
                    view.clearTable();
                    fillTable();
                    initComponents();
                }
                
            }
        };
        return al;
    }
    
    
    private ActionListener getEditButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setDisable("add", true);
                view.setDisable("table", true);
                view.setDisable("edit", true);
                view.setDisable("scrollPane", true);
                view.showForm();
                view.enableForm();
                //TODO
            }
        };
        return al;
    }
    
    private ActionListener getAddButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setDisable("add", true);
                view.setDisable("table", true);
                view.setDisable("scrollPane", true);
                view.showForm();
                view.enableForm();
                view.clearForm();
            }
        };
        return al;
    }
    
    private ActionListener getSaveButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    if (!view.isAnyTextFieldBlank()) {
                    Vector row = new Vector();

                    String newSerialNumber = view.getSerialNumber();
                    String newBrand = view.getBrand();
                    String newModel = view.getModel();
                    String newAttribute = view.getAtribute();

                    if (ald.isComputerInTheList(newSerialNumber) && !newSerialNumber.equals(view.getComputerInfo(view.getSelectedRow(), 0))) {
                        JOptionPane.showMessageDialog(view, "There is already a computer with this serial number",
                                "Serial number duplicated", JOptionPane.ERROR_MESSAGE);

                    } else {
                        if (view.isRowSelected(true)) {
                            ald.deleteComputer(view.getComputerInfo(view.getSelectedRow(), 0));
                        }

                        if (view.getComputerTypeOption() == "Desktop computer") {
                            DesktopComputer dc = new DesktopComputer(newSerialNumber, newBrand,
                                    newModel, newAttribute);
                            ald.addComputer((DesktopComputer) dc);

                        } else if (view.getComputerTypeOption() == "Laptop") {
                            Laptop l = new Laptop(newSerialNumber, newBrand, newModel, newAttribute);
                            ald.addComputer((Laptop) l);

                        } else if (view.getComputerTypeOption() == "All-in-one") {
                            AllInOne aio = new AllInOne(newSerialNumber, newBrand, newModel, newAttribute);
                            ald.addComputer((AllInOne) aio);

                        }
                        view.clearTable();
                        fillTable();
                        initComponents();
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(view, "You must complete all the fields.", "Incomplete data", JOptionPane.ERROR_MESSAGE);
                }
               
            }
        };
        return al;
    }
    
    private ActionListener getClearButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               view.clearForm();
                
            }
        };
        return al;
    }
    
    private ActionListener getCancelButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initComponents();
                view.hideForm();
                view.disableForm();  
                view.clearTable();
                fillTable();
            }
        };
        return al;
    }
    
    
    private ActionListener getTypeComboBox(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.updateTypeLabel();
            }
        };
        return al;
    }
    
    private MouseListener getComputersTableMouseListener(){
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!view.isComputerScrollPaneEnable()) {
                    return;
                }
                
                int rowSelected = view.getSelectedRow();

                if (rowSelected >= 0) {
                    Computer computerSelected = ald.getComputer(view.getComputerInfo(rowSelected, 0));

                    view.setSerialNumber(computerSelected.getSerialNumber());
                    view.setBrand(computerSelected.getBrand());
                    view.setModel(computerSelected.getModel());

                    if (computerSelected instanceof DesktopComputer) {
                        view.setComputerTypeOption(0);
                        view.setAtribute(((DesktopComputer) computerSelected).getPowerSupply());

                    } else if (computerSelected instanceof Laptop) {
                        view.setComputerTypeOption(1);
                        view.setAtribute(((Laptop) computerSelected).getKeyboardLayout());

                    } else if (computerSelected instanceof AllInOne) {
                        view.setComputerTypeOption(2);
                        view.setAtribute(((AllInOne) computerSelected).getScreenResolution());
                    }
                    view.setDisable("add", true);
                    view.setDisable("remove", false);
                    view.setDisable("edit", false);
                    view.showForm();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return ml;
    }
    
    private MouseListener getComputersScrollPaneMouseListener(){
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (view.isComputerScrollPaneEnable()) {
                    view.clearSelectionMouseEvent(e);
                    initComponents();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return ml;
    }
    
    
    public void fillTable() {
        HashMap<String, Computer> computerList = ald.getComputerList();
        for (Map.Entry<String, Computer> entry : computerList.entrySet()) {
            Vector row = new Vector();
            row.add(entry.getKey());
            row.add(entry.getValue().getBrand());
            row.add(entry.getValue().getModel());
            if (entry.getValue() instanceof DesktopComputer) {
                row.add("Desktop Computer");
            } else if (entry.getValue() instanceof Laptop) {
                row.add("Laptop");
            } else if (entry.getValue() instanceof AllInOne) {
                row.add("All in One");
            }

            view.addRowTable(row);
        }        
    }
    
    
    
    
}
