package org.example.uirecreate;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashBoard {
    private Stage primaryStage;
    private VBox root;
    private Scene scene;

    public DashBoard(Stage primaryStage) {
        this.primaryStage = primaryStage;
        setupUI();
    }

    private void setupUI() {
        root = new VBox();

        // Create a Menubar with sample options
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu viewMenu = new Menu("View");
        Menu toolsMenu = new Menu("Tools");
        fileMenu.getItems().add(new MenuItem("Open"));
        viewMenu.getItems().add(new MenuItem("Zoom In"));
        toolsMenu.getItems().add(new MenuItem("Options"));
        menuBar.getMenus().addAll(fileMenu, viewMenu, toolsMenu);

        // Add the Menubar to the root container
        root.getChildren().add(menuBar);

        // Use Tableview built in JavaFx view
        TableView<ObservableList<String>> tableView = new TableView<>();

        //sample cols
        for (int i = 0; i < 3; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>("Column " + (i + 1));
            final int colIndex = i;
            column.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().get(colIndex))
            );
            tableView.getColumns().add(column);
        }

        // Fake data in tables
        for (int i = 0; i < 10; i++) {
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add("Row " + (i + 1) + " Data A");
            row.add("Row " + (i + 1) + " Data B");
            row.add("Row " + (i + 1) + " Data C");
            tableView.getItems().add(row);
        }

        root.getChildren().add(tableView);

        // Create the scene
        scene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
    }

    public Scene getScene() {
        return scene;
    }
}