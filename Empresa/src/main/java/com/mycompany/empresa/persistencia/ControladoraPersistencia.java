
package com.mycompany.empresa.persistencia;

import com.mycompany.empresa.logica.Empleado;
import com.mycompany.empresa.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ControladoraPersistencia {
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public void crearEmpleado(Empleado emplead) {
       empleadoJpa.create(emplead);
    }

    public List<Empleado> traerEmpleados() {
       return empleadoJpa.findEmpleadoEntities();
    }

 

    public void eliminarEmpleado(int idEliminar) {
        try {
            empleadoJpa.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(int idEditar) {
        return empleadoJpa.findEmpleado(idEditar);
    }

    public void editarEmpleado(Empleado empleEdit) {
        try {
            empleadoJpa.edit(empleEdit);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        
    }


    
    
}
