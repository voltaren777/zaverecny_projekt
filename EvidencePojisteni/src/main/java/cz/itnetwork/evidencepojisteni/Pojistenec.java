/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;

/**
 *
 * @author stran
 */
public class Pojistenec {

    private String jmeno;
    private String prijmeni;
    private String telefonniCislo;
    private int vek;

    public Pojistenec(String jmeno, String prijmeni, String telefonniCislo, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefonniCislo = telefonniCislo;
        this.vek = vek;
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the prijmeni
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @return the telefonniCislo
     */
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    /**
     * @return the vek
     */
    public int getVek() {
        return vek;
    }

    @Override
    public String toString() {                                              // Vrátí detaily o pojištěnci
        return (jmeno + " " + prijmeni + "      " + vek + "      " + telefonniCislo);
    }
}
