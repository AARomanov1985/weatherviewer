/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.AARomanov1985.weatherviewer.view;

import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import ru.AARomanov1985.weatherviewer.controller.SimpleDialogListener;

/**
 *
 * @author raan
 */
public class EventDialog extends JDialog {

    public EventDialog(Frame owner, String message, boolean modal) {
        super(owner, null, modal);
        setUp(message);
    }

    private void setUp(String message) {
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        JPanel panel = new JPanel();
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("./res/icons/ok.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel.add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(AboutAppDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel.add(new JLabel(message), CENTER);
        this.add(panel, CENTER);
        panel = new JPanel();
        JButton button = new JButton("Ok");
        button.addActionListener(new SimpleDialogListener(this));
        panel.add(button);
        this.add(panel, SOUTH);
        this.pack();
    }
}