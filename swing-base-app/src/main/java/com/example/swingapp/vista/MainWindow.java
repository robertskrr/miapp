package com.example.swingapp.vista;

import javax.swing.*;

import com.example.swingapp.controlador.AppController;

import java.awt.*;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    
	private final ControlPanel controlPanel;
    private final OutputPanel outputPanel;
    private final AppController controller;

    public MainWindow() {
    	   // Llama al constructor de JFrame con el título de la ventana
        super("Aplicación Base Swing con Maven");

        // Define la acción al cerrar la ventana → finaliza la aplicación
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tamaño inicial de la ventana en píxeles
        setSize(800, 500);

        // Centra la ventana en la pantalla principal
        setLocationRelativeTo(null);

        // Asigna el gestor de diseño principal: BorderLayout
        // Esto permite dividir la ventana en zonas (NORTH, SOUTH, EAST, WEST, CENTER)
        getContentPane().setLayout(new BorderLayout());

        // Crea los paneles laterales y centrales
        controlPanel = new ControlPanel();  // Panel con botones y controles
        controlPanel.txtUrl.setForeground(new Color(255, 255, 255));
        controlPanel.txtUrl.setBackground(new Color(0, 0, 0));
        controlPanel.btnRun.setBackground(new Color(143, 240, 164));
        controlPanel.btnPingHost.setBackground(new Color(143, 240, 164));
        controlPanel.btnSockets.setBackground(new Color(143, 240, 164));
        controlPanel.btnStatsRed.setBackground(new Color(143, 240, 164));
        controlPanel.btnIp.setBackground(new Color(143, 240, 164));
        controlPanel.btnDate.setBackground(new Color(143, 240, 164));
        controlPanel.btnClear.setBackground(new Color(153, 193, 241));
        controlPanel.btnExit.setBackground(new Color(246, 97, 81));
        controlPanel.btnCurl.setBackground(new Color(143, 240, 164));
        outputPanel  = new OutputPanel();   // Panel que muestra texto o resultados

        // Crea el controlador que coordina los eventos entre ambos paneles
        controller   = new AppController(controlPanel, outputPanel);

        // Añade los paneles a las zonas correspondientes del BorderLayout
        getContentPane().add(controlPanel, BorderLayout.WEST);   // Lado izquierdo
        getContentPane().add(outputPanel, BorderLayout.CENTER);  // Zona central

        // Finalmente, muestra la ventana
        setVisible(true);
    
    }

}