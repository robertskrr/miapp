package com.example.swingapp;

import javax.swing.SwingUtilities;

import com.example.swingapp.vista.MainWindow;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
