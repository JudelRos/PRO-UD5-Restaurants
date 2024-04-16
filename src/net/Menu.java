package net;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import net.restaurantes.Restaurante;

public class Menu {
    private static ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
    private static final String MENU = """
                1.- Añadir restaurante
                2.- Editar restaurante
                3.- Mostrar restaurantes
                4.- Eliminar restaurante
                Q.- Salir del programa
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

    public static void editarRestaurante(int index) {
        mostrarRestaurantes();
        String indexString = JOptionPane.showInputDialog("Cual es el nº del restaurante que quieres modificar?");
        index = Integer.parseInt(indexString);
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
        for (int i = 0; i < listaRestaurantes.size(); i++) {
            JOptionPane.showInputDialog(i + listaRestaurantes.get(i).getNombre() + listaRestaurantes.get(i).getLocalizacion()
                    + listaRestaurantes.get(i).getHorario() + listaRestaurantes.get(i).getPuntuacion());
        }
    }

    public static void eliminarRestaurante(int index) {
        mostrarRestaurantes();
        String indexString = JOptionPane.showInputDialog("Que restaurante quieres eliminar? Escribe su nº");
        index = Integer.parseInt(indexString);
        listaRestaurantes.remove(index);
    }
}
