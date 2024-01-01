/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : library-system

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2023-10-12 08:55:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `bname` varchar(255) NOT NULL COMMENT '图书名称',
  `type` varchar(255) NOT NULL COMMENT '图书类型',
  `author` varchar(255) NOT NULL COMMENT '图书作者',
  `stock` int(11) NOT NULL COMMENT '库存',
  `language` varchar(255) NOT NULL COMMENT '语言',
  `bimage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10028 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('10001', '钢铁是怎样练成的', '文学类', '尼古拉·奥斯特洛夫斯基', '32', '中文', 'Snipaste_2023-10-02_23-25-14.png');
INSERT INTO `book` VALUES ('10002', '西游记', '文学类', '吴承恩', '44', '中文', 'Snipaste_2023-10-02_21-02-37.png');
INSERT INTO `book` VALUES ('10004', '水浒传', '文学类', '尼古拉·奥斯特洛夫斯基啊', '102', '英文', 'Snipaste_2023-10-02_23-27-17.png');
INSERT INTO `book` VALUES ('10005', 'java', '科技类', '张三', '33', '中文', 'Snipaste_2023-10-02_23-28-41.png');
INSERT INTO `book` VALUES ('10006', 'c+++', '科技类', '李四', '12', '中文', 'Snipaste_2023-10-02_23-29-26.png');
INSERT INTO `book` VALUES ('10007', '音乐鉴赏', '艺术类', '王五', '100', '中文', 'Snipaste_2023-10-02_23-30-12.png');
INSERT INTO `book` VALUES ('10008', '电影鉴赏', '艺术类', '赵六', '100', '英文', 'Snipaste_2023-10-02_23-31-22.png');
INSERT INTO `book` VALUES ('10009', '舌尖上的中国', '生活类', '阿巴阿巴', '100', '中文', 'Snipaste_2023-10-02_23-33-05.png');
INSERT INTO `book` VALUES ('10011', '剑指offer', '教育类', '赵六', '90', '中文', 'Snipaste_2023-10-02_23-33-59.png');
INSERT INTO `book` VALUES ('10012', '安徒生童话', '儿童类', '安徒生', '11', '英文', 'Snipaste_2023-10-02_23-37-54.png');
INSERT INTO `book` VALUES ('10013', '新闻周刊', '杂志类', '曹雪芹', '100', '中文', 'Snipaste_2023-10-02_23-38-36.png');
INSERT INTO `book` VALUES ('10014', '多彩的二战', '历史类', '毛泽东', '12', '中文', 'Snipaste_2023-10-02_23-39-16.png');
INSERT INTO `book` VALUES ('10015', '阿衰', '漫画类', '张三', '100', '中文', 'Snipaste_2023-10-02_23-39-47.png');
INSERT INTO `book` VALUES ('10016', '大国重器', '军事类', '马跃', '13', '中文', 'Snipaste_2023-10-02_23-40-22.png');
INSERT INTO `book` VALUES ('10017', '西方哲学史', '哲学类', '尼古拉·奥斯特洛夫斯基啊', '100', '英文', 'Snipaste_2023-10-02_23-41-01.png');
INSERT INTO `book` VALUES ('10022', '史记', '传记类', '司马迁a', '11', '中文', '83294957810500.png');
INSERT INTO `book` VALUES ('10027', 'python', '科技类', '李四', '11', '中文', '170496986644000.png');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '读者id',
  `rname` varchar(255) NOT NULL COMMENT '读者姓名',
  `password` varchar(255) NOT NULL DEFAULT '666' COMMENT '密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `type` varchar(255) DEFAULT NULL COMMENT '喜欢的书籍类型',
  `rimage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('1', '张三', '202cb962ac59075b964b07152d234b70', '1223', '3513683871@qq.com', '文学类,科技类,生活类', '168118134833000.png');
INSERT INTO `reader` VALUES ('4', '李四', 'fae0b27c451c728867a567e8c1bb4e53', '', '3513683871@qq.com', '传记类', '257998044176100.jpg');
INSERT INTO `reader` VALUES ('8', '张三1', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '传记类', '258729270858400.jfif');
INSERT INTO `reader` VALUES ('9', '王五', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '文学啊', '329850678642700.png');
INSERT INTO `reader` VALUES ('10', '赵六', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '传记', '329867539168400.png');
INSERT INTO `reader` VALUES ('11', '赵信', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '艺术类', '93424084010000.png');
INSERT INTO `reader` VALUES ('12', '提莫', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '传记', '93299886351700.png');
INSERT INTO `reader` VALUES ('13', '德莱文', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '科技类', '93593949930400.png');
INSERT INTO `reader` VALUES ('14', '赵云', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '艺术类', '93541796487200.png');
INSERT INTO `reader` VALUES ('18', '亚索', 'fae0b27c451c728867a567e8c1bb4e53', '19591581167', '3513683871@qq.com', '科技类', '93774456656400.png');
INSERT INTO `reader` VALUES ('29', '永恩', '666', '19591581167', '3513683871@qq.com', '文学类', '170688018481300.png');


