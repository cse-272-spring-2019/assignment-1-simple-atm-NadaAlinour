/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.concurrent.Task;

public class WithdrawScene {

    Stage stage;
    ATMmenu menu;
    Scene scene;
    ATM atm;
    ATM withdraw1;

    public WithdrawScene(Stage stage) {
        this.stage = stage;
    }

    public void setWithdraw1(ATM withdraw1) {
        this.withdraw1 = withdraw1;
    }

    public void prepareScene() {

        Label amount = new Label("Enter amount");
        Button submit = new Button("Submit");
        TextField amountt = new TextField();
        Button back = new Button("Back");
        Label insufficient1 = new Label();

        GridPane grid = new GridPane();
        grid.add(amount, 0, 0);
        grid.add(amountt, 1, 0);
        grid.add(submit, 1, 1);
        grid.add(back, 0, 2);
        grid.add(insufficient1, 1, 2);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String amount = amountt.getText();

                boolean valid = withdraw1.withdraw(amount);
                if (valid) {
                    insufficient1.setText("Successful");
                    ATMmenu.addtoHistory("Withdraw: " + amount);
                } else {
                    insufficient1.setText("Insufficient balance");

                }
            }

        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.setScene(menu.getScene());
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

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

}
