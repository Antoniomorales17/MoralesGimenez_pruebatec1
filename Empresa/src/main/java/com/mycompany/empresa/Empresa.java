package com.mycompany.empresa;

import com.mycompany.empresa.logica.Controladora;
import com.mycompany.empresa.logica.Empleado;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Empresa {

    public static void main(String[] args) {
        Date fechaInicio = new Date();

        //variables
        boolean bandera = false;
        int opcion;
        String respuesta = "";
        double opcDbl;
        Date fechaInit = null;

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
        //Comienzo del programa

        while (!bandera) {
            System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir:");
            opcion = teclado.nextInt();
            //Si la opción ingresada es salir cambia el estado de la bandera
            switch (opcion) {
                case 0:
                    bandera = true;
                    break;
                //Mostrar lista de empleados
                case 1:
                    //Evaluo que el dato sea string, ni esté vacío
                    do {
                        System.out.println("Por favor, ingrese un texto válido, el campo es requerido.");
                        System.out.println("Ingrese el nombre: ");
                        respuesta = teclado.next();
                        empleado.setNombre(respuesta);

                        System.out.println("Ingrese el apellido: ");
                        respuesta = teclado.next();
                        empleado.setApellido(respuesta);

                        System.out.println("Ingrese el cargo: ");
                        respuesta = teclado.next();
                        empleado.setCargo(respuesta);

                    } while (respuesta.equals(" ") || !respuesta.matches("^[a-zA-Z]+$"));
                    do {
                        System.out.println("Ingrese el salario: ");
                        respuesta = teclado.next();
                        try {
                            opcDbl = Double.parseDouble(respuesta);
                            empleado.setSalario(opcDbl);

                        } catch (NumberFormatException ex) {
                            System.out.println("Por favor, ingrese un número decimal válido:");
                        }
                    } while (!respuesta.matches("^[0-9]+(\\.[0-9]+)$"));
                    while (fechaInit == null) {

                        System.out.println("Ingrese la fecha de inicio con el siguiente formato ('yyyy-MM-dd') : ");
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            respuesta = teclado.next();
                            fechaInit = sdf.parse(respuesta);
                            empleado.setFechaInicio(fechaInit);
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha no válido.");
                        }

                    }
                    control.crearEmpleado(empleado);
                    System.out.println("El empleado se ha agregado con exito: " + empleado.toString());
                    break;

                //Mostar Lista
                case 2:
                    System.out.println("------------- Empleados Registrados-------------");
                    List<Empleado> listaEmpleados = control.traerEmpleados();
                    for (Empleado emp : listaEmpleados) {
                        System.out.println(emp.toString());
                    }
                    break;

              
                //Eliminar empleado
                case 4:
                    // Mostrar la lista de empleados para que el usuario seleccione uno a eliminar
                    List<Empleado> empleados = control.traerEmpleados();
                    System.out.println("Lista de empleados:");
                    for (Empleado emp : empleados) {
                        System.out.println(emp.toString());
                    }
                    System.out.println("Ingrese el ID del empleado que desea eliminar:");
                    int idEmpleadoEliminar = teclado.nextInt();

                    // Llamar al método eliminarEmpleado de la controladora
                    control.eliminarEmpleado(idEmpleadoEliminar);
                    System.out.println("Empleado eliminado con éxito.");
                    break;

            }
        }

        //Proceso lectura
        //ist<Empleado> listaEmpleados = control.traerEmpleados();
        //r (Empleado emplead : listaEmpleados) {
        //System.out.println(emplead.toString());
        //}
        //Proceso de eliminacion
        //  int idEliminar=1;
        //  control.eliminarEmpleado(idEliminar);
        //Proceso edicion
        //int idEditar = 2;
        //Empleado empleEdit = control.buscarEmpleado(idEditar);
        //empleEdit.setNombre("Juan");
        //control.editarEmpleado(empleEdit);
        //Proceso creacion
        // Empleado empleado2 = new Empleado(2,"Francisco","Morales", "Gerente", 1.800, fechaInicio);
        //  control.crearEmpleado(empleado2);
    }
}
