/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gisoro;

import java.util.Arrays;

/**
 *
 * @author Dominique
 */
public class Gisoro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boards boards = new Boards();
        System.out.println("Gutangira ...");
        Player playerA = new Player(boards.boardA, "A");
        Player playerB = new Player(boards.boardB, "B");
        
        //Play until one winns ...
        System.out.println("A B kuvuno ...");
        playerA.play();
        playerB.play();
        System.out.println("A B kwivunura ...");
        playerA.play();
        playerB.play();
        System.out.println("A B Gukina ...");
        while(playerA.win || playerB.win){
            playerA.play();
            playerB.play();
        }
    }
}
