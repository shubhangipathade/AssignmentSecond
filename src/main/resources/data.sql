DROP TABLE IF EXISTS SKILL_ENTITY;

CREATE TABLE SKILL_ENTITY (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   skill VARCHAR(250),
);

INSERT into SKILL_ENTITY(id, skill) VALUES (1, 'ReactJS');
INSERT into SKILL_ENTITY(id, skill) VALUES (2, 'Java ');
INSERT into SKILL_ENTITY(id, skill) VALUES (3, 'JavaScript');
INSERT into SKILL_ENTITY(id, skill) VALUES (4, 'Node JS');
INSERT into SKILL_ENTITY(id, skill) VALUES (5, 'Angular JS');
INSERT into SKILL_ENTITY(id, skill) VALUES (6, 'PHP');

INSERT into DEVELOPER_ENTITY(email, firstname, lastname, skills)
VALUES ('shubh10@gmail.com','Shubhangi','Pathade','Java');

INSERT into DEVELOPER_ENTITY(email, firstname, lastname, skills)
VALUES ('james290@gmail.com','James','Paul','Kotlin');


INSERT into DEVELOPER_ENTITY(email, firstname, lastname, skills)
VALUES ('vishnu54@gmail.com','Vishnu','Lembhe','ReactNative');


INSERT into DEVELOPER_ENTITY(email, firstname, lastname, skills)
VALUES ('advik99@gmail.com','Advik','Paul','Oracle');
