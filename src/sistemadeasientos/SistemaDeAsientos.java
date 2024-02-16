
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
        ListaAsientos lst = new ListaAsientos();
        lst.cargarProductos();      
        frmBus bus = new frmBus();      
        bus.show();
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
