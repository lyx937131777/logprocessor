package Processor.View;

import javax.swing.*;

public class ProcessorText extends JSplitPane {
    private JTextArea withDate;
    private JTextArea withoutDate;
    private JScrollPane leftScrollPane;
    private JScrollPane rightScrollPane;

    public ProcessorText() {
        super();
        withDate = new JTextArea();
        withoutDate = new JTextArea();
        leftScrollPane = new JScrollPane(withDate);
        rightScrollPane = new JScrollPane(withoutDate);
        this.setLeftComponent(leftScrollPane);
        this.setRightComponent(rightScrollPane);
        this.repaint();
    }

    public JTextArea getWithDate() {
        return withDate;
    }

    public JTextArea getWithoutDate() {
        return withoutDate;
    }
}
