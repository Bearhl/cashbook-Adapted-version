/*
 Navicat MySQL Data Transfer

 Source Server         : tao
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : consume

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 06/12/2019 00:16:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consume_line
-- ----------------------------
DROP TABLE IF EXISTS `consume_line`;
CREATE TABLE `consume_line`  (
  `美食支出` int(255) NULL DEFAULT NULL,
  `衣服支出` int(255) NULL DEFAULT NULL,
  `交通支出` int(255) NULL DEFAULT NULL,
  `生活用品支出` int(255) NULL DEFAULT NULL,
  `娱乐支出` int(255) NULL DEFAULT NULL,
  `日期` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consume_line
-- ----------------------------
INSERT INTO `consume_line` VALUES (30, 0, 5, 0, 10, '2019-11-12');
INSERT INTO `consume_line` VALUES (29, 0, 4, 6, 15, '2019-11-13');
INSERT INTO `consume_line` VALUES (25, 200, 6, 15, 5, '2019-11-14');
INSERT INTO `consume_line` VALUES (40, 0, 20, 0, 200, '2019-11-15');
INSERT INTO `consume_line` VALUES (20, 0, 0, 0, 20, '2019-11-16');
INSERT INTO `consume_line` VALUES (37, 0, 7, 0, 0, '2019-11-17');

SET FOREIGN_KEY_CHECKS = 1;
