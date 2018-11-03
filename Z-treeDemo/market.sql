/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost:3306
 Source Schema         : market

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 03/11/2018 22:03:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_pass` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_role` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `admin_role`(`admin_role`) USING BTREE,
  CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`admin_role`) REFERENCES `roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (1, 'admin', '123456', 1);
INSERT INTO `admins` VALUES (2, 'lina', '123456', 2);
INSERT INTO `admins` VALUES (3, 'baoyu', '123456', 3);

-- ----------------------------
-- Table structure for funs
-- ----------------------------
DROP TABLE IF EXISTS `funs`;
CREATE TABLE `funs`  (
  `fun_id` int(11) NOT NULL AUTO_INCREMENT,
  `fun_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fun_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fun_pid` int(11) NULL DEFAULT NULL,
  `fun_target` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`fun_id`) USING BTREE,
  INDEX `fun_pid`(`fun_pid`) USING BTREE,
  CONSTRAINT `funs_ibfk_1` FOREIGN KEY (`fun_pid`) REFERENCES `funs` (`fun_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of funs
-- ----------------------------
INSERT INTO `funs` VALUES (1, '基础数据管理', NULL, NULL, NULL);
INSERT INTO `funs` VALUES (2, '订单管理', NULL, NULL, NULL);
INSERT INTO `funs` VALUES (3, '系统管理', NULL, NULL, NULL);
INSERT INTO `funs` VALUES (4, '商品信息维护', '/admin/goods/search.do', 1, 'I2');
INSERT INTO `funs` VALUES (5, '商品类型维护', '/admin/type/search.do', 1, 'I2');
INSERT INTO `funs` VALUES (6, '未付款订单', '/admin/order/search.do', 2, 'I2');
INSERT INTO `funs` VALUES (7, '已付款订单', '/admin/order/search.do', 2, 'I2');
INSERT INTO `funs` VALUES (8, '退出', '/adminlogin.jsp', 3, '_top');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_price` float NULL DEFAULT NULL,
  `goods_num` int(11) NULL DEFAULT NULL,
  `goods_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_date` datetime(0) NULL DEFAULT NULL,
  `goods_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE,
  INDEX `goods_type`(`goods_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'InnoDB free: 3072 kB; (`goods_type`) REFER `no8/goods_type`(' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '哇哈哈1', 10, 999, NULL, '2016-08-31 14:45:52', 1);
INSERT INTO `goods` VALUES (2, 'MI5S', 2999, 100, NULL, '2016-08-31 14:46:23', 2);
INSERT INTO `goods` VALUES (5, 'test', 888, 18, NULL, '2016-09-01 11:19:26', 12);
INSERT INTO `goods` VALUES (9, '跑步机', 1000, 1000, NULL, '2016-09-20 15:05:02', 15);
INSERT INTO `goods` VALUES (10, '统一阿萨姆', 4, 191, NULL, '2016-09-21 16:20:29', 21);
INSERT INTO `goods` VALUES (16, '可口可乐', 3, 1000, NULL, '2016-09-23 10:20:16', 21);
INSERT INTO `goods` VALUES (17, 'iphone 7', 6188, 1, NULL, '2016-09-23 10:20:16', 2);
INSERT INTO `goods` VALUES (19, '哇哈哈', 25, 2500, NULL, '2016-09-23 10:20:20', 21);
INSERT INTO `goods` VALUES (20, 'test2', 2, 2, NULL, '2016-09-23 10:20:22', 1);
INSERT INTO `goods` VALUES (21, '爽歪歪', 5, 1000, NULL, '2016-09-23 10:20:24', 21);
INSERT INTO `goods` VALUES (23, '哑铃', 50, 100, NULL, '2016-09-23 10:20:32', 15);
INSERT INTO `goods` VALUES (26, '农夫山泉', 3, 100, NULL, '2016-09-23 10:20:43', 21);
INSERT INTO `goods` VALUES (27, '风衣', 998, 10, NULL, '2016-09-23 10:20:46', 10);
INSERT INTO `goods` VALUES (28, 'MAX-01', 1999, 120, NULL, '2016-09-23 10:20:49', 2);
INSERT INTO `goods` VALUES (30, '金刚芭比', 199, 1000, NULL, '2016-09-23 10:20:50', 10);
INSERT INTO `goods` VALUES (32, '罗曼尼康帝', 10000000, 100, NULL, '2016-09-23 10:20:54', 21);
INSERT INTO `goods` VALUES (33, '清风抽纸', 5, 3000, NULL, '2016-09-23 10:20:56', 1);
INSERT INTO `goods` VALUES (36, 'iphone7Plus', 20000, 8, NULL, '2016-09-23 10:21:03', 2);
INSERT INTO `goods` VALUES (41, '超新品雪碧', 50, 900000, NULL, '2016-09-23 10:21:08', 22);
INSERT INTO `goods` VALUES (42, '96拉菲', 29999, 50, NULL, '2016-09-23 10:21:08', 21);
INSERT INTO `goods` VALUES (45, '冰红茶', 3, 100, NULL, '2016-09-23 10:21:16', 21);
INSERT INTO `goods` VALUES (49, '百事可乐', 3, 200, NULL, '2016-09-23 10:21:27', 21);
INSERT INTO `goods` VALUES (51, '旺仔小王子', 3.5, 1000, NULL, '2016-09-23 10:21:38', 21);
INSERT INTO `goods` VALUES (56, 'AD钙', 3, 986, NULL, '2016-09-23 11:57:36', 21);
INSERT INTO `goods` VALUES (79, '威士忌', 1000, 120, NULL, '2016-09-27 11:55:56', 21);
INSERT INTO `goods` VALUES (80, '鱼竿', 13000, 2, NULL, '2016-09-27 12:12:39', 15);
INSERT INTO `goods` VALUES (86, 'lv包', 100, 1, NULL, '2016-10-12 12:28:37', 3);
INSERT INTO `goods` VALUES (87, 'a丝滑拿铁', 1, 1, NULL, NULL, 1);
INSERT INTO `goods` VALUES (88, '丝滑摩卡', 4, 10, NULL, NULL, 21);

-- ----------------------------
-- Table structure for goods_img
-- ----------------------------
DROP TABLE IF EXISTS `goods_img`;
CREATE TABLE `goods_img`  (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_goods` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`img_id`) USING BTREE,
  INDEX `img_goods`(`img_goods`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_pid` int(11) NULL DEFAULT NULL,
  `type_lv` int(11) NULL DEFAULT NULL,
  `type_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE,
  INDEX `type_pid`(`type_pid`) USING BTREE,
  CONSTRAINT `goods_type_ibfk_1` FOREIGN KEY (`type_pid`) REFERENCES `goods_type` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES (1, '家用电器', NULL, 1, '|1|');
INSERT INTO `goods_type` VALUES (2, '数码产品', NULL, 1, '|2|');
INSERT INTO `goods_type` VALUES (3, '服装服饰', NULL, 1, '|3|');
INSERT INTO `goods_type` VALUES (4, '照相机', 2, 2, '|2|4|');
INSERT INTO `goods_type` VALUES (5, '卡片机', 4, 3, '|2|4|5|');
INSERT INTO `goods_type` VALUES (6, '单反', 4, 3, '|2|4|6|');
INSERT INTO `goods_type` VALUES (7, '专业', 4, 3, '|2|4|7|');
INSERT INTO `goods_type` VALUES (9, '男装', 3, 2, '|3|9|');
INSERT INTO `goods_type` VALUES (10, '女装', 3, 2, '|3|10|');
INSERT INTO `goods_type` VALUES (11, '童装', 3, 2, '|3|11|');
INSERT INTO `goods_type` VALUES (12, '正装', 9, 3, '|3|9|12|');
INSERT INTO `goods_type` VALUES (13, '休闲', 9, 3, '|3|9|13|');
INSERT INTO `goods_type` VALUES (15, '运动器材', NULL, 1, '|15|');
INSERT INTO `goods_type` VALUES (16, '汽车配件', NULL, 1, '|16|');
INSERT INTO `goods_type` VALUES (18, '电子狗', 16, 2, '|16|18|');
INSERT INTO `goods_type` VALUES (19, '测速电子狗', 18, 3, '|16|18|19|');
INSERT INTO `goods_type` VALUES (20, 'pu裙子', 10, 3, '|3|10|20|');
INSERT INTO `goods_type` VALUES (21, '酒水饮料', NULL, 1, '|21|');
INSERT INTO `goods_type` VALUES (22, '雪碧', 21, 2, '|21|22|');
INSERT INTO `goods_type` VALUES (24, '箱包饰品', NULL, 1, '|24|');
INSERT INTO `goods_type` VALUES (25, '书籍资料', NULL, 1, '|25|');
INSERT INTO `goods_type` VALUES (26, '计算机书籍', 25, 2, '|25||26|');
INSERT INTO `goods_type` VALUES (27, '英语书籍', 25, 2, '|25||27|');

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `detail_order` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_goods` int(11) NULL DEFAULT NULL,
  `detail_price` float NULL DEFAULT NULL,
  `detail_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `detail_order`(`detail_order`) USING BTREE,
  INDEX `detail_goods`(`detail_goods`) USING BTREE,
  CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`detail_order`) REFERENCES `orders` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`detail_goods`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_details
