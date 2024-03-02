package com.mycompany.empresa.logica;

import com.mycompany.empresa.persistencia.ControladoraPersistencia;

import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearEmpleado(Empleado emplead) {
        controlPersis.crearEmpleado(emplead);
    }

    public List<Empleado> traerEmpleados() {
        return controlPersis.traerEmpleados();
    }

    public void eliminarEmpleado(int idEliminar) {
        controlPersis.eliminarEmpleado(idEliminar);

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
