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
package ru.AARomanov1985.weatherviewer.model;

import java.util.*;
import org.hibernate.Session;
import ru.AARomanov1985.weatherviewer.controller.Controller;

/**
 *
 * @author Alexandr Romanov
 */
public class DBManager {

    private Session session;

    private DBManager() {
        controller = Controller.getInstance();
    }

    private Controller controller;

    private static DBManager instance;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * Получить данные из таблицы data
     *
     * @param station id метеостанции из таблицы station
     * @param datein дата начала диапазона измерений
     * @param dateout дата окончания диапазона измерений
     */
    public String[][] getData(int station, Date datein, Date dateout) {
        return null;
    }

    public boolean connect() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            controller.drawError(new Throwable("Ошибка соединения с базой данных!"));
        }
        return false;
    }

    /**
     * Вставка данных в таблицу data
     *
     * @param data
     */
    public void insertData(String[][] data) {
        try {
            updateStation(session);
            controller.drawEvent("Данные успешно записаны!");
        } catch (Exception ex) {
            ex.printStackTrace();
            controller.drawError(new Throwable("Ошибка записи в базу данных!"));
        } finally {
            session.close();
        }
    }

    private void updateStation(Session session) {
        Station station = new Station();
        String name = controller.getMeteoStation();
        station.setName(name);
        session.update(station);
    }

    private void updateData(Session session, String[][] data) {

    }

    /**
     * Получить названия метеостанций из базы
     */
    public String[] getStationsNames() {
        Session session = null;
        List<String> stations = null;
        String[] names = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            stations = session.createSQLQuery("SELECT name FROM station ORDER BY name").list();
        } catch (Exception ex) {
            ex.printStackTrace();
            controller.drawError(new Throwable("Ошибка записи в базу данных!"));
        } finally {
            session.close();
        }

        if (stations != null && !stations.isEmpty()) {
            names = new String[stations.size()];
            for (int i = 0; i < stations.size(); i++) {
                names[i] = stations.get(i);
            }
        }
        return names;
    }

    public static void main(String[] args) {
        DBManager db = new DBManager();
        db.insertData(null);
        System.exit(0);
    }
}
