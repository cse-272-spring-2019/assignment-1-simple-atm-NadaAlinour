/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ATMmain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM");
        Login login = new Login(primaryStage);
        ATMmenu menu = new ATMmenu(primaryStage);
        WithdrawScene withdrawScene = new WithdrawScene(primaryStage);
        DepositScene depositScene = new DepositScene(primaryStage);

        login.prepareScene();
        menu.prepareScene();
        withdrawScene.prepareScene();
        depositScene.prepareScene();

        login.setATMmenu(menu);
        menu.setLogin(login);
        menu.setWithdrawScene(withdrawScene);
        withdrawScene.setATMmenu(menu);
        menu.setDepositScene(depositScene);
        depositScene.setATMmenu(menu);

        primaryStage.setScene(login.getScene());
        primaryStage.show();
    }

}
