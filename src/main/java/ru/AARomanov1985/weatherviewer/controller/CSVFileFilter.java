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

import java.io.File;

/**
 *
 * @author Alexandr Romanov
 */
public class CSVFileFilter extends javax.swing.filechooser.FileFilter{

    @Override
    public boolean accept(File f) {
        if (f!=null){
            String name = f.getName();
            int i = name.lastIndexOf('.');
            if(f.isDirectory()){
                return true;
            }else if(i>0 && i<name.length()-1){
                return name.substring(i+1).equalsIgnoreCase("csv");
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Архив погоды в CSV";
    }

}
