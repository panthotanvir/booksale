-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 14, 2014 at 09:50 AM
-- Server version: 5.5.40-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `booksale`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `uni_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `author` text NOT NULL,
  `publisher` text NOT NULL,
  `type` text,
  `description` text NOT NULL,
  `price` double NOT NULL,
  `photo` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `division_id` int(11) NOT NULL,
  `edition` text NOT NULL,
  PRIMARY KEY (`book_id`,`user_id`,`dept_id`),
  KEY `user_id` (`user_id`),
  KEY `dept_id` (`dept_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `user_id`, `dept_id`, `uni_id`, `title`, `author`, `publisher`, `type`, `description`, `price`, `photo`, `date`, `division_id`, `edition`) VALUES
(9, 7, 1, 1, 'Introduction to Automata Theory', 'John E. Hopcroft\r\n', 'ISBN\r\n', 'Automata\r\n', 'This is an academic textbook that is also suitable for a far broader readership\r\n', 250, '1.jpg', '2014-12-13 12:15:52', 1, '5th'),
(10, 7, 1, 1, 'A Quantitative Approach (The Morgan Kaufmann Series in Computer Architecture and Design)\r\n', 'David A. Patterson\r\n', 'Morgan Kaufmann Series\r\n', 'Computer Architecture\r\n', 'This is an academic textbook that is also suitable for a far broader readership\r\n', 150, '2.jpg', '2014-12-13 12:18:47', 1, '6th'),
(11, 7, 1, 1, 'Computer Networks: Principles, Technologies and Protocols for Network Design\r\n', 'Natalia Olifer\r\n', 'Wiley\r\n', 'Networking', 'Urgent for sale', 165, '3.jpg', '2014-12-13 15:23:49', 1, '8th'),
(12, 7, 1, 1, 'Optics & Modern Physics', 'Natalia Olifer\r\n', 'Wiley\r\n', 'Telecom', 'Urgent for sale', 185, '4.jpg', '2014-12-13 15:25:23', 1, '9th'),
(13, 8, 1, 1, 'Digital Systems: Principles and Applications\r\n', 'Jonson ', 'ISBN', 'Digital System', 'Condition is good', 280, '5.jpg', '2014-12-13 15:34:08', 1, '8th'),
(14, 7, 1, 1, 'Organic Chemistry', 'Jonathan Clayden', 'Robbins group', 'Chemistry', 'quality is good', 120, '0.20733758263665784.jpg', '2014-12-14 03:05:16', 1, 'second');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` text NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `dept_name`) VALUES
(1, 'Computer Science & Engineering'),
(2, 'Chemistry'),
(3, 'Physics'),
(4, 'Mathematics'),
(5, 'Pharmacy'),
(6, 'Electrical and Electronics Engineering'),
(7, 'Mechanical Engineering');

-- --------------------------------------------------------

--
-- Table structure for table `division`
--

CREATE TABLE IF NOT EXISTS `division` (
  `division_id` int(11) NOT NULL AUTO_INCREMENT,
  `division_name` text NOT NULL,
  PRIMARY KEY (`division_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `division`
--

INSERT INTO `division` (`division_id`, `division_name`) VALUES
(1, 'Dhaka'),
(2, 'Chittagong'),
(3, 'Khulna'),
(4, 'Rajshahi'),
(5, 'Sylhet'),
(6, 'Barisal'),
(7, 'Rangpur');

-- --------------------------------------------------------

--
-- Table structure for table `exchange`
--

CREATE TABLE IF NOT EXISTS `exchange` (
  `exchange_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `exchange_to` text NOT NULL,
  `exchange_with` text NOT NULL,
  `detail` text NOT NULL,
  `exchange_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`exchange_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `exchange`
--

INSERT INTO `exchange` (`exchange_id`, `user_id`, `dept_id`, `exchange_to`, `exchange_with`, `detail`, `exchange_date`) VALUES
(3, 1, 1, 'Graph theory', 'distributed system', 'i dont know', '2014-12-13 01:46:34'),
(4, 7, 1, 'Data Telecommunication System', 'Database Management system', 'Very urgent. \r\nCall : 01750000000\r\nAddress: Dhanmondi', '2014-12-13 13:18:17'),
(5, 7, 1, 'Computer Graphics', 'Computer Fundamental', 'Computer fundamental , Author : jones , 6th edition', '2014-12-13 13:19:58');

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `rate_id` int(11) NOT NULL AUTO_INCREMENT,
  `rate` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `viewer_id` int(11) NOT NULL,
  PRIMARY KEY (`rate_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`rate_id`, `rate`, `user_id`, `viewer_id`) VALUES
