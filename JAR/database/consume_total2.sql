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

 Date: 06/12/2019 00:16:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consume_total2
-- ----------------------------
DROP TABLE IF EXISTS `consume_total2`;
CREATE TABLE `consume_total2`  (
  `月份` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `支出数额` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consume_total2
-- ----------------------------
INSERT INTO `consume_total2` VALUES ('1', 12431);
INSERT INTO `consume_total2` VALUES ('2', 12341);
INSERT INTO `consume_total2` VALUES ('3', 5456);
INSERT INTO `consume_total2` VALUES ('4', 5345);
INSERT INTO `consume_total2` VALUES ('5', 5673);
INSERT INTO `consume_total2` VALUES ('6', 3453);
INSERT INTO `consume_total2` VALUES ('7', 3462);
INSERT INTO `consume_total2` VALUES ('8', 89767);
INSERT INTO `consume_total2` VALUES ('9', 34545);
INSERT INTO `consume_total2` VALUES ('10', 3978);
INSERT INTO `consume_total2` VALUES ('11', 4362);
INSERT INTO `consume_total2` VALUES ('12', 35278);

SET FOREIGN_KEY_CHECKS = 1;
