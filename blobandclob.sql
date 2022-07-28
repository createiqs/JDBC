create table createiq_docs(
id int primary key,
name varchar(255),
text_doc longtext,
logo blob,
date_of_creation date,
comments varchar(50)
);

ALTER TABLE createiq_docs MODIFY logo MEDIUMBLOB;

 
insert into createiq_docs values(101, 'oops',  load_file('F:\\test.txt'), load_file('F:\\sonu.png'), '2022-07-28', 'testing');	

SELECT * FROM spring_jdbc_db.createiq_docs;