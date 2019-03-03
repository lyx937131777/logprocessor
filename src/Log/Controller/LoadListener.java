package Log.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoadListener implements ActionListener {

    private LogController logController;
    public LoadListener(LogController logController) {
        this.logController = logController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(logController.getMainFrame());
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
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
//            try {
//                BufferedReader br = null;
//                br = new BufferedReader(new FileReader(file));
//                String str;
//                StringBuilder sb = new StringBuilder();
//                while((str = br.readLine()) != null) {
//                    sb.append(str);
//                }
//                jTextArea.append(sb.toString());
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
        }
    }
}
