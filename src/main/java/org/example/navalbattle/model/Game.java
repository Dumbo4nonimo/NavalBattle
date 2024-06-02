package org.example.navalbattle.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import org.example.navalbattle.view.GameStage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Game implements IGame {

    @FXML
    private GridPane gridPane, shipGridPane, grid2;
    private int size,count2 = 0,count3=0,count4=0,count5=0,finalCount=0,count6=0,count7=0;
    private Label notificationLabel;

    private BattleShipBoard battleShipBoard;
    private Button startBattleButton, winTheGame;

    private static final String[][] board = {
            {"", "1", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "4", ""},
            {"", "", "", "", "", "", "", "", "4", ""},
            {"1", "", "5", "5", "5", "", "", "4", "", ""},
            {"", "", "", "", "", "", "7", "", "", ""},
            {"", "", "", "", "", "", "7", "", "", ""},
            {"", "", "", "6", "6", "6", "6", "", "", "1"},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "3", "", "", "1", "", "", "", "2", ""},
            {"", "3", "", "", "", "", "", "", "2", ""}
    };

    public static String[][] getBoard() {
        return board;
    }

    public void initializeBoard(int tablero, Label notificationLabel) throws IOException {
        try {

            this.notificationLabel = notificationLabel;
            this.notificationLabel.setVisible(false);
            this.notificationLabel.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-font-size: 16px; -fx-padding: 10px;");

            battleShipBoard = new BattleShipBoard(shipGridPane, size, startBattleButton);
            battleShipBoard.initializeBoard();

            if (tablero == 0) {
                gridPane.setAlignment(Pos.CENTER);
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        Button button = new Button();
                        button.setPrefWidth(35);
                        button.setPrefHeight(35);
                        gridPane.add(button, col, row);
                        int finalRow = row;
                        int finalCol = col;
                        button.setOnAction(event -> handleButtonClick(finalRow, finalCol));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading the image: " + e.getMessage());
        }
    }

    private void handleButtonClick(int finalRow, int finalCol) {
        try {
            boolean hasShip = board[finalRow][finalCol].isEmpty();
            String boardType = board[finalRow][finalCol];


            GameStage gameStage = GameStage.getInstance();

            if (hasShip) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/lose.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);

                System.out.println("The position is: row " + finalRow + " col " + (finalCol + 1));
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                clickedButton.setDisable(true);
            } else if (Objects.equals(boardType, "1")) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + finalRow + " col " + finalCol);
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                finalCount++;
                clickedButton.setDisable(true);
                showNotification();
                if (finalCount==20){
                    winningMessage();
                }
            }   else if (Objects.equals(boardType, "2")) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + finalRow + " col " + finalCol);
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                count2++;
                finalCount++;
                clickedButton.setDisable(true);
                if(count2==2){
                showNotification();
                    if (finalCount==20){
                        winningMessage();
                    }
                }
                }
            else if (Objects.equals(boardType, "3")) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + finalRow + " col " + finalCol);
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                count3++;
                finalCount++;
                clickedButton.setDisable(true);
                if(count3==2){
                    showNotification();}}
            else if (Objects.equals(boardType, "4")) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + finalRow + " col " + finalCol);
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                count4++;
                finalCount++;
                clickedButton.setDisable(true);
                if(count4==3){
                    showNotification();}
                    if (finalCount==20){
                        winningMessage();
                    }
            }else if (Objects.equals(boardType, "5")) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + finalRow + " col " + finalCol);
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                count5++;
                finalCount++;
                clickedButton.setDisable(true);
                if(count5==3){
                    showNotification();}

            }else if (Objects.equals(boardType, "6")) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + finalRow + " col " + finalCol);
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                count6++;
                finalCount++;
                clickedButton.setDisable(true);
                if(count6==4){
                    showNotification();}
                if (finalCount==20){
                    winningMessage();
                }
            }else if (Objects.equals(boardType, "7")) {
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + finalRow + " col " + finalCol);
                int hitCol, hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol = random.nextInt(3, 11);
                attack(hitCol, hitRow, false);
                count5++;
                finalCount++;
                clickedButton.setDisable(true);
                if(count5==2){
                    showNotification();}
                if (finalCount==20){
                    winningMessage();
                }
            }



        } catch (Exception e) {
            System.err.println("Error handling the button click: " + e.getMessage());
        }
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void setShipGridPane(GridPane shipGridPane) {
        this.shipGridPane = shipGridPane;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStartBattleButton(Button startBattleButton) {
        this.startBattleButton = startBattleButton;
    }

    public Button getStartBattleButton() {
        return startBattleButton;
    }

    public void attack(int row, int col, boolean hit) {
        try {
            String imagePath = hit ? "/org/example/navalbattle/images/lose.jpg" : "/org/example/navalbattle/images/loginShip.jpg";
            Image img = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(29);
            imageView.setFitHeight(29);
            battleShipBoard.getGridPane().add(imageView, col, row);
            System.out.println("Button executed");
        } catch (Exception e) {
            System.err.println("Error handling the attack: " + e.getMessage());
        }
    }

    public void setBattleShipBoard(BattleShipBoard battleShipBoard) {
        this.battleShipBoard = battleShipBoard;
    }

    public void setNotificationLabel(Label notificationLabel) {
        this.notificationLabel = notificationLabel;
    }

    private void showNotification() {
        if (notificationLabel != null) {
            notificationLabel.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), ae -> notificationLabel.setVisible(false)));
            timeline.play();
        } else {
            System.err.println("Notification label is null");
        }
    }
    public void winningMessage(){
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Felicitacio");
        alert.setContentText("\n\nHas ganado");
        //alert.setGraphic(new ImageView(this.getClass().getResource("").toString()));
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.showAndWait();
    }
}
