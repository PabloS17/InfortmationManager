package net.infortmation;

public class Usuario {
	private String username;
	private String password;
	private String correo;
	
	public Usuario() {

	}

	public Usuario(String username, String password, String correo) {
		super();
		this.username = username;
		this.password = password;
		this.correo = correo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", correo=" + correo + "]";
	}
	
	
}
