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
    Pit chosePit = null;
    Pit stopPit = null;
    Pit currentPit = null;
    
    Random rand;
    List<Pit> playblePits;

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;
        this.win = true;
        rand = new Random();
        playblePits = new ArrayList();
        this.board.printBoard();
    }
    
    Pit choosePit(){
        //It should be intelligently implemented...
        this.chosePit = null;        
        int pId;
        updatePlayablePits();        
        if(!playblePits.isEmpty()){
            pId = rand.nextInt(playblePits.size());
            chosePit = playblePits.get(pId);
        }
//        updatePlayablePits();
//        playblePits.clear();
        return chosePit;
    }
    
    void playPit(Pit chosePit){
        assert(chosePit!=null);
        this.chosePit = chosePit;
        this.stopPit = chosePit;
        while(0<this.chosePit.getSize()){
            this.chosePit.setSize(this.chosePit.getSize()-1);
            //this.board.updatePit(chosePit);
            this.stopPit = this.stopPit.nextPit(this.board);
            this.stopPit.setSize(this.stopPit.getSize()+1);
            //this.board.updatePit(this.stopPit);
        }
        this.board.printBoard();
    }
    
    void play(){
        this.chosePit = choosePit();
        playPit(this.chosePit);
        this.currentPit = this.stopPit;
        if(this.stopPit.getSize()==1)
            return;
        if(Arrays.asList(0,1,2,3,4,5,6,7).contains(this.stopPit.getId())){
            this.stopPit.setSize(this.stopPit.getSize()+takePit());
            playPit(this.stopPit);
        }else{  
            playPit(this.stopPit);
        }

        if(playblePits.isEmpty())
            this.win = false;
    }
    
    void updatePlayablePits(){
        for(Pit p: this.board.board)
            if(p.getSize()>1)
                this.playblePits.add(p.getId(), p);
    }

    private int takePit() {
        System.out.println("Taking pits from Opponent!");
        return 0;
    }
}
