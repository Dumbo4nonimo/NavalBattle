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

public class GameNavalBattleLoginStage extends Stage {
    public GameNavalBattleLoginStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/navalbattle/game-naval-battle-Login-Stage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500,360);

        // Configuring the stage
        Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
        ImageView imgView = new ImageView(img);
        setTitle("Registrate"); // Sets the title of the stage
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
        GameNavalBattleLoginStage.GameNavalBattleLoginStageHolder.INSTANCE.close();
        GameNavalBattleLoginStage.GameNavalBattleLoginStageHolder.INSTANCE = null;
    }

    public static GameNavalBattleLoginStage getInstance() throws IOException {
        return  GameNavalBattleLoginStage.GameNavalBattleLoginStageHolder.INSTANCE != null?
                GameNavalBattleLoginStage.GameNavalBattleLoginStageHolder.INSTANCE :
                (GameNavalBattleLoginStage.GameNavalBattleLoginStageHolder.INSTANCE = new GameNavalBattleLoginStage());
    }

    private static class GameNavalBattleLoginStageHolder {
        private static GameNavalBattleLoginStage INSTANCE;
    }

}
