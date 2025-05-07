
CREATE TABLE `test_case` (
  `test_case_id` varchar(36) NOT NULL COMMENT '测试用例ID',
  `name` varchar(255) NOT NULL COMMENT '测试用例的名字',
  `version` varchar(30) DEFAULT NULL COMMENT 'Testcase自己的版本号',
  `description` text DEFAULT NULL COMMENT '测试例子的描述',
  `test_scenario_road` text DEFAULT NULL COMMENT '测试道路与fast api后端连接',
  `test_scenario_scenario` text DEFAULT NULL COMMENT '测试场景信息与fast api数据库连接',
  `precondition` text NOT NULL COMMENT '前置条件',
  `test_steps` text NOT NULL COMMENT '测试步骤',
  `test_level` enum('Cufu','System','Component') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '测试level层级',
  `test_instance` enum('G-Hi!','System_Hi!','Vehicle') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '测试实例',
  `signals` Json DEFAULT NULL COMMENT '主要信号的描述',
  `comments` Json DEFAULT NULL COMMENT '测试评价或者状态说明',
  `sketch_picture` JSON DEFAULT NULL COMMENT '图片存储桶路径',
  `feature` text DEFAULT NULL COMMENT '功能',
  `Executable_Case` varchar(36) DEFAULT NULL COMMENT '对象存储主键，对应ECU Test的测试包',
  `Executable_Case_Version` varchar(20) DEFAULT NULL COMMENT 'ET测试包版本',
  `Test_Design_Table` text DEFAULT NULL COMMENT '这个测例所关联的一系列软件版本号，类比requirements.txt',
  `Foreign_ID` VARCHAR(36) DEFAULT NULL COMMENT '用来追溯来自其他外部系统',
PRIMARY KEY (`test_case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `test_task` (
  `task_id` varchar(36) NOT NULL COMMENT '任务唯一标识',
  `task_name` varchar(50) NOT NULL COMMENT '任务名称',
  `test_instance` varchar(255) DEFAULT NULL COMMENT '测试实例',
  `test_compound` text DEFAULT NULL COMMENT '测试实例的ECU版本组合',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开始执行时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '预估结束时间',
  `task_status` enum('创建','计划中','进行中','已完成') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '创建' COMMENT '任务状态',
  `progress` decimal(5,2) DEFAULT '0.00' COMMENT '任务执行进度',
  `test_run` text DEFAULT NULL COMMENT '对应ET的test project',
  `tester` varchar(30) DEFAULT NULL COMMENT '测试员',
  `report_to_whom` varchar(30) NOT NULL COMMENT '任务发起人',
  `date_submit` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `date_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='测试任务表';


CREATE TABLE `test_instance` (
  `instance_id` varchar(36)  NOT NULL,                 -- 测试实例ID
  `bench_name` varchar(50) NOT NULL,                   -- 测试实例名:台架名
  `core_status` varchar(255) DEFAULT NULL,             -- 核心指标:温度
  `power_status` varchar(30) DEFAULT NULL,             -- 电压
  `ecu_hw` text,                                       -- ecu硬件版本信息
  `ecu_sw` text,                                       -- ecu软件版本信息
  `date_submit` timestamp NULL DEFAULT CURRENT_TIMESTAMP, -- 插入时间
  `date_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
  PRIMARY KEY (`instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `test_compound` (
  `compound_id` varchar(36) NOT NULL,
  `ecu_hw` text DEFAULT NULL,
  `ecu_sw` text DEFAULT NULL,
  `date_submit` timestamp NULL DEFAULT CURRENT_TIMESTAMP, -- 插入时间
  `date_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
  PRIMARY KEY (`compound_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3; 

CREATE TABLE `feature_ecu` (
  `f_e_id` varchar(36) NOT NULL,
  `feature` text DEFAULT NULL,
  `ECU` text DEFAULT NULL,
  `date_submit` timestamp NULL DEFAULT CURRENT_TIMESTAMP, -- 插入时间
  `date_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
  PRIMARY KEY (`f_e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3; 

CREATE TABLE `0100_dim_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_key` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `is_2fa_enabled` tinyint DEFAULT '0',
  `is_2fa_required` tinyint DEFAULT '1',
  `totp_secret` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` int unsigned DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `token` varchar(255) NOT NULL,
  `status` boolean DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `all_scenario_release` boolean DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `font_size` varchar(255) DEFAULT NULL,
  `software_setting` json DEFAULT NULL,
  `platform_version` varchar(255) DEFAULT NULL,
  `role` enum('TESTER','DEVELOPER','PM') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `date_submit` timestamp NULL DEFAULT CURRENT_TIMESTAMP, -- 插入时间
  `date_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_key` (`user_key`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;