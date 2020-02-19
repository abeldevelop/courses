INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Sudamerica');
INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Centroamerica');
INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Norteamerica');
INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Europa');
INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Asia');
INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Africa');
INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Oceania');
INSERT INTO `courses_clients_db`.`regions` (`name`) VALUES ('Antartida');


INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email1@mail.com', 'Name 1', 'Surname 1', 1);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email2@mail.com', 'Name 2', 'Surname 2', 2);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email3@mail.com', 'Name 3', 'Surname 3', 3);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email4@mail.com', 'Name 4', 'Surname 4', 4);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email5@mail.com', 'Name 5', 'Surname 5', 2);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email6@mail.com', 'Name 6', 'Surname 6', 8);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email7@mail.com', 'Name 7', 'Surname 7', 7);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email8@mail.com', 'Name 8', 'Surname 8', 5);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email9@mail.com', 'Name 9', 'Surname 9', 6);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email10@mail.com', 'Name 10', 'Surname 10', 5);
INSERT INTO `courses_clients_db`.`clients` (`create_at`, `email`, `name`, `surname`, `region_id`) VALUES ('2020-02-15', 'email11@mail.com', 'Name 11', 'Surname 11', 4);



INSERT INTO `courses_clients_db`.`roles` (`name`) VALUES ('ROLE_USER');
INSERT INTO `courses_clients_db`.`roles` (`name`) VALUES ('ROLE_ADMIN');

INSERT INTO `courses_clients_db`.`users` (`username`, `password`, `name`, `surname`, `email`, `enabled`) VALUES ('abel', '$2a$10$6UgciD1Ua7Jao6xYvsOH7.ADpM9M.zLXtVZs6dMJGnZj9AVjNDpNO', 'Abel', 'Abel', 'abel@abel.com', 1);
INSERT INTO `courses_clients_db`.`users` (`username`, `password`, `name`, `surname`, `email`, `enabled`) VALUES ('admin', '$2a$10$6UgciD1Ua7Jao6xYvsOH7.ADpM9M.zLXtVZs6dMJGnZj9AVjNDpNO', 'Admin', 'Admin', 'admin@admin.com', 1);

INSERT INTO `courses_clients_db`.`users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `courses_clients_db`.`users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `courses_clients_db`.`users_roles` (`user_id`, `role_id`) VALUES (2, 1);