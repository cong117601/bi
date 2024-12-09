# 建表脚本
# @author <a href="https://github.com/liyupi">程序员鱼皮</a>
# @from <a href="https://yupi.icu">编程导航知识星球</a>

-- 创建库
create database if not exists bi;

-- 切换库
use bi;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    index idx_userAccount (userAccount)
    ) comment '用户' collate = utf8mb4_unicode_ci;

-- 图表表
create table if not exists chart
(
    id           bigint auto_increment comment 'id' primary key,
    goal				 text  null comment '分析目标',
    `name`               varchar(128) null comment '图表名称',
    chartData    text  null comment '图表数据',
    chartType	   varchar(128) null comment '图表类型',
    genChart		 text	 null comment '生成的图表数据',
    genResult		 text	 null comment '生成的分析结论',
    status       varchar(128) not null default 'wait' comment 'wait,running,succeed,failed',
    execMessage  text   null comment '执行信息',
    userId       bigint null comment '创建用户 id',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '图表信息表' collate = utf8mb4_unicode_ci;

CREATE TABLE `chart` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                         `goal` text COLLATE utf8mb4_unicode_ci COMMENT '分析目标',
                         `name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图表名称',
                         `chartData` mediumtext COLLATE utf8mb4_unicode_ci COMMENT '图表数据',
                         `chartType` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图表类型',
                         `genChart` text COLLATE utf8mb4_unicode_ci COMMENT '生成的图表数据',
                         `genResult` text COLLATE utf8mb4_unicode_ci COMMENT '生成的分析结论',
                         `status` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'wait' COMMENT 'wait,running,succeed,failed',
                         `execMessage` text COLLATE utf8mb4_unicode_ci COMMENT '执行信息',
                         `userId` bigint(20) DEFAULT NULL COMMENT '创建用户 id',
                         `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         `isDelete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1865057779530723330 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='图表信息表';