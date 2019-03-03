package Processor.Controller;

import Main.MainFrame;
import Processor.View.ProcessorText;
import Processor.View.ProcessorToolbar;

import javax.swing.*;
import java.awt.*;

public class ProcessorController {

    private ProcessorText processorText;
    private ProcessorToolbar processorToolbar;
    private JPanel processorPanel;
    private MainFrame mainFrame;

    public ProcessorController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        processorPanel = new JPanel();
        processorText = new ProcessorText();
        processorToolbar = new ProcessorToolbar(this);
        processorPanel.setLayout(null);
        processorText.setBounds(0,0,1100,800);
        processorToolbar.setBounds(0,800,1100,40);
        processorPanel.add(processorText);
        processorPanel.add(processorToolbar);
        setListeners();
        mainFrame.addProcessorPanel(processorPanel);
    }

    private void setListeners() {
        processorToolbar.getReturnLogButton().addActionListener(new ReturnLogListener(mainFrame));
    }

    public void setsplit(double x) {
        processorText.setDividerLocation(x);
    }

    public ProcessorText getProcessorText() {
        return processorText;
    }

    public ProcessorToolbar getProcessorToolbar() {
        return processorToolbar;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
