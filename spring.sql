-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.29 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 city_erp 的数据库结构
CREATE DATABASE IF NOT EXISTS `city_erp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `city_erp`;

-- 导出  表 city_erp.erp_product 结构
CREATE TABLE IF NOT EXISTS `erp_product` (
  `SSNO` int(10) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `SNAME` varchar(20) DEFAULT NULL COMMENT '名称',
  `PRICE` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `QTY` int(10) DEFAULT NULL COMMENT '数量',
  `PHOTO` longblob COMMENT '产品照片',
  `FILENAME` varchar(200) DEFAULT NULL COMMENT '照片文件名',
  `ContentType` varchar(200) DEFAULT NULL COMMENT '照片文件类型',
  PRIMARY KEY (`SSNO`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  city_erp.erp_product 的数据：~9 rows (大约)
DELETE FROM `erp_product`;
/*!40000 ALTER TABLE `erp_product` DISABLE KEYS */;
INSERT INTO `erp_product` (`SSNO`, `SNAME`, `PRICE`, `QTY`, `PHOTO`, `FILENAME`, `ContentType`) VALUES
	(1, '啊', 12.00, 1234, NULL, NULL, NULL),
	(2, '苹果', 1.00, 2, NULL, NULL, NULL),
	(3, '橘子', 2.00, 20, NULL, NULL, NULL),
	(4, '葡萄', 12.00, 1000, NULL, NULL, NULL),
	(5, '菠萝', 10.00, 100, NULL, NULL, NULL),
	(6, '香蕉', 5.00, 200, NULL, NULL, NULL),
	(7, '桃子', 3.00, 100, NULL, NULL, NULL),
	(8, '桃子', 3.00, 100, NULL, NULL, NULL),
	(9, '香蕉', 5.00, 200, NULL, NULL, NULL);
/*!40000 ALTER TABLE `erp_product` ENABLE KEYS */;

-- 导出  表 city_erp.erp_product1 结构
CREATE TABLE IF NOT EXISTS `erp_product1` (
  `SSID` varchar(10) NOT NULL COMMENT '序号',
  `SNAME` varchar(20) DEFAULT NULL COMMENT '名称',
  `PRICE` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `PDATE` date DEFAULT NULL COMMENT '生产日期',
  PRIMARY KEY (`SSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  city_erp.erp_product1 的数据：~7 rows (大约)
DELETE FROM `erp_product1`;
/*!40000 ALTER TABLE `erp_product1` DISABLE KEYS */;
INSERT INTO `erp_product1` (`SSID`, `SNAME`, `PRICE`, `PDATE`) VALUES
	('1', '苹果', 1.00, '2020-01-01'),
	('2', '香蕉', 3.00, '1999-02-02'),
	('3', '橘子', 2.00, '2020-05-01'),
	('4', '香蕉', 3.00, '2020-06-01'),
	('5', '橡胶', 2.00, '2020-06-09'),
	('6', '葡萄', 5.00, '2020-04-01'),
	('7', '苹果', 10.00, '2020-06-25');
/*!40000 ALTER TABLE `erp_product1` ENABLE KEYS */;


-- 导出 cityerp 的数据库结构
CREATE DATABASE IF NOT EXISTS `cityerp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cityerp`;

