package com.example.swingapp.vista;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	public JButton btnRun, btnClear, btnExit, btnCurl, btnDate, btnIp, btnStatsRed, btnSockets, btnPingHost;
	public JTextField txtUrl, txtHost;

    public ControlPanel() {
        // grid con 10 filas (una por componente)
        setLayout(new GridLayout(10, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        txtUrl  = new JTextField("https://www.example.com");
        btnCurl = new JButton("🌐 Consultar URL");
        btnIp = new JButton("Interfaces e IPs");
        btnStatsRed = new JButton("Estadísticas de red");
        btnSockets = new JButton("Sockets en escucha");
        btnPingHost = new JButton("Hacer ping a URL");
        btnDate = new JButton("📅 Fecha");
        btnRun   = new JButton("▶ Ejecutar");
        btnClear = new JButton("🧹 Limpiar");
        btnExit  = new JButton("🚪 Salir");

        add(txtUrl);
        add(btnCurl);
        add(btnDate);
        add(btnIp);
        add(btnStatsRed);
        add(btnSockets);
        add(btnPingHost);
        add(btnRun);
        add(btnClear);
        add(btnExit);
    }
}