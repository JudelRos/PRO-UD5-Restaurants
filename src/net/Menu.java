package net;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
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

    // The `mostrarMenu()` method in the `Menu` class is responsible for displaying a menu of options
    // to the user using a dialog box. It presents a list of choices for the user to select from, such
    // as adding a restaurant, editing a restaurant, showing restaurants, deleting a restaurant, or
    // exiting the program. The user can input their choice, and the method returns the selected option
    // as an integer value.
    public static int mostrarMenu() {
        String opcionMenu = JOptionPane.showInputDialog(null, MENU, "Menu de restaurantes Salesianos", 1);
        return Integer.parseInt(opcionMenu);

    }

    /**
     * The function "anadirRestaurante" adds a new restaurant to a list by taking input for its name,
     * location, operating hours, and rating.
     */
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

    /**
     * The function "editarRestaurante" allows the user to modify the details of a restaurant in a list
     * of restaurants.
     */
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

    /**
     * The function `mostrarRestaurantes` sorts a list of restaurants by their rating and displays
     * their information in a dialog box.
     */
    public static void mostrarRestaurantes() {
        Stream<Restaurante> streamOrdenado = listaRestaurantes.stream()
                .sorted(Comparator.comparing(Restaurante::getPuntuacion).reversed());
        String infoRestaurantes = "";
        ArrayList<Restaurante> arrayListOrdenado = new ArrayList<Restaurante>(streamOrdenado.collect(Collectors.toList()));
        for (int i = 0; i < arrayListOrdenado.size(); i++) {
            infoRestaurantes += i + " " + arrayListOrdenado.get(i).getInfo();
        }
        JOptionPane.showInputDialog(infoRestaurantes);
    }

    /**
     * The function `eliminarRestaurante` allows the user to select a restaurant from a list and remove
     * it.
     */
    public static void eliminarRestaurante() {
        mostrarRestaurantes();
        String indexString = JOptionPane.showInputDialog("Que restaurante quieres eliminar? Escribe su nº");
        int index = Integer.parseInt(indexString);
        listaRestaurantes.remove(index);
    }
}
