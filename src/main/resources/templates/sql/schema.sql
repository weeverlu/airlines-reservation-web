CREATE TABLE `airlines_node` (
  `id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  `gmt_created` DATETIME NOT NULL ,
  `gmt_modified` DATETIME NOT NULL ,
  `airline_num` VARCHAR(20) NOT NULL ,
  `plane_model` VARCHAR(20) NOT NULL ,
  `num_firstclass` INT NOT NULL ,
  `num_economy` INT NOT NULL ,
  `price_firstclass` INT NOT NULL ,
  `price_economy` INT NOT NULL ,
  `departure_port` VARCHAR(20) NOT NULL ,
  `departure_time` VARCHAR(30) NOT NULL ,
  `arrival_port` VARCHAR(20) NOT NULL ,
  `arrival_time` VARCHAR(30) NOT NULL ,
  `creator` VARCHAR(30) NOT NULL ,
  `modifier` VARCHAR(30) NOT NULL
);

CREATE TABLE `seats_node` (
  `id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  `gmt_created` DATETIME NOT NULL ,
  `gmt_modified` DATETIME NOT NULL ,
  `airline_num` VARCHAR(20) NOT NULL ,
  `plane_model` VARCHAR(20) NOT NULL ,
  `guest_first_name` VARCHAR(30) NOT NULL ,
  `guest_last_name` VARCHAR(30) NOT NULL ,
  `guest_age` INT NOT NULL ,
  `seat_num` VARCHAR(30) NOT NULL ,
  `price` INT NOT NULL ,
  `seat_type` INT NOT NULL ,
  `creator` VARCHAR(30) NOT NULL ,
  `modifier` VARCHAR(30) NOT NULL
);

