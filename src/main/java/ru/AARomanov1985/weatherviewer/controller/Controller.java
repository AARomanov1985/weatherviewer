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
package ru.AARomanov1985.weatherviewer.controller;

import java.awt.Point;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import ru.AARomanov1985.weatherviewer.model.CSVManager;
import ru.AARomanov1985.weatherviewer.model.DBManager;
import ru.AARomanov1985.weatherviewer.model.DataManager;
import ru.AARomanov1985.weatherviewer.view.AboutAppDialog;
import ru.AARomanov1985.weatherviewer.view.ErrorDialog;
import ru.AARomanov1985.weatherviewer.view.EventDialog;
import ru.AARomanov1985.weatherviewer.view.GlobalWindow;
import ru.AARomanov1985.weatherviewer.view.LoadFromDB;

/**
 *
 * @author Alexandr Romanov
 */
public class Controller {

    private Controller() {
    }

    private static Controller instance;

    /**
     * Ссылки на экземпляры вспомогательных классов:
     */
    private static CSVManager csvManager = CSVManager.getInstance();
    private static DataManager dataManager = DataManager.getInstance();
    private static DBManager dbManager = DBManager.getInstance();

    private GlobalWindow window;

    public CSVManager getCsvManager() {
        return csvManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    /**
     * Закрытие приложения
     */
    public void exitApp() {
        System.exit(0);
    }

    /**
     * Загрузка и отображение файла
     */
    public void fileOpen() {
        JFileChooser fch = new JFileChooser();
        fch.setFileFilter(new CSVFileFilter());
        fch.setMultiSelectionEnabled(true);
        fch.showOpenDialog(fch);
        File[] files = fch.getSelectedFiles();
        for (File file : files) {
            if (file != null) {
                dataManager.setData(csvManager.readFile(file));
                printTable();
            }
        }
    }

    /**
     * Отрисовка главного окна
     */
    public void drawGeneralWindow() {
        window = new GlobalWindow();
        window.init();
        aboutAppDialog = new AboutAppDialog(window, null, true);
        while (aboutAppDialog == null) {
            Thread.yield();
        }
        window.setVisible(true);
    }

    /**
     * Получить данные от DataManager
     */
    public String[][] getData() {
        return dataManager.getData();
    }

    /**
     * Закрытие файла
     */
    public void fileClose() {
        dataManager.clearData();
        if (tabbedPane != null && tabbedPane.getTabCount() > 0) {
            tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
            if (tabbedPane.getTabCount() == 0) {
                window.init();
            }
        }
    }

    private AboutAppDialog aboutAppDialog;

    /**
     * Показать информацию о программе
     *
     * @param owner инициатор вызова
     */
    public void aboutApp() {
        int x = window.getX() + window.getWidth() / 3;
        int y = window.getY() + window.getHeight() / 3;
        aboutAppDialog.setLocation(x, y);
        aboutAppDialog.setVisible(true);
    }

    private JTabbedPane tabbedPane;

    /**
     * Вывести таблицу с данными
     */
    public void printTable() {
        new Runnable() {
            @Override
            public void run() {
                String[][] data = getData();
                String[] columns = getColumns();
                if (data != null && columns != null) {
                    if (tabbedPane == null) {
                        tabbedPane = new JTabbedPane();
                    }
                    JTable table = new JTable(data, columns);
                    table.setAutoResizeMode(AUTO_RESIZE_OFF);
                    JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    tabbedPane.addTab(getMeteoStation(), scroll);
                    window.add(tabbedPane);
                    window.setExtendedState(window.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                    window.setVisible(true);
                    //window.repaint();
                } else {
                    System.out.println("Неверный формат");
                }
            }
        }.run();
    }

    /**
     * Запуск приложения
     */
    public void startApp() {
        drawGeneralWindow();
        dbManager.connect();
    }

    /**
     * Получить имена столбцов
     */
    public String[] getColumns() {
        return dataManager.getColumns();
    }

    public void drawError(Throwable err) {
        JDialog dialog = new ErrorDialog(window, err.getMessage(), true);
        dialog.setLocation(getCentralLocation());
        dialog.setVisible(true);
    }

    /**
     * Отображение диалогового окна загрузки из БД
     */
    public void loadFromDB() {
        LoadFromDB loadFromDB = new LoadFromDB(window, null, true);
        loadFromDB.setLocation(getCentralLocation());
        loadFromDB.setVisible(true);
    }

    /**
     * Записать данные в БД
     */
    public void saveInDB() {
        dbManager.insertData(null);
    }

    /**
     * Получить название метеостанции
     */
    public String getMeteoStation() {
        return dataManager.getMeteoStation();
    }

    /**
     * Вывод уведомления
     */
    public void drawEvent(String message) {
        JDialog dialog = new EventDialog(window, message, true);
        dialog.setLocation(getCentralLocation());
        dialog.setVisible(true);
    }

    /**
     * Вычисляем расположение для диалоговых окон
     */
    private Point getCentralLocation() {
        int x = window.getX() + window.getWidth() / 3;
        int y = window.getY() + window.getHeight() / 3;
        return new Point(x, y);
    }

    /**
     * Получить названия метеостанций из базы
     */
    public String[] getStationsNames() {
        return dbManager.getStationsNames();
    }
}
