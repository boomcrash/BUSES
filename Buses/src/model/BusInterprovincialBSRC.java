/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class BusInterprovincialBSRC extends BusBSRC{
    ArrayList<AsientoBSRC> asientos=new ArrayList<>();
    int asiento;

    public BusInterprovincialBSRC(String placa, RutaBSRC ruta,int asiento) {
        super(placa, ruta);
        this.asiento=asiento;
        llenarAsientos();
    }

    public ArrayList<AsientoBSRC> getAsientos() {
        return asientos;
    }
    
    private void llenarAsientos(){
        String estado="ventana";
        for(int i=1;i<=asiento;i++){
            
            if(i%2!=0 && estado=="ventana"){
              asientos.add(new AsientoBSRC(i, true, "ventana")); 
               System.out.println("asiento: "+i+" lado: "+"ventana");
              estado="pasillo";
            }else if(i%2==0 && estado=="pasillo"){
              asientos.add(new AsientoBSRC(i, true, "pasillo"));
               System.out.println("asiento: "+i+" lado: "+"pasillo");
              estado="pasillo";
            }else if(i%2!=0 && estado=="pasillo"){
              asientos.add(new AsientoBSRC(i, true, "pasillo"));
               System.out.println("asiento: "+i+" lado: "+"pasillo");
              estado="ventana";
            }else if(i%2==0 && estado=="ventana"){
              asientos.add(new AsientoBSRC(i, true, "ventana"));
               System.out.println("asiento: "+i+" lado: "+"ventana");
              estado="ventana";
            }
       
        }
    }
    
    public void setAsientos(ArrayList<AsientoBSRC> asientos) {
        this.asientos = asientos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public RutaBSRC getRuta() {
        return ruta;
    }

    public void setRuta(RutaBSRC ruta) {
        this.ruta = ruta;
    }
    
}
