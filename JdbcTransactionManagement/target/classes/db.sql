CREATE TABLE sbi_bank(
  account_no bigint(11) NOT NULL,
  account_balance double default NULL,
  account_type varchar(45) NOT NULL,
  account_holder_name varchar(45) NOT NULL,
  PRIMARY KEY  (account_no)
);
