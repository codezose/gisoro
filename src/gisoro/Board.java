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
public class Board {
    final int SIZE = 16;
    boolean id;        
    Pit [] board = new Pit[16];

    public Board(boolean id) {
        this.id =id;
        initializeBoard();
    }
        
    public void initializeBoard(){
        for(int i=0;i<16;i++){
            if(i<8){
                if(Arrays.asList(1,6).contains(i))
                    board[i] = new BidirectionalPit(i, 4);
                else
                    board[i] = new ForwardPit(i, 4);
            }else{
                if(Arrays.asList(8,14).contains(i))
                    board[i] = new BidirectionalPit(i);
                else
                    board[i] = new ForwardPit(i);
            }
        }
    }
    
    Pit getPit(int id){
        return board[id];
    }
    
    void updatePit(Pit p){
        board[p.getId()] = p;
    }   
    
    Pit nextPit(int id) {
        int nextId = (id+1)%this.SIZE;
        return board[nextId];
    }
    
    Pit previousPit(int id) {
        int nextId = (id-1)<0? this.SIZE-1 : id-1;
        return board[nextId];
    }
    
    String getName(){
        if(this.id)
            return "boardA";
        else
            return "boardB";
    }
    public void printBoard(){
        System.out.print(getName()+": ");
        for(int i=0;i<this.SIZE;i++){
            System.out.print(String.valueOf(board[i].getSize())+"\t");
//            System.out.print("("+board[i].getName()+ ", " + String.valueOf(board[i].getSize())+")\t");
        }
        System.out.println("");
    } 
}
