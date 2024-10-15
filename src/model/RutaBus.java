package model;

import java.io.Serializable;

public class RutaBus implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombreRuta;
    private int cantidadPasajeros;

    public RutaBus(int id, String nombreRuta, int cantidadPasajeros) {
        this.id = id;
        this.nombreRuta = nombreRuta;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String toString() {
        return "RutaBus [id=" + id + ", nombreRuta=" + nombreRuta + ", cantidadPasajeros=" + cantidadPasajeros + "]";
    }
}
