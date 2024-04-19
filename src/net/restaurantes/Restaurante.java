package net.restaurantes;

import java.util.ArrayList;
import java.util.List;

/**
 * The `Restaurante` class represents a restaurant with properties such as name, location, schedule,
 * and rating, and provides a method to get concatenated information about the restaurant.
 */
public class Restaurante {
    private String nombre;
    private String localizacion;
    private String horario;
    private double puntuacion;

    public Restaurante(String nombre, String localizacion, String horario, double puntuacion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.horario = horario;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    List<Restaurante> listaRestaurantes = new ArrayList<>();

    /**
     * The `getInfo` function returns a concatenated string of the object's name, location, schedule,
     * and rating followed by a newline character.
     * 
     * @return The `getInfo()` method is returning a concatenated string that includes the name,
     * location, operating hours, and rating of an entity, separated by spaces and ending with a
     * newline character.
     */
    public String getInfo() {
        return this.getNombre() + " " + this.getLocalizacion() + " " + this.getHorario() + " " + this.getPuntuacion() + "\n";
    }
}
