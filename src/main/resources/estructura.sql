-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: teatro_db
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `artistas`
-- ACTUALIZACION
--

DROP TABLE IF EXISTS `artistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas` (
  `id_artista` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `ruta_imagen` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id_artista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas`
--

LOCK TABLES `artistas` WRITE;
/*!40000 ALTER TABLE `artistas` DISABLE KEYS */;
/*!40000 ALTER TABLE `artistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistas_seguidos`
--

DROP TABLE IF EXISTS `artistas_seguidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas_seguidos` (
  `id_usuario` int NOT NULL,
  `id_artista` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_artista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas_seguidos`
--

LOCK TABLES `artistas_seguidos` WRITE;
/*!40000 ALTER TABLE `artistas_seguidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `artistas_seguidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletines`
--

DROP TABLE IF EXISTS `boletines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boletines` (
  `id_boletin` int NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(1024) NOT NULL,
  `estado` tinyint NOT NULL,
  PRIMARY KEY (`id_boletin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletines`
--

LOCK TABLES `boletines` WRITE;
/*!40000 ALTER TABLE `boletines` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id_compra` int NOT NULL,
  `usuario_id` int NOT NULL,
  `evento_id` int NOT NULL,
  `seccion_id` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `fk_compra_usuario_idx` (`usuario_id`),
  KEY `fk_compra_evento_idx` (`evento_id`),
  KEY `fk_compra_seccion_idx` (`seccion_id`),
  CONSTRAINT `fk_compra_evento` FOREIGN KEY (`evento_id`) REFERENCES `eventos` (`id_evento`),
  CONSTRAINT `fk_compra_seccion` FOREIGN KEY (`seccion_id`) REFERENCES `secciones` (`id_seccion`),
  CONSTRAINT `fk_compra_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `id_evento` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(254) NOT NULL,
  `artista_id` int NOT NULL,
  `dia` varchar(12) NOT NULL,
  `hora` varchar(12) NOT NULL,
  `precio` int NOT NULL,
  `ruta_imagen` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `fk_idArtistas_idx` (`artista_id`),
  CONSTRAINT `fk_idArtistas` FOREIGN KEY (`artista_id`) REFERENCES `artistas` (`id_artista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodos_pago`
--

DROP TABLE IF EXISTS `metodos_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodos_pago` (
  `id_metodo_pago` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `numero_tarjeta` int NOT NULL,
  `fecha_vencimiento` varchar(12) NOT NULL,
  `codigo_verificacion` int NOT NULL,
  `ruta_imagen_marca` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id_metodo_pago`),
  KEY `fk_idUsuario_idx` (`usuario_id`),
  CONSTRAINT `fk_idUsuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodos_pago`
--

LOCK TABLES `metodos_pago` WRITE;
/*!40000 ALTER TABLE `metodos_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `metodos_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaciones` (
  `id_notificacion` int NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(1024) NOT NULL,
  PRIMARY KEY (`id_notificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resenas`
--

DROP TABLE IF EXISTS `resenas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resenas` (
  `id_resena` int NOT NULL AUTO_INCREMENT,
  `calificacion` int NOT NULL,
  `comentario` varchar(1024) NOT NULL,
  `evento_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id_resena`),
  KEY `fk_idEvento_idx` (`evento_id`),
  KEY `fk_idUsuario_idx` (`usuario_id`),
  CONSTRAINT `fk_idEvento` FOREIGN KEY (`evento_id`) REFERENCES `eventos` (`id_evento`),
  CONSTRAINT `fk_idUsuarios` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resenas`
--

LOCK TABLES `resenas` WRITE;
/*!40000 ALTER TABLE `resenas` DISABLE KEYS */;
/*!40000 ALTER TABLE `resenas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Super usuario'),(3,'Cliente');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secciones`
--

DROP TABLE IF EXISTS `secciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secciones` (
  `id_seccion` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id_seccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secciones`
--

LOCK TABLES `secciones` WRITE;
/*!40000 ALTER TABLE `secciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `secciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `cedula` varchar(24) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_idRol_idx` (`rol_id`),
  CONSTRAINT `fk_idRol` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Roberto','Cervantes','Castillo','1800800','roberto@ufide.com','Roberto',3),(4,'Juan','Perez','Perez','1100100','Juan@ufide.com','juan',3),(6,'Pablo','Gomez','Gomez','1700000','pablo@ufide.com','pablo',3),(7,'Felipe','Miranda','Alberto','910124578','felipe@ufide.com','Felipe',3);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_notificados`
--

DROP TABLE IF EXISTS `usuarios_notificados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_notificados` (
  `id_notificacion` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_notificacion`,`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_notificados`
--

LOCK TABLES `usuarios_notificados` WRITE;
/*!40000 ALTER TABLE `usuarios_notificados` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_notificados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-07 12:48:58
