/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOvehiculos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PERSONAL
 */
public interface DAOvehiculos {
    
    public boolean GuardarVehiculo (String pvehiculo, String npropietario, String tvehiculo );
    // pvehiculo = placa del vehiculo 
    public boolean GuardarVehiculo (String[]vehiculo);
    public DefaultTableModel MostrarVehiculos ();
    public boolean ActualizarVehiculo (String[]vehiculo);
    public void EliminarVehiculo (int codigo);
    public boolean GuardarArchivo ();
}
