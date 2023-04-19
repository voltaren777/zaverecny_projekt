/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cz.itnetwork.evidencepojisteni;

import java.util.Scanner;

/**
 *
 * @author stran
 */
public class EvidencePojisteni {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in,"windows-1250");
        Ui ui = new Ui();
        SeznamPojistencu seznampojistencu = new SeznamPojistencu();
        ui.behProgramu(sc, seznampojistencu);


    }
}
