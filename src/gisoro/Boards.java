/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gisoro;

/**
 *
 * @author Dominique
 */
public class Boards {
    Board boardA, boardB;


    public Boards() {
        boardA = new Board(true);
        boardB = new Board(false);  
    }    
        
    public Board getBoardA() {
        return boardA;
    }

    public Board getBoardB() {
        return boardB;
    }
    
    Board getBoard(boolean id){
        if(id)
            return boardA;
        else
            return boardB;
    }
}
