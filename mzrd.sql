/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : mzrd

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-08-13 14:08:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('1', 'admin', '�3�*鉎f�\n�5�M');

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) NOT NULL,
  `state` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES ('1', '采购部', '');
INSERT INTO `department_info` VALUES ('3', '公司', '');
INSERT INTO `department_info` VALUES ('4', '人事部', '\0');
INSERT INTO `department_info` VALUES ('5', '二', '');

-- ----------------------------
-- Table structure for desired_info
-- ----------------------------
DROP TABLE IF EXISTS `desired_info`;
CREATE TABLE `desired_info` (
  `deid` int(11) NOT NULL AUTO_INCREMENT,
  `srid` int(11) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `overDate` datetime DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `state` bit(1) DEFAULT b'1',
  PRIMARY KEY (`deid`),
  KEY `sid` (`srid`),
  KEY `id` (`id`),
  CONSTRAINT `desired_info_ibfk_1` FOREIGN KEY (`srid`) REFERENCES `supply_rank_info` (`srid`),
  CONSTRAINT `desired_info_ibfk_2` FOREIGN KEY (`id`) REFERENCES `staff_account_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of desired_info
-- ----------------------------

-- ----------------------------
-- Table structure for post_info
-- ----------------------------
DROP TABLE IF EXISTS `post_info`;
CREATE TABLE `post_info` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(20) NOT NULL,
  `did` int(11) NOT NULL,
  `rselect` int(1) NOT NULL,
  `rinsert` int(1) NOT NULL,
  `rdelete` int(1) NOT NULL,
  `rupdate` int(1) NOT NULL,
  `state` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`rid`),
  KEY `did` (`did`),
  CONSTRAINT `post_info_ibfk_1` FOREIGN KEY (`did`) REFERENCES `department_info` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_info
-- ----------------------------
INSERT INTO `post_info` VALUES ('1', '管理员', '3', '0', '0', '0', '0', '');
INSERT INTO `post_info` VALUES ('2', '高管', '1', '2', '2', '2', '2', '\0');
INSERT INTO `post_info` VALUES ('4', '采购员', '1', '1', '1', '1', '1', '');
INSERT INTO `post_info` VALUES ('5', 'af', '3', '2', '2', '2', '2', '');
INSERT INTO `post_info` VALUES ('6', '法', '4', '0', '0', '0', '0', '\0');
INSERT INTO `post_info` VALUES ('8', '经理', '1', '0', '3', '3', '3', '');
INSERT INTO `post_info` VALUES ('9', '范德萨', '3', '0', '0', '0', '0', '');

-- ----------------------------
-- Table structure for quote_info
-- ----------------------------
DROP TABLE IF EXISTS `quote_info`;
CREATE TABLE `quote_info` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `deid` int(11) NOT NULL,
  `number` int(5) NOT NULL,
  `unit` varchar(3) NOT NULL,
  `sid` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `remark` varchar(50) NOT NULL,
  `state` bit(1) NOT NULL DEFAULT b'0',
  `cause` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`qid`),
  KEY `sid` (`sid`),
  KEY `deid` (`deid`),
  CONSTRAINT `quote_info_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `supply_account_info` (`sid`),
  CONSTRAINT `quote_info_ibfk_2` FOREIGN KEY (`deid`) REFERENCES `desired_info` (`deid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quote_info
-- ----------------------------

-- ----------------------------
-- Table structure for staff_account_info
-- ----------------------------
DROP TABLE IF EXISTS `staff_account_info`;
CREATE TABLE `staff_account_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(23) NOT NULL,
  `password` varchar(22) NOT NULL,
  `rid` int(11) NOT NULL,
  `sname` varchar(21) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(31) DEFAULT NULL,
  `state` int(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  CONSTRAINT `staff_account_info_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `post_info` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_account_info
-- ----------------------------
INSERT INTO `staff_account_info` VALUES ('2', '发顺丰', '8褆壔�\r赦f\\sY5j��:M', '4', 'aad', '', '2r55@qq.com', '1');
INSERT INTO `staff_account_info` VALUES ('3', '121', '振.S纀犊0罝QS�&�', '5', '32', '13196411554', '', '0');
INSERT INTO `staff_account_info` VALUES ('19', '1234', 'q恧袨*ヤ哎r�\r, ', '2', '想', '13136984521', '', '1');
INSERT INTO `staff_account_info` VALUES ('20', '3213', '振.S纀犊0罝QS�&�', '2', '', null, '', '1');
INSERT INTO `staff_account_info` VALUES ('21', '3213321', 'q恧袨*ヤ哎r�\r, ', '4', '', null, '', '1');
INSERT INTO `staff_account_info` VALUES ('22', '4321', 'q恧袨*ヤ哎r�\r, ', '8', '', null, '', '1');
INSERT INTO `staff_account_info` VALUES ('23', '43212', 'q恧袨*ヤ哎r�\r, ', '8', '', null, '', '1');
INSERT INTO `staff_account_info` VALUES ('24', '5432', 'q恧袨*ヤ哎r�\r, ', '2', '', null, '', '1');
INSERT INTO `staff_account_info` VALUES ('25', '122', 'q恧袨*ヤ哎r�\r, ', '1', '', '132', '', '1');
INSERT INTO `staff_account_info` VALUES ('26', '人', 'q恧袨*ヤ哎r�\r, ', '2', '', null, '', '1');
INSERT INTO `staff_account_info` VALUES ('28', '请求', 'q恧袨*ヤ哎r�\r, ', '9', '', null, '', '1');

-- ----------------------------
-- Table structure for supply_account_info
-- ----------------------------
DROP TABLE IF EXISTS `supply_account_info`;
CREATE TABLE `supply_account_info` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `supplierName` varchar(20) DEFAULT NULL,
  `abbreviation` varchar(20) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `contact` varchar(9) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `state` int(1) DEFAULT '1',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supply_account_info
-- ----------------------------
INSERT INTO `supply_account_info` VALUES ('1', '123', '尣#}y蕡踕d昶\rヽEQ9d', '上海第二工业大学', '二工大', '浦东新区', '13196312458', '小黑', '22@qq.com', '1');
INSERT INTO `supply_account_info` VALUES ('2', '12', '振.S纀犊0罝QS�&�', 'we', '地方', '21', '13123451234', 'ere1', '33@qq.com', '0');
INSERT INTO `supply_account_info` VALUES ('3', '1211', '尣#}y蕡踕d昶\rヽEQ9d', '请问', '请问', '请问', '13123451234', '切勿', '11@qq.co', '1');
INSERT INTO `supply_account_info` VALUES ('4', '321', 'q恧袨*ヤ哎r�\r, ', '让我去二', '额外', '额外', '13123442134', '额外', '11@qq.com', '1');
INSERT INTO `supply_account_info` VALUES ('5', '432122', 'q恧袨*ヤ哎r�\r, ', '', '', '', null, '', '', '1');
INSERT INTO `supply_account_info` VALUES ('6', 'tj123', 'q恧袨*ヤ哎r�\r, ', '上海同济大学', '同济', '松江', '13412341234', '校长', 'tongii@qq.com', '1');
INSERT INTO `supply_account_info` VALUES ('11', '4312', 'q恧袨*ヤ哎r�\r, ', '去11', '11', 'qu11', null, 'rer', '11@qq.com', '1');

-- ----------------------------
-- Table structure for supply_rank_info
-- ----------------------------
DROP TABLE IF EXISTS `supply_rank_info`;
CREATE TABLE `supply_rank_info` (
  `srid` int(11) NOT NULL AUTO_INCREMENT,
  `srname` varchar(20) NOT NULL,
  PRIMARY KEY (`srid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supply_rank_info
-- ----------------------------
INSERT INTO `supply_rank_info` VALUES ('5', '电脑');
INSERT INTO `supply_rank_info` VALUES ('7', '鼠标');
INSERT INTO `supply_rank_info` VALUES ('11', '电灯');
INSERT INTO `supply_rank_info` VALUES ('19', '键盘');
INSERT INTO `supply_rank_info` VALUES ('26', '3214');
INSERT INTO `supply_rank_info` VALUES ('28', '432432');
INSERT INTO `supply_rank_info` VALUES ('30', '43243');
INSERT INTO `supply_rank_info` VALUES ('33', '543543');
INSERT INTO `supply_rank_info` VALUES ('34', '特特');
INSERT INTO `supply_rank_info` VALUES ('35', '二位若');
INSERT INTO `supply_rank_info` VALUES ('36', '2222');

-- ----------------------------
-- Table structure for supply_rank_relation_info
-- ----------------------------
DROP TABLE IF EXISTS `supply_rank_relation_info`;
CREATE TABLE `supply_rank_relation_info` (
  `arid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `srid` int(11) NOT NULL,
  PRIMARY KEY (`arid`),
  KEY `sid` (`sid`),
  KEY `srid` (`srid`),
  CONSTRAINT `supply_rank_relation_info_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `supply_account_info` (`sid`),
  CONSTRAINT `supply_rank_relation_info_ibfk_2` FOREIGN KEY (`srid`) REFERENCES `supply_rank_info` (`srid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supply_rank_relation_info
-- ----------------------------
INSERT INTO `supply_rank_relation_info` VALUES ('13', '6', '26');
INSERT INTO `supply_rank_relation_info` VALUES ('14', '6', '11');
INSERT INTO `supply_rank_relation_info` VALUES ('15', '6', '7');
INSERT INTO `supply_rank_relation_info` VALUES ('20', '1', '34');
INSERT INTO `supply_rank_relation_info` VALUES ('21', '1', '35');
INSERT INTO `supply_rank_relation_info` VALUES ('22', '1', '19');
INSERT INTO `supply_rank_relation_info` VALUES ('26', '11', '7');
INSERT INTO `supply_rank_relation_info` VALUES ('27', '11', '26');
INSERT INTO `supply_rank_relation_info` VALUES ('31', '2', '7');
INSERT INTO `supply_rank_relation_info` VALUES ('32', '2', '28');
INSERT INTO `supply_rank_relation_info` VALUES ('33', '2', '34');
