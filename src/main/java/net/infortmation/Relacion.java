package net.infortmation;

public class Relacion {
    private int id_tipo;
    private int id_arma;

    public Relacion(){

    }

    public Relacion(int id_tipo, int id_arma) {
        super();
        this.id_tipo = id_tipo;
        this.id_arma = id_arma;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getId_arma() {
        return id_arma;
    }

    public void setId_arma(int id_arma) {
        this.id_arma = id_arma;
    }

    @Override
    public String toString() {
        return "Relacion{" +
                "id_tipo=" + id_tipo +
                ", id_arma=" + id_arma +
                '}';
    }
}