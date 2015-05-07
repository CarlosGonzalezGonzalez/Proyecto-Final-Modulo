package configuration;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public final static String NOMBRE_FICHERO = "configuration/Configuration.properties";
	// Dinamincos
	public final static String TITULO_LOGIN = "tituloLogin";
	public final static String TEXTO_USUARIO = "textoUsuario";
	public final static String TEXTO_PASSWORD = "textoPassword";
	public final static String TEXTO_ACEPTAR = "textoAceptar";
	public final static String TEXTO_CANCELAR = "textoCancelar";
	public final static String USUARIO_VACIO = "usuarioVacio";
	public final static String PASS_VACIO = "passVacio";
	public final static String TITULO_MINISTRO = "tituloMinistro";
	public final static String TEXTO_CREAR_DIRECTOR = "textoCrearDirector";
	public final static String TEXTO_MODIFICAR_DIRECTOR = "textoModificarDirector";
	public final static String TEXTO_ELIMINAR_DIRECTOR = "textoEliminarDirector";
	public final static String TEXTO_VER_NOTAS = "textoVerNotas";
	public final static String TITULO_CREAR_DIRECTOR = "tituloCrearDirector";
	public final static String TEXTO_NOMBRE = "textoNombre";
	public final static String TEXTO_APELLIDOS = "textoApellidos"; 
	public final static String TEXTO_COMUNIDAD = "textoComunidad";
	public final static String COMPLETAR_DATOS = "completarDatos";
	public final static String DIRECTOR_CREADO = "directorCreado";
	public final static String TITULO_BUCAR_DIRECTOR = "tituloBuscar";
	public final static String TEXTO_BUSCAR_DIRECTOR = "textoBuscarDirector";
	public final static String TEXTO_BUSCAR = "textoBuscar";
	public final static String COMPLETAR_ID = "completarId";
	public final static String ID_NO_VALIDO = "idNoValido";
	public final static String TITULO_MODIFICAR_DIRECTOR = "tituloModificarDirector";
	public final static String TEXTO_ID = "textoId";
	public final static String DIRECTOR_MODIFICADO = "directorModificado";
	public final static String TITULO_ELIMINAR_DIRECTOR = "tituloEliminarDirector";
	public final static String TEXTO_ELIMINAR = "textoEliminar";
	public final static String DIRECTOR_ELIMINADO = "directorEliminado";
	public final static String TITULO_DIRECTOR = "tituloDirector";
	public final static String TEXTO_CREAR_PROFESOR = "textoCrearProfesor";
	public final static String TEXTO_MODIFICAR_PROFESOR = "textoModificarProfesor";
	public final static String TEXTO_ELIMINAR_PROFESOR = "textoEliminarProfesor";
	public final static String TITULO_CREAR_PROFESOR = "tituloCrearProfesor";
	public final static String  TEXTO_ID_DIRECTOR = "textoIdDirector";
	public final static String PROFESOR_CREADO = "profesorCreado";
	// Estaticos
	public final static String LOGIN = "Login";
	public final static String MINISTRO = "ministro";
	public final static String CREARDIRECTOR = "Crear Director";
	public final static String BUSCARDIRECTOR = "Buscar director";
	public final static String MODIFICARDIRECTOR = "Modificar director";
	public final static String ELIMINARDIRECTOR = "Eliminar director";
	public final static String DIRECTOR = "director";
	public final static String PROFESOR = "profesor";
	public final static String CREAR_DIRECTOR = "Crear director";
	public final static String MODIFICAR_DIRECTOR = "Modificar director";
	public final static String ELIMINAR_DIRECTOR = "Eliminar director";
	public final static String VER_NOTAS = "Ver notas";
	public final static String CREARPROFESOR = "Crear profesor";
	public final static String MODIFICARPROFESOR = "Modificar profesor";
	public final static String ELIMINARPROFESOR = "Eliminar profesor";
	
	
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
