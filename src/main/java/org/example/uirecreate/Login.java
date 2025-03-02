package org.example.uirecreate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {

    private Scene scene;
    private HBox root;
    private Stage primaryStage;
    private Runnable onLogin;
    private final double WIDTH;
    private final double HEIGHT;

    public Login(Stage stage, Runnable onLogin) {
        this.primaryStage = stage;
        this.HEIGHT = primaryStage.getHeight();
        this.WIDTH = primaryStage.getWidth();
        this.onLogin = onLogin;
        setupUI();
    }

    private void setupUI() {
        VBox leftBox = new VBox(15);
        leftBox.setPadding(new Insets(20));
        leftBox.setAlignment(Pos.CENTER_LEFT);

        // User field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button cancelButton = new Button("Cancel");
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> onLogin.run());
        cancelButton.setOnAction(event -> primaryStage.close());

        // Container for buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.getChildren().addAll(cancelButton, loginButton);

        leftBox.getChildren().addAll(usernameField, passwordField, buttonBox);

        ImageView logoImage = new ImageView(new Image("https://upload.wikimedia.org/wikipedia/en/thumb/e/eb/SUNY_Farmingdale_seal.svg/1200px-SUNY_Farmingdale_seal.svg.png"));
        logoImage.setPreserveRatio(true);
        logoImage.setFitWidth(WIDTH * 0.4);
        logoImage.setOpacity(0.3); // Set low opacity

        root = new HBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(leftBox, logoImage);

        scene = new Scene(root, WIDTH, HEIGHT);
    }

    public Scene getScene() {
        return scene;
    }
}