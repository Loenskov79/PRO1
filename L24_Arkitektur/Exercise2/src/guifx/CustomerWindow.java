package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import enumeration.Gender;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerWindow extends Stage {

    private Company company;
    private Customer customer;

    public void setCompany(Company company) {
        this.company = company;
    }

    public CustomerWindow(String title, Company company) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.company = company;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public CustomerWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private TextField txfName;
    private ComboBox txfGender;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblGender = new Label("Gender");
        pane.add(lblGender, 0, 2);

        txfGender = new ComboBox<>();
        txfGender.getItems().setAll(Gender.MALE, Gender.FEMALE, "-");
        txfGender.setValue("-");
        pane.add(txfGender, 0, 3);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 4);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 5);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (customer != null) {
            txfName.setText(customer.getName());
            if (customer.getGender() != null) {
                txfGender.getSelectionModel().select(customer.getGender());
            } else {
                txfGender.getSelectionModel().select(0);
            }
        } else {
            txfName.clear();
            txfGender.getSelectionModel().select(0);
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
        } else {
            Gender gender = null;
            try {
               if (txfGender.getValue() instanceof Gender) {
                   gender = (Gender) txfGender.getValue();
               }

            } catch (NumberFormatException ex) {
                // do nothing
            }
            if (gender == null) {
                lblError.setText("Not a valid gender");
            } else {
                // Call application.controller methods
                if (customer != null) {
                    Controller.updateCustomer(customer, name, gender);
                } else {
                    Customer customer = Controller.createCustomer(name, gender);
                    Controller.addCustomerToCompany(customer, company);
                }

                this.hide();
            }
        }
    }

}
