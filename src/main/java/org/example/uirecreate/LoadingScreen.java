package org.example.uirecreate;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoadingScreen {



    private Scene scene;
    private StackPane root;
    private Rectangle loadingBar;
    private Label percentageLabel;
    private Stage primaryStage;
    private Runnable onFinish;
    private final double WIDTH;
    private final double HEIGHT;

    public LoadingScreen(Stage stage, Runnable onFinish) {
        this.primaryStage = stage;
        this.onFinish = onFinish;
        this.HEIGHT = primaryStage.getHeight();
        this.WIDTH = primaryStage.getWidth();
        setupUI();
    }

    private void setupUI() {
        root = new StackPane();

        // Background Image
        ImageView backgroundImage = new ImageView(new Image("https://collegevine.imgix.net/5db5d533-2a41-408d-9209-5e9e2a0e1f32.jpg"));
        backgroundImage.setPreserveRatio(false); // stretch image to fill
        backgroundImage.setFitWidth(root.getMaxWidth());
        backgroundImage.setFitHeight(root.getMaxHeight());

        // Loading Bar
        loadingBar = new Rectangle(0, 30, Color.BLUE);
        loadingBar.setArcWidth(10);
        loadingBar.setArcHeight(10);
        percentageLabel = new Label("0%");
        percentageLabel.setTextFill(Color.WHITE);

        StackPane loadingStack = new StackPane();
        loadingStack.getChildren().addAll(loadingBar, percentageLabel);
        loadingStack.setMaxSize(600 * 0.5, 30);
        loadingStack.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-color: rgba(255, 255, 255, 0.5);");

        StackPane.setAlignment(loadingStack, Pos.BOTTOM_CENTER);
        StackPane.setMargin(loadingStack, new Insets(20));

        root.getChildren().addAll(backgroundImage, loadingStack);

        // Create the scene
        scene = new Scene(root, WIDTH, HEIGHT);

    }

    public Scene getScene() {
        return scene;
    }
    //loading start from middle
    public void startLoading() {
        Timeline timeline = new Timeline();
        for (int i = 0; i <= 100; i++) {
            final int progress = i;
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(i * 50), e -> {
                double percent = progress; // percent goes from 0 to 100
                loadingBar.setWidth(300 * (percent / 100));
                percentageLabel.setText((int) percent + "%");
            }));
        }
        timeline.setOnFinished(e -> onFinish.run());
        timeline.play();
    }
}