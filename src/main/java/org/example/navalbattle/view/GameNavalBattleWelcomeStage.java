package org.example.navalbattle.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameNavalBattleWelcomeStage extends Stage {

    public GameNavalBattleWelcomeStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/navalbattle/navalBattleGame.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 850,500);

        // Configuring the stage
        Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/shipEagleFavIcon.jpg"));
        ImageView imgView = new ImageView(img);
        setTitle("Bienvenido a Batalla naval"); // Sets the title of the stage
        setScene(scene); // Sets the scene for the stage
        setResizable(false); // Disallows resizing of the stage
        initStyle(StageStyle.UNIFIED);

        ((Pane) root).getChildren().add(0, imgView);

        getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/navalbattle/images/shipAutumFavIcon.jpg"))));
        show(); // Displays the stage
    }

    /**
     * Closes the instance of GameNavalBattleStage.
     * This method is used to clean up resources when the game stage is no longer needed.
     */
    public static void deleteInstance() {
        GameNavalBattleWelcomeStage.GameNavalBattleWelcomeStageHolder.INSTANCE.close();
        GameNavalBattleWelcomeStage.GameNavalBattleWelcomeStageHolder.INSTANCE = null;
    }

    public static GameNavalBattleWelcomeStage getInstance() throws IOException {
        return  GameNavalBattleWelcomeStageHolder.INSTANCE != null?
                GameNavalBattleWelcomeStageHolder.INSTANCE :
                (GameNavalBattleWelcomeStageHolder.INSTANCE = new GameNavalBattleWelcomeStage());
    }

    private static class GameNavalBattleWelcomeStageHolder {
        private static GameNavalBattleWelcomeStage INSTANCE;
    }
}
