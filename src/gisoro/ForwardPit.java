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
public class ForwardPit implements Pit{
    int size;
    boolean direction;
    int id;
    
    ForwardPit(int id){
        this.size = 0;
        this.direction = false;
        this.id = id;
    }
    
    ForwardPit(int id, int size){
        this.size = size;
        this.direction = false;
        this.id = id;
    }
    
    @Override
    public String getName() {
        if(Arrays.asList(6,8).contains(this.id))
           return "Nteba";
        else if(Arrays.asList(1,14).contains(this.id))
           return "Ngarama";
        else if(Arrays.asList(0,7).contains(this.id))
           return "Umutwe";
        return String.valueOf(this.id);
    }

    @Override
    public Pit nextPit(Board b) {
        return b.nextPit(this.id);
    }   

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int s) {
        this.size = s;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
