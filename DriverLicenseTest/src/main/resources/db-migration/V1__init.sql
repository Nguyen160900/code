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
  year_of_birth date,
  gender boolean,
  create_date datetime,
  CONSTRAINT fk_role_id_roles_id  FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE IF NOT EXISTS categorys (
  id INT PRIMARY KEY AUTO_INCREMENT,
  category_name VARCHAR(255),
  descriptions TEXT
);

CREATE TABLE IF NOT EXISTS levels (
  id INT PRIMARY KEY AUTO_INCREMENT,
  level_name VARCHAR(255),
  descriptions TEXT,
  time_test INT,
  category_id INT,
  CONSTRAINT fk_level_category_category_id FOREIGN KEY (category_id) REFERENCES categorys (id)
);

CREATE TABLE IF NOT EXISTS questions (
  id INT PRIMARY KEY AUTO_INCREMENT,
  question_name VARCHAR(255),
  level_id INT,
  type BOOLEAN,
  image TEXT,
  CONSTRAINT fk_question_level_level_id FOREIGN KEY (level_id) REFERENCES levels (id)
);

CREATE TABLE IF NOT EXISTS answers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  question_id INT,
  name VARCHAR(255),
  CONSTRAINT fk_answer_question_question_id FOREIGN KEY (question_id) REFERENCES questions (id)
);

CREATE TABLE IF NOT EXISTS correct_answer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  answer_id INT,
  question_id INT,
  CONSTRAINT fk_correct_answer_question_question_id FOREIGN KEY (question_id) REFERENCES questions (id),
  CONSTRAINT fk_correct_answer_answer_answer_id FOREIGN KEY (answer_id) REFERENCES answers (id)
);

CREATE TABLE IF NOT EXISTS history_test (
  id INT PRIMARY KEY AUTO_INCREMENT,
  level_id INT,
  user_id INT,
  time_save DATETIME,
  status VARCHAR(255),
  point INT,
  CONSTRAINT fk_history_test_users_user_id FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_history_test_levels_level_id FOREIGN KEY (level_id) REFERENCES levels (id)
);

CREATE TABLE IF NOT EXISTS user_answer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  question_id INT,
  answer_id INT,
  history_test_id INT,
  CONSTRAINT fk_user_answer_history_test_history_test_id FOREIGN KEY (history_test_id) REFERENCES history_test (id),
  CONSTRAINT fk_user_answer_question_question_id FOREIGN KEY (question_id) REFERENCES questions (id)
);

CREATE TABLE IF NOT EXISTS fees (
  id INT PRIMARY KEY AUTO_INCREMENT,
  application INT,
  theoretical INT,
  pratice INT,
  card INT,
  time_save date,
  level_id INT,
  CONSTRAINT fk_fees_levels_level_id FOREIGN KEY (level_id) REFERENCES levels (id)
);

CREATE TABLE IF NOT EXISTS tests_info (
  id INT PRIMARY KEY AUTO_INCREMENT,
  date_real_test datetime,
  date_mock_test datetime,
  date_open datetime,
  date_close datetime,
  number_subscription INT,
  level_id INT,
  CONSTRAINT fk_tests_info_levels_level_id FOREIGN KEY (level_id) REFERENCES levels (id)
);

CREATE TABLE IF NOT EXISTS user_test (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  test_info_id INT,
  time_subscriptions datetime,
  CONSTRAINT fk_user_test_users_user_id FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_user_test_tests_info_test_info_id FOREIGN KEY (test_info_id) REFERENCES tests_info (id)
);

CREATE TABLE IF NOT EXISTS study_app (
  id INT PRIMARY KEY AUTO_INCREMENT,
  registered_address VARCHAR(255),
  current_address VARCHAR(255),
  citizen_identification VARCHAR(255),
  date_issue date,
  place_issue VARCHAR(255),
  number_driver_license VARCHAR(255),
  date_issue_driver date,
  level_name VARCHAR(255),
  ageney VARCHAR(255),
  description VARCHAR(255),
  status_apply_integration boolean,
  user_test_id INT,
  create_date datetime,
  image TEXT,
  CONSTRAINT fk_study_app_users_user_id FOREIGN KEY (user_test_id) REFERENCES user_test (id)
);



