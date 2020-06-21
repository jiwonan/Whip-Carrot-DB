DROP TABLE IF EXISTS user;

CREATE TABLE user (
	id bigint(20) PRIMARY KEY AUTO_INCREMENT,
	user_id varchar(20) NOT NULL,
	user_pw varchar(25) NOT NULL,
	nickname varchar(50) NOT NULL,
	profile varchar(30),
	carrot int(20) NOT NULL
)