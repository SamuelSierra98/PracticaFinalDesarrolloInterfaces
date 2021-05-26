package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constructores.Cliente;
import dao.*;
import constructores.*;
import excepciones.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class CrearUsuario extends JFrame {
	List<Cliente> misClientes = new ArrayList<Cliente>();
	clienteDAO clienteDao = new clienteDAO();
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField idCliente;
	private JTextField documento;
	private JTextField email;
	private JTextField password;
	private JTextField nombreCliente;
	private JTextField apellidoCliente;
	private JTextField telefono;
	private JTextField fax;
	private JTextField direccion1;
	private JTextField direccion2;
	private JTextField pais;
	private JTextField region;
	private JTextField ciudad;
	private JTextField codigoPostal;
	private JTextField codigoEmpleado;
	private JTextField limiteCredito;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @throws MisExcepciones
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws MisExcepciones
	 */
	public CrearUsuario(final String[] args) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lbl_TITULO = new JLabel("Crear Usuario");
		lbl_TITULO.setBackground(Color.WHITE);
		lbl_TITULO.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TITULO.setFont(new Font("Agency FB", Font.BOLD, 22));

		JLabel lblNombre = new JLabel("Username");
		lblNombre.setFont(new Font("Agency FB", Font.BOLD, 14));

		nombre = new JTextField();
		nombre.setColumns(10);

		JLabel lblIdcliente = new JLabel("ID Cliente");
		lblIdcliente.setFont(new Font("Agency FB", Font.BOLD, 14));

		idCliente = new JTextField();
		idCliente.setColumns(10);
		idCliente.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
			}
		});

		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setFont(new Font("Agency FB", Font.BOLD, 14));

		final JComboBox<TipoDocumento> JComboBox_TipoDocumento = new JComboBox<TipoDocumento>();
		JComboBox_TipoDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		JComboBox_TipoDocumento.setModel(
				new javax.swing.DefaultComboBoxModel<>(new TipoDocumento[] { TipoDocumento.DNI, TipoDocumento.NIE }));

		if (JComboBox_TipoDocumento.getName() == "DNI") {

		}
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Agency FB", Font.BOLD, 14));

		documento = new JTextField();
		documento.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Agency FB", Font.BOLD, 14));

		email = new JTextField();
		email.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Agency FB", Font.BOLD, 14));
		password = new JTextField();
		password.setColumns(10);

		JLabel lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setFont(new Font("Agency FB", Font.BOLD, 14));

		nombreCliente = new JTextField();
		nombreCliente.setColumns(10);

		JLabel lblApellidoCliente = new JLabel("Apellido Cliente");
		lblApellidoCliente.setFont(new Font("Agency FB", Font.BOLD, 14));

		apellidoCliente = new JTextField();
		apellidoCliente.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Agency FB", Font.BOLD, 14));

		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		JLabel lblFax = new JLabel("FAX");
		lblFax.setFont(new Font("Agency FB", Font.BOLD, 14));

		fax = new JTextField();
		fax.setColumns(10);
		fax.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		JLabel lblDireccion2 = new JLabel("Direccion2");
		lblDireccion2.setFont(new Font("Agency FB", Font.BOLD, 14));

		direccion1 = new JTextField();
		direccion1.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion1");
		lblDireccion.setFont(new Font("Agency FB", Font.BOLD, 14));

		direccion2 = new JTextField();
		direccion2.setColumns(10);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Agency FB", Font.BOLD, 14));

		pais = new JTextField();
		pais.setColumns(10);

		JLabel lblRegion = new JLabel("Region");
		lblRegion.setFont(new Font("Agency FB", Font.BOLD, 14));

		region = new JTextField();
		region.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Agency FB", Font.BOLD, 14));

		ciudad = new JTextField();
		ciudad.setColumns(10);

		JLabel lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setFont(new Font("Agency FB", Font.BOLD, 14));

		codigoPostal = new JTextField();
		codigoPostal.setColumns(10);
		codigoPostal.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		JLabel lblCodigoEmpleado = new JLabel("Codigo Empleado");
		lblCodigoEmpleado.setFont(new Font("Agency FB", Font.BOLD, 14));

		codigoEmpleado = new JTextField();
		codigoEmpleado.setColumns(10);
		codigoEmpleado.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		JLabel lblLimiteCredito = new JLabel("Limite Credito");
		lblLimiteCredito.setFont(new Font("Agency FB", Font.BOLD, 14));

		limiteCredito = new JTextField();
		limiteCredito.setColumns(10);
		limiteCredito.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		final JLabel lblNewLabel = new JLabel("Ha habido un error al crear el usuario, porfavor pruebe de nuevo");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 14));
		lblNewLabel.setVisible(false);

		JButton btnNewButton = new JButton("CREAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					apellidoCliente.setText(null);
					ciudad.setText(null);
					codigoEmpleado.setText(null);
					codigoPostal.setText(null);
					direccion1.setText(null);
					direccion2.setText(null);
					documento.setText(null);
					email.setText(null);
					fax.setText(null);
					idCliente.setText(null);
					limiteCredito.setText(null);
					nombre.setText(null);
					nombreCliente.setText(null);
					pais.setText(null);
					password.setText(null);
					region.setText(null);
					telefono.setText(null);

				} catch (Exception e1) {
					lblNewLabel.setVisible(true);
					e1.printStackTrace();

				}
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 14));

		JButton btnNewButton_1 = new JButton("MENU");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.main(args);
			}
		});
		btnNewButton_1.setFont(new Font("Agency FB", Font.BOLD, 14));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbl_TITULO, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIdcliente, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 94,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(idCliente, GroupLayout.PREFERRED_SIZE, 149,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(password, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblFax, GroupLayout.PREFERRED_SIZE, 94,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(fax, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 94,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(direccion1, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblDireccion2, GroupLayout.PREFERRED_SIZE, 94,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(direccion2, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(110).addComponent(telefono,
										GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(email, GroupLayout.PREFERRED_SIZE, 151,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblDocumento, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(documento, 151, 151, 151))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblTipoDocumento, GroupLayout.PREFERRED_SIZE, 144,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(JComboBox_TipoDocumento, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblCodigoPostal, GroupLayout.PREFERRED_SIZE, 94,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(codigoPostal,
														GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPais, GroupLayout.PREFERRED_SIZE, 94,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(pais, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblRegion, GroupLayout.PREFERRED_SIZE, 94,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(region, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblCiudad, GroupLayout.PREFERRED_SIZE, 94,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(ciudad, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblNombreCliente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApellidoCliente, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(apellidoCliente, GroupLayout.PREFERRED_SIZE, 151,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(nombreCliente, GroupLayout.PREFERRED_SIZE, 151,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblLimiteCredito).addComponent(lblCodigoEmpleado))
										.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(12)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton_1).addComponent(lblNewLabel,
														GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(codigoEmpleado, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
										.addComponent(limiteCredito))))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(lbl_TITULO, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addComponent(lblIdcliente, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNombre).addGap(4).addComponent(
								lblPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addComponent(idCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFax, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(direccion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(4)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDireccion2, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(direccion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(11)
				.addGroup(gl_contentPane
						.createParallelGroup(
								Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPais, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(pais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRegion, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(region, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(4)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCiudad, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCodigoPostal, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(codigoPostal, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(22))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(7)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTipoDocumento).addComponent(JComboBox_TipoDocumento,
												GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDocumento).addComponent(documento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(6)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(codigoEmpleado,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCodigoEmpleado, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(telefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(14).addComponent(limiteCredito,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNombreCliente, GroupLayout.PREFERRED_SIZE, 20,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(nombreCliente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblApellidoCliente, GroupLayout.PREFERRED_SIZE, 20,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(apellidoCliente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblLimiteCredito, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_1,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
