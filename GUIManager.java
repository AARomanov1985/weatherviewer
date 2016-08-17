/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template data, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.AARomanov1985.weatherviewer;

import java.awt.Dimension;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ru.AARomanov1985.weatherviewer.controller.Controller;
import ru.AARomanov1985.weatherviewer.view.*;

/**
 *
 * @author raan
 */
public class GUIManager {

    private Controller controller = Controller.getInstance();

    private GUIManager() {
    }

    private static GUIManager instance;

    public static GUIManager getInstance() {
        if (instance == null) {
            instance = new GUIManager();
        }
        return instance;
    }

    private GlobalWindow generalWindow;
    private AboutAppDialog aboutAppDialog = new AboutAppDialog(generalWindow, null, true);
    private JTable table;

    public GlobalWindow getGeneralWindow() {
        return generalWindow;
    }

    public void drawGeneralWindow() {
        new Runnable() {
            @Override
            public void run() {
                if (generalWindow == null) {
                    generalWindow = new GlobalWindow();
                    generalWindow.init();
                }
            }
        }.run();

    }

    public AboutAppDialog getAboutAppDialog() {
        return aboutAppDialog;
    }

    public void drawAboutAppDialog() {
        //aboutAppDialog = new AboutAppDialog(generalWindow, null, true);
        aboutAppDialog.setVisible(true);
    }

    public File openFile() {
        JFileChooser fch = new JFileChooser();
        fch.showOpenDialog(fch);
        disableTable();
        return fch.getSelectedFile();
    }

    public void drawTable() {
        new Runnable() {
            @Override
            public void run() {
                String[][] data = controller.getData();
                String[] columns = controller.getColumns();
                if (data != null && columns != null) {
                    table = new JTable(data, columns);
                    generalWindow.setPreferredSize(new Dimension(1024, 600));
                    generalWindow.pack();
                    generalWindow.setVisible(true);
                    generalWindow.add(table);
                    JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    scrollPane.setVisible(true);
                    generalWindow.add(scrollPane);
                    generalWindow.setExtendedState(generalWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                    generalWindow.repaint();
                } else {
                    System.out.println("Неверный формат");
                }
            }
        }.run();
    }

    public void disableTable() {
        generalWindow.dispose();
        drawGeneralWindow();
    }

    public void drawError(Throwable err) {
        JDialog dialog = new ErrorDialog(generalWindow, err.getMessage(), true);
        dialog.setVisible(true);
    }
}
