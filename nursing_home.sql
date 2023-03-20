/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : nursing_home

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 13/05/2020 16:48:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bed_inf
-- ----------------------------
DROP TABLE IF EXISTS `bed_inf`;
CREATE TABLE `bed_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `room` varchar(100) DEFAULT NULL,
  `floor` varchar(200) DEFAULT NULL,
  `create_date` char(20) DEFAULT NULL,
  `status` int(10) DEFAULT '0',
  `type` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `number` int(2) DEFAULT NULL COMMENT '1:单人间，2:多人间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='养老院管理系统';

-- ----------------------------
-- Records of bed_inf
-- ----------------------------
BEGIN;
INSERT INTO `bed_inf` VALUES (1, '1112', '102', '132323', '2020-03-12', 0, '很豪华,1,1', '100', 1);
INSERT INTO `bed_inf` VALUES (3, '001', '10', '1', '2019-11-30', 0, '豪华', '100', NULL);
INSERT INTO `bed_inf` VALUES (4, '111', '111', '1', '2020-01-06', 1, '豪华', '111', NULL);
COMMIT;

-- ----------------------------
-- Table structure for dept_inf
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_inf
-- ----------------------------
BEGIN;
INSERT INTO `dept_inf` VALUES (32, '天天', '要犹犹豫豫', '女', 100);
INSERT INTO `dept_inf` VALUES (3, '张三', '他是组织人员', '男', 434);
INSERT INTO `dept_inf` VALUES (5, '李四', '也是组织人员', '女', 23);
INSERT INTO `dept_inf` VALUES (31, '我查查', '哈哈哈哈', '男', 10);
INSERT INTO `dept_inf` VALUES (30, '哈哈', '方法', '男', 100);
COMMIT;

-- ----------------------------
-- Table structure for employee_inf
-- ----------------------------
DROP TABLE IF EXISTS `employee_inf`;
CREATE TABLE `employee_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  `begin` varchar(50) DEFAULT NULL,
  `end` varchar(100) DEFAULT NULL,
  `dept_name` varchar(10) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT '111111',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_inf
-- ----------------------------
BEGIN;
INSERT INTO `employee_inf` VALUES (1, 5, '广州天河', 51, '2019-12-13', '2019-12-13', '本科', '美声', '唱歌', '2016-03-14 11:35:18', '123456');
INSERT INTO `employee_inf` VALUES (3, 3, '广州', 51, '2019-12-11', '2019-12-11', '本科', '爬山', '爬山', '2016-07-14 09:54:52', NULL);
INSERT INTO `employee_inf` VALUES (7, 6, '我', 234, '2019-12-12', '2019-12-19', NULL, '我的', '我', '2019-12-07', '111111');
COMMIT;

-- ----------------------------
-- Table structure for home_inf
-- ----------------------------
DROP TABLE IF EXISTS `home_inf`;
CREATE TABLE `home_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for job_inf
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_inf
-- ----------------------------
BEGIN;
INSERT INTO `job_inf` VALUES (2, '张护工', '工作15年', '男', 50);
INSERT INTO `job_inf` VALUES (11, '1', '2,3,4,5,6,7', '男', 56);
COMMIT;

-- ----------------------------
-- Table structure for message_inf
-- ----------------------------
DROP TABLE IF EXISTS `message_inf`;
CREATE TABLE `message_inf` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `create_date` varchar(50) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_inf
-- ----------------------------
BEGIN;
INSERT INTO `message_inf` VALUES (1, 1, '1', '1', '1', '1');
INSERT INTO `message_inf` VALUES (2, 5, '4234', '', '2019-12-10', '4234');
INSERT INTO `message_inf` VALUES (3, 5, '432', '', '2019-12-04', '432');
COMMIT;

-- ----------------------------
-- Table structure for notice_inf
-- ----------------------------
DROP TABLE IF EXISTS `notice_inf`;
CREATE TABLE `notice_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  `pabulum` varchar(50) DEFAULT NULL,
  `heat` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice_inf
-- ----------------------------
BEGIN;
INSERT INTO `notice_inf` VALUES (10, '肘子', '中餐', '10', '2020-03-23', '100', '10', '100');
COMMIT;

-- ----------------------------
-- Table structure for provider_inf
-- ----------------------------
DROP TABLE IF EXISTS `provider_inf`;
CREATE TABLE `provider_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of provider_inf
-- ----------------------------
BEGIN;
INSERT INTO `provider_inf` VALUES (10, '2', '2', '1', '2019-12-31');
COMMIT;

-- ----------------------------
-- Table structure for user_inf
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_date` char(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
BEGIN;
INSERT INTO `user_inf` VALUES (1, 'admin', '123456', 1, '2016-03-12 09:34:28', '超级管理员1', NULL, NULL);
INSERT INTO `user_inf` VALUES (2, 'root', '123456', NULL, '2016-03-12 09:34:28', 'root', NULL, NULL);
INSERT INTO `user_inf` VALUES (3, '哈哈', '123456', NULL, '2016-03-12 09:34:28', '哈哈', NULL, NULL);
INSERT INTO `user_inf` VALUES (4, 'rain', '123456', NULL, '2016-03-12 09:34:28', 'rain', NULL, NULL);
INSERT INTO `user_inf` VALUES (5, 'lalala', '123456', 2, NULL, 'wangtian', NULL, NULL);
INSERT INTO `user_inf` VALUES (9, 'user1', '123456', 2, '2020-01-06', 'user1', '15248409744', '中国');
INSERT INTO `user_inf` VALUES (8, '测试', '443', 1, NULL, '234', NULL, NULL);
INSERT INTO `user_inf` VALUES (10, 'user2', '123456', 2, '2020-01-06', 'user2', '15248409766', '中国');
INSERT INTO `user_inf` VALUES (13, '测试用户02181029', '123456', 1, '2020-02-18 10:29:47', 'test02181029', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for yuyue
-- ----------------------------
DROP TABLE IF EXISTS `yuyue`;
CREATE TABLE `yuyue` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `begin` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `beginday` varchar(255) DEFAULT NULL,
  `endday` varchar(255) DEFAULT NULL,
  `create_date` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yuyue
-- ----------------------------
BEGIN;
INSERT INTO `yuyue` VALUES (1, '2019-12-12', '2019-12-20', '上午', '上午', '2019-12-05', NULL);
INSERT INTO `yuyue` VALUES (2, '2020-03-11', '2020-03-12', '上午', '上午', '2020-03-29', '问问');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
