/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : company

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2013-02-05 19:43:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `dbuser`
-- ----------------------------
DROP TABLE IF EXISTS `dbuser`;
CREATE TABLE `dbuser` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL,
  `CREATED_BY` varchar(255) NOT NULL,
  `CREATED_DATE` date NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dbuser
-- ----------------------------
INSERT INTO dbuser VALUES ('1', 'Fuuu1274174343', 'll', '2013-02-05');
INSERT INTO dbuser VALUES ('2', 'Fuuu-2047702172', 'll', '2013-02-05');
INSERT INTO dbuser VALUES ('3', 'Fuuu-1976961094', 'll', '2013-02-05');
INSERT INTO dbuser VALUES ('4', 'Fuuu1819344797', 'll', '2013-02-05');
INSERT INTO dbuser VALUES ('5', 'Fuuu172856467', 'll', '2013-02-05');
