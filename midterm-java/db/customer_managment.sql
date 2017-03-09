/*
Navicat MySQL Data Transfer

Source Server         : BIGkeen Server
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : customer_managment

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-03-09 13:59:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_customer`
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer` (
  `cus_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cus_first_name` varchar(25) DEFAULT NULL,
  `cus_last_name` varchar(25) DEFAULT NULL,
  `cus_gender` varchar(1) DEFAULT NULL,
  `cus_email_address` varchar(50) DEFAULT NULL,
  `cus_dob` date DEFAULT NULL,
  `cus_address` varchar(255) DEFAULT NULL,
  `cus_phone_number` varchar(20) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES ('1', 'A', '1', 'M', 'A1@example.com', '2017-01-01', 'PP', '012345678', '2017-01-01 00:00:00', '2017-01-01 00:00:00');
INSERT INTO `tb_customer` VALUES ('2', 'B', '1', 'M', 'B1@example.com', '2017-01-01', 'PP', '012345678', '2017-01-01 00:00:00', '2017-01-01 00:00:00');
INSERT INTO `tb_customer` VALUES ('3', 'C', '1', 'F', 'C1@example.com', '2017-01-01', 'PP', '012345678', '2017-01-01 00:00:00', '2017-01-01 00:00:00');
INSERT INTO `tb_customer` VALUES ('4', 'D', '1', 'F', 'D1@example.com', '2017-01-01', 'PP', '012345678', '2017-01-01 00:00:00', '2017-01-01 00:00:00');
INSERT INTO `tb_customer` VALUES ('5', 'E', '1', 'M', 'E1@example.com', '2017-01-01', 'PP', '012345678', '2017-01-01 00:00:00', '2017-01-01 00:00:00');
INSERT INTO `tb_customer` VALUES ('6', 'F', '1', 'M', 'F1@example.com', '2017-01-01', 'PP', '012345678', '2017-01-01 00:00:00', '2017-01-01 00:00:00');
INSERT INTO `tb_customer` VALUES ('7', 'Sovan', 'Dara', 'M', 'sovandara@yahoo.com', '2003-02-08', 'Phnom Penh', '098777654', '2017-03-07 16:17:52', '2017-03-07 16:18:03');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) unsigned NOT NULL DEFAULT '0',
  `username` varchar(25) NOT NULL,
  `passwd` varchar(25) NOT NULL,
  `userrole` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', 'ADMIN');
INSERT INTO `tb_user` VALUES ('2', 'user-test', '123456', 'USER');
