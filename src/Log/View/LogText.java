package Log.View;

import javax.swing.*;

public class LogText extends JSplitPane {

    private JTextArea beforeFiltering;
    private JTextArea afterFiltering;
    private JScrollPane leftScrollPane;
    private JScrollPane rightScrollPane;

    public LogText() {
        super();
        beforeFiltering = new JTextArea();
        afterFiltering = new JTextArea();
        leftScrollPane = new JScrollPane(beforeFiltering);
        rightScrollPane = new JScrollPane(afterFiltering);
        this.setLeftComponent(leftScrollPane);
        this.setRightComponent(rightScrollPane);
        this.repaint();
    }

    public JTextArea getBeforeFiltering() {
        return beforeFiltering;
    }

    public JTextArea getAfterFiltering() {
        return afterFiltering;
    }
}
