package org.example.navalbattle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.navalbattle.view.GameNavalBattleLoginStage;
import org.example.navalbattle.view.GameNavalBattleStage;
import org.example.navalbattle.view.GameNavalBattleWelcomeStage;

import java.io.IOException;

public class GameNavalBattleWelcomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void initialize() {

    }
    @FXML
    private Button howToPlayButton;

    @FXML
    private Button playButton;

    @FXML
    void onActionButtonPlay(ActionEvent event) throws IOException {
        GameNavalBattleWelcomeStage.deleteInstance();
        GameNavalBattleLoginStage.getInstance();

    }

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/navalbattle/game-naval-battle-Welcome-view.fxml"));
        Scene scene1 = new Scene(root, 850,500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // to obtain the current stage
        stage.setScene(scene1);

        Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/shipEagleFavIcon.jpg"));
        ImageView imgView = new ImageView(img);
        ((Pane) root).getChildren().add(0, imgView);
        stage.show();
    }
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/navalbattle/game-naval-battle-Welcome2-view.fxml"));
        Scene scene2 = new Scene(root, 850,500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // to obtain the current stage
        stage.setScene(scene2);

        Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/amunition.jpg"));
        ImageView imgView = new ImageView(img);
        ((Pane) root).getChildren().add(0, imgView);
        stage.show();
    }


}
