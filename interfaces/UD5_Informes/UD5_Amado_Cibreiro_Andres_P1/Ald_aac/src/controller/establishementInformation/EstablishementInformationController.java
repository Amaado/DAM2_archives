package controller.establishementInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Ald.Ald;
import view.establishmentInformation.EstablishmentInformationDialog;

public class EstablishementInformationController {
    private final EstablishmentInformationDialog view;
    private Ald ald;
    
    public EstablishementInformationController(EstablishmentInformationDialog view, Ald ald) {
        this.view = view;
        this.ald = ald;
        this.view.addSaveButtonActionListener(this.getSaveButtonActionListener());
        this.view.addEditButtonActionListener(this.getEditButtonActionListener());
        this.view.addCleanButtonActionListener(this.getCleanButtonActionListener());
        this.view.addCancelButtonActionListener(this.getCancelButtonActionListener());
        this.initComponents();
    }
    
    private void initComponents(){
        view.setButtonEnabeled("save");
        view.setButtonEnabeled("clean");
        view.setButtonEnabeled("edit");
        
        if(ald.getName().isBlank() && ald.getAddress().isBlank() && ald.getPhone().isBlank() && ald.getNumEmployees() == 0){
            view.setButtonDisabled("edit");
            view.setTextFieldsEnabled();
        }else{
            view.setButtonDisabled("save");
            view.setButtonDisabled("clean");
            view.setTextFieldsDisabled();
        }
        view.setName(ald.getName());
        view.setAddress(ald.getAddress());
        view.setPhone(ald.getPhone());
        view.setEmployeesNuber(ald.getNumEmployees());
        
    }
    
    
    private ActionListener getSaveButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ald.setName(view.getName());
                ald.setAddress(view.getAddress());
                ald.setPhone(view.getPhone());
                ald.setNumEmployees(view.getEmployeesNumber());
                view.setButtonEnabeled("edit");
                view.setButtonDisabled("save");
                view.setButtonDisabled("clean");
                view.setTextFieldsDisabled();
                view.setCancelButtonName("Cancel");
                
            }
        };
        return al;
    }
    
    private ActionListener getEditButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setButtonDisabled("edit");
                view.setButtonEnabeled("save");
                view.setButtonEnabeled("clean");
                view.setTextFieldsEnabled();
                view.setCancelButtonName("Volver");
                
            }
        };
        return al;
    }
        
    private ActionListener getCleanButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.cleanTextFields();
            }
        };
        return al;
    }
            
    private ActionListener getCancelButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(view.getCancelButtonName()=="Cancel"){
                    view.dispose();
                }else{
                    view.setButtonEnabeled("edit");
                    view.setButtonDisabled("save");
                    view.setButtonDisabled("clean");
                    view.setTextFieldsDisabled();
                    
                    view.setName(ald.getName());
                    view.setAddress(ald.getAddress());
                    view.setPhone(ald.getPhone());
                    view.setEmployeesNuber(ald.getNumEmployees());
                    
                    view.setCancelButtonName("Cancel");
                }
                
                
            }
        };
        return al;
    }
                

}
