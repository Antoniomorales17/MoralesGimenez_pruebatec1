package com.mycompany.empresa.logica;

import com.mycompany.empresa.persistencia.ControladoraPersistencia;
import com.mycompany.empresa.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearEmpleado(Empleado emplead) {
        controlPersis.crearEmpleado(emplead);
    }

    public List<Empleado> traerEmpleados() {
        return controlPersis.traerEmpleados();
    }

    public void eliminarEmpleado(int idEliminar) throws MiExcepcionPersonalizada {
        Empleado empleado = buscarEmpleado(idEliminar);
        if (empleado == null) {
            throw new MiExcepcionPersonalizada("El empleado con el ID " + idEliminar + " no existe.");
        }
        try {
            controlPersis.eliminarEmpleado(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Empleado no encontrado para eliminación", ex);
            throw new MiExcepcionPersonalizada("Error al eliminar el empleado con ID " + idEliminar);
        }
    }

    public Empleado buscarEmpleado(int idEditar) {
        return controlPersis.buscarEmpleado(idEditar);

    }

    public void editarEmpleado(Empleado empleEdit) {
        controlPersis.editarEmpleado(empleEdit);
    }

    public List<Empleado> buscarEmpleadosPorCargo(String cargo) {
        return controlPersis.buscarEmpleadosPorCargo(cargo);
    }

}
