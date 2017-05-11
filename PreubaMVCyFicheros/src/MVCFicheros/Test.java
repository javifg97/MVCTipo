package MVCFicheros;

import java.awt.Window;

public class Test {
	public static void main(String[] args) {
		Vista vista = new VistaImp();
		Modelo modelo = new ModeloImp();
		Controlador controlador = new ControladorImp();

		vista.setControlador(controlador);
		vista.setModelo(modelo);
		controlador.setModelo(modelo);
		controlador.setVista(vista);
		modelo.setVista(vista);
		((Window) vista).setVisible(true);

	}
}
