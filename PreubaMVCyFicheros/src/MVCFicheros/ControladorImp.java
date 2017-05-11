package MVCFicheros;

public class ControladorImp implements Controlador {
	private ModeloImp modelo;
	private VistaImp vista;

	public void setModelo(Modelo modelo) {
		this.modelo = (ModeloImp) modelo;
	}

	public void setVista(Vista vista) {
		this.vista = (VistaImp) vista;
	}

	public void GrabarCont() {
		String usuario = vista.getStrTxtfusuario();
		String contrase�a = vista.getStrTxtfContrase�a();
		String url = vista.getStrTxtfURL();
		String notas = vista.getStrTxtfNotas();
		modelo.GrabarMod(usuario, contrase�a, url, notas);
	}

	public void EstablecerAtrib() {
		this.modelo.CargarMod();
	}

}
