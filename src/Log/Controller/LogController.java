package Log.Controller;

import Log.View.LogText;
import Log.View.LogToolbar;
import Main.MainFrame;

import javax.swing.*;

public class LogController {

    private LogText logText;
    private LogToolbar logToolbar;
    private MainFrame mainFrame;
    private JPanel logPanel;

    public LogController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        logPanel = new JPanel();
        logText = new LogText();
        logToolbar = new LogToolbar(this);
        logPanel.setLayout(null);
        logText.setBounds(0,0,1101,801);
        logToolbar.setBounds(1101,0,120,801);
        logPanel.add(logText);
        logPanel.add(logToolbar);
        setListeners();
        mainFrame.addLogPanel(logPanel);
    }

    private void setListeners() {

    }

    public void test() {
        logText.setDividerLocation(0.8);
    }

}
