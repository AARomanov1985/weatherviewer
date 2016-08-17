/*
 * Copyright (C) 2016 Alexandr Romanov
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package ru.AARomanov1985.weatherviewer.view;

import com.toedter.calendar.JDateChooser;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Date;
import javax.swing.*;
import ru.AARomanov1985.weatherviewer.controller.Controller;

/**
 *
 * @author Alexandr Romanov
 */
public class LoadFromDB extends JDialog {

    public LoadFromDB(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        super.setTitle("Опции загрузки данных");

        JPanel panel = new JPanel(new FlowLayout(1, 10, 5));
        panel.setSize(new Dimension(260, 160));

        JLabel labelStation = new JLabel("Станция");
        panel.add(labelStation);

        JComboBox station = new JComboBox(Controller.getInstance().getStationsNames());
        panel.add(station);

        JLabel dateinLabel = new JLabel("Установите диапазон выборки");
        panel.add(dateinLabel);

        JDateChooser dateinButton = new JDateChooser(new Date());
        panel.add(dateinButton);

        JDateChooser dateoutButton = new JDateChooser(new Date());
        panel.add(dateoutButton,SOUTH);

        JButton load = new JButton("Load");
        load.setSize(40, 10);
        panel.add(load);

        JButton cancel = new JButton("Cancel");
        cancel.setSize(40, 10);
        panel.add(cancel);

        super.setSize(panel.getSize());

        super.add(panel);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        //super.pack();
    }
}
