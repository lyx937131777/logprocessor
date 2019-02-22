package Log.View;

import javax.swing.*;

public class LogText extends JSplitPane {

    private JTextArea beforeFiltering;
    private JTextArea afterFiltering;

    public LogText() {
        super();
        beforeFiltering = new JTextArea();
        afterFiltering = new JTextArea();
        this.setLeftComponent(beforeFiltering);
        this.setRightComponent(afterFiltering);
        this.setDividerLocation(0.8);
        this.repaint();
    }


}
