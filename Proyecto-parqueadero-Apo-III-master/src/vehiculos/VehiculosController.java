/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

import DAOvehiculos.DAOvehiculos;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PERSONAL
 */
public class VehiculosController implements DAOvehiculos {
    
    private static VehiculosController instancia;
    private String vehiculos[][];
    private int pVehiculo;
    
    public static VehiculosController getInstance(){
        if(instancia == null)
            instancia = new VehiculosController();
        return instancia;
    }
   
    private VehiculosController (){
        this.vehiculos=new String[3][15];
        this.pVehiculo=0;
    }
    
    @Override 
    public boolean GuardarVehiculo (String pvehiculo,String npropietario, String tvehiculo){
        
        vehiculos[0][pVehiculo]=pvehiculo;
        vehiculos[1][pVehiculo]=npropietario;
        vehiculos[2][pVehiculo]=tvehiculo;
        pVehiculo ++;

        return true;
    }
    
    @Override 
    public boolean GuardarVehiculo (String [] vehiculo){
        vehiculos[0][pVehiculo]= vehiculo[0];
        vehiculos[1][pVehiculo]= vehiculo[1];
        vehiculos[2][pVehiculo]= vehiculo[2];
        pVehiculo++;
        
        return true;
    }
    
   @Override
   public DefaultTableModel MostrarVehiculos(){
       DefaultTableModel modelo = new DefaultTableModel();
       
       // creamos los encabezados de la tabla
       modelo.addColumn("Placa");
       modelo.addColumn("N propietario");
       modelo.addColumn("Tipo");
       
       // agregamos filas al modelo 
       
       for(int i=0;i<15;i++){
           String[] vehiculo = new String [3];
           for (int j=0;j<3;j++){
               if (vehiculos[j][i] != null)
                   vehiculo[j]=vehiculos[j][i];
           }
           modelo.addRow(vehiculo);
       }
       return modelo;
       
   }
    @Override 
    public boolean ActualizarVehiculo (String[] vehiculo) {
        int fila=0;
        for(int i=0;i<pVehiculo;i++){
            if(vehiculos[0][i]==vehiculo[0]){
                fila=i;
                break;
            }
        }

        vehiculos[0][fila]=vehiculo[0];
        vehiculos[1][fila]=vehiculo[1];
        vehiculos[2][fila]=vehiculo[2];

        return true;
    }
    
    @Override
    public void EliminarVehiculo (int seleccion){
           if( pVehiculo>=1)
       {
            
            for (int i=seleccion;i<15;i++)
            {
                for(int j=0;j<3;j++)
                {
                
                    if(vehiculos[j][i] !=null)
                    {
                      vehiculos[j][i]=vehiculos[j][seleccion+1];      
                    }
                }
                seleccion++;
            }
            pVehiculo--;
        }
       
       else
       {
            JOptionPane.showMessageDialog(null, "No hay vehiculos para retirar");   
       }
    }
      
    @Override
    public boolean GuardarArchivo() {
        FileWriter fw;
        String datos="";
        boolean gDatos=false;
        
        for(int i=0;i<pVehiculo;i++){
            
            for(int j=0;j<3;j++){
                //System.out.println("codigo "+pokemones[i][j]+": nombre: "+pokemones[i][j]);
                if(vehiculos[j][i] != null)
                    datos+=vehiculos[j][i]+"-";
            }
            datos+="\n";
        }
        
        try{
            JFileChooser guardar = new JFileChooser();
            guardar.showSaveDialog(null);
            guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            //String archivo = ""+guardar.getSelectedFile();
            String ruta = ""+guardar.getCurrentDirectory();
            String nombre = guardar.getSelectedFile().getName();
            fw=new FileWriter(ruta+"\\"+nombre+".txt");
            fw.write(datos);

            
            fw.close();
            gDatos=true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(VehiculosController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return gDatos;
        
    }
}
   
