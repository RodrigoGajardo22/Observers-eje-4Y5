package ui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.portsou.Observador;

//Observador 
public class Gerente implements Observador {

	public JLabel label;

	public Gerente() {

		JFrame frame = new JFrame("Monitor");
		frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		label = new JLabel("...");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLocation(100, 300);
		frame.setVisible(true);
	}

	@Override
	public void actualizar(String monto) {
		label.setText(monto);

	}

}
