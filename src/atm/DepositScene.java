/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DepositScene {

    Stage stage;
    ATMmenu menu;
    Scene scene;
    ATM atm;
    ATM deposit1;

    public void setDeposit1(ATM deposit1) {
        this.deposit1 = deposit1;
    }

    public DepositScene(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {
        Label amount = new Label("Enter amount");
        TextField amountt = new TextField();
        Button submit = new Button("Submit");
        Button back = new Button("Back");
        Label successLabel = new Label();
        Label testLabel = new Label();

        GridPane grid = new GridPane();
        grid.add(amount, 0, 0);
        grid.add(amountt, 1, 0);
        grid.add(submit, 1, 1);
        grid.add(back, 0, 2);
        grid.add(successLabel, 1, 2);
        grid.add(testLabel, 3, 2);

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //invoke deposit method
                String amount = amountt.getText();
                deposit1.deposit(amount);
                successLabel.setText("Successful");
                ATMmenu.addtoHistory("Deposit: " + amount);

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

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setATMmenu(ATMmenu menu) {
        this.menu = menu;
    }

}
