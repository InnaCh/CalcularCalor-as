/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch_calculocalorías.model;

/**
 *
 * @author a0y3770325h
 */

    public enum TipoActividad {
           SEDENTARIA (1.2),
           MODERADA (1.375),
           LIGERA (1.55),
           INTENSA (1.725),
           MUY_INTENSA (1.9);
    
    
           double valor;
           
      private TipoActividad (double valor){
          this.valor = valor;
      }
      
          
      public double getValor(){
          return valor;
      }
      
           @Override
      public String toString(){
          String tipo="";
          switch (this){
              case SEDENTARIA:
                  tipo="Sedentaria";break;
              case MODERADA:
                  tipo="Moderada";break;
              case LIGERA:
                  tipo="Ligera";break;
              case INTENSA:
                  tipo="Intensa";break;
              case MUY_INTENSA:
                  tipo="Muy intensa";break;
          }
          return tipo;
      }
}
    

