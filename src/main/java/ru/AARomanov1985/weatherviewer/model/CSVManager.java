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

import au.com.bytecode.opencsv.CSVReader;
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import java.io.*;
import java.util.*;
import ru.AARomanov1985.weatherviewer.controller.Controller;

/**
 *
 * @author raan
 */
public class CSVManager {

    private CSVManager() {
        controller = Controller.getInstance();
    }

    private Controller controller;

    private static CSVManager instance;

    public static CSVManager getInstance() {
        if (instance == null) {
            instance = new CSVManager();
        }
        return instance;
    }

    /**
     * Чтение csv-файла
     */
    public List<String[]> readFile(File file) {
        List<String[]> data = null;
        try {
            CSVReader reader = new CSVReader(new UTF8Reader(new FileInputStream(file)), ';');
            data = reader.readAll();
        } catch (IOException ex) {
            controller.drawError(ex);
        }
        return data;
    }
}
