package Log.Controller;

import Log.View.LogText;
import Log.View.LogToolbar;
import Main.MainFrame;

import javax.swing.*;
import java.awt.*;

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
        logText.setBounds(0,0,1100,800);
        logToolbar.setBounds(0,800,1100,40);
        logPanel.add(logText);
        logPanel.add(logToolbar);
//        logText.setBackground(Color.yellow);
//        logToolbar.setBackground(Color.red);
//        logPanel.setBackground(Color.blue);
        setListeners();
        mainFrame.addLogPanel(logPanel);
    }

    private void setListeners() {
        logToolbar.getChooseFileButton().addActionListener(new LoadListener(this));
        logToolbar.getFilterButton().addActionListener(new FilterListener(this));
        logToolbar.getProcessButton().addActionListener(new ProcessListener(mainFrame));
    }

    public void setsplit(double x) {
        logText.setDividerLocation(x);
    }

    public LogText getLogText() {
        return logText;
    }

    public LogToolbar getLogToolbar() {
        return logToolbar;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
