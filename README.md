# mytasks

DATABASE SCRIPT USED

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mytasks
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mytasks
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mytasks
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mytasks` DEFAULT CHARACTER SET utf8 ;
USE `mytasks` ;

-- -----------------------------------------------------
-- Table `mytasks`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytasks`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mytasks`.`folder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytasks`.`folder` (
  `folder_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`folder_id`, `user_id`),
  INDEX `folder_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `folder_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `mytasks`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mytasks`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mytasks`.`task` (
  `task_id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `completed` TINYINT NOT NULL DEFAULT '0',
  `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `folder_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`task_id`, `user_id`, `folder_id`),
  INDEX `task_folder_idx` (`folder_id` ASC, `user_id` ASC) VISIBLE,
  CONSTRAINT `task_folder`
    FOREIGN KEY (`folder_id` , `user_id`)
    REFERENCES `mytasks`.`folder` (`folder_id` , `user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


TEST USER= email:nuevo@mail.com password: 123

