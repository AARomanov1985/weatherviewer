package ru.AARomanov1985.weatherviewer;

import ru.AARomanov1985.weatherviewer.controller.Controller;

public class App {

    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        try {
            controller.startApp();
        } catch (Exception ex) {
            controller.drawError(ex);
        }
    }
}