package ifrs.apps.geradoratas.app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClasseMain extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PrincipalView.fxml"));
        
            Scene scene = new Scene(root);
            
            stage.setTitle("Gerador de Atas");
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
