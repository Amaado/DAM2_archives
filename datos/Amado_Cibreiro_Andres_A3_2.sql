-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.11.6-MariaDB-0+deb12u1 - Debian 12
-- SO del servidor:              debian-linux-gnu
-- HeidiSQL Versión:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para gestion_plazas
CREATE DATABASE IF NOT EXISTS `gestion_plazas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `gestion_plazas`;

-- Volcando estructura para tabla gestion_plazas.garajes
CREATE TABLE IF NOT EXISTS `garajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_parking` int(11) NOT NULL,
  `tamano` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `disponibleAlquiler` tinyint(1) DEFAULT NULL,
  `horarioUso` varchar(50) DEFAULT NULL,
  `modoAcceso` varchar(100) DEFAULT NULL,
  `fotoGaraje` text DEFAULT NULL,
  `id_metodoPago` int(11) DEFAULT NULL,
  `fechaPublicacion` date DEFAULT NULL,
  `minimo_duracion` int(11) DEFAULT NULL,
  `maximo_duracion` int(11) DEFAULT NULL,
  `condicionesEspeciales` text DEFAULT NULL,
  `tipoPlaza` varchar(50) DEFAULT NULL,
  `alturaMaxima` decimal(5,2) DEFAULT NULL,
  `anchuraMaxima` decimal(5,2) DEFAULT NULL,
  `numeroPlaza` int(11) DEFAULT NULL,
  `id_propietario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_parking` (`id_parking`),
  KEY `id_metodoPago` (`id_metodoPago`),
  CONSTRAINT `garajes_ibfk_1` FOREIGN KEY (`id_parking`) REFERENCES `parkings` (`id`),
  CONSTRAINT `garajes_ibfk_2` FOREIGN KEY (`id_metodoPago`) REFERENCES `metodosPago` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.garajes: ~5 rows (aproximadamente)
INSERT INTO `garajes` (`id`, `id_parking`, `tamano`, `precio`, `disponibleAlquiler`, `horarioUso`, `modoAcceso`, `fotoGaraje`, `id_metodoPago`, `fechaPublicacion`, `minimo_duracion`, `maximo_duracion`, `condicionesEspeciales`, `tipoPlaza`, `alturaMaxima`, `anchuraMaxima`, `numeroPlaza`, `id_propietario`) VALUES
	(1, 1, '12 m²', 50.00, 1, '24/7', 'Control remoto', 'https://example.com/garaje1.jpg', 1, '2024-01-01', 1, 12, 'No se permiten camiones', 'Cubierta', 2.10, 2.50, 12, 2),
	(2, 1, '15 m²', 60.00, 1, 'Lunes a Viernes', 'Llave magnética', 'https://example.com/garaje2.jpg', 2, '2024-01-15', 1, 6, 'Acceso limitado', 'Descubierta', 2.00, 2.30, 14, 3),
	(3, 2, '10 m²', 40.00, 0, '24/7', 'Código QR', 'https://example.com/garaje3.jpg', 3, '2023-12-10', 2, 12, NULL, 'Cubierta', 1.90, 2.40, 20, 4),
	(4, 3, '18 m²', 75.00, 1, 'Solo fines de semana', 'Control remoto', 'https://example.com/garaje4.jpg', 1, '2024-02-01', 1, 8, 'Prohibido para motos', 'Cubierta', 2.30, 2.80, 22, 2),
	(5, 4, '20 m²', 80.00, 1, 'Lunes a Viernes', 'Llave física', 'https://example.com/garaje5.jpg', 2, '2024-03-01', 3, 24, NULL, 'Descubierta', 2.40, 2.90, 25, 3);

-- Volcando estructura para tabla gestion_plazas.historialAlquileres
CREATE TABLE IF NOT EXISTS `historialAlquileres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_garaje` int(11) NOT NULL,
  `id_metodoPago` int(11) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_garaje` (`id_garaje`),
  KEY `id_metodoPago` (`id_metodoPago`),
  CONSTRAINT `historialAlquileres_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `historialAlquileres_ibfk_2` FOREIGN KEY (`id_garaje`) REFERENCES `garajes` (`id`),
  CONSTRAINT `historialAlquileres_ibfk_3` FOREIGN KEY (`id_metodoPago`) REFERENCES `metodosPago` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.historialAlquileres: ~5 rows (aproximadamente)
INSERT INTO `historialAlquileres` (`id`, `id_usuario`, `id_garaje`, `id_metodoPago`, `fechaInicio`, `fechaFin`) VALUES
	(1, 2, 1, 1, '2024-01-01', '2024-02-01'),
	(2, 3, 2, 2, '2024-01-15', '2024-03-15'),
	(3, 4, 3, 3, '2024-02-01', '2024-04-01'),
	(4, 5, 4, 4, '2024-03-01', '2024-03-15'),
	(5, 6, 5, 5, '2024-03-10', '2024-04-10');

-- Volcando estructura para tabla gestion_plazas.metodosPago
CREATE TABLE IF NOT EXISTS `metodosPago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.metodosPago: ~5 rows (aproximadamente)
INSERT INTO `metodosPago` (`id`, `nombre`) VALUES
	(1, 'Transferencia bancaria'),
	(2, 'Tarjeta de crédito'),
	(3, 'Bizum a número 666555444'),
	(4, 'PayPal'),
	(5, 'Efectivo');

