package org.example.navalbattle;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.navalbattle.model.BattleShipBoard;
import org.example.navalbattle.model.Ship;
import org.example.navalbattle.view.GameNavalBattleStage;
import org.example.navalbattle.view.GameNavalBattleWelcomeStage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * The Main class of the Naval Battle game application.
 */
public class Main extends Application {

    /**
     * The main method, launches the JavaFX application.
     *
     * @param args the command-line arguments passed to the application. They are not used in this application.
     */
    public static void main(String[] args) {
        // shutdown hook
        hook();
        // Launches the JavaFX application
        launch();
    }

    /**
     * The entry point of the application. Launches the JavaFX application.
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws IOException if an error occurs while loading the game stage.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Creates and initializes the main game stage
        GameNavalBattleStage.getInstance();
    }

    public static void hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Synchronize to prevent concurrent modification issues
            synchronized (Main.class) {
                String[][] playerBoard = BattleShipBoard.getPlayerBoat();
                Ship[] ships = BattleShipBoard.getShips();
                saveGameState(playerBoard, ships);
            }
        }));
    }

    //serialization
    public static void saveGameState(String[][] playerBoard, Ship[] ships) {
        try (FileOutputStream fileOut = new FileOutputStream("serializable.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(playerBoard);
            out.writeObject(ships);

        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}