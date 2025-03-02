package org.example.uirecreate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        // start on the loading screen
        LoadingScreen loadingScreen = new LoadingScreen(primaryStage, () -> loadLoginScene(primaryStage));
        primaryStage.setScene(loadingScreen.getScene());
        primaryStage.setTitle("Loading Screen");
        primaryStage.setMaximized(true);
        primaryStage.show();
        loadingScreen.startLoading();
    }

    private void loadLoginScene(Stage primaryStage) {
        Login login = new Login(primaryStage, () -> loadDashBoardScene(primaryStage));
        primaryStage.setTitle("Login");
        primaryStage.setScene(login.getScene());
    }

    private void loadDashBoardScene(Stage primaryStage) {
        DashBoard dashBoard = new DashBoard(primaryStage);
        primaryStage.setTitle("DashBoard");
        primaryStage.setScene(dashBoard.getScene());
    }

    public static void main(String[] args) {
        launch(args);
    }}