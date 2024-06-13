package gui;

import gui.admin.AdminWindow;
import gui.admin.MenuWindow;
import gui.user.UserWindow;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class StartWindow extends Application {

    private Scene scene;
    private static GridPane startWindow;
    public void start(Stage stage) {

        stage.setTitle("KAS");
        startWindow = new GridPane();
        this.initContent(startWindow);

        scene = new Scene(startWindow);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinHeight(600);
        stage.setMinWidth(550);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(40));
        pane.setHgap(40);
        pane.setVgap(40);
        pane.setGridLinesVisible(false);

        Label lblHeading = new Label("Konference Administrations System");
        pane.add(lblHeading,0,0);
        lblHeading.setMinSize(50,50);
        lblHeading.setFont(Font.font("Verdana",FontWeight.EXTRA_BOLD,30));
        GridPane.setHalignment(lblHeading,HPos.CENTER);


        Button btnAdmin = new Button("Administrator");
        pane.add(btnAdmin,0,1);
        GridPane.setHalignment(btnAdmin,HPos.CENTER);
        GridPane.setMargin(btnAdmin,new Insets(0,100,0,0));
        btnAdmin.setOnAction(e-> {
            MenuWindow menuWindow = new MenuWindow(startWindow);
            pane.getScene().setRoot(menuWindow.getWindow());
        });

        Button btnUser = new Button("Deltager");
        pane.add(btnUser,0,1);
        GridPane.setHalignment(btnUser,HPos.CENTER);
        GridPane.setMargin(btnUser,new Insets(0,0,0,100));

        btnUser.setOnAction(event-> {
            UserWindow userWindow = new UserWindow(startWindow);
            pane.getScene().setRoot(userWindow.getWindow());
        });

    }

    public static GridPane getWindow(){
        return startWindow;
    }


}
