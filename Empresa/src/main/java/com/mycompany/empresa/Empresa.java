
package com.mycompany.empresa;

import com.mycompany.empresa.logica.Controladora;
import com.mycompany.empresa.logica.Empleado;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Empresa {

    public static void main(String[] args) {
         Date fechaInicio = new Date();
         
         //variables
       
        
         //Creo instancia de la clase Empleado
        Empleado empleado = new Empleado();
        
         //Creo Scanner para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
       
        //Creamos la tabla empleado
        Controladora control = new Controladora();
        
        //Menu de inicio
        System.out.println("""
        ------------------- Bienvenido a JobCompany -------------------
                           
                Estamos aquí para facilitarte todas las herramientas que necesitas
                para una administración efectiva y eficiente de tus recursos humanos                       
              
                            """);
        
         System.out.println("""
        -------------- Menú inicio --------------         
        Ingrese la opción que desea realizar:
                           
        1.Agregar un nuevo empleado 
                           
        2.Listar empleados
                           
        3.Actualizar información de un empleado
                           
        4.Eliminar un empleado
                           
        5.Buscar empleados por cargo
            
        Pulse 0 para salir               
        """);
         
         //Proceso lectura
         List<Empleado> listaEmpleados = control.traerEmpleados();
         for(Empleado emplead : listaEmpleados){
             System.out.println(emplead.toString());
         }
         
         //Proceso de eliminacion
       //  int idEliminar=1;
       //  control.eliminarEmpleado(idEliminar);
         
         
         //Proceso edicion
         int idEditar = 2;
         Empleado empleEdit = control.buscarEmpleado(idEditar);
         empleEdit.setNombre("Juan");
         
         control.editarEmpleado(empleEdit);

         
         //Proceso creacion
      // Empleado empleado2 = new Empleado(2,"Francisco","Morales", "Gerente", 1.800, fechaInicio);
        
    //  control.crearEmpleado(empleado2);
        
       
    }
}