-- Volcando estructura para tabla gestion_plazas.parkings
CREATE TABLE IF NOT EXISTS `parkings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direccion` text DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `provincia` varchar(100) DEFAULT NULL,
  `latitud` decimal(10,6) DEFAULT NULL,
  `longitud` decimal(10,6) DEFAULT NULL,
  `metodoPagoDefault_id` int(11) DEFAULT NULL,
  `distanciaCentroCiudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `metodoPagoDefault_id` (`metodoPagoDefault_id`),
  CONSTRAINT `parkings_ibfk_1` FOREIGN KEY (`metodoPagoDefault_id`) REFERENCES `metodosPago` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.parkings: ~5 rows (aproximadamente)
INSERT INTO `parkings` (`id`, `nombre`, `direccion`, `ciudad`, `provincia`, `latitud`, `longitud`, `metodoPagoDefault_id`, `distanciaCentroCiudad`) VALUES
	(1, 'Parking Central', 'Calle Mayor, 12', 'Madrid', 'Madrid', 40.416775, -3.703790, 1, '2 km'),
	(2, 'Parking Norte', 'Avenida Norte, 15', 'Barcelona', 'Cataluña', 41.387917, 2.169918, 2, '3 km'),
	(3, 'Parking Sur', 'Plaza del Sol', 'Valencia', 'Comunidad Valenciana', 39.469907, -0.376288, 3, '1 km'),
	(4, 'Parking Este', 'Calle Luna, 45', 'Sevilla', 'Andalucía', 37.388630, -5.982327, 1, '4 km'),
	(5, 'Parking Oeste', 'Carretera Oeste, 123', 'Bilbao', 'País Vasco', 43.263012, -2.934985, 2, '5 km');

-- Volcando estructura para tabla gestion_plazas.userCategorias
CREATE TABLE IF NOT EXISTS `userCategorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(50) NOT NULL,
  `descripcion` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.userCategorias: ~5 rows (aproximadamente)
INSERT INTO `userCategorias` (`id`, `nombre_categoria`, `descripcion`) VALUES
	(100, 'Propietario', 'Usuario que posee y alquila plazas de garaje.'),
	(200, 'Arrendatario', 'Usuario que alquila plazas de garaje.'),
	(300, 'Corporativo', 'Empresa que gestiona múltiples plazas.'),
	(400, 'Temporal', 'Usuarios que alquilan por periodos cortos.'),
	(500, 'Estudiante', 'Usuarios con descuentos para estudiantes.');

-- Volcando estructura para tabla gestion_plazas.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `contacto` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `userCategorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.usuarios: ~5 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `nombre`, `contacto`, `telefono`, `id_categoria`, `fechaRegistro`) VALUES
	(2, 'Juan Pérez', 'juanperez@example.com', '600123456', 100, '2023-05-10'),
	(3, 'Manuel Sanz', 'sanz@example.com', '633456432', 100, '2023-05-11'),
	(4, 'Ramón Duarte', 'ramonduarte@example.com', '600654321', 200, '2022-08-22'),
	(5, 'Lucía Gómez', 'lucia.gomez@example.com', '611333222', 300, '2024-01-15'),
	(6, 'Pedro Torres', 'pedro.torres@example.com', '622444333', 400, '2024-02-01');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
