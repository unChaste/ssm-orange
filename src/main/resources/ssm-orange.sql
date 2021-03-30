create table `user` (
  `id` int not null auto_increment,
  `username` varchar(64) default null,
  `password` varchar(64) default null,
  `nickname` varchar(64) default null,
  `gender` tinyint default 0 COMMENT '0-未知，1-男，2-女',
  `createTime` datetime default null,
  `updateTime` datetime default null,
  primary key (`id`)
) ENGINE = InnoDB default CHARSET=utf8;


select * from user;