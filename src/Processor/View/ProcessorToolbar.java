package Processor.View;

import Log.Controller.LogController;
import Log.Controller.ProcessListener;
import Processor.Controller.ProcessorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessorToolbar extends JPanel {

    private JButton showWithDateButton;
    private JButton showWithoutDateButton;
    private JButton returnLogButton;
    private JTextField keyTextField;
    private JButton filterButton;

    private ProcessorController processorController;

    public ProcessorToolbar(ProcessorController processorController) {
        super();
        this.setLayout(null);
        this.processorController = processorController;
        showWithDateButton = new JButton("绘制图片（含时间）");
        showWithoutDateButton = new JButton("绘制图片（不含时间）");
        keyTextField = new JTextField("VC_SVG");
        filterButton = new JButton("重新筛选");
        returnLogButton = new JButton("返回");
        showWithDateButton.setBounds(130,5,200,30);
        keyTextField.setBounds(400,5,130,30);
        filterButton.setBounds(550,5,130,30);
        showWithoutDateButton.setBounds(770,5,200,30);
        returnLogButton.setBounds(1020,5,70,30);
        this.add(showWithDateButton);
        this.add(keyTextField);
        this.add(filterButton);
        this.add(showWithoutDateButton);
        this.add(returnLogButton);
    }

    public JButton getShowWithDateButton() {
        return showWithDateButton;
    }

    public JButton getShowWithoutDateButton() {
        return showWithoutDateButton;
    }

    public JButton getReturnLogButton() {
        return returnLogButton;
    }
    public JTextField getKeyTextField() {
        return keyTextField;
    }

    public JButton getFilterButton() {
        return filterButton;
    }
}
