/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;
import view.clock.ClockConfigurationDialog;

/**
 *
 * @author fermigo
 */
public class ClockController {

    private final MainJFrame mainView;
    private final ClockConfigurationDialog view;

    public ClockController(MainJFrame mainView, ClockConfigurationDialog view) {
        this.view = view;
        this.mainView = mainView;
        this.view.addSetButtonActionListerner(this.getSetButtonActionListerner());
        this.view.addEnableDisableAlarmButtonActionListerner(this.getEnableDisableAlarmButtonActionListerner());
        updateView();
    }

    private ActionListener getSetButtonActionListerner() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set();
            }
        };
        return al;
    }

    private void updateView() {
        view.setMessage(mainView.getAlarmMessage());
        view.setMinutes(mainView.getMinutesAlarm());
        view.setHour(mainView.getHourAlarm());
        if (mainView.isMode24()) {
            view.setMode(true);
        } else {
            view.setMode(false);
        }
        view.enableDisableAlarm(mainView.isEnableAlarm());

    }

    private void set() {
        mainView.setAlarmMessage(view.getMessage());
        mainView.setHourAlarm(view.getHour());
        mainView.setMinutesAlarm(view.getMinutes());
        String mode = view.getMode();
        Boolean mode24 = false;
        if (mode.equals("24h")) {
            mode24 = true;
        }
        mainView.setMode24(mode24);
    }

    private ActionListener getEnableDisableAlarmButtonActionListerner() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set();
                if (mainView.isEnableAlarm()) {
                    mainView.setEnableAlarm(false);
                    mainView.notificationsMenuIconChange(false);
                } else {
                    mainView.setEnableAlarm(true);
                    mainView.notificationsMenuIconChange(true);
                }
                updateView();
            }
        };
        return al;
    }

}
