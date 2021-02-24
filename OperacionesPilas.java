/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author jupas
 */
public class OperacionesPilas<T extends Base> {
    
    public static <T extends Base> Pila <T> duplicarPila(Pila<T> pilaOriginal){
        Pila<T> duplicada =new Pila<>();
        Pila<T> colaAux =new Pila<>();
        
        while (!pilaOriginal.estaVacia()) {            
            colaAux.apilar( pilaOriginal.desapilar());
        }
        
        while (!colaAux.estaVacia()) {            
            T temporal=colaAux.desapilar();
            T temporal2=(T)temporal.copia();
            pilaOriginal.apilar(temporal);
            duplicada.apilar(temporal2);
        }
        
        return duplicada;
    
    }
}
