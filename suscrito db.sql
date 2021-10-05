/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 8.0.23 : Database - suscrito_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`suscrito_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `suscrito_db`;

/*Table structure for table `comentario` */

DROP TABLE IF EXISTS `comentario`;

CREATE TABLE `comentario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estrellas` int DEFAULT NULL,
  `texto` varchar(255) DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `suscrito_codigo` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `COMENTARIO_FK_SUSCRITO` (`suscrito_codigo`),
  KEY `COMENTARIO_FK_POST` (`post_id`),
  CONSTRAINT `COMENTARIO_FK_POST` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `COMENTARIO_FK_SUSCRITO` FOREIGN KEY (`suscrito_codigo`) REFERENCES `suscrito` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `comentario` */

insert  into `comentario`(`id`,`estrellas`,`texto`,`post_id`,`suscrito_codigo`) values (5,123,'Hace legalmente',1,1);

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `texto` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post` */

insert  into `post`(`id`,`autor`,`fecha`,`texto`,`titulo`) values (1,'Italo Golin','2012-04-23','Hace calor che','Calor en el mediterraneo');

/*Table structure for table `suscrito` */

DROP TABLE IF EXISTS `suscrito`;

CREATE TABLE `suscrito` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `suscrito` */

insert  into `suscrito`(`codigo`,`correo`,`nombre`) values (1,'italo.galeano123@gmail.com','Italo Golin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
