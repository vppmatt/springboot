-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.32 - MySQL Community Server (GPL)
-- Server OS:                    Linux
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for invoice_manager
DROP DATABASE IF EXISTS `invoice_manager`;
CREATE DATABASE IF NOT EXISTS `invoice_manager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `invoice_manager`;

-- Dumping structure for table invoice_manager.customer
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `address3` varchar(255) DEFAULT NULL,
  `address4` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- Dumping data for table invoice_manager.customer: ~0 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `address1`, `address2`, `address3`, `address4`, `country`, `name`, `email`, `phone`) VALUES
	(80, '17 Hampton Street', 'Birdsworth', NULL, 'BD1 3LL', 'UK', 'Big Cars Ltd', 'bigcars@bigcars.notavalidemail.co.uk', '+44 123 456 7890'),
	(81, '3029 South Avenue', 'Wheel Arch', 'MS', '12345', 'USA', 'Small Bikes Corp', 'smallbikes@smallbikes.notavalidemail.com', '+1 222 222 2222'),
	(82, '82 Rue La Seine', 'Ville du Nord', 'La Place', '54321', 'France', 'Bateaux Rapides SA', 'fastboats@bateauxrapides.notavalidemail.fr', '+33 123 456 789');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
