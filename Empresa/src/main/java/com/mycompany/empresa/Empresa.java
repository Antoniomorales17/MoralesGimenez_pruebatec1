package com.mycompany.empresa;

import com.mycompany.empresa.logica.Controladora;
import com.mycompany.empresa.logica.Empleado;
import com.mycompany.empresa.logica.MiExcepcionPersonalizada;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Set;

public class Empresa {

    public static void main(String[] args) throws MiExcepcionPersonalizada {

        Controladora control = new Controladora();
        Empleado empleado = new Empleado();

        boolean bandera = false;
        int opcion;
        String respuesta = "";
        double opcDbl;
        Date fechaInit = null;

        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        //Menu de inicio
        System.out.println(
                "                          ------------------- Bienvenido a JobCompany -------------------\n"
                + "                              _______________                        |*\\_/*|________\n"
                + "                             |  ___________  |     .-.     .-.      ||_/-\\_|______  |\n"
                + "                             | |           | |    .****. .****.     | |           | |\n"
                + "                             | |   0   0   | |    .*****.*****.     | |   0   0   | |\n"
                + "                             | |     -     | |     .*********.      | |     -     | |\n"
                + "                             | |   \\___/   | |      .*******.       | |   \\___/   | |\n"
                + "                             | |___     ___| |       .*****.        | |___________| |\n"
                + "                             |_____|\\_/|_____|        .***.         |_______________|\n"
                + "                               _|__|/ \\|_|_.............*.............._|________|_\n"
                + "                              / ********** \\                          / ********** \\\n"
                + "                            /  ************  \\                      /  ************  \\\n"
                + "                           --------------------                    --------------------\n"
                + "\n"
                + "                Estamos aquí para facilitarte todas las herramientas que necesitas\n"
                + "                para una administración efectiva y eficiente de su compañía, la solucion para cualquier Dev\n"
        );

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
            try {
                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir:");
                opcion = teclado.nextInt();
                //Si la opción ingresada es salir cambia el estado de la bandera
                switch (opcion) {
                    case 0:
                        bandera = true;
                        break;

                    case 1:
                        do {
                            System.out.println("Por favor, ingrese un texto válido, el campo es requerido.");
                            System.out.println("Ingrese el nombre: ");
                            respuesta = teclado.next();
                            while (!respuesta.matches("^[a-zA-Z]+$")) {
                                System.out.println("Por favor, ingrese un nombre válido (solo letras): ");
                                respuesta = teclado.next();
                            }
                            empleado.setNombre(respuesta);

                            System.out.println("Ingrese el apellido: ");
                            respuesta = teclado.next();
                            while (!respuesta.matches("^[a-zA-Z]+$")) {
                                System.out.println("Por favor, ingrese un apellido válido (solo letras): ");
                                respuesta = teclado.next();
                            }
                            empleado.setApellido(respuesta);

                            System.out.println("Ingrese el cargo: ");
                            respuesta = teclado.next();
                            empleado.setCargo(respuesta);

                        } while (respuesta.isBlank());

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
                                System.out.println("Formato de fecha no válido. Por favor, inténtelo de nuevo.");
                            }
                        }
                        control.crearEmpleado(empleado);
                        System.out.println("El empleado se ha agregado con éxito: " + empleado.toString());
                        break;

                    //Mostrar Lista
                    case 2:
                        System.out.println("------------- Empleados Registrados-------------");
                        List<Empleado> listaEmpleados = control.traerEmpleados();
                        for (Empleado emp : listaEmpleados) {
                            System.out.println(emp.toString());
                        }
                        break;

                    case 3:
                        // Mostrar la lista de empleados para que el usuario seleccione uno a editar
                        List<Empleado> empleadosEditar = control.traerEmpleados();
                        System.out.println("Lista de empleados:");
                        for (Empleado emp : empleadosEditar) {
                            System.out.println(emp.toString());
                        }
                        System.out.println("Ingrese el ID del empleado que desea editar:");
                        int idEmpleadoEditar = teclado.nextInt();

                        // Buscar el empleado que corresponde al ID proporcionado
                        Empleado empleadoEditar = control.buscarEmpleado(idEmpleadoEditar);

                        if (empleadoEditar != null) {
                            boolean seguirModificando = true;
                            while (seguirModificando) {
                                // Mostrar las opciones de campos que el usuario puede actualizar
                                System.out.println("Seleccione el campo que desea actualizar:");
                                System.out.println("1. Nombre");
                                System.out.println("2. Apellido");
                                System.out.println("3. Cargo");
                                System.out.println("4. Salario");
                                System.out.println("5. Fecha de inicio");

                                int opcionActualizar = teclado.nextInt();
                                switch (opcionActualizar) {
                                    case 1:
                                        System.out.println("Ingrese el nuevo nombre:");
                                        respuesta = teclado.next();
                                        while (!respuesta.matches("^[a-zA-Z]+$")) {
                                            System.out.println("Por favor, ingrese un nombre válido (solo letras): ");
                                            respuesta = teclado.next();
                                        }
                                        empleadoEditar.setNombre(respuesta);
                                        break;
                                    case 2:
                                        System.out.println("Ingrese el nuevo apellido:");
                                        respuesta = teclado.next();
                                        while (!respuesta.matches("^[a-zA-Z]+$")) {
                                            System.out.println("Por favor, ingrese un apellido válido (solo letras): ");
                                            respuesta = teclado.next();
                                        }
                                        empleadoEditar.setApellido(respuesta);
                                        break;
                                    case 3:
                                        System.out.println("Ingrese el nuevo cargo:");
                                        respuesta = teclado.next();
                                        empleadoEditar.setCargo(respuesta);
                                        break;
                                    case 4:
                                        System.out.println("Ingrese el nuevo salario:");
                                        do {
                                            respuesta = teclado.next();
                                            try {
                                                opcDbl = Double.parseDouble(respuesta);
                                                empleadoEditar.setSalario(opcDbl);
                                            } catch (NumberFormatException ex) {
                                                System.out.println("Por favor, ingrese un número decimal válido:");
                                            }
                                        } while (!respuesta.matches("^[0-9]+(\\.[0-9]+)$"));
                                        break;
                                    case 5:
                                        System.out.println("Ingrese la nueva fecha de inicio (formato yyyy-MM-dd):");
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        while (fechaInit == null) {
                                            respuesta = teclado.next();
                                            try {
                                                fechaInit = sdf.parse(respuesta);
                                                empleadoEditar.setFechaInicio(fechaInit);
                                            } catch (ParseException e) {
                                                System.out.println("Formato de fecha incorrecto. Por favor, inténtelo de nuevo.");
                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Opción inválida.");
                                        break;
                                }
                                System.out.println("¿Desea seguir modificando al mismo empleado? (S/N)");
                                String continuar = "";
                                do {
                                    continuar = teclado.next().toUpperCase();
                                    if (!continuar.equals("S") && !continuar.equals("N")) {
                                        System.out.println("Por favor, ingrese S para sí o N para no:");
                                    }
                                } while (!continuar.equals("S") && !continuar.equals("N"));

                                if (continuar.equals("N")) {
                                    seguirModificando = false;
                                }

                            }
                            // Actualizar el empleado en la base de datos
                            control.editarEmpleado(empleadoEditar);
                            System.out.println("Empleado actualizado con éxito.");
                        } else {
                            System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                        }
                        break;

                    //Eliminar empleado
                    case 4:
                        List<Empleado> empleados = control.traerEmpleados();
                        System.out.println("Lista de empleados:");
                        for (Empleado emp : empleados) {
                            System.out.println(emp.toString());
                        }
                        System.out.println("Ingrese el ID del empleado que desea eliminar:");
                        int idEmpleadoEliminar = teclado.nextInt();

                        // Verificar si el ID del empleado existe
                        boolean empleadoEncontrado = false;
                        for (Empleado emp : empleados) {
                            if (emp.getId() == idEmpleadoEliminar) {
                                empleadoEncontrado = true;
                                break;
                            }
                        }

                        if (empleadoEncontrado) {
                            boolean confirmacion = false;
                            while (!confirmacion) {
                                System.out.println("¿Está seguro de que desea eliminar a este empleado? (S/N)");
                                respuesta = teclado.next().toUpperCase();
                                if (respuesta.equals("S")) {
                                    try {
                                        control.eliminarEmpleado(idEmpleadoEliminar);
                                        System.out.println("Empleado eliminado con éxito.");
                                        confirmacion = true;
                                        //Lanzamos excepcion si no hay usuario con ese ID
                                    } catch (MiExcepcionPersonalizada ex) {
                                        System.out.println(ex.getMessage());
                                        confirmacion = true;
                                    }
                                } else if (respuesta.equals("N")) {
                                    System.out.println("Operación de eliminación cancelada.");
                                    confirmacion = true;
                                } else {
                                    System.out.println("Por favor, ingrese una respuesta válida (S/N):");
                                }
                            }
                        } else {
                            System.out.println("El empleado con ID " + idEmpleadoEliminar + " no existe.");
                        }
                        break;

                    case 5:
                        System.out.println("Cargos disponibles:");

                        // Utilizamos un conjunto para evitar duplicados
                        Set<String> cargos = new HashSet<>();
                        List<Empleado> todosEmpleados = control.traerEmpleados();
                        for (Empleado emp : todosEmpleados) {
                            // Convertir el cargo a minúsculas antes de agregarlo al conjunto
                            cargos.add(emp.getCargo().toLowerCase());
                        }

                        for (String cargo : cargos) {
                            System.out.println(cargo);
                        }

                        boolean validInput = false;
                        while (!validInput) {
                            try {
                                System.out.println("Ingrese el cargo que desea buscar:");
                                String cargoBuscar = teclado.next().toLowerCase();

                                List<Empleado> empleadosPorCargo = control.buscarEmpleadosPorCargo(cargoBuscar);

                                if (!empleadosPorCargo.isEmpty()) {
                                    System.out.println("Empleados con el cargo '" + cargoBuscar + "':");
                                    for (Empleado emp : empleadosPorCargo) {
                                        System.out.println(emp.toString());
                                    }
                                } else {
                                    System.out.println("No se encontraron empleados con el cargo '" + cargoBuscar + "'.");
                                }
                                validInput = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Por favor, ingrese un valor válido.");
                            }
                        }
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 0 al 5.");
                teclado.next();
            }
        }

        System.out.println("Gracias por utilizar JobCompany. ¡Hasta luego Devs!"
                + "         __\n"
                + " _(\\    |@@|\n"
                + "(__/\\__ \\--/ __\n"
                + "   \\___|----|  |   __\n"
                + "       \\ }{ /\\ )_ / _\\\n"
                + "       /\\__/\\ \\__O (__\n"
                + "      (--/\\--)    \\__/\n"
                + "      _)(  )(_\n"
                + "     `---''---");

    }
}
