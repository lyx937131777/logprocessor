package Main;

import Log.Controller.LogController;
import Processor.Controller.ProcessorController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame {

    private static final String LOG = "Log";
    private static final String PROCESSOR = "Processor";

    private String page;
    private JMenu menu;
    private JMenuItem newLog;
    private JMenuItem load;
    private JMenuItem save;

    private JPanel mainpanel;
    private LogController logController;
    private ProcessorController processorController;

    public MainFrame(String args[]) {
        super("LogProcessor");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1101, 884);
        this.setLocationRelativeTo(null);
        mainpanel = new JPanel();
        this.setContentPane(mainpanel);
        mainpanel.setLayout(new CardLayout());
        initialization();
        this.setVisible(true);
        logController.setsplit(0.5);
        processorController.setsplit(0.5);
        if(args.length != 0) {
            System.out.println(args[0]);
            File file = new File(args[0]);
            JTextArea jTextArea = logController.getLogText().getBeforeFiltering();
            jTextArea.setText("");
            FileInputStream fileinstream = null;
            try {
                fileinstream = new FileInputStream(file);
            }
            catch (FileNotFoundException fe) {

            }
            try {
                byte buffer[] = new byte[(int) file.length()];
                fileinstream.read(buffer);
                String s = new String(buffer, "UTF-8");
                jTextArea.append(s);
            }
            catch (IOException ioe) {

            }
            finally {
                try {
                    if (fileinstream != null)
                        fileinstream.close();
                }
                catch (IOException ioe2) {
                }
            }
            logController.getLogToolbar().getFilterButton().doClick();
            logController.getLogToolbar().getProcessButton().doClick();
        }
    }

    private void initialization() {
        setMenu();
        logController = new LogController(this);
        processorController = new ProcessorController(this);
        changeToLogPage();
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

    public void changeToLogPage() {
        page = LOG;
//        setTitle("Log");
        menu.setEnabled(true);
        CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
        cardLayout.show(mainpanel,page);
    }

    public void changeToProcessorPage() {
        page = PROCESSOR;
//        setTitle("Processor");
        menu.setEnabled(false);
        CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
        cardLayout.show(mainpanel,page);
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
        mainpanel.add(logPanel,LOG);
    }

    public void addProcessorPanel(JPanel processorPanel) {
        mainpanel.add(processorPanel,PROCESSOR);
    }

    public LogController getLogController() {
        return logController;
    }

    public ProcessorController getProcessorController() {
        return processorController;
    }
}
