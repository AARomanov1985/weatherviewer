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

import java.awt.*;
import static java.awt.BorderLayout.NORTH;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import ru.AARomanov1985.weatherviewer.Project;
import ru.AARomanov1985.weatherviewer.controller.AboutDialogListener;
import ru.AARomanov1985.weatherviewer.controller.MenuExitListener;
import ru.AARomanov1985.weatherviewer.controller.MenuFileCloseListener;
import ru.AARomanov1985.weatherviewer.controller.MenuFileOpenListener;
import ru.AARomanov1985.weatherviewer.controller.MenuLoadFromDBListener;
import ru.AARomanov1985.weatherviewer.controller.MenuSaveListener;

/**
 *
 * @author Alexandr Romanov
 */
public class GlobalWindow extends JFrame {

    private final int width = 800;
    private final int height = 500;

    public void init() {
        this.setSize(width, height);

        GroupLayout layout = new GroupLayout(this);

        this.setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(Project.NAME);
        addMenu();
        addIcons();
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new File("./res/weather.png"));
        } catch (IOException ex) {
            Logger.getLogger(GlobalWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setIconImage(icon);
    }

    private void addMenu() {

        JMenuBar menuBar = new JMenuBar();

        /**
         * Раздел "Файл"
         */
        JMenu fileMenu = new JMenu("File");

        /**
         * Загрузка файла для разборки
         */
        JMenuItem loadItem = new JMenuItem("Open");
        loadItem.addActionListener(new MenuFileOpenListener());
        fileMenu.add(loadItem);

        /**
         * Загрузисть из базы данных
         */
        JMenuItem loadDBItem = new JMenuItem("Load..");
        loadDBItem.addActionListener(new MenuLoadFromDBListener());
        fileMenu.add(loadDBItem);

        /**
         * Сохранить в базу данных
         */
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new MenuSaveListener());
        fileMenu.add(saveItem);

        /**
         * Выгрузка файла
         */
        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.addActionListener(new MenuFileCloseListener());
        fileMenu.add(closeItem);

        /**
         * Выход
         */
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new MenuExitListener());
        fileMenu.add(exitItem);

        /**
         * Раздел "хелп"
         */
        JMenu aboutMenu = new JMenu("Help");

        /**
         * Вывести информацию о программе
         */
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new AboutDialogListener());
        aboutMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        this.setJMenuBar(menuBar);

    }

    private void addIcons() {
        JToolBar iconpanel = new JToolBar();
        this.setLayout(new BorderLayout());

        JButton addFile = new JButton(new ImageIcon("./res/icons/Add.png"));
        addFile.setPreferredSize(new Dimension(24, 24));
        addFile.addActionListener(new MenuFileOpenListener());
        addFile.setToolTipText("add");
        iconpanel.add(addFile);

        JButton loadData = new JButton(new ImageIcon("./res/icons/database_add.png"));
        loadData.setPreferredSize(new Dimension(24, 24));
        loadData.addActionListener(new MenuLoadFromDBListener());
        loadData.setToolTipText("load..");
        iconpanel.add(loadData);

        JButton save = new JButton(new ImageIcon("./res/icons/Save.png"));
        save.setPreferredSize(new Dimension(24, 24));
        save.addActionListener(new MenuSaveListener());
        save.setToolTipText("save");
        iconpanel.add(save);

        JButton admin = new JButton(new ImageIcon("./res/icons/Admin.png"));
        admin.setPreferredSize(new Dimension(24, 24));
        admin.setToolTipText("settings");
        iconpanel.add(admin);

        JButton close = new JButton(new ImageIcon("./res/icons/Delete.png"));
        close.setPreferredSize(new Dimension(24, 24));
        close.addActionListener(new MenuFileCloseListener());
        close.setToolTipText("close tab");
        iconpanel.add(close);

        iconpanel.setVisible(true);
        this.add(iconpanel, NORTH);
    }
}