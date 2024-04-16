
import net.Menu;

public class App {

    public static void main(String[] args) throws Exception {
        do {
            int opcionMenu = Menu.mostrarMenu();

            switch (opcionMenu) {
                case 1:
                    Menu.anadirRestaurante();
                    break;
                case 2:
                    Menu.editarRestaurante();
                    break;
                case 3:
                    Menu.mostrarRestaurantes();
                    break;
                case 4:
                    Menu.eliminarRestaurante();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        } while (true);
    }
}
