package Processor.Controller;

import Main.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnLogListener implements ActionListener {

    private MainFrame mainFrame;

    public ReturnLogListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.changeToLogPage();
    }
}
