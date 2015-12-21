CREATE DATABASE  IF NOT EXISTS `billionfun` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `billionfun`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: billionfun
-- ------------------------------------------------------
-- Server version	5.5.47

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_data_dictionary`
--

DROP TABLE IF EXISTS `sys_data_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '字典名称',
  `code` varchar(32) DEFAULT NULL COMMENT '字典编号',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `status` int(11) DEFAULT NULL COMMENT '状态：0-无效1-有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_data_dictionary`
--

LOCK TABLES `sys_data_dictionary` WRITE;
/*!40000 ALTER TABLE `sys_data_dictionary` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_data_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_func`
--

DROP TABLE IF EXISTS `sys_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_func` (
  `id` varchar(16) NOT NULL COMMENT '功能编号',
  `parent_id` varchar(16) DEFAULT NULL COMMENT '父功能编号',
  `name` varchar(32) DEFAULT NULL COMMENT '功能名称',
  `level` int(11) DEFAULT NULL COMMENT '功能级别',
  `type` int(11) DEFAULT NULL COMMENT '功能类型1.菜单2-按钮',
  `url` varchar(256) DEFAULT NULL COMMENT '跳转url',
  `status` int(11) DEFAULT NULL COMMENT '状态：0-无效1-有效',
  `img_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_func`
--

LOCK TABLES `sys_func` WRITE;
/*!40000 ALTER TABLE `sys_func` DISABLE KEYS */;
INSERT INTO `sys_func` VALUES ('99','0','系统模块',1,NULL,NULL,1,NULL),('9901','99','用户管理',2,NULL,'system/searchSysUser.html?funcode=9901',1,NULL),('990101','9901','新增',3,1,'system/toAddSysUser.html',1,'/images/add.jpg'),('990102','9901','修改',3,2,'doModify(\'system/toModifySysUser.html\',\'sysUser.id\')',1,'/images/modify.jpg'),('990103','9901','删除',3,2,'doRemove(\'system/removesSysUser.html\')',1,'/images/delete.jpg'),('9902','99','角色管理',2,NULL,'system/searchSysRole.html?funcode=9902',1,NULL),('990201','9902','新增',3,1,'system/toAddSysRole.html',1,'/images/add.jpg'),('990202','9902','修改',3,2,'doModify(\'system/toModifySysRole.html\',\'sysRole.id\')',1,'/images/modify.jpg'),('990203','9902','删除',3,2,'doRemove(\'system/removesSysRole.html\')',1,'/images/delete.jpg'),('9903','99','功能菜单管理',2,1,'system/searchSysFunc.html?funcode=9903',1,NULL),('990301','9903','新增',3,1,'system/toAddSysFunc.html',1,'/images/add.jpg'),('990302','9903','修改',3,2,'doModify(\'system/toModifySysFunc.html\',\'sysFunc.id\')',1,'/images/modify.jpg'),('990303','9903','删除',3,2,'doRemove(\'system/removesSysFunc.html\')',1,'/images/delete.jpg');
/*!40000 ALTER TABLE `sys_func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `LOG_NAME` varchar(1000) DEFAULT NULL COMMENT '名称',
  `LOG_IP` varchar(1000) DEFAULT NULL COMMENT 'ip',
  `LOG_DATE` varchar(1000) DEFAULT NULL COMMENT '时间',
  `LOG_LEVEL` varchar(1000) DEFAULT NULL COMMENT '级别',
  `LOG_CLASS` varchar(1000) DEFAULT NULL COMMENT '类',
  `LOG_MESSAGE` varchar(1000) DEFAULT NULL COMMENT '信息',
  `LOG_DESC` varchar(1000) DEFAULT NULL COMMENT '详细描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1,'Administrator','192.168.1.1','2015-12-20 18:08:11,354','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','7'),(2,'Administrator','192.168.1.1','2015-12-20 18:22:20,588','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:25)'),(3,'Administrator','192.168.1.1','2015-12-20 18:27:29,968','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:25)'),(4,'Administrator','192.168.1.1','2015-12-20 18:27:41,961','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:25)'),(5,'Administrator','','2015/12/20 20:35:11','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:25)'),(6,'Administrator','','2015/12/20 23:03:28','ERROR','org.springframework.web.context.ContextLoader','Context initialization failed','org.springframework.web.context.ContextLoader.initWebApplicationContext(ContextLoader.java:331)'),(7,'Administrator','','2015/12/20 23:09:28','ERROR','org.springframework.web.context.ContextLoader','Context initialization failed','org.springframework.web.context.ContextLoader.initWebApplicationContext(ContextLoader.java:331)'),(8,'Administrator','','2015/12/20 23:21:57','ERROR','org.springframework.web.context.ContextLoader','Context initialization failed','org.springframework.web.context.ContextLoader.initWebApplicationContext(ContextLoader.java:331)'),(9,'Administrator','','2015/12/20 23:23:43','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:24)'),(10,'Administrator','0:0:0:0:0:0:0:1','2015/12/20 23:25:59','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:24)'),(11,'Administrator','','2015/12/20 23:31:37','ERROR','org.springframework.web.context.ContextLoader','Context initialization failed','org.springframework.web.context.ContextLoader.initWebApplicationContext(ContextLoader.java:331)'),(12,'Administrator','0:0:0:0:0:0:0:1','2015/12/20 23:39:18','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:24)'),(13,'Administrator','0:0:0:0:0:0:0:1','2015/12/20 23:43:42','ERROR','com.billionfun.bms.product.mall.controllers.DefaultController','-----------error-------------','com.billionfun.bms.product.mall.controllers.DefaultController.login(DefaultController.java:24)');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(32) DEFAULT NULL COMMENT '角色编码',
  `status` int(11) DEFAULT NULL COMMENT '状态：1-有效0-无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'系统管理员','ROLE_ADMIN',1),(2,'普通用户','ROLE_USER',1),(1000,'超级管理员','ROLE_SA',1);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_func`
--

DROP TABLE IF EXISTS `sys_role_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_func` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `func_id` varchar(16) NOT NULL COMMENT '功能id',
  PRIMARY KEY (`role_id`,`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色功能关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_func`
--

LOCK TABLES `sys_role_func` WRITE;
/*!40000 ALTER TABLE `sys_role_func` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `full_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型1-系统用户',
  `prov_code` int(11) DEFAULT NULL COMMENT '省编号',
  `city_code` int(11) DEFAULT NULL COMMENT '市编号',
  `effect_start_date` date DEFAULT NULL COMMENT '用户生效开始时间',
  `effect_end_date` date DEFAULT NULL COMMENT '用户生效结束时间',
  `telephone` varchar(32) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(256) DEFAULT NULL COMMENT '详细地址',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `create_optr` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modify_optr` varchar(32) DEFAULT NULL COMMENT '修改人',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT NULL COMMENT '状态：1-有效 0-无效',
  `dist_code` int(11) DEFAULT NULL COMMENT '区编号',
  `cityCode` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `createOptr` varchar(255) DEFAULT NULL,
  `distCode` int(11) DEFAULT NULL,
  `effectEndDate` datetime DEFAULT NULL,
  `effectStartDate` datetime DEFAULT NULL,
  `modifyOptr` varchar(255) DEFAULT NULL,
  `provCode` int(11) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'zhuyi','1353e154e737b532853783c8b726cdb1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'admin','password','fullName',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1000);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-21 11:40:55
