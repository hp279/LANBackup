DROP DATABASE lanbackupdb;
CREATE DATABASE lanbackupdb;
USE lanbackupdb;

CREATE TABLE `admin` (
  `admin_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `display_name` VARCHAR(255) NOT NULL,
  `password` CHAR(41) NOT NULL,
  `last_update` TIMESTAMP NOT NULL,
   PRIMARY KEY (`admin_id`),
   UNIQUE KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `client` (
  `client_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ip_address` varchar(15) NOT NULL,
  `src_login` varchar(45) NOT NULL,
  `src_password` varchar(41) NOT NULL,
  `dst_login` varchar(45) NOT NULL,
  `dst_password` varchar(41) NOT NULL,
  `enabled` BOOLEAN NOT NULL,
  `create_date` DATETIME NOT NULL,
  `last_update` TIMESTAMP NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY (`ip_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `folder` (
  `folder_id` BIGINT NOT NULL AUTO_INCREMENT,
  `client_id` INT(11) NOT NULL,
  `path` TEXT NOT NULL,
  `backuped` BOOLEAN NOT NULL,
  `location_type` ENUM('SOURCE', 'DESTINATION') NOT NULL, 
  `last_update` TIMESTAMP NOT NULL,
  PRIMARY KEY (`folder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `config_log` (
  `config_log_id` BIGINT NOT NULL AUTO_INCREMENT,
  `client_ip_address` varchar(15) NOT NULL,
  `description` VARCHAR(260) NOT NULL,
  `update_type` ENUM('CREATE', 'DELETE', 'UPDATE', 'ENABLE', 'DISABLE', 'UPDATE_FOLDERS_FOR_BACKUP') NOT NULL, 
  `activity_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`config_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `backup_activity_log` (
  `backup_activity_log_id` BIGINT NOT NULL AUTO_INCREMENT,
  `folder_id` BIGINT NOT NULL,
  `activity_date` DATETIME NOT NULL,
  `activity_result` ENUM('SUCCESS', 'FAILURE') NOT NULL, 
  `description` VARCHAR(260) NOT NULL,
  PRIMARY KEY (`backup_activity_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
