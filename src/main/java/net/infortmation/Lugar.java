package net.infortmation;

public class Lugar {
	int id;
	String Tipo;
	String Nombre;
	String Popularidad;
	
	public Lugar() {
		
	}
	
	public Lugar(int id, String tipo, String nombre, String popularidad) {
		super();
		this.id = id;
		Tipo = tipo;
		Nombre = nombre;
		Popularidad = popularidad;
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

	public String getPopularidad() {
		return Popularidad;
	}

	public void setPopularidad(String popularidad) {
		Popularidad = popularidad;
	}

	@Override
	public String toString() {
		return "Lugar [id=" + id + ", Tipo=" + Tipo + ", Nombre=" + Nombre + ", Popularidad=" + Popularidad + "]";
	}
	
	
	
}
