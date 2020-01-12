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

 Date: 06/12/2019 00:16:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consume_barchart2
-- ----------------------------
DROP TABLE IF EXISTS `consume_barchart2`;
CREATE TABLE `consume_barchart2`  (
  `数额` int(255) NULL DEFAULT NULL,
  `收入/支出` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `年份` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consume_barchart2
-- ----------------------------
INSERT INTO `consume_barchart2` VALUES (10000, '收入', '2000');
INSERT INTO `consume_barchart2` VALUES (12000, '收入', '2001');
INSERT INTO `consume_barchart2` VALUES (13000, '收入', '2002');
INSERT INTO `consume_barchart2` VALUES (14000, '收入', '2003');
INSERT INTO `consume_barchart2` VALUES (15000, '收入', '2004');
INSERT INTO `consume_barchart2` VALUES (6000, '支出', '2000');
INSERT INTO `consume_barchart2` VALUES (6500, '支出', '2000');
INSERT INTO `consume_barchart2` VALUES (8000, '支出', '2001');
INSERT INTO `consume_barchart2` VALUES (10000, '支出', '2002');
INSERT INTO `consume_barchart2` VALUES (14000, '支出', '2003');
INSERT INTO `consume_barchart2` VALUES (20000, '支出', '2004');

SET FOREIGN_KEY_CHECKS = 1;
