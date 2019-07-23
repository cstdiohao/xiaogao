CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `realName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `id_table`(
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(32) NOT NULL,
  `index` int(32) NOT NULL,
  primary key (`id`),
	unique key `key_name_index` (`key_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;