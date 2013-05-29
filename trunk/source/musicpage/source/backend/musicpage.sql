/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : musicpage

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2013-05-28 23:52:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `album`
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `idSong` int(11) NOT NULL,
  `title` varchar(555) NOT NULL,
  `source` varchar(555) NOT NULL,
  `sourceType` varchar(555) NOT NULL,
  `description` varchar(5555) DEFAULT NULL,
  `createdTime` date NOT NULL,
  `modifyTime` date NOT NULL,
  PRIMARY KEY (`id`,`idSong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for `song`
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(555) NOT NULL,
  `source` varchar(555) NOT NULL,
  `sourceType` varchar(555) NOT NULL,
  `description` varchar(5555) DEFAULT NULL,
  `createdTime` date NOT NULL,
  `modifyTime` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('1', 'k-video', 'http://chiasenhac.com/hd/video/k-video/', 'chiasenhac.com', null, '2013-05-28', '0000-00-00');
INSERT INTO `song` VALUES ('2', 'lele', 'mp3.zing.vn', 'zing', null, '0000-00-00', '0000-00-00');
INSERT INTO `song` VALUES ('3', 'lele', 'mp3.zing.vn', 'zing', null, '0000-00-00', '0000-00-00');
INSERT INTO `song` VALUES ('4', 'lele', 'mp3.zing.vn', 'zing', null, '0000-00-00', '0000-00-00');
