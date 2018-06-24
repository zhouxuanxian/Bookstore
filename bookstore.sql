/*
SQLyog Ultimate v9.30 
MySQL - 5.5.53 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(30) DEFAULT NULL,
  `admin_password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`admin_id`,`admin_name`,`admin_password`) values (1,'周轩衔','123456');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `bookname` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `booktype` varchar(20) DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `picture` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book` (`uid`),
  CONSTRAINT `FK_book` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`uid`,`bookname`,`author`,`price`,`booktype`,`publish`,`number`,`picture`) values (3,3,'数据库系统概论','王珊',15,'经管类','高等教育出版社',1,'20180611071801.jpg'),(5,1,'数据库','周轩衔',14,'计算机类','高等教育出版社',1,'20180614071516.jpg'),(6,1,'数据库','周轩衔',14,'计算机类','高等教育出版社',12,'20180614071534.jpg'),(7,1,'数据库系统概论','王珊',15,'计算机类','高等教育出版社',1,'20180614071549.jpg'),(8,1,'信息安全','周轩衔',5,'计算机类','高等教育出版社',2,'20180614072734.jpg'),(9,1,'数据库系统概论','周轩衔',6,'计算机类','高等教育出版社',1,'20180614072757.jpg'),(10,1,'数据库系统概论','王珊',15,'文学类','高等教育出版社',1,'20180614072815.jpg'),(11,1,'数据库系统概论','王珊',15,'通用学科类','高等教育出版社',1,'20180622051258.png'),(12,1,'数据库系统概论','王珊',15,'工科类','高等教育出版社',12,'20180622051605.png'),(13,1,'信息安全','周轩衔',15,'计算机类','高等教育出版社',1,'20180622053049.jpg');

/*Table structure for table `buybook` */

DROP TABLE IF EXISTS `buybook`;

CREATE TABLE `buybook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(30) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `picture` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `buybook_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `buybook` */

insert  into `buybook`(`id`,`bookname`,`author`,`uid`,`picture`) values (2,'数据库系统概论','王珊',1,'20180615121509.jpg'),(3,'数据库系统概论','王珊',1,'20180622051542.png'),(4,'数据库','王珊',1,'20180622051712.jpg');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `contact` varchar(30) DEFAULT NULL,
  `picture` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`phone`,`password`,`contact`,`picture`) values (1,'zxx','15815750366','123456','148566666666','20180622105145.png'),(2,'周轩衔','15015054637','zxx123456','1635005721','20180622105145.png'),(3,'周轩衔','13912344577','123456','1234567424','20180622105145.png'),(4,'阿轩小子','15918812291','zxx','1299537044','20180622105145.png'),(6,'周轩衔','15015503423','1234567','1233497','20180622105145.png'),(7,'cyc','15815750599','cyc','1234566','20180622052030.png');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
