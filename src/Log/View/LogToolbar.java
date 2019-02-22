package Log.View;

import Log.Controller.LogController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogToolbar extends JPanel {

    private JButton fliterButton;
    private LogController logController;

    public LogToolbar(LogController logController) {
        super();
        this.logController = logController;
        fliterButton = new JButton("筛选");
        fliterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logController.test();
            }
        });
        this.add(fliterButton);
    }
}
