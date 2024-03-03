# Documentación JobCompany 👨‍💻👨‍💻
## Prueba Técnica del Módulo Java Básico para Bootcamp Hack A Boss

![gif](https://i.imgur.com/vH8eTBZ.png)

 Aplicación Java diseñada para administrar la información de los empleados de una organización mediante el uso de Java Persistence API (JPA). A continuación, se explica el funcionamiento de las principales funcionalidades.

 ### Características
 
🔵 Acceso a base de datos SQL mediante JPA.

🔵 Operaciones CRUD para la gestión de empleados.

🔵 Validación de datos, manejo de errores y excepciones.

🔵 Interfaz intuitiva mediante comandos en la terminal.

![menu](https://i.imgur.com/0Xtj9iM.png)

## Requisitos
🔵 Java Development Kit (JDK) 17

🔵 Apache Maven

🔵 Base de datos SQL (archivo incluído):

DB: "empleados"

Usuario: "root"

Contraseña: ""

## Funcionalidades Principales

### 1. Agregar un Nuevo Empleado

✅ Permite registrar la información de un nuevo empleado, incluyendo nombre, apellido, cargo, salario y fecha de inicio.
 
#### Instrucciones:

✅ Selecciona la opción 1 en el menú principal. Ingresa la información solicitada

### 2. Listar Empleados

✅ Muestra la lista de todos los empleados registrados en el sistema.

#### Instrucciones:

✅ Selecciona la opción 2 en el menú principal.

### 3. Actualizar Información de un Empleado

✅ Permite modificar los datos de un empleado existente, incluyendo nombre, apellido, cargo, salario y fecha de inicio.

#### Instrucciones:

✅ Selecciona la opción 3 en el menú principal. Ingresa el ID del empleado que deseas modificar. Sigue las instrucciones para seleccionar el campo a modificar y proporcionar el nuevo valor.

### 4. Eliminar un Empleado

✅ Permite eliminar un empleado del sistema.

#### Instrucciones:

✅ Selecciona la opción 4 en el menú principal. Ingresa el ID del empleado que deseas eliminar. Confirma la eliminación.

### 5. Buscar Empleados por Cargo

✅ Filtra y muestra los empleados según el cargo especificado.

#### Instrucciones:

✅ Selecciona la opción 5 en el menú principal. Muestra un listado de los cargos para filtrar.

## Validación de datos

#### Agregar un Nuevo Empleado

🔵 Validación de campos requeridos: Se asegura de que se proporcionen todos los campos obligatorios (nombre, apellido, cargo, salario, fecha de inicio) antes de registrar al empleado.

🔵 Validación de datos válidos: Cada campo se valida para garantizar que los datos ingresados sean válidos y cumplan con los criterios establecidos.

#### Listar Empleados

🔵 Sin Validaciones Específicas: Dado que esta función implica solo la recuperación y presentación de datos, no se aplican validaciones específicas en este contexto.

#### Actualizar Información de un Empleado

🔵 Validación de ID existente: Antes de permitir la modificación, se verifica que el ID proporcionado corresponda a un empleado existente en la base de datos.

🔵 Validación de Campos Modificables: Se asegura de que solo se puedan modificar los campos específicos (nombre, apellido, cargo, salario, fecha de inicio) y que los datos modificados sean válidos.

#### Eliminar un Empleado

🔵 Validación de ID existente: Antes de proceder con la eliminación, se verifica que el ID proporcionado corresponda a un empleado existente en la base de datos.Además, se verifica la confirmacion de eliminar al empleado.

#### Buscar Empleados por Cargo

🔵 Validación de cargo válido: Se verifica que el cargo ingresado para la búsqueda sea válido y exista en la base de datos.Se muestran los datos previamente para facilitar la seleccion del usuario.

#### Menú Principal

🔵 Validación de Opciones del Menú: El sistema garantiza que solo se puedan seleccionar opciones válidas del menú principal (opciones del 1 al 5).

🔵 Manejo de Opciones No Válidas: Además, se implementa un mecanismo para manejar opciones no válidas, proporcionando mensajes de error claros para que el usuario pueda identificar el error.
