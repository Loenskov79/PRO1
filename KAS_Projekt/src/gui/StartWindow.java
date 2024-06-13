package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartWindow extends Application {

    private Scene scene;
    private GridPane pane;

    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinHeight(500);
        stage.setMinWidth(470);
        stage.show();
    }

    public GridPane getPane() {
        return pane;
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(40));
        pane.setHgap(40);
        pane.setVgap(40);
        pane.setGridLinesVisible(false);

        Label lblHeading = new Label("Konference Administrations System");
        pane.add(lblHeading,0,0);
        lblHeading.setMinSize(50,50);
        lblHeading.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 30));
        GridPane.setHalignment(lblHeading, HPos.CENTER);

        Button btnAdmin = new Button("Administrator");
        pane.add(btnAdmin,0,1);
        GridPane.setHalignment(btnAdmin,HPos.CENTER);
        GridPane.setMargin(btnAdmin,new Insets(0,100,0,0));
        btnAdmin.setOnAction(e -> {
            AdminWindow adminWindow = new AdminWindow();
            pane.getScene().setRoot(adminWindow.getAdminPane());
        });

        Button btnDeltager = new Button("Deltager");
        pane.add(btnDeltager,0,1);
        GridPane.setHalignment(btnDeltager,HPos.CENTER);
        GridPane.setMargin(btnDeltager,new Insets(0,0,0,100));
        btnDeltager.setOnAction(e -> {
            UserWindow userWindow = new UserWindow();
            pane.getScene().setRoot(userWindow.getUserPane());
        });

    }
}
