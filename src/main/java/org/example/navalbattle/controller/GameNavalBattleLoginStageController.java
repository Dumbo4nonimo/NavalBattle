package org.example.navalbattle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.navalbattle.model.Player;
import org.example.navalbattle.model.alert.AlertBox;

import java.io.IOException;

public class GameNavalBattleLoginStageController {
    @FXML
    public void initialize() {

    }
    @FXML
    private Button startBattleButton;

    @FXML
    private TextField textFieldNickname1;

    @FXML
    private TextField textFieldNickname2;

    @FXML
    void onActionStartBattleButton(ActionEvent event) throws IOException {
        if(validation()){
            Player player1 = new Player();
            Player player2 = new Player();

            String nickname1 = textFieldNickname1.getText();
            String nickname2 = textFieldNickname2.getText();

            player1.setNickname(nickname1);
            player2.setNickname(nickname2);

            System.out.println("done...");
        }else{
            AlertBox alertBox = new AlertBox();
            alertBox.showMessage("Error", "Upss!, algo ha pasado",
                    "Por favor ingrese los apodos de cada jugador");
        }

    }

    public boolean validation(){
        boolean flag = false;
        if(textFieldNickname1.getText().equals("") || textFieldNickname2.getText().equals("")){
            return flag;
        }

        flag = true;
        return flag;

    }


}
