/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {

    PinValidation validation;
    Scene scene;
    ATMmenu menu;
    Stage stage;

    public Login(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        validation = new PinValidation();
        Label pinLabel = new Label("Enter pin: ");
        PasswordField pinField = new PasswordField();
        Button submit = new Button("Submit");
        Label validationLabel = new Label();

        GridPane grid = new GridPane();
        grid.add(pinLabel, 0, 0);
        grid.add(submit, 1, 3);
        grid.add(pinField, 1, 0);
        grid.add(validationLabel, 1, 4);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fetchedpin = pinField.getText();

                boolean valid = validation.validate(fetchedpin);
                if (valid) {
                    stage.setScene(menu.getScene());

                } else {
                    validationLabel.setText("Incorrect pin");
                }
            }
        });

        scene = new Scene(grid, 400, 200);
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setATMmenu(ATMmenu menu) {
        this.menu = menu;
    }

}
