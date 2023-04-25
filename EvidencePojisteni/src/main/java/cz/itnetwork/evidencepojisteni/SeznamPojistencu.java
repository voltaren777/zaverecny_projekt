/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author stran
 */
public class SeznamPojistencu {

    private ArrayList<Pojistenec> pojistenci = new ArrayList<>();             //Kolekce k uložení pojištěných

    /**
     *Přidá pojštěnce
     * @param pojistenec
     */
    public void pridejPojistenceDoSeznamu(String jmeno, String prijmeni, String telefonniCislo,int vek) {

        pojistenci.add(new Pojistenec(jmeno,prijmeni,telefonniCislo,vek));                                         //Uložení pojištěnce do kolekce
    }

    /**
     *Cyklem vypíše všechny seznam všech pojištěnců
     * @param Scanner
     */
    public void zobrazVsechnyPojistence() {

        for (Pojistenec pojistenec : pojistenci) {
            System.out.printf("\n%s\n", pojistenec);

        }

    }

    /**
     *Vyhledá jména dle zadaného jména a příjmení a vrátí pojištěnce při shodě
     * @param jmeno
     * @param prijmeni
     * @return
     */
    public String vyhledejPojistence(String jmeno, String prijmeni) {
        for (Pojistenec x : pojistenci) {

            if ((x.getJmeno().equalsIgnoreCase(jmeno.trim())) && (x.getPrijmeni().equalsIgnoreCase(prijmeni.trim()))) {
                return x.toString();
            }}

            return "Pojištěnec nenalezen";

       }
    }
