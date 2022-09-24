package net.infortmation;

public class Cosmetico {
	int id;
	String Tipo;
	String Nombre;
	String Rareza;
	int Precio;
	
	public Cosmetico() {

	}
	
	public Cosmetico(int id, String tipo, String nombre, String rareza, int precio) {
		super();
		this.id = id;
		Tipo = tipo;
		Nombre = nombre;
		Rareza = rareza;
		Precio = precio;
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

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	@Override
	public String toString() {
		return "Cosmetico [id=" + id + ", Tipo=" + Tipo + ", Nombre=" + Nombre + ", Rareza=" + Rareza + ", Precio="
				+ Precio + "]";
	}
	
	
	
}
