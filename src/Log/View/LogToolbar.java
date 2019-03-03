package Log.View;

import Log.Controller.LogController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogToolbar extends JPanel {

    private JButton chooseFileButton;
    private JTextField keyTextField;
    private JButton filterButton;
    private JButton processButton;

    private LogController logController;

    public LogToolbar(LogController logController) {
        super();
        this.setLayout(null);
        this.logController = logController;
        chooseFileButton = new JButton("选择文件");
        keyTextField = new JTextField("VC_SVG");
        filterButton = new JButton("筛选");
        processButton = new JButton("处理日志");
        chooseFileButton.setBounds(20,5,130,30);
        keyTextField.setBounds(400,5,130,30);
        filterButton.setBounds(550,5,70,30);
        processButton.setBounds(950,5,130,30);
        this.add(chooseFileButton);
        this.add(keyTextField);
        this.add(filterButton);
        this.add(processButton);
    }

    public JButton getChooseFileButton() {
        return chooseFileButton;
    }

    public JTextField getKeyTextField() {
        return keyTextField;
    }

    public JButton getFilterButton() {
        return filterButton;
    }

    public JButton getProcessButton() {
        return processButton;
    }
}
