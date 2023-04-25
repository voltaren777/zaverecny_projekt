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
                System.out.println("\n\nPřidán nový pojištěný!\nPro pokračování stiskněte enter\n\n");
                sc.nextLine();
            } else if (vstup == 2) {
                seznamPojistencu.zobrazVsechnyPojistence();
                System.out.println("\nPro pokračování stiskněte enter\n");
                sc.nextLine();
            } else if (vstup == 3) {
                zobrazUIProVyhledaniPojistence(sc, seznamPojistencu);
                System.out.println("\n\nPro pokračování stiskněte enter\n");
                sc.nextLine();
            } else if (vstup > 4) {
                System.out.println("\nNeplatné zadání, vložte číslo v rozmezí 1-4\n\nPro pokračování stiskněte enter");
                sc.nextLine();
            }
        }
    }

    /**
     * Zobrazí výchozí obrazovku a rozhraní pro zadání číselných pokynů
     *
     * @param Scanner
     * @return pokyn k ovladani programu
     */
    public int zobrazVychoziObrazovku(Scanner sc) {

        System.out.println("Evidence Pojištěných\n\n");

        System.out.println("Vyberte si akci:\n1 - Přidat nového pojisteného \n2 - Vypsat všechny pojištěné \n3 - Vyhledat pojištěného \n4 - Konec\n");

        vstup = nactiCislo(sc);

        return vstup;
    }

    /**
     * Zobrazí rozhraní pro zadání nového pojištěnce, zvaliduje vstup a přidá
     * pojištěnce do seznamu.
     *
     * @param sc
     * @param seznamPojistencu
     */
    public void zobrazUIProPridaniPojisteneho(Scanner sc, SeznamPojistencu seznamPojistencu) {

        String telefonniCislo = "";

        System.out.println("Zadejte jméno pojišteného:");       // Zadání jména
        String jmeno = sc.nextLine();

        System.out.println("Zadejte příjmení:");                // Zadání příjmení
        String prijmeni = sc.nextLine();

        System.out.println("Zadejte telefoní číslo:");          // Zadání telefoního čísla + validace vstupu

        while (telefonniCislo.equals("")) {

            telefonniCislo = sc.nextLine();

        }
        System.out.println("Zadejte věk:");                    // Zadání věku + validace vstupu přes funkci nactiCislo()

        int vek = nactiCislo(sc);

        seznamPojistencu.pridejPojistenceDoSeznamu(jmeno, prijmeni, telefonniCislo, vek);  // Přídání pojištěnce do seznamu

    }

    /**
     * Zobrazí rozhraní pro zadání jména a příjmení a v případě nalezení
     * shodných parametrů v seznamu pojištěných vypíše údaje dotyčného.
     *
     * @param scanner
     * @param seznamPojistencu
     */
    public void zobrazUIProVyhledaniPojistence(Scanner sc, SeznamPojistencu seznamPojistencu) {

        System.out.println("Zadejte prosím jméno");               // zadání jména a uložení do proměnné
        String jmeno = sc.nextLine();
        System.out.println("Zadejte prosím příjmení");            // zadání příjmení a uložení do proměnné
        String prijmeni = sc.nextLine();

        System.out.println("\n" + seznamPojistencu.vyhledejPojistence(jmeno, prijmeni));      //Vyhledání pojištěnce dle jména a příjmení

    }

    /**
     * Zadání a validace čísla
     *
     * @param Scanner
     * @return Zvalidovane číslo
     */
    public int nactiCislo(Scanner sc) {
        int cislo = -1;
        while (cislo == -1) {

            try {
                cislo = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Neplatný vstup, musíte vložit číslo. Opakujte zadání prosím");
            }
        }
        return cislo;
    }
}
