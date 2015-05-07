package entidades;

public class Profesor {
	
	private String nombre;
	private String apellidos;
	private String idDirector;
	private String usuario;
	private String pass;
	
	public Profesor(String nombre,String apellidos,String idDirector,String usuario,String pass){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idDirector = idDirector;
		this.usuario = usuario;
		this.pass = pass;
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

	public String getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(String idDirector) {
		this.idDirector = idDirector;
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
	
	

}
