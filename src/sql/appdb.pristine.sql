CREATE SCHEMA appdb;
use appdb;

CREATE TABLE IF NOT EXISTS students
 (
   student_id                    INT(11)       NOT NULL   , 
   lastname                      VARCHAR(30)       NULL   , 
   firstname                     VARCHAR(20)       NULL   , 
   gender_code                   VARCHAR(1)        NULL   , 
   birth_dttm                    DATETIME          NULL   , 
   PRIMARY KEY (student_id) 
 ) ENGINE = INNODB;

