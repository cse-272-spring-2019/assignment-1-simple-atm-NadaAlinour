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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ATMmenu {

    Scene scene;
    Login login;
    Stage stage;
    WithdrawScene withdrawScene;
    DepositScene depositScene;
    ATM atm = new ATM();
    static LinkedList<String> history = new LinkedList<>();
    static int position = -1;

    static void addtoHistory(String transaction) {
        history.add(transaction);
        if (history.size() > 5) {
            history.removeFirst();
        }
        position = history.size();

    }

    public ATM getAtm() {
        return atm;
    }

    public void prepareScene() {
        Button logout = new Button("Logout");
        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");
        Button balanceInquiry = new Button("Balance Inquiry");
        Button next = new Button("Next");
        Button previous = new Button("Previous");

        Label getbalance = new Label();
        Label historyLabel = new Label();

        GridPane grid = new GridPane();
        grid.add(logout, 3, 5);
        grid.add(withdraw, 0, 0);
        grid.add(deposit, 0, 1);
        grid.add(balanceInquiry, 0, 2);
        grid.add(next, 0, 3);
        grid.add(previous, 0, 4);
        grid.add(getbalance, 3, 2);
        grid.add(historyLabel, 2, 3);

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(login.getScene());

            }
        });

        balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getbalance.setText(atm.Balance());
                addtoHistory("Balance Inquiry: " + atm.Balance());

            }
        });

        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //goes  to withdraw scene
                stage.setScene(withdrawScene.getScene());
                withdrawScene.setWithdraw1(atm);
            }
        });

        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(depositScene.getScene());
                depositScene.setDeposit1(atm);
            }

        });

        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (position <= 0) {
                    historyLabel.setText("No further information");

                } else {
                    position--;
                    historyLabel.setText(history.get(position));

                }

            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (history.size() < 2 || position == 5 || position == history.size()) {
                    historyLabel.setText("No further information");
                } else {
                    historyLabel.setText(history.get(position));
                    position++;
                }

            }
        });

        scene = new Scene(grid, 400, 200);

    }

    public Scene getScene() {
        return scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setWithdrawScene(WithdrawScene withdrawScene) {
        this.withdrawScene = withdrawScene;
    }

    public void setDepositScene(DepositScene depositScene) {
        this.depositScene = depositScene;
    }

    public ATMmenu(Stage stage) {

        this.stage = stage;
    }

}
