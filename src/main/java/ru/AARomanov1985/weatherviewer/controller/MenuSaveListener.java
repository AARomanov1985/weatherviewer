/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.AARomanov1985.weatherviewer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author raan
 */
public class MenuSaveListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Controller.getInstance().saveInDB();
    }
}