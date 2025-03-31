/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.generateReport;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ald.DatabaseConnection;
import model.Ald.JasperReportServece;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.mariadb.jdbc.Connection;
import view.generateReport.GenerateReportDialog;

/**
 *
 * @author aca
 */
public class GenerateReportController {

    private final GenerateReportDialog view;
    static DatabaseConnection conn = null;

    public GenerateReportController(GenerateReportDialog view) {
        this.view = view;
        this.view.addTestButtonActionListener(this.getTestButtonActionListener());
        this.view.addGenerateReportButtonActionListener(this.getGenerateReportButtonActionListener());
        this.view.addCancelButtonActionListener(this.getCancelButtonActionListener());
        initComponents();
    }

    private void initComponents() {
        view.setTestLabelVisibility(false);

        view.setHostTextField("192.168.250.5");
        view.setDatabaseTextField("aldComputerService");
        view.setUsernameTextField("user");
        view.setPasswordTextField("abc123.");
    }

    public ActionListener getTestButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String host = view.getHost();
                String database = view.getDatabase();
                String username = view.getUsername();
                String password = view.getPassword();

                try {
                    conn = new DatabaseConnection(host, database, username, password);
                    conn.getConnection();

                    view.setTestLabel("Test ok");
                    view.setTextLabelColor(Color.GREEN);
                    view.setTestLabelVisibility(true);
                } catch (SQLException ex) {
                    view.setTestLabel("Test failed");
                    view.setTextLabelColor(Color.RED);
                    view.setTestLabelVisibility(true);

                    ex.printStackTrace();
                } catch (NullPointerException nullex) {
                    view.setTestLabel("You must complete all fields");
                    view.setTextLabelColor(Color.RED);
                    view.setTestLabelVisibility(true);

                    nullex.printStackTrace();
                }
            }
        };
        return al;
    }

    public ActionListener getCancelButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }

    public ActionListener getGenerateReportButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String host = view.getHost();
                String database = view.getDatabase();
                String username = view.getUsername();
                String password = view.getPassword();

                try {
                    conn = new DatabaseConnection(host, database, username, password);
                    conn.getConnection();
                    JasperReportServece.setConnection(conn);

                    String currentDirectory = System.getProperty("user.dir");
                    String sourceFile = currentDirectory + "/resources/Report_5_4.jrxml";
                    String destFile = currentDirectory + "/reports/" + view.getReportName() + ".pdf";
                    Map<String, Object> parameters = null;
                    
                    JasperReportServece.exportReport(sourceFile, destFile, parameters);
                    JasperReportServece.viewReport(sourceFile, parameters);
                    view.dispose();
                    
                } catch (JRException | SQLException ex) {
                    Logger.getLogger(GenerateReportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return al;
    }

}
