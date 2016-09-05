package logic.controller;

/**
 * Created by samik on 5.9.16.
 */
public class Util {

    public static String removeDecimalString(String input) {
        int dotIndex = input.indexOf(".");

        // retezec neobsahuje tecku
        if(dotIndex == -1) {
            return input;
        } else {
            return input.substring(0, dotIndex);
        }
    }
}
