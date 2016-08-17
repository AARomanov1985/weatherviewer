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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Alexandr Romanov
 */

@Entity
@Table(name = "data")
public class WeatherRecord {

    private int id;

    private int id_station;
    private String time_measure;
    private double temperature;
    private double Po;
    private double P;
    private double Pa;
    private int U;
    private String DD;
    private int Ff;
    private int ff10;
    private int ff3;
    private String N;
    private String WW;
    private String W1;
    private String W2;
    private double Tn;
    private double Tx;
    private String Cl;
    private String Nh;
    private String H;
    private String Cm;
    private String Ch;
    private double W;
    private double Td;
    private String RRR;
    private int tR;
    private String E;
    private String Tg;
    private String E2;
    private String sss;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(targetEntity = Station.class)
    @JoinColumn(name="id_station")
    public int getId_station() {
        return id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public String getTime_measure() {
        return time_measure;
    }

    public void setTime_measure(String time_measure) {
        this.time_measure = time_measure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPo() {
        return Po;
    }

    public void setPo(double Po) {
        this.Po = Po;
    }

    public double getP() {
        return P;
    }

    public void setP(double P) {
        this.P = P;
    }

    public double getPa() {
        return Pa;
    }

    public void setPa(double Pa) {
        this.Pa = Pa;
    }

    public int getU() {
        return U;
    }

    public void setU(int U) {
        this.U = U;
    }

    public String getDD() {
        return DD;
    }

    public void setDD(String DD) {
        this.DD = DD;
    }

    public int getFf() {
        return Ff;
    }

    public void setFf(int Ff) {
        this.Ff = Ff;
    }

    public int getFf10() {
        return ff10;
    }

    public void setFf10(int ff10) {
        this.ff10 = ff10;
    }

    public int getFf3() {
        return ff3;
    }

    public void setFf3(int ff3) {
        this.ff3 = ff3;
    }

    public String getN() {
        return N;
    }

    public void setN(String N) {
        this.N = N;
    }

    public String getWW() {
        return WW;
    }

    public void setWW(String WW) {
        this.WW = WW;
    }

    public String getW1() {
        return W1;
    }

    public void setW1(String W1) {
        this.W1 = W1;
    }

    public String getW2() {
        return W2;
    }

    public void setW2(String W2) {
        this.W2 = W2;
    }

    public double getTn() {
        return Tn;
    }

    public void setTn(double Tn) {
        this.Tn = Tn;
    }

    public double getTx() {
        return Tx;
    }

    public void setTx(double Tx) {
        this.Tx = Tx;
    }

    public String getCl() {
        return Cl;
    }

    public void setCl(String Cl) {
        this.Cl = Cl;
    }

    public String getNh() {
        return Nh;
    }

    public void setNh(String Nh) {
        this.Nh = Nh;
    }

    public String getH() {
        return H;
    }

    public void setH(String H) {
        this.H = H;
    }

    public String getCm() {
        return Cm;
    }

    public void setCm(String Cm) {
        this.Cm = Cm;
    }

    public String getCh() {
        return Ch;
    }

    public void setCh(String Ch) {
        this.Ch = Ch;
    }

    public double getW() {
        return W;
    }

    public void setW(double W) {
        this.W = W;
    }

    public double getTd() {
        return Td;
    }

    public void setTd(double Td) {
        this.Td = Td;
    }

    public String getRRR() {
        return RRR;
    }

    public void setRRR(String RRR) {
        this.RRR = RRR;
    }

    public int gettR() {
        return tR;
    }

    public void settR(int tR) {
        this.tR = tR;
    }

    public String getE() {
        return E;
    }

    public void setE(String E) {
        this.E = E;
    }

    public String getTg() {
        return Tg;
    }

    public void setTg(String Tg) {
        this.Tg = Tg;
    }

    public String getE2() {
        return E2;
    }

    public void setE2(String E2) {
        this.E2 = E2;
    }

    public String getSss() {
        return sss;
    }

    public void setSss(String sss) {
        this.sss = sss;
    }
}