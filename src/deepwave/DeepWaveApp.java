/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave;

import deepwave.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author atphan
 */
public class DeepWaveApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        MainController mainController = new MainController();
        // set scalling minimum
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(800);

        mainController.showMainView(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
