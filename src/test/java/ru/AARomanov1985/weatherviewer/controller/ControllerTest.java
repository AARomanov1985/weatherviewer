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

import static junit.framework.TestCase.assertEquals;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import ru.AARomanov1985.weatherviewer.model.CSVManager;
import ru.AARomanov1985.weatherviewer.model.DataManager;

/**
 *
 * @author Alexandr Romanov
 */
public class ControllerTest {

    public ControllerTest() {
    }

    private Controller instance;

    @Before
    public void setUp() {
        instance = Controller.getInstance();
    }

    @Test
    public void testGetCsvManager() {
        System.out.println("getCsvManager");
        CSVManager expResult = CSVManager.getInstance();
        CSVManager result = instance.getCsvManager();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDataManager() {
        System.out.println("getDataManager");
        DataManager expResult = Controller.getInstance().getDataManager();
        DataManager result = instance.getDataManager();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Controller expResult = instance;
        Controller result = Controller.getInstance();
        assertEquals(expResult, result);
    }

    //@Test
    public void testExitApp() {
        System.out.println("exitApp");
        instance.exitApp();
        Assert.assertTrue(true);
    }

    //@Test
    public void testFileOpen() {
        System.out.println("fileOpen");
        Controller instance = null;
        instance.fileOpen();
    }

    //@Test
    public void testDrawGeneralWindow() {
        System.out.println("drawGeneralWindow");
        Controller instance = null;
        instance.drawGeneralWindow();
    }

    //@Test
    public void testGetData() {
        System.out.println("getData");
        String[][] expResult = Controller.getInstance().getData();
        String[][] result = instance.getData();
        assertArrayEquals(expResult, result);
    }

    //@Test
    public void testFileClose() {
        System.out.println("fileClose");
        Controller instance = null;
        instance.fileClose();
    }

    //@Test
    public void testAboutApp() {
        System.out.println("aboutApp");
        Controller instance = null;
        instance.aboutApp();
    }

    //@Test
    public void testPrintTable() {
        System.out.println("printTable");
        Controller instance = null;
        instance.printTable();
    }

    //@Test
    public void testStartApp() {
        System.out.println("startApp");
        Controller instance = null;
        instance.startApp();
    }

    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        String[] expResult = Controller.getInstance().getColumns();
        String[] result = instance.getColumns();
        assertArrayEquals(expResult, result);
    }

    //@Test
    public void testPrintError() {
        System.out.println("printError");
        Throwable err = null;
        Controller instance = null;
        instance.drawError(err);
    }

    //@Test
    public void testLoadFromDB() {
        System.out.println("loadFromDB");
        Controller instance = null;
        instance.loadFromDB();
    }

    //@Test
    public void testSaveInDB() {
        System.out.println("saveInDB");
        Controller instance = null;
        instance.saveInDB();
    }

    @Test
    public void testGetMeteoStation() {
        System.out.println("getMeteoStation");
        String expResult = Controller.getInstance().getMeteoStation();
        String result = instance.getMeteoStation();
        assertEquals(expResult, result);
    }
}
