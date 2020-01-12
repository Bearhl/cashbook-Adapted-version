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

 Date: 06/12/2019 00:16:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consume_line2
-- ----------------------------
DROP TABLE IF EXISTS `consume_line2`;
CREATE TABLE `consume_line2`  (
  `月总收入` int(255) NULL DEFAULT NULL,
  `月总支出` int(255) NULL DEFAULT NULL,
  `月份` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consume_line2
-- ----------------------------
INSERT INTO `consume_line2` VALUES (2000, 3000, '1');
INSERT INTO `consume_line2` VALUES (2300, 2400, '2');
INSERT INTO `consume_line2` VALUES (2342, 2344, '3');
INSERT INTO `consume_line2` VALUES (2134, 3464, '4');
INSERT INTO `consume_line2` VALUES (2342, 2235, '5');
INSERT INTO `consume_line2` VALUES (1131, 3125, '6');
INSERT INTO `consume_line2` VALUES (4575, 4376, '7');
INSERT INTO `consume_line2` VALUES (3478, 5823, '8');
INSERT INTO `consume_line2` VALUES (1249, 9478, '9');
INSERT INTO `consume_line2` VALUES (4859, 2305, '10');
INSERT INTO `consume_line2` VALUES (2849, 3856, '11');
INSERT INTO `consume_line2` VALUES (4384, 9847, '12');

SET FOREIGN_KEY_CHECKS = 1;
