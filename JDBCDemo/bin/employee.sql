create table employee( eid int unsigned not null primary key 
, ename varchar(45) not null, esal decimal(12, 2) default '10000.00', 
mail_id varchar(150) not null unique);