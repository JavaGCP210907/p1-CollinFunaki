--Create Employee reimbursement system tables
CREATE TABLE ers_user_roles (
	user_role_id int PRIMARY KEY,
	user_role varchar(10)
);

CREATE TABLE ers_users (
	users_id int PRIMARY KEY,
	username varchar(50),
	password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150),
	user_role_id_fk int REFERENCES ers_user_roles (user_role_id)
);

CREATE TABLE ers_reimbursement_type (
	reimb_type_id int PRIMARY KEY,
	reimb_type varchar(10)
);

CREATE TABLE ers_reimburement_status (
	reimb_status_id int PRIMARY KEY,
	reimb_status varchar(10)
);

CREATE TABLE ers_reimbursement (
	reimb_id int PRIMARY KEY,
	reimb_amount int,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(100),
	reimb_receipt bytea,
	reimb_author int,
	reimb_resolver int,
	reimb_status_id int,
	reimb_type_id int
);


DROP TABLE ers_users;
DROP TABLE ers_user_roles;
DROP TABLE ers_reimbursement;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_reimburement_status;