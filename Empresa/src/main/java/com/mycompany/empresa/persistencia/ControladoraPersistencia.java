package com.mycompany.empresa.persistencia;

import com.mycompany.empresa.logica.Empleado;
import com.mycompany.empresa.logica.MiExcepcionPersonalizada;
import com.mycompany.empresa.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public void crearEmpleado(Empleado empleado) {
        try {
            empleadoJpa.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al crear empleado", ex);
        }
    }

    public List<Empleado> traerEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

    public void eliminarEmpleado(int idEliminar) throws NonexistentEntityException, MiExcepcionPersonalizada {
        Empleado empleado = buscarEmpleado(idEliminar);
        if (empleado == null) {
            throw new MiExcepcionPersonalizada("El empleado con el ID " + idEliminar + " no existe.");
        }
        try {
            empleadoJpa.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Empleado no encontrado para eliminación", ex);
            throw ex;
        }
    }

    public Empleado buscarEmpleado(int idEditar) {
        return empleadoJpa.findEmpleado(idEditar);
    }

    public void editarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al editar empleado", ex);
        }
    }

    public List<Empleado> buscarEmpleadosPorCargo(String cargo) {
        EntityManager entityManager = empleadoJpa.getEntityManager();
        try {
            String jpql = "SELECT e FROM Empleado e WHERE e.cargo = :cargo";
            TypedQuery<Empleado> query = entityManager.createQuery(jpql, Empleado.class);
            query.setParameter("cargo", cargo);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
