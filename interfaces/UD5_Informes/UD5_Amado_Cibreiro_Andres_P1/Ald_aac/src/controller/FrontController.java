package controller;

import clock.AlarmEvent;
import clock.IAlarmListener;
import controller.clock.ClockController;
import controller.computersManagement.ComputersManagementController;
import controller.controllerHelper.FrontControllerHelper;
import controller.establishementInformation.EstablishementInformationController;
import controller.generateReport.GenerateReportController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import model.Ald.Ald;
import view.establishmentInformation.EstablishmentInformationDialog;
import view.MainJFrame;
import view.clock.ClockConfigurationDialog;
import view.computersManagement.ComputersManagementDialog;
import view.generateReport.GenerateReportDialog;

public class FrontController implements IAlarmListener {

    private final MainJFrame view;
    private Ald ald;
    private FrontControllerHelper fch;

    public FrontController(MainJFrame view, Ald ald) throws MalformedURLException, MalformedURLException, HelpSetException{
        this.view = view;
        this.ald = ald;
        this.fch = new FrontControllerHelper(view);
        this.view.setFocus();
        this.view.addEstablishmentInformationMenuItemActionListener(this.getEstablishmentInformationMenuItemActionListener());
        this.view.addComputersManagementMenuItemActionListener(this.getComputersManagementMenuItemActionListener());
        this.view.addGenerateReportMenuItemActionListener(this.getGenerateReportMenuItemActionListener());
        this.view.addQuitMenuItemActionListener(this.getQuitMenuItemActionListener());
        this.view.addNotificationMenuItemItemListener(this.getNotificationMenuItemItemListener());
        configureNotificationReceptor();
    }
    

    private ActionListener getEstablishmentInformationMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EstablishmentInformationDialog eid = new EstablishmentInformationDialog(view, true);
                EstablishementInformationController eic = new EstablishementInformationController(eid, ald);
                eid.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener getComputersManagementMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComputersManagementDialog cmd = new ComputersManagementDialog(view, true);
                ComputersManagementController cmc = new ComputersManagementController(cmd, ald);
                cmd.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener getGenerateReportMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateReportDialog grd = new GenerateReportDialog(view, true);
                GenerateReportController grc = new GenerateReportController(grd);
                grd.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener getQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                System.exit(0);
            }
        };
        return al;
    }
    
    
    
        private ActionListener getNotificationMenuItemItemListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClockConfigurationDialog ccd = new ClockConfigurationDialog(view, true);
                ClockController cc = new ClockController(view, ccd);
                ccd.setVisible(true);
            }
        };
        return al;
    }

    private void configureNotificationReceptor() {
        this.view.addAlarmListener(this);
    }

    @Override
    public void captureAlarm(AlarmEvent ev) {
        view.setEnableAlarm(false);
        JOptionPane.showMessageDialog(view, view.getAlarmMessage());
    }
    
}
