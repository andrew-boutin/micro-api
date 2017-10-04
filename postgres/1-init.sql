CREATE TABLE technology(
  id SERIAL NOT NULL PRIMARY KEY,
  title VARCHAR,
  link VARCHAR
);

INSERT INTO technology (title, link) VALUES
  ('Spring', 'https://spring.io/'),
  ('Gradle', 'https://gradle.org/'),
  ('Docker', 'https://www.docker.com/'),
  ('PostgreSQL', 'https://www.postgresql.org/');
