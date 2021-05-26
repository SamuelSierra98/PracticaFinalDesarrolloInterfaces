package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Main extends JFrame {

	private JPanel jpanel;

	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main(final String[] args) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		jpanel = new JPanel();
		jpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpanel);
		
		JButton nuevoUsuario = new JButton("Nuevo usuario");
		nuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					CrearUsuario.main(args);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton nuevoPedido = new JButton("Nuevo pedido");
		nuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CrearPedido.main(args);
			}
		});
			
		GroupLayout panel = new GroupLayout(jpanel);
		
		panel.setHorizontalGroup(
			panel.createParallelGroup(Alignment.CENTER)
				.addGroup(panel.createSequentialGroup()
					.addGap(280)
					.addComponent(nuevoUsuario)
					.addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
					.addComponent(nuevoPedido)
					.addGap(280)));
		
		panel.setVerticalGroup(
			panel.createParallelGroup(Alignment.CENTER)
				.addGroup(panel.createSequentialGroup()
					.addGap(250)
					.addGroup(panel.createParallelGroup(Alignment.CENTER)
						.addComponent(nuevoUsuario)
						.addComponent(nuevoPedido))
					.addContainerGap(289, Short.MAX_VALUE))
		);
		
		jpanel.setLayout(panel);
	}
}

