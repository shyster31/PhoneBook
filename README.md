CREATE TABLE `phone_book_items` (
	`id` varchar(255) NOT NULL,
	`first_name` varchar(255) NOT NULL,
	`last_name` varchar(255) NOT NULL,
	`patronymic` varchar(255) NOT NULL,
	`phone` varchar(255) NOT NULL,
	`home_phone` varchar(255),
	`adress` varchar(255),
	`email` varchar(255),
	`login` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `phone_book_users` (
	`id` varchar(255) NOT NULL,
	`first_name` varchar(255) NOT NULL,
	`last_name` varchar(255) NOT NULL,
	`patronymic` varchar(255) NOT NULL,
	`login` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);
