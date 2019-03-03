package Log.Controller;

import Main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessListener implements ActionListener {

    private MainFrame mainFrame;

    public ProcessListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.changeToProcessorPage();
        JTextArea beforeProcess = mainFrame.getLogController().getLogText().getAfterFiltering();
        JTextArea withDate = mainFrame.getProcessorController().getProcessorText().getWithDate();
        JTextArea withoutDate = mainFrame.getProcessorController().getProcessorText().getWithoutDate();
        withDate.setText("");
        withoutDate.setText("");
        String beforeProcessString = beforeProcess.getText();
        for(String str : beforeProcessString.split("\n\n")) {
            String date = str.split(",")[0];
            String content = str.split(":")[5] + ":" + str.split(":")[6];
            withDate.append(content + " (" + date + ")\n\n" );
            withoutDate.append(content + "\n\n");
        }
    }
}
