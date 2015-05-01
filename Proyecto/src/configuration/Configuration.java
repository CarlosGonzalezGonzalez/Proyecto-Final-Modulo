package configuration;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public final static String NOMBRE_FICHERO = "configuration/Configuration.properties";
	
	// InterfazLogin
	public final static String TITULO_LOGIN = "tituloLogin";
	public final static String TEXTO_USUARIO = "textoUsuario";
	public final static String TEXTO_PASSWORD = "textoPassword";
	public final static String TEXTO_ACEPTAR = "textoAceptar";
	public final static String TEXTO_CANCELAR = "textoCancelar";
	// MiActionListenerLogin
	public final static String USUARIO_VACIO = "usuarioVacio";
	public final static String PASS_VACIO = "passVacio";
	// ServidorHilo
	public final static String LOGIN = "Login";
	public final static String MINISTRO = "ministro";
	public final static String CREARDIRECTOR = "Crear Director";
	public final static String DIRECTOR = "director";
	public final static String PROFESOR = "profesor";
	public final static String PADRES = "padres";
	// InterfazMinistro
	public final static String TITULO_MINISTRO = "tituloMinistro";
	public final static String TEXTO_CREAR_DIRECTOR = "textoCrearDirector";
	public final static String TEXTO_MODIFICAR_DIRECTOR = "textoModificarDirector";
	public final static String TEXTO_ELIMINAR_DIRECTOR = "textoEliminarDirector";
	public final static String TEXTO_VER_NOTAS = "textoVerNotas";
	// MiActionsListenerInterfazMinistro
	public final static String CREAR_DIRECTOR = "Crear director";
	public final static String MODIFICAR_DIRECTOR = "Modificar director";
	public final static String ELIMINAR_DIRECTOR = "Eliminar director";
	public final static String VER_NOTAS = "Ver notas";
	// InterfazCrearDirector
	public final static String TITULO_CREAR_DIRECTOR = "tituloCrearDirector";
	public final static String TEXTO_NOMBRE = "textoNombre";
	public final static String TEXTO_APELLIDOS = "textoApellidos"; 
	public final static String TEXTO_COMUNIDAD = "textoComunidad";
	// MiActionListenerCrearDirector
	public final static String COMPLETAR_DATOS = "completarDatos";
	public final static String DIRECTOR_CREADO = "directorCreado";
	
	Properties properties = null;
	
	private Configuration() {
        this.properties = new Properties();
        try {
            properties.load(Configuration.class.getClassLoader().getResourceAsStream(NOMBRE_FICHERO));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//Configuration

    public static Configuration getInstance() {
        return ConfigurationHolder.INSTANCE;
    }

    private static class ConfigurationHolder {

        private static final Configuration INSTANCE = new Configuration();
    }
    
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}
