package Main;

import Log.Controller.LogController;
import Processor.Controller.ProcessorController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private String mode;
    private JMenu menu;
    private JMenuItem newLog;
    private JMenuItem load;
    private JMenuItem save;

    private JPanel mainpanel;
    private LogController logController;
    private ProcessorController processorController;

    public MainFrame() {
        super("LogProcessor");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1239, 871);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.green);
        mainpanel = new JPanel();
        this.setContentPane(mainpanel);
        mainpanel.setLayout(new CardLayout());
        initialization();
        this.setVisible(true);
    }

    private void initialization() {
        mode = "Log";
        setMenu();
        logController = new LogController(this);
        processorController = new ProcessorController(this);
        changeToBuildMode();
    }

    private void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        menu = new JMenu("File");

        newLog = new JMenuItem("New");
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");

        menu.add(newLog);
        menu.add(load);
        menu.add(save);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public void changeToBuildMode() {
        mode = "Build";
        //setTitle("BuildScene");
        menu.setEnabled(true);
        CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
        cardLayout.show(mainpanel,mode);
    }

    public void changeToGameMode() {
        mode = "Game";
        //setTitle("GameScene");
        menu.setEnabled(false);
        CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
        cardLayout.show(mainpanel,mode);
    }

    public JMenuItem getNewLog() {
        return newLog;
    }

    public JMenuItem getLoad() {
        return load;
    }

    public JMenuItem getSave() {
        return save;
    }

    public void addLogPanel(JPanel logPanel) {
        mainpanel.add(logPanel,"Log");
    }

    public void addProcessorPanel(JPanel processorPanel) {
        mainpanel.add(processorPanel,"Processor");
    }

    public LogController getLogController() {
        return logController;
    }

    public ProcessorController getProcessorController() {
        return processorController;
    }
}
