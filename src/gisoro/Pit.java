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
public interface Pit {
    int getId();
    int getSize();
    void setSize(int s);
    String getName();
    Pit nextPit(Board b);
}
