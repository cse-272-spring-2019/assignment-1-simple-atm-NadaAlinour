/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

public class PinValidation {

    String fetchedPin;
    String Pin = "1234";

    public boolean validate(String fetchedPin) {
        boolean validationResult = false;
        if (fetchedPin.equals(Pin)) {
            validationResult = true;

        }

        return validationResult;
    }

}
