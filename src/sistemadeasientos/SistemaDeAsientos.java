package sistemadeasientos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sistemadeasientos.business.ListaAsientos;

public class SistemaDeAsientos extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear una nueva lista de asientos
        ListaAsientos lst = new ListaAsientos();
        // Cargar los productos en la lista de asientos
        lst.cargarProductos();
        // Crear una nueva instancia del formulario del bus
        frmBus bus = new frmBus();
        // Mostrar la ventana del formulario del bus
        bus.show();   
    }

    public static void main(String[] args) {
        launch(args);
    }

}
