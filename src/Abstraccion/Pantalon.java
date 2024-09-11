/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstraccion;

import Implementador.color.Seleccion_color;
import Implementador.talla.Seleccion_talla;

/**
 *
 * @author jorge malaver
 */
public class Pantalon extends Abstract_prenda {
 
    
    public Pantalon(Seleccion_color tono, Seleccion_talla talla){
     super(tono, talla);   
    }
    
    @Override
    public String prenda(){
       return tono.Seleccionar_color() +" y talla "+ talla.seleccionar_talla();
    }
}
