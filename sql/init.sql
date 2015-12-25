CREATE TABLE user (
  id varchar(32) NOT NULL,
  username varchar(255) DEFAULT NULL,
  password varchar(32) DEFAULT NULL,
  nickname varchar(255) DEFAULT NULL,
  gender char(1) DEFAULT NULL,
  email varchar(32) DEFAULT NULL,
  ctime varchar(19) DEFAULT NULL,
  PRIMARY KEY (id)
) CHARSET=utf8;