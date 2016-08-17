/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.AARomanov1985.weatherviewer.view;

import java.awt.*;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import ru.AARomanov1985.weatherviewer.Project;

/**
 *
 * @author raan
 */
public class AboutAppDialog extends JDialog {

    public AboutAppDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        //this.setSize(width, height);
        this.setTitle("О программе");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        addLabel();
        this.pack();
    }

    private void addLabel() {
        JPanel panel = new JPanel();
        BufferedImage myPicture;
        panel.setLayout(new BorderLayout(2, 1));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        try {
            myPicture = ImageIO.read(new File("./res/header1.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel.add(picLabel, NORTH);
        } catch (IOException ex) {
            Logger.getLogger(AboutAppDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        panel.add(new JLabel("<html><body><h3>" + Project.NAME + " " + Project.VERSION + "</h3>"
                + "<font face=’verdana’ size = 2>"
                + "Программа обработки метеоданных в формате csv"
                + "<br><br>Права на использование и воспроизведение "
                + "согласно GNU GENERAL PUBLIC LICENSE"
                + "<br>2016 г.</body></html>"), SOUTH);
        this.add(panel);
    }
}
