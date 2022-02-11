CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  user_id varchar(10) NOT NULL,
  password varchar(60) NOT NULL,
  username varchar(50),
  PRIMARY KEY(id)
);