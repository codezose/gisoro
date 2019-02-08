/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gisoro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dominique
 */
public class Player {
    String name;
    boolean win;
//    int id;   //Later needed
    Board board;
    Board adversaryBoard;
    Pit chosePit = null;
    Pit stopPit = null;
    Pit currentPit = null;
    int currentPitId;
    
    Random rand;
    List<Integer> playblePits;

    public Player(Board board, Board adversaryBoard, String name) {
        this.board = board;
        this.name = name;
        this.win = true;
        rand = new Random();
        playblePits = new ArrayList();
        this.board.printBoard();
        this.adversaryBoard = adversaryBoard;
    }
    
    Pit choosePit(){
        //It should be intelligently implemented...
        this.chosePit = null;        
        int pId;
        updatePlayablePits();        
        if(!playblePits.isEmpty()){
            pId = rand.nextInt(playblePits.size());
            chosePit = this.board.board[playblePits.get(pId)];
        }
//        updatePlayablePits();
        playblePits.clear();
        return chosePit;
    }
    
    void playPit(Pit chosePit){
        assert(chosePit!=null);
        this.chosePit = chosePit;
        this.stopPit = chosePit;                       
        this.currentPitId = this.stopPit.getId();
        while(0<this.chosePit.getSize()){
            this.chosePit.setSize(this.chosePit.getSize()-1);
            //this.board.updatePit(chosePit);
            this.stopPit = this.stopPit.nextPit(this.board);
            this.stopPit.setSize(this.stopPit.getSize()+1); 
            //this.board.updatePit(this.stopPit);
        }
//        this.board.printBoard();
    }
    
    void play(){
//        this.board.printBoard();

        updatePlayablePits();
        if(playblePits.isEmpty()){
            this.win = false;
            return;
        }
        
        this.chosePit = choosePit();
        playPit(this.chosePit);
        while(this.stopPit.getSize()!=1){
            if(Arrays.asList(0,1,2,3,4,5,6,7).contains(this.stopPit.getId()) && allowTakeSeeds(this.stopPit.getId())){
                this.currentPit = this.board.board[this.currentPitId];
                this.board.board[this.currentPitId].setSize(takeSeeds(this.stopPit.getId()));
                playPit(this.currentPit);
            }else{  
                playPit(this.stopPit);
            }
        }
        this.board.printBoard();
    }
    
    void updatePlayablePits(){
        for(Pit p: this.board.board)
            if(p.getSize()>1)
                this.playblePits.add(p.getId());
    }

    private int takeSeeds(int id) {
        Pit firstPit = this.adversaryBoard.board[id];
        Pit secondPit = this.adversaryBoard.board[this.adversaryBoard.SIZE-id-1];
        int wonSeeds = 0;
        if(firstPit.getSize()>0 && secondPit.getSize()>0){
            wonSeeds = firstPit.getSize()+secondPit.getSize();
            firstPit.setSize(0);
            secondPit.setSize(0);
            System.out.println(this.name + " takes seeds from (ids) "+id);
        }
        return wonSeeds;
    }
    
    boolean allowTakeSeeds(int id){
        Pit firstPit = this.adversaryBoard.board[id];
        Pit secondPit = this.adversaryBoard.board[this.adversaryBoard.SIZE-id-1];
        if(firstPit.getSize()>0 && secondPit.getSize()>0)
            return true;
        return false;
    }
}
