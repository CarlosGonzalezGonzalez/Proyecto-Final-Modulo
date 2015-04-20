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
	// Servidor
	public final static String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS usuarios"
			+ "(nombre VARCHAR(15) PRIMARY KEY, "
			+ "pass CARCHAR(15), "
			+ "categoria TEXT)" + "ENGINE=InnoDB";
	// ServidorHilo
	public final static String LOGIN = "Login";
	
	
	
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
