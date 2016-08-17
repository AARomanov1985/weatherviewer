/*
 * Copyright (C) 2016 raan
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

import java.util.List;
import java.util.StringTokenizer;
import ru.AARomanov1985.weatherviewer.controller.Controller;

/**
 * Класс отвечает за работу с данными, полученными из массива String[][]
 *
 * @author raan
 */
public class DataManager {

    private DataManager() {
        controller = Controller.getInstance();
    }

    private Controller controller;

    private static DataManager instance;

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    /**
     * Данные из csv-файла
     */
    private List<String[]> data;

    public void setData(List<String[]> data) {
        this.data = data;
    }

    /**
     * Получить данные из открытого файла
     */
    public String[][] getData() {
        String[][] rows = null;
        if (data != null && data.size() > 6) {
            rows = new String[data.size() - 7][data.get(6).length];
            System.out.println("rows" + rows.length + " " + data.size());
            for (int x = 7; x < (data.size()); x++) {
                for (int y = 0; y < data.get(6).length; y++) {
                    rows[x - 7][y] = data.get(x)[y];
                }
            }
        } else {
            controller.drawError(new Throwable("Неверный формат файла"));
        }

        return rows;
    }

    /**
     * Получить название метеостанции
     */
    public String getMeteoStation() {
        String meteoStation = null;
        if (data != null && !data.isEmpty()) {
            String[] header = data.get(0);
            if (header != null && header.length != 0) {
                StringTokenizer tokenizer = new StringTokenizer(header[0], ",");
                String token = tokenizer.nextToken();
                try {
                    meteoStation = token.substring(15);
                } catch (NullPointerException ignore) {
                    meteoStation = "Метеостанция";
                }
            }
        }
        return meteoStation;
    }

    /**
     * Получить названия столбцов
     */
    public String[] getColumns() {
        String[] columns = null;
        if (data != null && data.size() > 6) {
            columns = data.get(6);
        }
        return columns;
    }

    /**
     * Обнулить ссылку на открытый файл
     */
    public void clearData() {
        System.out.println("close file");
        data = null;
    }
}
