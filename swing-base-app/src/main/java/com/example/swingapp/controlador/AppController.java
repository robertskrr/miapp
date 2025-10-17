package com.example.swingapp.controlador;

import javax.swing.*;

import com.example.swingapp.vista.ControlPanel;
import com.example.swingapp.vista.OutputPanel;

import java.awt.event.ActionEvent;

public class AppController {
	private final ControlPanel controlPanel;
	private final OutputPanel outputPanel;

	public AppController(ControlPanel c, OutputPanel o) {
		this.controlPanel = c;
		this.outputPanel = o;

		// Acciones de botones
		controlPanel.btnRun.addActionListener(this::onRun);
		controlPanel.btnClear.addActionListener(this::onClear);
		controlPanel.btnExit.addActionListener(e -> System.exit(0));
	}

	private void onCurl(ActionEvent e) {
		String url = controlPanel.txtUrl.getText().trim();
		if (url.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce una URL.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		outputPanel.append("$ curl " + url);

		// Comando segun SO
		String os = System.getProperty("os.name").toLowerCase();
		ProcessBuilder pb;
		if (os.contains("win")) {
			// Windows: usar curl nativo en Windows 10+ o PowerShell como alternativa
			pb = new ProcessBuilder("cmd.exe", "/c", "curl -s " + url);
			// Alternativa PowerShell:
			// pb = new ProcessBuilder("powershell", "-Command", "Invoke-WebRequest
			// -UseBasicParsing " + url + " | Select-Object -ExpandProperty Content");
		} else {
			pb = new ProcessBuilder("bash", "-lc", "curl -s " + url);
		}
		pb.redirectErrorStream(true);

		try {
			Process p = pb.start();
			new Thread(() -> {
				try (var br = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()))) {
					String line;
					while ((line = br.readLine()) != null) {
						outputPanel.append(line);
					}
				} catch (Exception ex) {
					outputPanel.append("Error: " + ex.getMessage());
				}
			}).start();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error ejecutando cURL:\n" + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void onRun(ActionEvent e) {
		outputPanel.append("Ejecutando comando...");
		try {
			ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "8.8.8.8");
			pb.redirectErrorStream(true);
			Process process = pb.start();

			new Thread(() -> {
				try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()))) {
					String line;
					while ((line = reader.readLine()) != null) {
						outputPanel.append(line);
					}
				} catch (Exception ex) {
					outputPanel.append("Error: " + ex.getMessage());
				}
			}).start();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error ejecutando proceso:\n" + ex.getMessage());
		}
	}

	private void onClear(ActionEvent e) {
		outputPanel.clear();
	}
}