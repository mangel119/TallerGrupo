/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import java.util.LinkedList;

/**
 *
 * @author jupas
 */
public class Pila<T extends Base> {
    
    private LinkedList<T> tope;
    
    public Pila () {
        tope= new LinkedList<>();
    }
    
    public void apilar(T elem) {
        tope.addFirst(elem);
    }
    public T desapilar() {
        return tope.removeFirst();
    }

    public boolean estaVacia() {
        return tope.isEmpty();
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        for (T e : tope)
        {
            sb.append(" ").append(e.toString());
        }
        sb.append("]");
        
        return sb.toString();
    }
    
}
