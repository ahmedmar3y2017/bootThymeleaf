DROP TABLE IF EXISTS `person`;
CREATE TABLE  `person` (
  `id` int(11) NOT NULL auto_increment,
  `address` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user`;
CREATE TABLE  `user` (
  `id` int(11) NOT NULL auto_increment,
  `password` varchar(225) NOT NULL,
  `role` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;