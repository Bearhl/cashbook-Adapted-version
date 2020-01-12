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

 Date: 06/12/2019 00:14:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consume_barchart
-- ----------------------------
DROP TABLE IF EXISTS `consume_barchart`;
CREATE TABLE `consume_barchart`  (
  `月支出` int(255) NULL DEFAULT NULL,
  `消费类型` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `月份` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consume_barchart
-- ----------------------------
INSERT INTO `consume_barchart` VALUES (500, '衣服', 1);
INSERT INTO `consume_barchart` VALUES (200, '交通', 1);
INSERT INTO `consume_barchart` VALUES (100, '生活用品', 1);
INSERT INTO `consume_barchart` VALUES (500, '娱乐', 1);
INSERT INTO `consume_barchart` VALUES (800, '美食', 2);
INSERT INTO `consume_barchart` VALUES (400, '衣服', 2);
INSERT INTO `consume_barchart` VALUES (210, '交通', 2);
INSERT INTO `consume_barchart` VALUES (120, '生活用品', 2);
INSERT INTO `consume_barchart` VALUES (450, '娱乐', 2);
INSERT INTO `consume_barchart` VALUES (850, '美食', 3);
INSERT INTO `consume_barchart` VALUES (450, '衣服', 3);
INSERT INTO `consume_barchart` VALUES (180, '交通', 3);
INSERT INTO `consume_barchart` VALUES (90, '生活用品', 3);
INSERT INTO `consume_barchart` VALUES (479, '娱乐', 3);
INSERT INTO `consume_barchart` VALUES (870, '美食', 4);
INSERT INTO `consume_barchart` VALUES (469, '衣服', 4);
INSERT INTO `consume_barchart` VALUES (199, '交通', 4);
INSERT INTO `consume_barchart` VALUES (300, '生活用品', 4);
INSERT INTO `consume_barchart` VALUES (600, '娱乐', 4);
INSERT INTO `consume_barchart` VALUES (1000, '美食', 1);

SET FOREIGN_KEY_CHECKS = 1;