-- ----------------------------
INSERT INTO `order_details` VALUES (1, 'fb8e80736686008f0166860091f30000', 1, 10, 4);
INSERT INTO `order_details` VALUES (2, 'fb8e80736686008f0166860091f30000', 2, 2999, 3);
INSERT INTO `order_details` VALUES (3, 'fb8e80966686261b016686261cb10000', 1, 100, 10);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_user` int(11) NULL DEFAULT NULL,
  `order_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `order_user`(`order_user`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('fb8e80736686008f0166860091f30000', 1, '甲骨文中心', '1370000000', 'lina');
INSERT INTO `orders` VALUES ('fb8e80966686261b016686261cb10000', NULL, '甲骨文', '10000', '一个订单');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `permission_role` int(11) NULL DEFAULT NULL,
  `permission_fun` int(11) NULL DEFAULT NULL,
  INDEX `permission_role`(`permission_role`) USING BTREE,
  INDEX `permission_fun`(`permission_fun`) USING BTREE,
  CONSTRAINT `permissions_ibfk_1` FOREIGN KEY (`permission_role`) REFERENCES `roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `permissions_ibfk_2` FOREIGN KEY (`permission_fun`) REFERENCES `funs` (`fun_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES (1, 1);
INSERT INTO `permissions` VALUES (1, 2);
INSERT INTO `permissions` VALUES (1, 3);
INSERT INTO `permissions` VALUES (2, 1);
INSERT INTO `permissions` VALUES (2, 3);
INSERT INTO `permissions` VALUES (3, 2);
INSERT INTO `permissions` VALUES (3, 3);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, '超级管理员');
INSERT INTO `roles` VALUES (2, '基础数据管理员');
INSERT INTO `roles` VALUES (3, '订单管理员');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pass` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'peter', '123456', '北京', '15810848579');
INSERT INTO `users` VALUES (2, 'sun', '123456', '天津', '15810848579');
INSERT INTO `users` VALUES (3, 'puma', '123456', '安阳', '12345678901');
INSERT INTO `users` VALUES (5, '老张', '123456', '河南', '13298309999');
INSERT INTO `users` VALUES (6, 'MI2', '123456', '北京海淀', '158XXXX1084');
INSERT INTO `users` VALUES (7, '王五', '098098', '天津', '1238676');
INSERT INTO `users` VALUES (8, 'qq', 'qq', 'qq', 'qq');

-- ----------------------------
-- View structure for detail_view
-- ----------------------------
DROP VIEW IF EXISTS `detail_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `detail_view` AS select `order_details`.`detail_goods` AS `detail_goods`,`goods`.`goods_name` AS `goods_name`,sum((`order_details`.`detail_num` * `order_details`.`detail_price`)) AS `sum(detail_num*detail_price)` from (`order_details` join `goods` on((`order_details`.`detail_goods` = `goods`.`goods_id`))) group by `order_details`.`detail_goods`,`goods`.`goods_name` ;

SET FOREIGN_KEY_CHECKS = 1;
