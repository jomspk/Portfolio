CREATE TABLE IF NOT EXISTS users (
  id serial,
  user_id varchar(64) NOT NULL,
  password varchar(64) NOT NULL,
  username varchar(64),
  PRIMARY KEY(id)
);