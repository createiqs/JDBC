create table employees(
    eid int unsigned,
    ename varchar(250) not null,
    esal decimal(12, 2) not null,
    email varchar(300) unique,
    doj date not null,
    constraint eid_pk primary key(eid)  
        );