-- ----------------------------
-- Table structure for reader_book
-- ----------------------------
DROP TABLE IF EXISTS `reader_book`;
CREATE TABLE `reader_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `rid` int(11) NOT NULL COMMENT '借阅人id',
  `bid` int(11) NOT NULL COMMENT '借阅书籍id',
  `status` int(11) NOT NULL DEFAULT '0',
  `borrow_time` datetime DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `bid` (`bid`),
  CONSTRAINT `reader_book_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `reader` (`id`),
  CONSTRAINT `reader_book_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader_book
-- ----------------------------
INSERT INTO `reader_book` VALUES ('10', '8', '10005', '1', '2023-09-15 15:24:54', '2023-09-15 15:25:08');
INSERT INTO `reader_book` VALUES ('16', '11', '10015', '1', '2023-09-15 20:28:51', '2023-09-29 21:35:11');
INSERT INTO `reader_book` VALUES ('17', '8', '10006', '0', '2023-09-15 22:32:22', null);
INSERT INTO `reader_book` VALUES ('19', '1', '10011', '1', '2023-09-15 23:09:41', '2023-09-18 10:34:56');
INSERT INTO `reader_book` VALUES ('20', '1', '10009', '0', '2023-09-15 23:20:56', null);
INSERT INTO `reader_book` VALUES ('21', '12', '10015', '0', '2023-09-16 09:49:28', null);
INSERT INTO `reader_book` VALUES ('22', '12', '10017', '0', '2023-09-16 09:49:42', null);
INSERT INTO `reader_book` VALUES ('23', '11', '10016', '1', '2023-09-16 09:50:46', '2023-10-03 22:17:50');
INSERT INTO `reader_book` VALUES ('25', '11', '10004', '1', '2023-09-16 09:52:16', '2023-09-18 10:02:11');
INSERT INTO `reader_book` VALUES ('26', '12', '10004', '1', '2023-09-16 09:52:21', '2023-10-03 22:15:16');
INSERT INTO `reader_book` VALUES ('27', '8', '10015', '1', '2023-09-16 09:52:37', '2023-09-16 09:54:45');
INSERT INTO `reader_book` VALUES ('28', '1', '10006', '1', '2023-09-16 10:00:05', '2023-10-03 21:21:51');
INSERT INTO `reader_book` VALUES ('30', '10', '10012', '0', '2023-09-18 09:35:44', null);
INSERT INTO `reader_book` VALUES ('31', '12', '10014', '0', '2023-09-18 09:36:51', null);
INSERT INTO `reader_book` VALUES ('32', '11', '10013', '0', '2023-09-18 09:37:22', null);
INSERT INTO `reader_book` VALUES ('36', '9', '10015', '1', '2023-09-18 10:25:27', '2023-09-18 10:26:01');
INSERT INTO `reader_book` VALUES ('38', '1', '10005', '1', '2023-09-18 10:35:41', '2023-10-06 23:01:30');
INSERT INTO `reader_book` VALUES ('42', '8', '10005', '0', '2023-09-28 14:49:24', null);
INSERT INTO `reader_book` VALUES ('43', '9', '10005', '0', '2023-09-28 14:49:33', null);
INSERT INTO `reader_book` VALUES ('59', '18', '10027', '0', '2023-10-05 00:59:30', null);
INSERT INTO `reader_book` VALUES ('60', '1', '10012', '0', '2023-10-06 23:15:31', null);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` varchar(255) NOT NULL COMMENT '类型名称',
  `feature` varchar(255) NOT NULL COMMENT '类型特征',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '文学类', '文学是以语言文字为工具,比较形象化地反映客观现实、表现作家心灵..dadsadsdsdasdsadsaddsdsssssssssssssssssda.');
INSERT INTO `type` VALUES ('2', '科技类', '专业性是科技类图书*为突出的特点。随着科学技术的不断发展,学科的专业不断分化,科技类图书的内容多表现为某一专业或领域的理论知识和应用技术等');
INSERT INTO `type` VALUES ('4', '军事类', '了解军事知识');
INSERT INTO `type` VALUES ('8', '传记类', '记录个人成长史');
INSERT INTO `type` VALUES ('9', '艺术类', '培养艺术家');
INSERT INTO `type` VALUES ('10', '生活类', '记录美好生活');
INSERT INTO `type` VALUES ('11', '教育类', '刷题刷题刷题');
INSERT INTO `type` VALUES ('12', '儿童类', '儿童启蒙书籍');
INSERT INTO `type` VALUES ('13', '杂志类', '休闲必看书籍');
INSERT INTO `type` VALUES ('14', '历史类', '了解学习历史');
INSERT INTO `type` VALUES ('15', '漫画类', '图开心');
INSERT INTO `type` VALUES ('16', '哲学类', '看不懂');
INSERT INTO `type` VALUES ('20', 'eqweeqwe', '');
INSERT INTO `type` VALUES ('21', '儿童类', '12312311231231231');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `username` varchar(255) NOT NULL COMMENT '姓名',
  `phone` varchar(255) NOT NULL COMMENT '手机',
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1234567890@qq.com', '21232f297a57a5a743894a0e4a801fc3', 'admin', '19591581167', '66375241992600.jfif');
