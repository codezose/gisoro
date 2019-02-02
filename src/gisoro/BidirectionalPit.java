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
public class BidirectionalPit extends ForwardPit implements Pit{
    
    public BidirectionalPit(int id) {
        super(id);
    }
    
    public BidirectionalPit(int id, int size) {
        super(id, size);
        this.direction = true;
    }
    
    public Pit previousPit(Board b){
        return b.previousPit(this.id);
    }
    
}
