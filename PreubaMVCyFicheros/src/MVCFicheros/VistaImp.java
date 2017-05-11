package MVCFicheros;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaImp extends JFrame implements Vista {
	private ModeloImp modelo;
	private ControladorImp controlador;
	private Container contenedor;
	private JTextField txtfusuario;
	private JTextField txtfContraseña;
	private JTextField txtfURL;
	private JTextField txtfNotas;

	public VistaImp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Usuario:");

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");

		JLabel lblNewLabel_2 = new JLabel("URL:");

		JLabel lblNewLabel_3 = new JLabel("Notas:");

		JButton btnGrabar = new JButton("Grabar Datos");

		JButton btnCaraga = new JButton("Cargar Datos");

		txtfusuario = new JTextField();
		txtfusuario.setColumns(10);

		txtfContraseña = new JTextField();
		txtfContraseña.setColumns(10);

		txtfURL = new JTextField();
		txtfURL.setColumns(10);

		txtfNotas = new JTextField();
		txtfNotas.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2).addComponent(lblNewLabel_3).addComponent(lblNewLabel))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addComponent(txtfNotas)
								.addComponent(txtfURL).addComponent(txtfContraseña).addComponent(txtfusuario,
										GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
						.addGap(127))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(225, Short.MAX_VALUE)
								.addComponent(btnGrabar).addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(225, Short.MAX_VALUE)
						.addComponent(btnCaraga).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						txtfusuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						txtfContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(
						txtfURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						txtfNotas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(84))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(166, Short.MAX_VALUE)
								.addComponent(btnCaraga).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnGrabar).addContainerGap()));
		getContentPane().setLayout(groupLayout);
		setBounds(500, 500, 356, 273);

		btnCaraga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.EstablecerAtrib();
				txtfusuario.setText(modelo.getUsuario());
				txtfContraseña.setText(modelo.getContraseña());
				txtfURL.setText(modelo.getURL());
				txtfNotas.setText(modelo.getNotas());

			}
		});
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.GrabarCont();
			}
		});

	}

	public String getStrTxtfusuario() {
		return txtfusuario.getText();
	}

	public String getStrTxtfContraseña() {
		return txtfContraseña.getText();
	}

	public String getStrTxtfURL() {
		return txtfURL.getText();
	}

	public String getStrTxtfNotas() {
		return txtfNotas.getText();
	}

	public void setControlador(Controlador controlador) {
		this.controlador = (ControladorImp) controlador;
	}

	public Container getContenedor() {

		return this.contenedor;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = (ModeloImp) modelo;
	}
}
