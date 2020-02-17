CREATE TABLE courses_clients_db.clients (
	id bigint not null auto_increment, 
	create_at date, 
	email varchar(255), 
	name varchar(255), 
	surname varchar(255), 
	primary key (id)
) engine=InnoDB;