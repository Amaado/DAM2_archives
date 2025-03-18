/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.controllerHelper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JFrame;

/**
 *
 * @author aca
 */
public class FrontControllerHelper {
    
    private JFrame view;
    private HelpBroker hb;

    public FrontControllerHelper(JFrame view) throws MalformedURLException, HelpSetException {
        this.view = view;
        initHelp();
    }
    
    private void initHelp() throws MalformedURLException, HelpSetException {
        try {
            File helpFile = new File("help/help_set.hs");
            URL hsURL = helpFile.toURI().toURL();
            HelpSet helpSet = new HelpSet(getClass().getClassLoader(), hsURL);
            this.hb = helpSet.createHelpBroker();
            hb.enableHelpKey(view.getContentPane(), "app", helpSet);
            
        } catch (MalformedURLException | HelpSetException e) {
            e.printStackTrace();
        }

    }
}
