package net.infortmation;

public class Arma {
	int id;
	String Tipo;
	String Nombre;
	String Rareza;
	int damage;
	int cargador;
	float cadencia;
	
	public Arma() {

	}
	
	public Arma(int id, String tipo, String nombre, String rareza, int damage, int cargador, float cadencia) {
		super();
		this.id = id;
		Tipo = tipo;
		Nombre = nombre;
		Rareza = rareza;
		this.damage = damage;
		this.cargador = cargador;
		this.cadencia = cadencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getRareza() {
		return Rareza;
	}

	public void setRareza(String rareza) {
		Rareza = rareza;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCargador() {
		return cargador;
	}

	public void setCargador(int cargador) {
		this.cargador = cargador;
	}

	public float getCadencia() {
		return cadencia;
	}

	public void setCadencia(float cadencia) {
		this.cadencia = cadencia;
	}

	@Override
	public String toString() {
		return "Arma [id=" + id + ", Tipo=" + Tipo + ", Nombre=" + Nombre + ", Rareza=" + Rareza + ", damage=" + damage
				+ ", cargador=" + cargador + ", cadencia=" + cadencia + "]";
	}
	
	
	
}
