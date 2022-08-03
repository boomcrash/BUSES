/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.TextField;
import java.time.LocalTime;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.BusInterprovincialBSRC;
import model.BusProvinciaBSRC;
import model.RutaBSRC;
import visual.CrudBSRC;
import static visual.CrudBSRC.listaInterprovinciales;
import static visual.CrudBSRC.listaProvinciales;


public class AdmBusesBSRC {
    
    public void agregarBus(String tipoBus,String placa, RutaBSRC ruta,int asiento){
        if(tipoBus.equalsIgnoreCase("interprovincial")){
            if(validarRegistro(placa)){
                listaInterprovinciales.put(listaInterprovinciales.size()+1, new BusInterprovincialBSRC(placa, ruta,asiento));
             JOptionPane.showMessageDialog(null, "SE HA REGISTRADO EL BUS");
            }else{
                 JOptionPane.showMessageDialog(null, "NO PUEDEN HABER DOS BUSES CON LA MISMA PLACA");
            }
        }else if(tipoBus.equalsIgnoreCase("provincial")){
            if(validarRegistro(placa)){
                listaProvinciales.put(listaProvinciales.size()+1, new BusProvinciaBSRC(placa, ruta,asiento));
                JOptionPane.showMessageDialog(null, "SE HA REGISTRADO EL BUS");
                System.out.println(listaProvinciales.size());
            }else{
                 JOptionPane.showMessageDialog(null, "NO PUEDEN HABER DOS BUSES CON LA MISMA PLACA");
            }
            
        }
    }   
    
    public void llenarTabla(JTable tabla){
        
        DefaultTableModel modelo = new DefaultTableModel(null, new String[]{
                "PLACA", "TIPO", "ASIENTOS", "ORIGEN","DESTINO", "SALIDA","LLEGADA","PRECIO"});
        for(Map.Entry<Integer, BusInterprovincialBSRC> objeto : listaInterprovinciales.entrySet()){
                        BusInterprovincialBSRC valor = objeto.getValue();
                        modelo.addRow(new Object[]{
                            valor.getPlaca(),
                            "INTERPROVINCIAL",
                            valor.getAsientos().size(),
                            valor.getRuta().getOrigen(),
                            valor.getRuta().getDestino(),
                            valor.getRuta().getHoraSalida(),
                            valor.getRuta().getHoraLlegada(),
                            valor.getRuta().getPrecio()
                        });
                                System.out.println(valor.getPlaca());
        }
        for(Map.Entry<Integer, BusProvinciaBSRC> objeto : listaProvinciales.entrySet()){
                        BusProvinciaBSRC valor = objeto.getValue();
                        modelo.addRow(new Object[]{
                            valor.getPlaca(),
                            "PROVINCIAL",
                            valor.getAsientos().size(),
                            valor.getRuta().getOrigen(),
                            valor.getRuta().getDestino(),
                            valor.getRuta().getHoraSalida(),
                            valor.getRuta().getHoraLlegada(),
                            valor.getRuta().getPrecio()
                        });     

        }
        tabla.setModel(modelo);

    } 
 
