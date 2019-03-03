package Log.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterListener implements ActionListener {

    private LogController logController;

    public FilterListener(LogController logController) {
        this.logController = logController;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextArea beforeFiltering = logController.getLogText().getBeforeFiltering();
        JTextArea afterFiltering =logController.getLogText().getAfterFiltering();
        afterFiltering.setText("");
        String key = logController.getLogToolbar().getKeyTextField().getText();
        String beforeFilteringString = beforeFiltering.getText();
        for(String str : beforeFilteringString.split("\n")) {
            if(str.contains(key)){
                afterFiltering.append(str + "\n\n");
            }
        }
    }
}
