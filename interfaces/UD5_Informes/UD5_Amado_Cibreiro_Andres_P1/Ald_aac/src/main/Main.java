package main;

import controller.FrontController;
import java.net.MalformedURLException;
import javax.help.HelpSetException;
import model.Ald.Ald;
import view.MainJFrame;

public class Main {
    public static void main(String[] args) throws MalformedURLException, HelpSetException {
        MainJFrame mainView = new MainJFrame();
        Ald ald = Ald.getModel();
        FrontController fc = new FrontController(mainView, ald);
        mainView.setVisible(true);
        
        
    }
}
