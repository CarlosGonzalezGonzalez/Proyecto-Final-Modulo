package entidades;

public class Director {

	private String nombre;
	private String apellidos;
	private String usuario;
	private String pass;
	private String comunidad;
	
	public Director(String nombre,String apellidos,String usuario,String pass,String comunidad){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.pass = pass;
		this.comunidad = comunidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}
	
	
	
}
