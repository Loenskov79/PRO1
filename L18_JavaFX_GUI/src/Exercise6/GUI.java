package Exercise6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("GUI");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextArea txStudentInfo = new TextArea();
    private final TextField txAge = new TextField();
    private final CheckBox checkbox = new CheckBox();
    private final Button create = new Button("Create");
    private final Button update = new Button("Update");
    private final Button delete = new Button("Delete");
    private ArrayList<Student> students = new ArrayList<>();
    private final Button inc = new Button("Inc");
    private final Button reset = new Button("Reset");

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label studentInfo = new Label("Student info: ");
        pane.add(studentInfo,0,0);

        pane.add(txStudentInfo,0,1);
        txStudentInfo.setPrefWidth(270);
        txStudentInfo.setPrefRowCount(7);
        txStudentInfo.setEditable(false);

        GridPane pane2 = new GridPane();

        // set padding of the pane
//        pane2.setPadding(new Insets(20));
        // set horizontal gap between components
        pane2.setHgap(10);
        // set vertical gap between components
        pane2.setVgap(10);

        Label name = new Label("Name:");
        pane2.add(name,0,0);

        Label age = new Label("Age:");
        pane2.add(age,0,1);

        Label active = new Label("Active");
        pane2.add(active,0,2);

        pane2.add(txfName,1,0);

        pane2.add(txAge,1,1);

        pane2.add(inc,2,1);

        pane2.add(reset,3,1);

        pane2.add(checkbox,1,2);

        pane2.add(create,0,3);

        pane2.add(update,1,3);

        pane2.add(delete,2,3);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setMaxWidth(100);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setMaxWidth(100);
        pane2.getColumnConstraints().addAll(column1,column2);

        pane.add(pane2,0,2);

        create.setOnAction(event -> createStudent());
        update.setOnAction(event -> updateButton());
        delete.setOnAction(event -> delete());
        inc.setOnAction(event -> incrementAge());

    }

    public void createStudent() {
        String name = txfName.getText().trim();
        int age = Integer.parseInt(txAge.getText().trim());
        boolean isActive = false;
        if (checkbox.isSelected()) {
            isActive = true;
        } else;

        Student student = new Student(name, age, isActive);
        students.add(student);
        txStudentInfo.setText("Name: " + student.getName() + "\nAge: " + student.getAge() + "\nActive: " + student.isActive());

        create.setDisable(true);
        txfName.setText("");
        txAge.setText("");
        checkbox.setSelected(false);

    }

    public void updateButton() {
        String name = txfName.getText().trim();
        String ageText = txAge.getText().trim();
        int age = students.get(0).getAge();
        boolean isActive = checkbox.isSelected();

        if (!ageText.isEmpty()) {
            age = Integer.parseInt(ageText);
        }

        if (!name.isEmpty()) {
            students.get(0).setName(name);
        }

        Student student = new Student(name, age, isActive);
        students.set(0,student);
        txStudentInfo.setText("Name: " + student.getName() + "\nAge: " + age + "\nActive: " + isActive);
    }

    public void delete() {
        students.remove(0);
        create.setDisable(false);
        txStudentInfo.setText("");
        txfName.setText("");
        txAge.setText("");
        checkbox.setSelected(false);
    }

    public void incrementAge() {
        int newAge = students.get(0).getAge() + 1;
        students.get(0).setAge(newAge);

        txStudentInfo.setText("Name: " + students.get(0).getName() + "\nAge: " + newAge + "\nActive: " + students.get(0).isActive());
    }

    public void reset() {
        String txfName = students.get(0).getName();
    }
}
