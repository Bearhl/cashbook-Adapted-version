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

 Date: 06/12/2019 00:16:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consume_total
-- ----------------------------
DROP TABLE IF EXISTS `consume_total`;
CREATE TABLE `consume_total`  (
  `消费类型` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `本年支出` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consume_total
-- ----------------------------
INSERT INTO `consume_total` VALUES ('美食', 7300);
INSERT INTO `consume_total` VALUES ('衣服', 1000);
INSERT INTO `consume_total` VALUES ('交通', 1825);
INSERT INTO `consume_total` VALUES ('生活用品', 800);
INSERT INTO `consume_total` VALUES ('娱乐', 2000);

SET FOREIGN_KEY_CHECKS = 1;
