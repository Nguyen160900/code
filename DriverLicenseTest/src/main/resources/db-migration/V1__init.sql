CREATE TABLE IF NOT EXISTS roles (
  id INT PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(255),
  descriptions TEXT
);

CREATE TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  is_enabled boolean,
  role_id INT,
  create_date datetime,
  CONSTRAINT fk_role_id_roles_id  FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE IF NOT EXISTS levels (
  id INT PRIMARY KEY AUTO_INCREMENT,
  level_name VARCHAR(255),
  descriptions TEXT
);

CREATE TABLE IF NOT EXISTS questions (
  id INT PRIMARY KEY AUTO_INCREMENT,
  question_name VARCHAR(255),
  level_id INT,
  type BOOLEAN,
  CONSTRAINT fk_question_level_level_id FOREIGN KEY (level_id) REFERENCES levels (id)
);

CREATE TABLE IF NOT EXISTS answers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  question_id INT,
  name VARCHAR(255),
  CONSTRAINT fk_answer_question_question_id FOREIGN KEY (question_id) REFERENCES questions (id)
);

CREATE TABLE IF NOT EXISTS user_answer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  question_id INT,
  answer_id INT,
  user_id INT,
  CONSTRAINT fk_user_answer_users_user_id FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_user_answer_question_question_id FOREIGN KEY (question_id) REFERENCES questions (id)
);