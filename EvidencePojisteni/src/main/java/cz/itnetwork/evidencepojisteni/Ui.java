/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;

import java.util.Scanner;

/**
 *
 * @author stran
 */
public class Ui {

    private int vstup = 0;

    /**
     * Cyklus pro běh samotného programu
     *
     * @param sc
     * @param seznamPojistencu
     */
    public void behProgramu(Scanner sc, SeznamPojistencu seznamPojistencu) {
        while (vstup != 4) {
            zobrazVychoziObrazovku(sc);
            if (vstup == 1) {
                zobrazUIProPridaniPojisteneho(sc, seznamPojistencu);
            } else if (vstup == 2) {
                seznamPojistencu.zobrazVsechnyPojištěnce(sc);
            } else if (vstup == 3) {
                zobrazUIProVyhledaniPojistence(sc, seznamPojistencu);
            } else if (vstup > 4){
                System.out.println("\nNeplatné zadání, vložte číslo v rozmezí 1-4\n\nPro pokračování stiskněte enter");
                sc.nextLine();}
        }}
    

    /**
     * Zobrazí výchozí obrazovku a rozhraní pro zadání číselných pokynů
     *
     * @param sc
     * @return
     */
    public int zobrazVychoziObrazovku(Scanner sc) {

        System.out.println("Evidence Pojištěných\n\n");

        System.out.println("Vyberte si akci:\n1 - Přidat nového pojisteného \n2 - Vypsat všechny pojištěné \n3 - Vyhledat pojištěného \n4 - Konec\n");

        try {                                                                       // Zadání pokynu a jeho validace pomocí try-catch
            vstup = Integer.parseInt(sc.nextLine());
            return vstup;
        } catch (Exception e) {
            System.out.println("\nVstup musí být číslo, opakujte volbu prosím\n\nPro pokračování stiskněte enter.");
            sc.nextLine();
        }

        return vstup;
    }

    /**
     * Zobrazí rozhraní pro zadání nového pojištěnce, zvaliduje vstup a přidá
     * pojištěnce do seznamu.
     *
     * @param Scanner
     * @param seznamPojistencu
     */
    public void zobrazUIProPridaniPojisteneho(Scanner sc, SeznamPojistencu seznamPojistencu) {

        int telefonniCislo = -1;
        int vek = -1;

        System.out.println("Zadejte jméno pojišteného:");       // Zadání jména
        String jmeno = sc.nextLine();

        System.out.println("Zadejte příjmení:");                // Zadání příjmení
        String prijmeni = sc.nextLine();

        System.out.println("Zadejte telefoní číslo:");          // Zadání telefoního čísla + validace vstupu

        while (telefonniCislo == -1) {

            try {
                telefonniCislo = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Neplatný vstup, musíte vložit číslo. Opakujte zadání prosím");
            }
        }
        System.out.println("Zadejte věk:");                    // Zadání věku + validace vstupu

        while (vek == -1) {

            try {
                vek = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Neplatný vstup, musíte vložit číslo. Opakujte zadání prosím");
            }
        }

        seznamPojistencu.pridejPojistenceDoSeznamu(new Pojistenec(jmeno, prijmeni, telefonniCislo, vek));  // Přídání pojištěnce do seznamu

        System.out.println("\n\nPřidán nový pojištěný!\nPro pokračování stiskněte enter\n\n");
        sc.nextLine();
    }

    /**
     * Zobrazí rozhraní pro zadání jména a příjmení a v případě nalezení
     * shodných parametrů v seznamu pojištěných vypíše údaje dotyčného.
     *
     * @param sc
     * @param seznamPojistencu
     */
    public void zobrazUIProVyhledaniPojistence(Scanner sc, SeznamPojistencu seznamPojistencu) {

        System.out.println("Zadejte prosím jméno");               // zadání jména a uložení do proměnné
        String jmeno = sc.nextLine();
        System.out.println("Zadejte prosím příjmení");            // zadání příjmení a uložení do proměnné
        String prijmeni = sc.nextLine();

        System.out.println("\n" + seznamPojistencu.vyhledejPojistence(jmeno, prijmeni));      //Vyhledání pojištěnce dle jména a příjmení
        System.out.println("\n\nPro pokračování stiskněte enter\n");
        sc.nextLine();

    }
}