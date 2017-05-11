package MVCFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ModeloImp implements Modelo {
	private VistaImp vista;
	private String Usuario;
	private String Contrase�a;
	private String URL;
	private String Notas;

	public void setVista(Vista vista) {
		this.vista = (VistaImp) vista;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public void setNotas(String notas) {
		Notas = notas;
	}

	public String getUsuario() {
		return Usuario;
	}

	public String getContrase�a() {
		return Contrase�a;
	}

	public String getURL() {
		return URL;
	}

	public String getNotas() {
		return Notas;
	}

	public void GrabarMod(String usuario, String contrase�a, String url, String notas) {
		setUsuario(usuario);
		setContrase�a(contrase�a);
		setURL(url);
		setNotas(notas);
		Properties propiedades = new Properties();
		OutputStream salida = null;
		try {
			File miFichero = new File("src/configuracion.ini");
			if (miFichero.exists()) {
				salida = new FileOutputStream(miFichero);
				// asignamos los valores a las propiedades
				propiedades.setProperty("Usuario", Usuario);
				propiedades.setProperty("pass", Contrase�a);
				propiedades.setProperty("URL", URL);
				propiedades.setProperty("Notas", notas);
				// guardamos el archivo de propiedades en la carpeta de
				// aplicaci�n
				propiedades.store(salida, "Comentario para el fichero");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (salida != null) {
				try {
					salida.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void CargarMod() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				// cargamos el archivo de propiedades
				propiedades.load(entrada);
				// obtenemos las propiedades y las imprimimos
				this.Usuario = propiedades.getProperty("Usuario");
				this.Contrase�a = propiedades.getProperty("pass");
				this.URL = propiedades.getProperty("URL");
				this.Notas = propiedades.getProperty("Notas");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		vista.EstablecerTxtfCarga(Usuario, Contrase�a, URL, Notas);
	}
}
