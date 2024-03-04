-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-03-2024 a las 11:31:21
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `FECHAINICIO` date DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `APELLIDO`, `CARGO`, `FECHAINICIO`, `NOMBRE`, `SALARIO`) VALUES
(7, 'Messi', 'Staff', '1992-07-08', 'Leo', 30),
(8, 'Ronaldo', 'Jefe', '1992-05-10', 'Cristiano', 100),
(10, 'pique', 'cantante', '2024-12-12', 'Shakira', 200000),
(11, 'Rivas', 'Torero', '2024-12-12', 'Amador', 10000),
(12, 'Musk', 'CEO', '2019-08-12', 'Elon', 1000000000000),
(14, 'Gates', 'CEO', '2000-05-10', 'Bill', 10000),
(16, 'Cesar', 'Emperador', '1992-10-10', 'Julio', 20),
(17, 'Marcos', 'Staff', '2002-06-30', 'Luis', 3000),
(18, 'Roberts', 'Actriz', '1995-12-12', 'Julia', 50000),
(19, 'Pitt', 'Actor', '1981-03-12', 'Brad', 5000),
(21, 'Cristo', 'Dios', '0002-11-30', 'Jesus', 0),
(22, 'Del', 'monte', '2325-11-23', 'Maria', 3000),
(27, 'Garcia', 'Ejecutiva', '2001-09-21', 'Carmen', 300),
(28, 'Aparicio', 'Monja', '1000-12-12', 'Saul', 0),
(31, 'Cepeda', 'Senior', '1993-12-12', 'Manuel', 12.33);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