-- 导出  表 cityerp.erp_areas 结构
CREATE TABLE IF NOT EXISTS `erp_areas` (
  `ANo` int(11) NOT NULL AUTO_INCREMENT COMMENT '鍖哄煙缂栧彿',
  `AName` varchar(20) DEFAULT NULL COMMENT '鍖哄煙鍚嶇О',
  PRIMARY KEY (`ANo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.erp_areas 的数据：~4 rows (大约)
DELETE FROM `erp_areas`;
/*!40000 ALTER TABLE `erp_areas` DISABLE KEYS */;
INSERT INTO `erp_areas` (`ANo`, `AName`) VALUES
	(1, '大连'),
	(2, '北京'),
	(3, '上海'),
	(4, '南京');
/*!40000 ALTER TABLE `erp_areas` ENABLE KEYS */;

-- 导出  表 cityerp.erp_category 结构
CREATE TABLE IF NOT EXISTS `erp_category` (
  `CNo` int(11) NOT NULL AUTO_INCREMENT COMMENT '绫诲埆缂栧彿',
  `CName` varchar(20) DEFAULT NULL COMMENT '绫诲埆鍚嶇О',
  PRIMARY KEY (`CNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.erp_category 的数据：~3 rows (大约)
DELETE FROM `erp_category`;
/*!40000 ALTER TABLE `erp_category` DISABLE KEYS */;
INSERT INTO `erp_category` (`CNo`, `CName`) VALUES
	(1, '服装'),
	(2, '食品'),
	(3, '电器');
/*!40000 ALTER TABLE `erp_category` ENABLE KEYS */;

-- 导出  表 cityerp.erp_product 结构
CREATE TABLE IF NOT EXISTS `erp_product` (
  `PNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '浜у搧缂栧彿',
  `PName` varchar(20) NOT NULL COMMENT '浜у搧鍚嶇О',
  `CNO` int(11) DEFAULT NULL COMMENT '浜у搧绫诲埆缂栧彿',
  `UNITPRICE` decimal(10,2) DEFAULT NULL COMMENT '鍗曚环',
  `QTY` int(11) DEFAULT NULL COMMENT '浜у搧鏁伴噺',
  PRIMARY KEY (`PNO`),
  KEY `FK_erp_product_erp_category` (`CNO`),
  CONSTRAINT `FK_erp_product_erp_category` FOREIGN KEY (`CNO`) REFERENCES `erp_category` (`CNo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.erp_product 的数据：~4 rows (大约)
DELETE FROM `erp_product`;
/*!40000 ALTER TABLE `erp_product` DISABLE KEYS */;
INSERT INTO `erp_product` (`PNO`, `PName`, `CNO`, `UNITPRICE`, `QTY`) VALUES
	(1, '羽绒服', 1, 2000.00, 2000),
	(2, '橘子', 2, 3.00, 100),
	(3, '香蕉', 2, 3.00, 200),
	(4, '苹果', 2, 1.00, 100);
/*!40000 ALTER TABLE `erp_product` ENABLE KEYS */;

-- 导出  表 cityerp.erp_productarea 结构
CREATE TABLE IF NOT EXISTS `erp_productarea` (
  `ANo` int(11) NOT NULL COMMENT '鍖哄煙缂栧彿',
  `PNO` int(11) NOT NULL COMMENT '浜у搧缂栧彿',
  PRIMARY KEY (`ANo`,`PNO`),
  KEY `FK_erp_productarea_erp_products` (`PNO`),
  CONSTRAINT `FK_erp_productarea_erp_areas` FOREIGN KEY (`ANo`) REFERENCES `erp_areas` (`ANo`),
  CONSTRAINT `FK_erp_productarea_erp_products` FOREIGN KEY (`PNO`) REFERENCES `erp_products` (`PNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.erp_productarea 的数据：~4 rows (大约)
DELETE FROM `erp_productarea`;
/*!40000 ALTER TABLE `erp_productarea` DISABLE KEYS */;
INSERT INTO `erp_productarea` (`ANo`, `PNO`) VALUES
	(1, 1),
	(1, 2),
	(2, 2),
	(3, 2);
/*!40000 ALTER TABLE `erp_productarea` ENABLE KEYS */;

-- 导出  表 cityerp.erp_productpackaging 结构
CREATE TABLE IF NOT EXISTS `erp_productpackaging` (
  `PNO` int(11) NOT NULL COMMENT '缂栧彿',
  `PTYPE` varchar(50) NOT NULL COMMENT '鍖呰绫诲瀷',
  `PSIZE` int(11) NOT NULL COMMENT '鍖呰灏哄,鍗曚綅 m鲁',
  PRIMARY KEY (`PNO`),
  CONSTRAINT `FK__erp_products` FOREIGN KEY (`PNO`) REFERENCES `erp_products` (`PNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.erp_productpackaging 的数据：~2 rows (大约)
DELETE FROM `erp_productpackaging`;
/*!40000 ALTER TABLE `erp_productpackaging` DISABLE KEYS */;
INSERT INTO `erp_productpackaging` (`PNO`, `PTYPE`, `PSIZE`) VALUES
	(1, '1', 1),
	(2, '12', 112);
/*!40000 ALTER TABLE `erp_productpackaging` ENABLE KEYS */;

-- 导出  表 cityerp.erp_products 结构
CREATE TABLE IF NOT EXISTS `erp_products` (
  `PNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '浜у搧缂栧彿',
  `PName` varchar(100) DEFAULT NULL COMMENT '浜у搧鍚嶇О',
  `PDATE` datetime DEFAULT NULL COMMENT '鐢熶骇鏃ユ湡',
  `UNITPRICE` decimal(10,2) DEFAULT NULL COMMENT '浜у搧鍗曚环',
  `QTY` int(11) DEFAULT NULL COMMENT '搴撳瓨鏁伴噺',
  PRIMARY KEY (`PNO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.erp_products 的数据：~2 rows (大约)
DELETE FROM `erp_products`;
/*!40000 ALTER TABLE `erp_products` DISABLE KEYS */;
INSERT INTO `erp_products` (`PNO`, `PName`, `PDATE`, `UNITPRICE`, `QTY`) VALUES
	(1, '1', '2020-04-21 00:00:00', 1.00, 1),
	(2, '苹果', '2020-04-07 00:00:00', 12.00, 12);
/*!40000 ALTER TABLE `erp_products` ENABLE KEYS */;

-- 导出  表 cityerp.product 结构
CREATE TABLE IF NOT EXISTS `product` (
  `PNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '浜у搧缂栧彿',
  `GNO` int(11) DEFAULT NULL COMMENT '绫诲埆缂栧彿',
  `PNAME` varchar(200) DEFAULT NULL COMMENT '浜у搧鍚嶇О',
  `Price` varchar(1000) DEFAULT NULL COMMENT '鍗曚环',
  `QTY` int(11) DEFAULT NULL COMMENT '搴撳瓨鏁伴噺',
  PRIMARY KEY (`PNO`),
  KEY `FK_product_productcategory` (`GNO`),
  CONSTRAINT `FK_product_productcategory` FOREIGN KEY (`GNO`) REFERENCES `productcategory` (`GNo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.product 的数据：~2 rows (大约)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`PNO`, `GNO`, `PNAME`, `Price`, `QTY`) VALUES
	(1, 3, '苹果', '12', 123),
	(2, 1, '橘子', '10', 1000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 导出  表 cityerp.productcategory 结构
CREATE TABLE IF NOT EXISTS `productcategory` (
  `GNo` int(11) NOT NULL AUTO_INCREMENT COMMENT '绫诲埆缂栧彿',
  `GName` varchar(20) DEFAULT NULL COMMENT '绫诲埆鍚嶇О',
  PRIMARY KEY (`GNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerp.productcategory 的数据：~3 rows (大约)
DELETE FROM `productcategory`;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
INSERT INTO `productcategory` (`GNo`, `GName`) VALUES
	(1, '水果'),
	(2, '蔬菜'),
	(3, '肉类');
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;


-- 导出 cityerpmybatis 的数据库结构
CREATE DATABASE IF NOT EXISTS `cityerpmybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cityerpmybatis`;

-- 导出  表 cityerpmybatis.erp_order 结构
CREATE TABLE IF NOT EXISTS `erp_order` (
  `ONO` int(11) NOT NULL AUTO_INCREMENT COMMENT '璁㈠崟缂栧彿',
  `PName` varchar(20) DEFAULT NULL COMMENT '浜у搧鍚嶇О',
  `Price` decimal(12,2) DEFAULT NULL COMMENT '鍗曚环',
  `QTY` int(11) DEFAULT NULL COMMENT '璁㈣喘鏁伴噺',
  `ODATE` datetime DEFAULT NULL COMMENT '璁㈣喘鏃ユ湡',
  PRIMARY KEY (`ONO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpmybatis.erp_order 的数据：~4 rows (大约)
DELETE FROM `erp_order`;
/*!40000 ALTER TABLE `erp_order` DISABLE KEYS */;
INSERT INTO `erp_order` (`ONO`, `PName`, `Price`, `QTY`, `ODATE`) VALUES
	(1, '苹果', 1.00, 10, '2019-01-01 00:00:00'),
	(2, '苹果汁', 2.00, 10, '2019-03-01 00:00:00'),
	(3, '苹果汁', 2.00, 100, '2019-03-01 00:00:00'),
	(4, '苹果', 1.00, 10, '2020-01-01 00:00:00');
/*!40000 ALTER TABLE `erp_order` ENABLE KEYS */;

-- 导出  表 cityerpmybatis.erp_product 结构
CREATE TABLE IF NOT EXISTS `erp_product` (
  `PNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '浜у搧缂栧彿',
  `PName` varchar(20) DEFAULT NULL COMMENT '浜у搧鍚嶇О',
  `Price` decimal(12,2) DEFAULT NULL COMMENT '鍗曚环',
  `QTY` int(11) DEFAULT NULL COMMENT '鏁伴噺',
  PRIMARY KEY (`PNO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpmybatis.erp_product 的数据：~3 rows (大约)
DELETE FROM `erp_product`;
/*!40000 ALTER TABLE `erp_product` DISABLE KEYS */;
INSERT INTO `erp_product` (`PNO`, `PName`, `Price`, `QTY`) VALUES
	(1, '苹果', 1.00, 100),
	(2, '橘子', 10.00, 100),
	(4, '苹果', 1.00, 100);
/*!40000 ALTER TABLE `erp_product` ENABLE KEYS */;


-- 导出 cityerpspring 的数据库结构
CREATE DATABASE IF NOT EXISTS `cityerpspring` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cityerpspring`;

-- 导出  表 cityerpspring.erp_areas 结构
CREATE TABLE IF NOT EXISTS `erp_areas` (
  `Ano` int(10) NOT NULL AUTO_INCREMENT COMMENT '区域编号',
  `Aname` varchar(20) DEFAULT NULL COMMENT '区域名称',
  PRIMARY KEY (`Ano`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpspring.erp_areas 的数据：~3 rows (大约)
DELETE FROM `erp_areas`;
/*!40000 ALTER TABLE `erp_areas` DISABLE KEYS */;
INSERT INTO `erp_areas` (`Ano`, `Aname`) VALUES
	(1, '大连'),
	(2, '北京'),
	(3, '上海');
/*!40000 ALTER TABLE `erp_areas` ENABLE KEYS */;

-- 导出  表 cityerpspring.erp_product 结构
CREATE TABLE IF NOT EXISTS `erp_product` (
  `PNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `PName` varchar(20) DEFAULT NULL COMMENT '名称',
  `Price` decimal(12,2) DEFAULT NULL COMMENT '单价',
  `QTY` int(11) DEFAULT NULL COMMENT '数量',
  `PDATE` datetime DEFAULT NULL COMMENT '生产日期',
  PRIMARY KEY (`PNO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpspring.erp_product 的数据：~6 rows (大约)
DELETE FROM `erp_product`;
/*!40000 ALTER TABLE `erp_product` DISABLE KEYS */;
INSERT INTO `erp_product` (`PNO`, `PName`, `Price`, `QTY`, `PDATE`) VALUES
	(1, '苹果汁', 1.00, 1000, '2000-01-01 00:00:00'),
	(2, '橘子汁', 2.00, 1000, '2002-01-07 00:00:00'),
	(3, '香蕉', 3.00, 1000, '2010-01-01 00:00:00'),
	(4, '葡萄', 3.00, 1000, '2020-01-01 00:00:00'),
	(5, '苹果', 1.00, 1000, '2000-01-01 00:00:00'),
	(6, '苹果', 1.00, 1000, '2020-01-01 00:00:00');
/*!40000 ALTER TABLE `erp_product` ENABLE KEYS */;

-- 导出  表 cityerpspring.erp_product1 结构
CREATE TABLE IF NOT EXISTS `erp_product1` (
  `PID` varchar(10) NOT NULL COMMENT '浜у搧缂栧彿',
  `PName` varchar(20) NOT NULL COMMENT '浜у搧鍚嶇О',
  `MODEL` varchar(2) NOT NULL COMMENT '鍨嬪彿',
  `PRICE` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '鍗曚环',
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpspring.erp_product1 的数据：~2 rows (大约)
DELETE FROM `erp_product1`;
/*!40000 ALTER TABLE `erp_product1` DISABLE KEYS */;
INSERT INTO `erp_product1` (`PID`, `PName`, `MODEL`, `PRICE`) VALUES
	('1', '苹果', '1', 11.10),
	('2', '香蕉', '2', 22.20);
/*!40000 ALTER TABLE `erp_product1` ENABLE KEYS */;

-- 导出  表 cityerpspring.erp_productarea 结构
CREATE TABLE IF NOT EXISTS `erp_productarea` (
  `ANo` int(10) NOT NULL COMMENT '区域编号',
  `PNo` int(10) NOT NULL COMMENT '产品编号',
  PRIMARY KEY (`ANo`,`PNo`),
  KEY `FK__erp_products` (`PNo`),
  CONSTRAINT `FK__erp_areas` FOREIGN KEY (`ANo`) REFERENCES `erp_areas` (`Ano`),
  CONSTRAINT `FK__erp_products` FOREIGN KEY (`PNo`) REFERENCES `erp_products` (`PNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpspring.erp_productarea 的数据：~2 rows (大约)
DELETE FROM `erp_productarea`;
/*!40000 ALTER TABLE `erp_productarea` DISABLE KEYS */;
INSERT INTO `erp_productarea` (`ANo`, `PNo`) VALUES
	(1, 1),
	(2, 1);
/*!40000 ALTER TABLE `erp_productarea` ENABLE KEYS */;

-- 导出  表 cityerpspring.erp_products 结构
CREATE TABLE IF NOT EXISTS `erp_products` (
  `PNO` int(10) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `PName` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `PDATE` datetime DEFAULT NULL COMMENT '生产日期',
  `UNITPRICE` decimal(10,2) DEFAULT NULL COMMENT '产品单价',
  `QTY` int(10) DEFAULT NULL COMMENT '库存数量',
  PRIMARY KEY (`PNO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpspring.erp_products 的数据：~4 rows (大约)
DELETE FROM `erp_products`;
/*!40000 ALTER TABLE `erp_products` DISABLE KEYS */;
INSERT INTO `erp_products` (`PNO`, `PName`, `PDATE`, `UNITPRICE`, `QTY`) VALUES
	(1, '苹果', '2020-01-01 00:01:00', 2.00, 100),
	(2, '橘子', '2020-01-01 00:01:00', 2.00, 100),
	(3, '葡萄', '2020-01-01 00:01:00', 2.00, 100),
	(4, '葡萄', '2020-01-01 00:01:00', 2.00, 100);
/*!40000 ALTER TABLE `erp_products` ENABLE KEYS */;

-- 导出  表 cityerpspring.oa_product 结构
CREATE TABLE IF NOT EXISTS `oa_product` (
  `SSNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '搴忓彿',
  `SNAME` varchar(20) DEFAULT NULL COMMENT '鍚嶇О',
  `PRICE` decimal(10,2) DEFAULT NULL COMMENT '閲戦',
  `QTY` int(11) DEFAULT NULL COMMENT '鏁伴噺',
  PRIMARY KEY (`SSNO`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  cityerpspring.oa_product 的数据：~7 rows (大约)
DELETE FROM `oa_product`;
/*!40000 ALTER TABLE `oa_product` DISABLE KEYS */;
INSERT INTO `oa_product` (`SSNO`, `SNAME`, `PRICE`, `QTY`) VALUES
	(1, '苹果', 1.00, 10),
	(2, '苹果汁', 1.00, 10),
	(3, '橘子', 2.00, 10),
	(4, '苹果', 3.00, 10),
	(5, '苹果汁', 2.00, 10),
	(6, '葡萄', 1.00, 10),
	(7, '葡萄', 1.00, 10);
/*!40000 ALTER TABLE `oa_product` ENABLE KEYS */;


-- 导出 cityinfo 的数据库结构
CREATE DATABASE IF NOT EXISTS `cityinfo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cityinfo`;

-- 导出  表 cityinfo.info_student 结构
CREATE TABLE IF NOT EXISTS `info_student` (
  `SSNO` int(10) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `SNAME` varchar(20) DEFAULT NULL COMMENT '名称',
  `CNO` int(10) DEFAULT NULL COMMENT '班级编号',
  `AGE` int(2) DEFAULT NULL COMMENT '年龄',
  `SEX` varchar(10) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`SSNO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityinfo.info_student 的数据：~4 rows (大约)
DELETE FROM `info_student`;
/*!40000 ALTER TABLE `info_student` DISABLE KEYS */;
INSERT INTO `info_student` (`SSNO`, `SNAME`, `CNO`, `AGE`, `SEX`) VALUES
	(1, '张三', 1, 20, '男'),
	(2, '李四', 1, 32, '女'),
	(3, '王五', 1, 23, '男'),
	(4, '丁六', 2, 21, '男');
/*!40000 ALTER TABLE `info_student` ENABLE KEYS */;

-- 导出  表 cityinfo.oa_class 结构
CREATE TABLE IF NOT EXISTS `oa_class` (
  `CLNO` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CLNAME` varchar(20) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`CLNO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  cityinfo.oa_class 的数据：~3 rows (大约)
DELETE FROM `oa_class`;
/*!40000 ALTER TABLE `oa_class` DISABLE KEYS */;
INSERT INTO `oa_class` (`CLNO`, `CLNAME`) VALUES
	(1, '1班'),
	(2, '2班'),
	(3, '3班');
/*!40000 ALTER TABLE `oa_class` ENABLE KEYS */;

-- 导出  表 cityinfo.oa_course 结构
CREATE TABLE IF NOT EXISTS `oa_course` (
  `CNO` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CNAME` varchar(20) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`CNO`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityinfo.oa_course 的数据：~4 rows (大约)
DELETE FROM `oa_course`;
/*!40000 ALTER TABLE `oa_course` DISABLE KEYS */;
INSERT INTO `oa_course` (`CNO`, `CNAME`) VALUES
	(1, '高数'),
	(2, '线代'),
	(3, 'C语言'),
	(4, 'java');
/*!40000 ALTER TABLE `oa_course` ENABLE KEYS */;

-- 导出  表 cityinfo.oa_student 结构
CREATE TABLE IF NOT EXISTS `oa_student` (
  `SSNO` int(10) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `SNAME` varchar(20) DEFAULT NULL COMMENT '名称',
  `CLNO` int(10) DEFAULT NULL COMMENT '班级编号',
  `AGE` int(2) DEFAULT NULL COMMENT '年龄',
  `SEX` varchar(10) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`SSNO`),
  KEY `FK__oa_class` (`CLNO`) USING BTREE,
  CONSTRAINT `FK__oa_class` FOREIGN KEY (`CLNO`) REFERENCES `oa_class` (`CLNO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityinfo.oa_student 的数据：~4 rows (大约)
DELETE FROM `oa_student`;
/*!40000 ALTER TABLE `oa_student` DISABLE KEYS */;
INSERT INTO `oa_student` (`SSNO`, `SNAME`, `CLNO`, `AGE`, `SEX`) VALUES
	(1, '张三', 1, 21, '男'),
	(2, '李四', 2, 17, '女'),
	(3, '张四', 1, 21, '男'),
	(4, '李四', 1, 20, '女');
/*!40000 ALTER TABLE `oa_student` ENABLE KEYS */;

-- 导出  表 cityinfo.oa_studentcourse 结构
CREATE TABLE IF NOT EXISTS `oa_studentcourse` (
  `CNO` int(10) NOT NULL COMMENT '编号',
  `SSNO` int(10) NOT NULL COMMENT '编号',
  PRIMARY KEY (`CNO`,`SSNO`),
  KEY `FK_oa_studentcourse_oa_student` (`SSNO`),
  CONSTRAINT `FK_oa_studentcourse_oa_course` FOREIGN KEY (`CNO`) REFERENCES `oa_course` (`CNO`),
  CONSTRAINT `FK_oa_studentcourse_oa_student` FOREIGN KEY (`SSNO`) REFERENCES `oa_student` (`SSNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityinfo.oa_studentcourse 的数据：~3 rows (大约)
DELETE FROM `oa_studentcourse`;
/*!40000 ALTER TABLE `oa_studentcourse` DISABLE KEYS */;
INSERT INTO `oa_studentcourse` (`CNO`, `SSNO`) VALUES
	(1, 1),
	(2, 1),
	(1, 3);
/*!40000 ALTER TABLE `oa_studentcourse` ENABLE KEYS */;


-- 导出 citymis 的数据库结构
CREATE DATABASE IF NOT EXISTS `citymis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `citymis`;

-- 导出  表 citymis.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `CNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '瀹㈡埛搴忓彿',
  `CCODE` varchar(50) DEFAULT NULL COMMENT '瀹㈡埛缂栫爜',
  `CNAME` varchar(50) DEFAULT NULL COMMENT '瀹㈡埛鍚嶇О',
  `STAFFNUM` int(11) DEFAULT NULL COMMENT '鍛樺伐浜烘暟',
  `CREATEDATE` date DEFAULT NULL COMMENT '鎴愮珛鏃ユ湡',
  `YEARSALES` decimal(12,2) DEFAULT NULL COMMENT '骞撮攢鍞',
  `Address` varchar(100) DEFAULT NULL COMMENT '娉ㄥ唽鍦板潃',
  `TEL` varchar(20) DEFAULT NULL COMMENT '鍏徃鐢佃瘽',
  PRIMARY KEY (`CNO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  citymis.customer 的数据：~2 rows (大约)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`CNO`, `CCODE`, `CNAME`, `STAFFNUM`, `CREATEDATE`, `YEARSALES`, `Address`, `TEL`) VALUES
	(1, '1', '张三', 1, '2020-03-13', 1000.00, '大连', '12312312'),
	(2, '2', '李四', 1222, '2020-03-05', 1212.00, '大连', '1212');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- 导出 cityoa 的数据库结构
CREATE DATABASE IF NOT EXISTS `cityoa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cityoa`;

-- 导出  表 cityoa.oa_behave 结构
CREATE TABLE IF NOT EXISTS `oa_behave` (
  `BNO` int(11) NOT NULL AUTO_INCREMENT,
  `BNAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BNO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_behave 的数据：~4 rows (大约)
DELETE FROM `oa_behave`;
/*!40000 ALTER TABLE `oa_behave` DISABLE KEYS */;
INSERT INTO `oa_behave` (`BNO`, `BNAME`) VALUES
	(1, '旅游'),
	(2, '爬山'),
	(3, '音乐'),
	(4, '文学');
/*!40000 ALTER TABLE `oa_behave` ENABLE KEYS */;

-- 导出  表 cityoa.oa_course 结构
CREATE TABLE IF NOT EXISTS `oa_course` (
  `CNo` int(11) NOT NULL AUTO_INCREMENT COMMENT '璇剧▼缂栧彿',
  `CName` varchar(20) DEFAULT NULL COMMENT '璇剧▼鍚嶇О',
  PRIMARY KEY (`CNo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_course 的数据：~5 rows (大约)
DELETE FROM `oa_course`;
/*!40000 ALTER TABLE `oa_course` DISABLE KEYS */;
INSERT INTO `oa_course` (`CNo`, `CName`) VALUES
	(1, '高数'),
	(2, '线代'),
	(3, '英语'),
	(4, 'C语言'),
	(5, '数字电路');
/*!40000 ALTER TABLE `oa_course` ENABLE KEYS */;

-- 导出  表 cityoa.oa_department 结构
CREATE TABLE IF NOT EXISTS `oa_department` (
  `DEPTNO` int(11) NOT NULL AUTO_INCREMENT,
  `DEPTCODE` varchar(20) DEFAULT NULL,
  `DEPTNAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DEPTNO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_department 的数据：~5 rows (大约)
DELETE FROM `oa_department`;
/*!40000 ALTER TABLE `oa_department` DISABLE KEYS */;
INSERT INTO `oa_department` (`DEPTNO`, `DEPTCODE`, `DEPTNAME`) VALUES
	(1, 'D01', '财务部'),
	(2, 'D02', '销售部'),
	(3, 'D03', '生产部'),
	(4, 'D04', '开发部'),
	(5, 'D999', '太空部');
/*!40000 ALTER TABLE `oa_department` ENABLE KEYS */;

-- 导出  表 cityoa.oa_employee 结构
CREATE TABLE IF NOT EXISTS `oa_employee` (
  `EMPID` varchar(20) NOT NULL,
  `DEPTNO` int(11) DEFAULT NULL,
  `EMPPassword` varchar(20) DEFAULT NULL,
  `EMPNAME` varchar(50) DEFAULT NULL,
  `EMPSEX` varchar(2) DEFAULT NULL,
  `AGE` int(11) DEFAULT '18',
  `BirthDAY` date DEFAULT NULL,
  `JOINDATE` date DEFAULT NULL,
  `SALARY` decimal(12,2) DEFAULT '0.00',
  `PHOTO` longblob,
  `PhotoFileName` varchar(50) DEFAULT NULL,
  `PhotoContentType` varchar(50) DEFAULT NULL,
  `CardCode` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`EMPID`),
  UNIQUE KEY `CardCode` (`CardCode`),
  KEY `FK_oa_employee_oa_department` (`DEPTNO`),
  CONSTRAINT `FK_oa_employee_oa_department` FOREIGN KEY (`DEPTNO`) REFERENCES `oa_department` (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_employee 的数据：~5 rows (大约)
DELETE FROM `oa_employee`;
/*!40000 ALTER TABLE `oa_employee` DISABLE KEYS */;
INSERT INTO `oa_employee` (`EMPID`, `DEPTNO`, `EMPPassword`, `EMPNAME`, `EMPSEX`, `AGE`, `BirthDAY`, `JOINDATE`, `SALARY`, `PHOTO`, `PhotoFileName`, `PhotoContentType`, `CardCode`) VALUES
	('1001', 1, '1001', '王明', '男', 20, '1989-10-01', '2013-10-10', 3000.00, NULL, NULL, NULL, NULL),
	('1002', 1, '1002', '刘明', '男', 21, '1988-05-01', '2012-10-10', 4000.00, NULL, NULL, NULL, NULL),
	('1003', 3, '1003', '赵明', '男', 22, '1987-10-01', '2011-11-10', 5000.00, NULL, NULL, NULL, NULL),
	('7777', 2, '7777', '七七七', '男', 18, '2020-03-26', '2020-03-26', 5500.00, NULL, NULL, NULL, '201123199901019878'),
	('8888', 4, '8888', '张三', '男', 30, '2020-02-22', '2020-03-26', 6000.00, NULL, NULL, NULL, '23022182920202020222');
/*!40000 ALTER TABLE `oa_employee` ENABLE KEYS */;

-- 导出  表 cityoa.oa_employeeaddress 结构
CREATE TABLE IF NOT EXISTS `oa_employeeaddress` (
  `EMPID` varchar(20) NOT NULL,
  `CITY` varchar(30) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `POSTCODE` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`EMPID`),
  CONSTRAINT `FK_oa_employeeaddress_oa_employee` FOREIGN KEY (`EMPID`) REFERENCES `oa_employee` (`EMPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_employeeaddress 的数据：~1 rows (大约)
DELETE FROM `oa_employeeaddress`;
/*!40000 ALTER TABLE `oa_employeeaddress` DISABLE KEYS */;
INSERT INTO `oa_employeeaddress` (`EMPID`, `CITY`, `Address`, `POSTCODE`) VALUES
	('8888', '大连', '中山', '10080');
/*!40000 ALTER TABLE `oa_employeeaddress` ENABLE KEYS */;

-- 导出  表 cityoa.oa_employeebehave 结构
CREATE TABLE IF NOT EXISTS `oa_employeebehave` (
  `EMPID` varchar(20) NOT NULL DEFAULT '',
  `BNO` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`EMPID`,`BNO`),
  KEY `FK_oa_employeebehave_oa_behave` (`BNO`),
  CONSTRAINT `FK_oa_employeebehave_oa_behave` FOREIGN KEY (`BNO`) REFERENCES `oa_behave` (`BNO`),
  CONSTRAINT `FK_oa_employeebehave_oa_employee` FOREIGN KEY (`EMPID`) REFERENCES `oa_employee` (`EMPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_employeebehave 的数据：~3 rows (大约)
DELETE FROM `oa_employeebehave`;
/*!40000 ALTER TABLE `oa_employeebehave` DISABLE KEYS */;
INSERT INTO `oa_employeebehave` (`EMPID`, `BNO`) VALUES
	('1001', 1),
	('1001', 2),
	('1001', 4);
/*!40000 ALTER TABLE `oa_employeebehave` ENABLE KEYS */;

-- 导出  表 cityoa.oa_employeecontactinfo 结构
CREATE TABLE IF NOT EXISTS `oa_employeecontactinfo` (
  `CINO` int(11) NOT NULL AUTO_INCREMENT,
  `EMPID` varchar(20) NOT NULL,
  `Mail` varchar(100) DEFAULT NULL,
  `Mobile` varchar(20) DEFAULT NULL,
  `QQ` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CINO`),
  UNIQUE KEY `EMPID` (`EMPID`),
  UNIQUE KEY `Mail` (`Mail`),
  UNIQUE KEY `Mobile` (`Mobile`),
  CONSTRAINT `FK_oa_employeecontactinfo_oa_employee` FOREIGN KEY (`EMPID`) REFERENCES `oa_employee` (`EMPID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_employeecontactinfo 的数据：~1 rows (大约)
DELETE FROM `oa_employeecontactinfo`;
/*!40000 ALTER TABLE `oa_employeecontactinfo` DISABLE KEYS */;
INSERT INTO `oa_employeecontactinfo` (`CINO`, `EMPID`, `Mail`, `Mobile`, `QQ`) VALUES
	(2, '8888', '8888@qq.com', '12312341234', '12345678');
/*!40000 ALTER TABLE `oa_employeecontactinfo` ENABLE KEYS */;

-- 导出  表 cityoa.oa_student 结构
CREATE TABLE IF NOT EXISTS `oa_student` (
  `SSID` varchar(10) NOT NULL COMMENT '瀛﹀彿',
  `SName` varchar(20) DEFAULT NULL COMMENT '瀛︾敓濮撳悕',
  `SEX` varchar(2) DEFAULT NULL COMMENT '鎬у埆',
  `AGE` int(11) DEFAULT NULL COMMENT '骞撮緞',
  PRIMARY KEY (`SSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_student 的数据：~4 rows (大约)
DELETE FROM `oa_student`;
/*!40000 ALTER TABLE `oa_student` DISABLE KEYS */;
INSERT INTO `oa_student` (`SSID`, `SName`, `SEX`, `AGE`) VALUES
	('1', '张三', '男', 20),
	('2', '李四', '女', 26),
	('3', '王五', '女', 22),
	('4', '丁六', '女', 25);
/*!40000 ALTER TABLE `oa_student` ENABLE KEYS */;

-- 导出  表 cityoa.oa_studentcourse 结构
CREATE TABLE IF NOT EXISTS `oa_studentcourse` (
  `CNo` int(11) NOT NULL COMMENT '璇剧▼缂栧彿',
  `SSID` varchar(20) NOT NULL COMMENT '瀛︾敓缂栧彿',
  PRIMARY KEY (`CNo`,`SSID`),
  KEY `FK_oa_studentcourse_oa_course` (`CNo`),
  KEY `FK_oa_studentcourse_oa_student` (`SSID`),
  CONSTRAINT `FK_oa_studentcourse_oa_course` FOREIGN KEY (`CNo`) REFERENCES `oa_course` (`CNo`),
  CONSTRAINT `FK_oa_studentcourse_oa_student` FOREIGN KEY (`SSID`) REFERENCES `oa_student` (`SSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityoa.oa_studentcourse 的数据：~4 rows (大约)
DELETE FROM `oa_studentcourse`;
/*!40000 ALTER TABLE `oa_studentcourse` DISABLE KEYS */;
INSERT INTO `oa_studentcourse` (`CNo`, `SSID`) VALUES
	(1, '1'),
	(1, '2'),
	(2, '1'),
	(3, '1');
/*!40000 ALTER TABLE `oa_studentcourse` ENABLE KEYS */;


-- 导出 cityoaapp 的数据库结构
CREATE DATABASE IF NOT EXISTS `cityoaapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cityoaapp`;

-- 导出  表 cityoaapp.employee 结构
CREATE TABLE IF NOT EXISTS `employee` (
  `employeeid` varchar(20) NOT NULL COMMENT '鍛樺伐ID',
  `Ename` varchar(20) DEFAULT NULL COMMENT '鍛樺伐濮撳悕',
  `SEX` varchar(2) DEFAULT NULL COMMENT '鎬у埆',
  `Birthday` datetime DEFAULT NULL COMMENT '鐢熸棩 ',
  `EMPAGE` int(11) DEFAULT NULL COMMENT '骞撮緞',
  `SALARY` decimal(12,2) DEFAULT NULL COMMENT '宸ヨ祫',
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityoaapp.employee 的数据：~3 rows (大约)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`employeeid`, `Ename`, `SEX`, `Birthday`, `EMPAGE`, `SALARY`) VALUES
	('1', '张三', '男', '2020-03-17 00:00:00', 20, 2000.00),
	('2', '李四', '男', '1999-02-02 00:00:00', 20, 12345.00),
	('3', '王五', '男', '2020-03-11 00:00:00', 20, 2000.00);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- 导出 cityoaspring 的数据库结构
CREATE DATABASE IF NOT EXISTS `cityoaspring` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cityoaspring`;

-- 导出  表 cityoaspring.oa_employee 结构
CREATE TABLE IF NOT EXISTS `oa_employee` (
  `EID` varchar(20) NOT NULL COMMENT '员工账号',
  `EPASS` varchar(20) DEFAULT NULL COMMENT '员工密码',
  `EName` varchar(20) DEFAULT NULL COMMENT '员工姓名',
  `AGE` int(11) DEFAULT NULL COMMENT '年龄',
  `SALARY` decimal(10,2) DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  cityoaspring.oa_employee 的数据：~7 rows (大约)
DELETE FROM `oa_employee`;
/*!40000 ALTER TABLE `oa_employee` DISABLE KEYS */;
INSERT INTO `oa_employee` (`EID`, `EPASS`, `EName`, `AGE`, `SALARY`) VALUES
	('1', '123456', '张三', 23, 4000.00),
	('2', '234567', '李四', 25, 3000.00),
	('3', '1234567', '王五', 33, 4000.00),
	('4', '234567', '丁六', 20, 3000.00),
	('5', '45678', '丙', 35, 5000.00),
	('6', '12345', '张三', 22, 5000.00),
	('7', '12345', '张三', 22, 5000.00);
/*!40000 ALTER TABLE `oa_employee` ENABLE KEYS */;


-- 导出 citytb 的数据库结构
CREATE DATABASE IF NOT EXISTS `citytb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `citytb`;

-- 导出  表 citytb.tb_orders 结构
CREATE TABLE IF NOT EXISTS `tb_orders` (
  `OrderNo` int(11) NOT NULL AUTO_INCREMENT COMMENT '璁㈠崟缂栧彿',
  `OrderDATE` date DEFAULT NULL COMMENT '璁㈠崟鏃ユ湡',
  `Price` decimal(10,2) DEFAULT NULL COMMENT '浜у搧鍗曚环',
  `QTY` int(11) DEFAULT NULL COMMENT '浜у搧鏁伴噺',
  `CNAME` varchar(20) DEFAULT NULL COMMENT '瀹㈡埛鍚嶇О',
  PRIMARY KEY (`OrderNo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  citytb.tb_orders 的数据：~6 rows (大约)
DELETE FROM `tb_orders`;
/*!40000 ALTER TABLE `tb_orders` DISABLE KEYS */;
INSERT INTO `tb_orders` (`OrderNo`, `OrderDATE`, `Price`, `QTY`, `CNAME`) VALUES
	(1, '2019-04-17', 1.00, 100, '张三'),
	(2, '2019-02-17', 2.00, 100, '张四'),
	(3, '2019-03-17', 4.00, 100, '王五'),
	(4, '2020-03-17', 1.00, 100, '王六'),
	(5, '2020-04-17', 2.00, 100, '丙七'),
	(6, '2020-04-14', 3.00, 100, '丙八');
/*!40000 ALTER TABLE `tb_orders` ENABLE KEYS */;


-- 导出 saperp 的数据库结构
CREATE DATABASE IF NOT EXISTS `saperp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `saperp`;

-- 导出  表 saperp.sap_product 结构
CREATE TABLE IF NOT EXISTS `sap_product` (
  `pno` int(11) NOT NULL AUTO_INCREMENT COMMENT '浜у搧缂栧彿',
  `pcode` varchar(20) DEFAULT NULL COMMENT '浜у搧缂栫爜',
  `pname` varchar(100) DEFAULT NULL COMMENT '浜у搧鍚嶇О',
  `pdate` datetime DEFAULT NULL COMMENT '鐢熶骇鏃ユ湡',
  `unitprice` decimal(12,2) DEFAULT NULL COMMENT '鍗曚环',
  `qtyinstock` decimal(10,2) DEFAULT NULL COMMENT '搴撳瓨鏁伴噺',
  PRIMARY KEY (`pno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  saperp.sap_product 的数据：~2 rows (大约)
DELETE FROM `sap_product`;
/*!40000 ALTER TABLE `sap_product` DISABLE KEYS */;
INSERT INTO `sap_product` (`pno`, `pcode`, `pname`, `pdate`, `unitprice`, `qtyinstock`) VALUES
	(1, '1', '啊', '2020-03-11 23:59:00', 100.00, 2000.00),
	(2, '2', '苹果', '2020-03-12 23:59:00', 1000.00, 10000.00);
/*!40000 ALTER TABLE `sap_product` ENABLE KEYS */;


-- 导出 ssm02 的数据库结构
CREATE DATABASE IF NOT EXISTS `ssm02` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ssm02`;

-- 导出  表 ssm02.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `truename` varchar(20) DEFAULT '0',
  `gender` varchar(20) DEFAULT '0',
  `nation` varchar(10) DEFAULT NULL,
  `birth` varchar(50) DEFAULT NULL,
  `identify` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `info` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  ssm02.customer 的数据：~2 rows (大约)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `truename`, `gender`, `nation`, `birth`, `identify`, `address`, `info`) VALUES
	(1, '阿云啊', '男', '汉', '1999年10月01日', '87897564645555545', '辽宁省大连市', 'D:\\workspace\\images\\sound1.mp3'),
	(2, '朴槿惠', '女', '汉', '1919年10月8日', '310228197410000', '上海市金山区南门村8号', 'D:\\workspace\\images\\sound1.mp3');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 导出  表 ssm02.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  ssm02.user 的数据：~3 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`) VALUES
	(1, '1', '1'),
	(2, '蔡徐坤', '唱跳rap'),
	(3, '罗志祥', '12345');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
