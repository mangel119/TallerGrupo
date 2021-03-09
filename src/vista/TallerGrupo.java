/**
 * Sirve como punto de partida para la ejecución de la interfaz.
 *
 * @author juan_san.erazo@uao.edu.co Juan Pablo Sandoval Erazo 2195823
 * @author miguel.sanabria@uao.edu.co Miguel Angel Sanabria Rodriguez 2167228
 *@author john.quintero@uao.edu.co John Alejandro Quintero Suaza 2171945
 *@author esteban.garrido@uao.edu.co  Esteban Garrido  2160721
 * @date 8 Marzo 2021
 * @version 1.0
 */
package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Familia Sanabria
 */
public class TallerGrupo extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
