/*
 Navicat MySQL Data Transfer

 Source Server         : employ
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 10.23.12.225:3306
 Source Schema         : m-job

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 27/02/2020 15:57:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enterprise_position
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_position`;
CREATE TABLE `enterprise_position` (
  `id` varchar(32) NOT NULL COMMENT '职位序号',
  `enterprise_id` varchar(32) NOT NULL COMMENT '公司Id',
  `enterprise_name` varchar(50) NOT NULL COMMENT '公司名称',
  `position` varchar(20) NOT NULL COMMENT '职位名称',
  `experience` varchar(20) DEFAULT NULL COMMENT '经验要求',
  `education` varchar(20) DEFAULT NULL COMMENT '学历要求',
  `salary_lower` int(10) DEFAULT NULL COMMENT '薪资范围下限',
  `salary_upper` int(10) DEFAULT NULL COMMENT '薪资范围上限',
  `position_key` varchar(50) DEFAULT NULL COMMENT '职位关键词',
  `position_title` varchar(100) DEFAULT NULL COMMENT '岗位描述小标题',
  `position_content` varchar(255) DEFAULT NULL COMMENT '岗位描述正文内容',
  `work_address` varchar(256) DEFAULT NULL COMMENT '工作地址',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `status` varchar(20) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `region_id` varchar(32) NOT NULL COMMENT '工作城市行政区域编码',
  `region_full_name` varchar(256) NOT NULL COMMENT '工作城市行政区域全名',
  `hire_number` int(10) DEFAULT NULL COMMENT '招聘人数',
  `phone` varchar(32) NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_position
-- ----------------------------
BEGIN;
INSERT INTO `enterprise_position` VALUES ('1231890201018646530', '222', '阿里巴巴', '测试', '3', '6', 10, 12, '测试', '测试', '1. 根据项目说明、设计文档、使用说明书等，做好测试前的准备工作，保证产品测试工作的计划性与规范性；  2. 按照测试流程、计划以及对产品特性的把握，编写测试用例，确保测试目的的达成；  3. 根据测试计划及测试用例，执行测试，确保在软件发布前基本排除其缺陷；  4. 根据测试结果，与开发部门等反复沟通测试情况，修正测试中发现的缺陷，完善软件性能；  5. 整理测试文档，编写测试总结；  6.完成上级领导交办的其它工作任务。', '浙江杭州', '2020-02-24 18:34:46', '1', 'admin', NULL, NULL, '2020-02-24 18:34:46', '330100000000', '浙江省/杭州市', 5, '0571-12345678');
INSERT INTO `enterprise_position` VALUES ('1231901410614673410', '1231863000063807490', 'testtest', '测试岗位', '3', '4', 10, 20, '好工作', '非常好的工作', '非常好的工作哈哈', '浙江省杭州市余杭区临平南苑街道cbc大厦2号楼', '2020-02-24 20:01:46', '1', 'admin', '2020-02-24 19:58:34', 'admin', '2020-02-24 00:00:00', '130102000000', '河北省/石家庄市/长安区', 5, '15657170234');
INSERT INTO `enterprise_position` VALUES ('1231905535834472449', '222', '阿里巴巴', '测试', '7', '6', 20, 30, '测试', '测试', '测试', '杭州', '2020-02-24 19:35:42', '1', 'admin', NULL, NULL, '2020-02-24 19:35:42', '330201000000', '浙江省/宁波市/市辖区', 5, '1341234567');
INSERT INTO `enterprise_position` VALUES ('1231913033270050817', '1231778429951553538', '中国移动', '移动5G++', '4', '6', 6, 8, '五险一金', '5G运营相关', '5G运营相关5G运营相关5G运营相关5G运营相关5G运营相关5G运营相关', '浙江省杭州市江干区九堡', '2020-02-24 20:05:29', '1', 'admin', NULL, NULL, '2020-02-24 20:05:29', '330104000000', '浙江省/杭州市/江干区', 3, '15657180193');
INSERT INTO `enterprise_position` VALUES ('1231916003827400706', '222', '阿里巴巴', '算法01', '1', '1', 2, 5, '应届', 'test', 'test', '杭州', '2020-02-24 20:17:18', '1', 'admin', NULL, NULL, '2020-02-24 20:17:18', '330000000000', '浙江省', 10, '15652222222');
INSERT INTO `enterprise_position` VALUES ('1231949950678495234', '222', '阿里巴巴', '前端', '2', '7', 10, 20, '年假', '前端', '前端', '浙江杭州', '2020-02-24 00:00:00', '1', 'admin', '2020-02-24 22:34:53', 'admin', '2020-02-24 00:00:00', '140171000000', '山西省/太原市/山西转型综合改革示范区', 2, '0571-87654321');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
