package org.example.navalbattle.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

// Dentro de la clase GameStage
public class GameStage extends Stage {

    private Scene currentScene;
    private Parent root1;
    private Parent root2;

        private static GameStage instance;

        public GameStage() {
            super();
            instance = this; // Establece esta instancia como la instancia actual
            initialize(); // Inicializa la escena y carga los archivos FXML
        }


    private void initialize() {
        try {
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/org/example/navalbattle/navalBattleGame.fxml"));
            root1 = loader1.load();

            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/org/example/navalbattle/navalBattleGame1.fxml"));
            root2 = loader2.load();

            currentScene = new Scene(root1, 1000, 500);

            setTitle("Batalla naval");
            setScene(currentScene);
            setResizable(false);
            getIcons().add(new Image(getClass().getResource("/org/example/navalbattle/images/shipAutumFavIcon.jpg").toString()));

        } catch (IOException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
        }
    }

    public static GameStage getInstance() {
        if (GameStageHolder.INSTANCE == null) {
            GameStageHolder.INSTANCE = new GameStage();
        }
        return GameStageHolder.INSTANCE;
    }

    public void switchToScene1() {
        currentScene.setRoot(root1);
        show();
    }

    public void switchToScene2() {
        currentScene.setRoot(root2);
        show(); // Mostrar la ventana después de cambiar la escena
    }

    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }
}
