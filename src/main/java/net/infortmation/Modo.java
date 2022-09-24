package net.infortmation;

public class Modo {
	int id;
	int cantJugadores;
	String tipo;
	
	public Modo() {

	}
	
	public Modo(int id, int cantJugadores, String tipo) {
		super();
		this.id = id;
		this.cantJugadores = cantJugadores;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantJugadores() {
		return cantJugadores;
	}

	public void setCantJugadores(int cantJugadores) {
		this.cantJugadores = cantJugadores;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Modo [id=" + id + ", cantJugadores=" + cantJugadores + ", tipo=" + tipo + "]";
	}
	
	
	
	
}
