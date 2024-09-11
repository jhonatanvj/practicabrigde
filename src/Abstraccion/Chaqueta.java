/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstraccion;

/**
 *
 * @author jorge malaver
 */
import Implementador.color.Seleccion_color;
import Implementador.talla.Seleccion_talla;

public class Chaqueta extends Abstract_prenda{
    
    public Chaqueta(Seleccion_color tono, Seleccion_talla talla){
     super(tono, talla);   
    }
    
    @Override
    public String prenda(){
        return tono.Seleccionar_color() +" y talla "+ talla.seleccionar_talla();
    }
}
