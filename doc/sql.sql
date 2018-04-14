/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.17-log : Database - lingshi_salesmgr
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lingshi_salesmgr` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lingshi_salesmgr`;

/*Table structure for table `addresslist` */

DROP TABLE IF EXISTS `addresslist`;

CREATE TABLE `addresslist` (
  `addressListId` varchar(32) NOT NULL COMMENT '通讯录编号',
  `addressListName` varchar(20) NOT NULL DEFAULT '' COMMENT '通讯录名称',
  `addressListPhone` varchar(20) NOT NULL DEFAULT '' COMMENT '通讯录电话',
  `addressListTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '通讯录创建时间',
  PRIMARY KEY (`addressListId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `addresslist` */

insert  into `addresslist`(`addressListId`,`addressListName`,`addressListPhone`,`addressListTime`) values ('A56211370089912','小小','17612145896','2014-01-01 00:00:00'),('A95511371387513','大大','17548523695','2014-01-01 00:00:00');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `goodsId` varchar(32) NOT NULL COMMENT '商品编号',
  `goodsName` varchar(40) NOT NULL DEFAULT '' COMMENT '商品名称',
  `goodsCost` float NOT NULL DEFAULT '0' COMMENT '商品成本',
  `goodsPrice` float NOT NULL DEFAULT '0' COMMENT '售价',
  `goodsCount` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `goodsTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '创建商品时间',
  `goodsPercentage` float NOT NULL DEFAULT '0' COMMENT '商品提成',
  `goodsKindId` varchar(32) NOT NULL COMMENT '商品种类编号',
  `goodsImgUrl` varchar(100) NOT NULL DEFAULT '' COMMENT '预览图Url',
  `goodsContents` varchar(2000) NOT NULL DEFAULT '' COMMENT '商品介绍',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`goodsId`,`goodsName`,`goodsCost`,`goodsPrice`,`goodsCount`,`goodsTime`,`goodsPercentage`,`goodsKindId`,`goodsImgUrl`,`goodsContents`) values ('LG54113260413514','真维斯被套',50,80,97,'2018-03-27 13:26:04',10,'LG72614183633411','','我是被套'),('LG61713251421311','雕牌洗衣粉',8,10,486,'2018-03-27 13:25:14',0.5,'LG16314185305513','','<p style=\"text-align: center;\"><b>我雕牌洗衣粉<img src=\"http://localhost:8091/WebContent/Contents/lib/layui/images/face/16.gif\" alt=\"[太开心]\"></b></p>');

/*Table structure for table `goodsimg` */

DROP TABLE IF EXISTS `goodsimg`;

CREATE TABLE `goodsimg` (
  `goodsImgId` varchar(32) NOT NULL COMMENT '编号',
  `goodsImgUrl` varchar(100) NOT NULL DEFAULT '' COMMENT '商品图片url',
  `goodsId` varchar(32) NOT NULL DEFAULT '' COMMENT '商品id',
  PRIMARY KEY (`goodsImgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsimg` */

insert  into `goodsimg`(`goodsImgId`,`goodsImgUrl`,`goodsId`) values ('LG10314521639310','/Uploadfile/goodsimg/LG91513351239716.png','LG61713251421311'),('LG12814521639411','/Uploadfile/goodsimg/LG25713250990310.png','LG61713251421311'),('LG35813260414615','/Uploadfile/goodsimg/LG39013254957513.png','LG54113260413514');

/*Table structure for table `goodskind` */

DROP TABLE IF EXISTS `goodskind`;

CREATE TABLE `goodskind` (
  `goodsKindId` varchar(32) NOT NULL COMMENT '编号',
  `goodsKindName` varchar(20) NOT NULL COMMENT '商品分类名称',
  `goodsKindTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`goodsKindId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodskind` */

insert  into `goodskind`(`goodsKindId`,`goodsKindName`,`goodsKindTime`) values ('LG16314185305513','清洁','2014-01-01 00:00:00'),('LG72614183633411','床具','2014-01-01 00:00:00'),('LG85714184497412','厨具','2014-01-01 00:00:00'),('LG87914190419914','衣服','2014-01-01 00:00:00');

/*Table structure for table `orderform` */

DROP TABLE IF EXISTS `orderform`;

CREATE TABLE `orderform` (
  `orderId` varchar(32) NOT NULL COMMENT '订单号',
  `orderTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '订单时间',
  `orderPrice` float NOT NULL DEFAULT '0' COMMENT '订单金额',
  `userId` varchar(32) NOT NULL COMMENT '售出人员编号',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderform` */

insert  into `orderform`(`orderId`,`orderTime`,`orderPrice`,`userId`) values ('LG61914303108112','2018-03-28 14:30:31',80,'A96311013517616');

/*Table structure for table `ordergoods` */

DROP TABLE IF EXISTS `ordergoods`;

CREATE TABLE `ordergoods` (
  `orderGoodsId` varchar(32) NOT NULL COMMENT '订单物品编号',
  `goodsId` varchar(32) NOT NULL COMMENT '物品编号',
  `orderGoodsName` varchar(20) NOT NULL COMMENT '售出时名称',
  `orderGoodsCost` float NOT NULL DEFAULT '0' COMMENT '售出时成本',
  `orderGoodsPrice` float NOT NULL DEFAULT '0' COMMENT '售出时售价',
  `orderGoodsCount` int(11) NOT NULL DEFAULT '0' COMMENT '售出数量',
  `orderGoodsPercentage` float NOT NULL DEFAULT '0' COMMENT '售出时提成',
  `orderId` varchar(32) NOT NULL COMMENT '订单编号',
  PRIMARY KEY (`orderGoodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ordergoods` */

insert  into `ordergoods`(`orderGoodsId`,`goodsId`,`orderGoodsName`,`orderGoodsCost`,`orderGoodsPrice`,`orderGoodsCount`,`orderGoodsPercentage`,`orderId`) values ('LG68514303108613','LG54113260413514','真维斯被套',50,80,1,10,'LG61914303108112');

/*Table structure for table `syslog` */

DROP TABLE IF EXISTS `syslog`;

CREATE TABLE `syslog` (
  `sysLogId` varchar(32) NOT NULL COMMENT '日志编号',
  `sysLogContent` varchar(200) NOT NULL DEFAULT '' COMMENT '日志内容',
  `sysLogTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '日志时间',
  `userId` varchar(32) NOT NULL COMMENT '操作人编号',
  PRIMARY KEY (`sysLogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `syslog` */

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userId` varchar(32) NOT NULL COMMENT '用户编号',
  `userName` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `realName` varchar(20) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `createTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '创建时间',
  `wages` float NOT NULL DEFAULT '0' COMMENT '基本工资',
  `userType` int(11) NOT NULL DEFAULT '1' COMMENT '用户类型（-1管理员 1分销员 2采购员）',
  `userHeadImgUrl` varchar(100) NOT NULL DEFAULT '' COMMENT '用户头像url',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userId`,`userName`,`password`,`realName`,`createTime`,`wages`,`userType`,`userHeadImgUrl`) values ('A47611123321712','zhoujielun','202CB962AC59075B964B07152D234B70','周杰伦','2014-01-01 00:00:00',3000,2,''),('A76511001709613','xiaoxiao','202CB962AC59075B964B07152D234B70','小小','2014-01-01 00:00:00',3000,1,'/Uploadfile/userheads/LG81014133529310.png'),('A84511110453511','lingjunjie','202CB962AC59075B964B07152D234B70','林俊杰','2014-01-01 00:00:00',3000,2,'/Uploadfile/userheads/LG31811110141710.png'),('A96311013517616','dada','202CB962AC59075B964B07152D234B70','大大','2014-01-01 00:00:00',3000,1,'/Uploadfile/userheads/LG94411013455915.png'),('R00001','root','C4CA4238A0B923820DCC509A6F75849B','我是超管','2014-01-01 00:00:00',0,-1,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
