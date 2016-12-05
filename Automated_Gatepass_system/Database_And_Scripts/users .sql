-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 01, 2015 at 03:49 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `code` varchar(50) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `reg_no` varchar(10) NOT NULL,
  `school` varchar(20) NOT NULL,
  `course` varchar(20) NOT NULL,
  `year` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`code`, `product_name`, `reg_no`, `school`, `course`, `year`) VALUES
('2333', 'Dell', 'If_1005_11', 'Information Sciences', 'Informatics', 'Fourth Year'),
('29283670', 'Dell', 'If_1005_11', 'Information Sciences', 'Informatics', 'Fourth Year'),
('2147483647', 'Beast', 'bae_12_11', 'HR', 'Music', 'Third Year'),
('2147483647', 'Beast', 'HR_11_16', 'HR', 'Music', '3'),
('2147483647', '', '', '', '', ''),
('850006000012', 'Macintosh', 'is_13_15', 'Information Sciences', 'Informatics', 'Second year');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