(1, 4, 1, 1),
(2, 5, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE IF NOT EXISTS `request` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`request_id`, `user_id`, `dept_id`, `title`, `date`) VALUES
(1, 1, 1, 'Optics', '2014-11-28 18:00:00'),
(4, 1, 1, 'Physics', '2014-11-30 13:53:29'),
(5, 1, 1, 'Chemistry', '2014-11-30 13:53:47'),
(6, 1, 1, 'computer fundamental', '2014-12-12 14:10:39'),
(7, 7, 1, 'Computer Networking', '2014-12-13 13:16:21'),
(8, 7, 1, 'Introduction to Automata Theory, Languages, and Computation', '2014-12-13 13:16:51');

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE IF NOT EXISTS `university` (
  `uni_id` int(11) NOT NULL AUTO_INCREMENT,
  `uni_name` text NOT NULL,
  `uni_type` int(2) NOT NULL,
  PRIMARY KEY (`uni_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `university`
--

INSERT INTO `university` (`uni_id`, `uni_name`, `uni_type`) VALUES
(1, 'University of Dhaka', 1),
(2, 'Khulna University', 1),
(3, 'Eastwest University', 2),
(4, 'Daffodil University', 2),
(5, 'Rajshai University', 1),
(6, 'Buet', 3),
(7, 'Kuet', 3),
(8, 'Cuet', 3),
(9, 'Ruet', 3),
(11, 'Jahangirnagor Univesity', 1),
(12, 'Jagannath University', 1),
(13, 'Comilla University', 1),
(14, 'Barisal University', 1),
(15, 'Estern University', 2),
(16, 'Southest University', 2),
(17, 'Stamford University', 2),
(18, 'State University', 2);

-- --------------------------------------------------------

--
-- Table structure for table `uni_dept`
--

CREATE TABLE IF NOT EXISTS `uni_dept` (
  `uni_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  PRIMARY KEY (`uni_id`,`dept_id`),
  KEY `dept_id` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `uni_dept`
--

INSERT INTO `uni_dept` (`uni_id`, `dept_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(5, 3),
(1, 4),
(2, 4),
(3, 4),
(4, 4),
(5, 4),
(1, 5),
(2, 5),
(3, 5),
(4, 5),
(5, 5),
(6, 6),
(7, 6),
(8, 6),
(6, 7),
(7, 7),
(8, 7);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` text NOT NULL,
  `user_photo` text NOT NULL,
  `uni_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `phone` text NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`user_id`,`uni_id`,`dept_id`),
  KEY `uni_id` (`uni_id`),
  KEY `dept_id` (`dept_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_photo`, `uni_id`, `dept_id`, `email`, `password`, `phone`, `address`) VALUES
(7, 'Mithun Mondal', 'mithun.jpg', 1, 1, 'mithunshawon@gmail.com', '123', '01751111111', 'Dhaka'),
(8, 'Pantho Tanvir', 'pantho.jpg', 1, 1, 'panthotanvir@gmail.com', '123', '01751111111', 'Dhaka'),
(9, 'Redown Mahmud ', 'ratul.jpg', 1, 1, 'ratul@gmail.com', '123', '01751111111', 'Dhaka'),
(10, 'Mahbuba Afrin', 'ritu.jpg', 1, 1, 'ritu@gmail.com', '123', '01751111111', 'Dhaka'),
(11, 'Abdullah Khan', 'abdullah.jpg', 1, 1, 'abdullah@gmail.com', '123', '01751111111', 'Dhaka'),
(12, 'Mehedi Hasan', 'mehedi.jpg', 1, 1, 'mehedi@gmail.com', '123', '01751111111', 'Dhaka'),
(13, 'Mainul Hasan', 'hasan.jpg', 2, 1, 'hasan@gmail.com', '123', '01751111111', 'Dhaka'),
(14, 'Tanvir Ahmed', 'tanvir.jpg', 2, 1, 'tanvir01@gmail.com', '123', '01751111111', 'Khulna'),
(15, 'Saikat', 'saikat.jpg', 7, 1, 'saikat@gmail.com', '123', '01751111111', 'Dhaka'),
(16, 'Redown Mahmud ', 'ratul.jpg', 7, 6, 'ratul1@gmail.com', '123', '01751111111', 'Dhaka'),
(17, 'Mahbuba Afrin', 'ritu.jpg', 8, 1, 'ritu1@gmail.com', '123', '01751111111', 'Dhaka'),
(18, 'Abdullah Khan', 'abdullah.jpg', 8, 7, 'abdullah1@gmail.com', '123', '01751111111', 'Dhaka'),
(19, 'Mehedi Hasan', 'mehedi.jpg', 3, 1, 'mehedi1@gmail.com', '123', '01751111111', 'Dhaka'),
(20, 'Mainul Hasan', 'hasan.jpg', 4, 1, 'hasanpink@gmail.com', '123', '01751111111', 'Dhaka'),
(21, 'Tanvir Ahmed', 'tanvir.jpg', 3, 1, 'tanvir@gmail.com', '123', '01751111111', 'Khulna');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `book_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `uni_dept`
--
ALTER TABLE `uni_dept`
  ADD CONSTRAINT `uni_dept_ibfk_1` FOREIGN KEY (`uni_id`) REFERENCES `university` (`uni_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `uni_dept_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`uni_id`) REFERENCES `university` (`uni_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
