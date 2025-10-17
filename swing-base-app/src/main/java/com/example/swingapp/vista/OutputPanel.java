package com.example.swingapp.vista;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
	JTextArea textArea;

    public OutputPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void append(String msg) {
        textArea.append(msg + "\n");
    }

    public void clear() {
        textArea.setText("");
    }
}