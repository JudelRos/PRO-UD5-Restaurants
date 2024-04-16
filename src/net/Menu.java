package net;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import net.restaurantes.Restaurante;

public class Menu {
    private static ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
    private static final String MENU = """
                1.- Añadir restaurante
                2.- Editar restaurante
                3.- Mostrar restaurantes
                4.- Eliminar restaurante
                0.- Salir del programa
            """;

    public static int mostrarMenu() {
        String opcionMenu = JOptionPane.showInputDialog(null, MENU , "Menu de restaurantes Salesianos", 1);
        return Integer.parseInt(opcionMenu);

    }

    public static void anadirRestaurante() {

        
        String nuevoNombreRestaurante = JOptionPane.showInputDialog("Introduce el nombre del restaurante");
        String nuevaLocalizacionRestaurante = JOptionPane.showInputDialog("Introduce la localización del restaurante");
        String nuevoHorarioRestaurante = JOptionPane
                .showInputDialog("Introduce el horario del restaurante. HH:MM-HH:MM");
        String nuevaPuntuacionRestauranteString = JOptionPane.showInputDialog("Introduce la puntación del restaurante");
        double nuevaPuntuacionRestaurante = Double.parseDouble(nuevaPuntuacionRestauranteString);

        Restaurante restaurante = new Restaurante(nuevoNombreRestaurante, nuevaLocalizacionRestaurante,
                nuevoHorarioRestaurante, nuevaPuntuacionRestaurante);
        listaRestaurantes.add(restaurante);

    }

    public static void editarRestaurante() {
        mostrarRestaurantes();
        String indexString = JOptionPane.showInputDialog("Cual es el nº del restaurante que quieres modificar?");
        int index = Integer.parseInt(indexString);
        String nuevoNombreRestaurante = JOptionPane.showInputDialog("Introduce el nuevo nombre del restaurante");
        String nuevaLocalizacionRestaurante = JOptionPane
                .showInputDialog("Introduce la nueva localización del restaurante");
        String nuevoHorarioRestaurante = JOptionPane
                .showInputDialog("Introduce el nuevo horario del restaurante. HH:MM-HH:MM");
        String nuevaPuntuacionRestauranteString = JOptionPane
                .showInputDialog("Introduce la nueva puntación del restaurante");
        double nuevaPuntuacionRestaurante = Double.parseDouble(nuevaPuntuacionRestauranteString);

        Restaurante restaurante = new Restaurante(nuevoNombreRestaurante, nuevaLocalizacionRestaurante,
                nuevoHorarioRestaurante, nuevaPuntuacionRestaurante);
        listaRestaurantes.set(index, restaurante);

    }

    public static void mostrarRestaurantes() {
        Stream<Restaurante> streamOrdenado = listaRestaurantes.stream().sorted(Comparator.comparing(Restaurante::getPuntuacion));
        System.out.println(streamOrdenado);
        Comparator<Restaurante> comparadorPorPuntuacion = (r1, r2) ->
            Double.compare(r2.getPuntuacion(), r1.getPuntuacion());
            Collections.sort(listaRestaurantes, comparadorPorPuntuacion);
        String infoRestaurantes = "";
        for (int i = 0; i < listaRestaurantes.size(); i++) {
            infoRestaurantes += i + " " + listaRestaurantes.get(i).getInfo();
        }
        JOptionPane.showInputDialog(infoRestaurantes);
    }

    public static void eliminarRestaurante() {
        mostrarRestaurantes();
        String indexString = JOptionPane.showInputDialog("Que restaurante quieres eliminar? Escribe su nº");
        int index = Integer.parseInt(indexString);
        listaRestaurantes.remove(index);
    }
}