    public void filtrarTabla(JTable tabla,String tipo,String texto){
        if(tipo.equalsIgnoreCase("origen")){
                    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{
                "PLACA", "TIPO", "ASIENTOS", "ORIGEN","DESTINO", "SALIDA","LLEGADA","PRECIO"});
            for(Map.Entry<Integer, BusInterprovincialBSRC> objeto : listaInterprovinciales.entrySet()){
                            BusInterprovincialBSRC valor = objeto.getValue();
                            if(valor.getRuta().getOrigen().equalsIgnoreCase(texto)){
                                 modelo.addRow(new Object[]{
                                valor.getPlaca(),
                                "INTERPROVINCIAL",
                                valor.getAsientos().size(),
                                valor.getRuta().getOrigen(),
                                valor.getRuta().getHoraSalida(),
                                valor.getRuta().getDestino(),
                                valor.getRuta().getHoraLlegada(),
                                valor.getRuta().getPrecio()
                            });
                                    System.out.println(valor.getPlaca());
                            }
            }
            for(Map.Entry<Integer, BusProvinciaBSRC> objeto : listaProvinciales.entrySet()){
                            BusProvinciaBSRC valor = objeto.getValue();
                            if(valor.getRuta().getOrigen().equalsIgnoreCase(texto)){
                                 modelo.addRow(new Object[]{
                                valor.getPlaca(),
                                "PROVINCIAL",
                                valor.getAsientos().size(),
                                valor.getRuta().getOrigen(),
                                valor.getRuta().getHoraSalida(),
                                valor.getRuta().getDestino(),
                                valor.getRuta().getHoraLlegada(),
                                valor.getRuta().getPrecio()
                            });
                                    System.out.println(valor.getPlaca());
                            }

            }
            tabla.setModel(modelo);
        }else if(tipo.equalsIgnoreCase("destino")){
                DefaultTableModel modelo = new DefaultTableModel(null, new String[]{
                "PLACA", "TIPO", "ASIENTOS", "ORIGEN","DESTINO", "SALIDA","LLEGADA","PRECIO"});
                for(Map.Entry<Integer, BusInterprovincialBSRC> objeto : listaInterprovinciales.entrySet()){
                                BusInterprovincialBSRC valor = objeto.getValue();
                                if(valor.getRuta().getDestino().equalsIgnoreCase(texto)){
                                     modelo.addRow(new Object[]{
                                    valor.getPlaca(),
                                    "INTERPROVINCIAL",
                                    valor.getAsientos().size(),
                                    valor.getRuta().getOrigen(),
                                    valor.getRuta().getHoraSalida(),
                                    valor.getRuta().getDestino(),
                                    valor.getRuta().getHoraLlegada(),
                                    valor.getRuta().getPrecio()
                                });
                                        System.out.println(valor.getPlaca());
                                }
                }
                for(Map.Entry<Integer, BusProvinciaBSRC> objeto : listaProvinciales.entrySet()){
                                BusProvinciaBSRC valor = objeto.getValue();
                                if(valor.getRuta().getDestino().equalsIgnoreCase(texto)){
                                     modelo.addRow(new Object[]{
                                    valor.getPlaca(),
                                    "PROVINCIAL",
                                    valor.getAsientos().size(),
                                    valor.getRuta().getOrigen(),
                                    valor.getRuta().getHoraSalida(),
                                    valor.getRuta().getDestino(),
                                    valor.getRuta().getHoraLlegada(),
                                    valor.getRuta().getPrecio()
                                });
                                        System.out.println(valor.getPlaca());
                                }

                }
                tabla.setModel(modelo);
        }
    }
    
    public void llenardatos(String placa,JTextField origen,JTextField placaM,JTextField destino,JTextField precio,JComboBox salida,JComboBox llegada){
            for(Map.Entry<Integer, BusInterprovincialBSRC> objeto : listaInterprovinciales.entrySet()){
                            BusInterprovincialBSRC valor = objeto.getValue();
                            if(valor.getPlaca().equalsIgnoreCase(placa)){
                                placaM.setText(valor.getPlaca());
                                destino.setText(valor.getRuta().getDestino());
                                origen.setText(valor.getRuta().getOrigen());
                                salida.setSelectedItem(String.valueOf(valor.getRuta().getHoraSalida()));
                                llegada.setSelectedItem(String.valueOf(valor.getRuta().getHoraLlegada()));
                                precio.setText(String.valueOf(valor.getRuta().getPrecio()));
                            }
            }
            for(Map.Entry<Integer, BusProvinciaBSRC> objeto : listaProvinciales.entrySet()){
                            BusProvinciaBSRC valor = objeto.getValue();
                            if(valor.getPlaca().equalsIgnoreCase(placa)){
                                placaM.setText(valor.getPlaca());
                                destino.setText(valor.getRuta().getDestino());
                                origen.setText(valor.getRuta().getOrigen());
                                salida.setSelectedItem(String.valueOf(valor.getRuta().getHoraSalida()));
                                llegada.setSelectedItem(String.valueOf(valor.getRuta().getHoraLlegada()));
                                precio.setText(String.valueOf(valor.getRuta().getPrecio()));
                          
                            }

            }
       
    }
     
     
    public void modificardatos(JTextField origen,JTextField placaM,JTextField destino,JTextField precio,JComboBox salida,JComboBox llegada){
          for(Map.Entry<Integer, BusInterprovincialBSRC> objeto : listaInterprovinciales.entrySet()){
                          BusInterprovincialBSRC valor = objeto.getValue();
                          if(valor.getPlaca().equalsIgnoreCase(placaM.getText().toString().trim())){
                             valor.getRuta().setDestino(destino.getText().toString().trim());
                              valor.getRuta().setOrigen(origen.getText().toString().trim());
                              valor.getRuta().setPrecio(Double.parseDouble(precio.getText().toString().trim()));
                              
                              LocalTime salidaBus = LocalTime.parse(salida.getSelectedItem().toString().trim());
                              LocalTime llegadaBus = LocalTime.parse(llegada.getSelectedItem().toString().trim());
                              valor.getRuta().setHoraSalida(salidaBus);
                              valor.getRuta().setHoraLlegada(llegadaBus);
                              JOptionPane.showMessageDialog(null, "SE HA MODIFICADO EL BUS");
                          }
                             
          }
          for(Map.Entry<Integer, BusProvinciaBSRC> objeto : listaProvinciales.entrySet()){
                          BusProvinciaBSRC valor = objeto.getValue();
                          if(valor.getPlaca().equalsIgnoreCase(placaM.getText().toString().trim())){
                             valor.getRuta().setDestino(destino.getText().toString().trim());
                              valor.getRuta().setOrigen(origen.getText().toString().trim());
                              valor.getRuta().setPrecio(Double.parseDouble(precio.getText().toString().trim()));
                              
                              LocalTime salidaBus = LocalTime.parse(salida.getSelectedItem().toString().trim());
                              LocalTime llegadaBus = LocalTime.parse(llegada.getSelectedItem().toString().trim());
                              valor.getRuta().setHoraSalida(salidaBus);
                              valor.getRuta().setHoraLlegada(llegadaBus);
                              JOptionPane.showMessageDialog(null, "SE HA MODIFICADO EL BUS");
                          }
          }

  }
    
    
    public void eliminardatos(String placa){
      for(Map.Entry<Integer, BusInterprovincialBSRC> objeto : listaInterprovinciales.entrySet()){
                      BusInterprovincialBSRC valor = objeto.getValue();
                      if(valor.getPlaca().equalsIgnoreCase(placa)){
                          int identificador = objeto.getKey();  
                          listaInterprovinciales.remove(identificador, valor);
                                  JOptionPane.showMessageDialog(null, "SE HA ELIMINADO EL BUS");
                      }
      }
      for(Map.Entry<Integer, BusProvinciaBSRC> objeto : listaProvinciales.entrySet()){
                      BusProvinciaBSRC valor = objeto.getValue();
                      if(valor.getPlaca().equalsIgnoreCase(placa)){
                         int identificador = objeto.getKey(); 
                         listaProvinciales.remove(identificador, valor);
                         JOptionPane.showMessageDialog(null, "SE HA ELIMINADO EL BUS");
                        }
        }

  }
    
    
  public boolean validarRegistro(String placa){
      boolean permitir=true;
      for(Map.Entry<Integer, BusInterprovincialBSRC> objeto : listaInterprovinciales.entrySet()){
                      BusInterprovincialBSRC valor = objeto.getValue();
                      if(valor.getPlaca().equalsIgnoreCase(placa)){
                         permitir=false;
                      }
      }
      for(Map.Entry<Integer, BusProvinciaBSRC> objeto : listaProvinciales.entrySet()){
                      BusProvinciaBSRC valor = objeto.getValue();
                      if(valor.getPlaca().equalsIgnoreCase(placa)){
                        permitir=false;
                      }
        }
        return permitir;
  }
}
