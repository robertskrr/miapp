package com.example.swingapp.vista;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	public JButton btnRun, btnClear, btnExit, btnCurl, btnDate;
	public JTextField txtUrl;

    public ControlPanel() {
        // grid con 6 filas (una por botón)
        setLayout(new GridLayout(6, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        txtUrl  = new JTextField("https://www.example.com");
        btnCurl = new JButton("🌐 Consultar");
        btnDate = new JButton("Date");
        btnRun   = new JButton("▶ Ejecutar");
        btnClear = new JButton("🧹 Limpiar");
        btnExit  = new JButton("🚪 Salir");

        add(txtUrl);
        add(btnCurl);
        add(btnDate);
        add(btnRun);
        add(btnClear);
        add(btnExit);
    }
}