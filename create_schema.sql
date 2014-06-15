SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hotelverwaltung
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hotelverwaltung` ;
CREATE SCHEMA IF NOT EXISTS `hotelverwaltung` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `hotelverwaltung` ;

-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotelverwaltung`.`Room` ;

CREATE TABLE IF NOT EXISTS `hotelverwaltung`.`Room` (
  `RID` INT NOT NULL AUTO_INCREMENT,
  `Price` DECIMAL(5,2) NOT NULL,
  `isDoubleRoom` TINYINT(1) NOT NULL,
  PRIMARY KEY (`RID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotelverwaltung`.`Service` ;

CREATE TABLE IF NOT EXISTS `hotelverwaltung`.`Service` (
  `SID` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(45) NOT NULL,
  `Price` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`SID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotelverwaltung`.`Customer` ;

CREATE TABLE IF NOT EXISTS `hotelverwaltung`.`Customer` (
  `CID` INT NOT NULL AUTO_INCREMENT,
  `FName` VARCHAR(45) NOT NULL,
  `LName` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(150) NOT NULL,
  `BDate` DATE NOT NULL,
  `Title` VARCHAR(45) NULL,
  PRIMARY KEY (`CID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotelverwaltung`.`Booking` ;

CREATE TABLE IF NOT EXISTS `hotelverwaltung`.`Booking` (
  `BID` INT NOT NULL AUTO_INCREMENT,
  `CreatedOn` DATE NOT NULL,
  `CID` INT NOT NULL,
  PRIMARY KEY (`BID`),
  INDEX `fk_Customer_idx` (`CID` ASC),
  CONSTRAINT `fk_Customer`
    FOREIGN KEY (`CID`)
    REFERENCES `hotelverwaltung`.`Customer` (`CID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Booking_Service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotelverwaltung`.`Booking_Service` ;

CREATE TABLE IF NOT EXISTS `hotelverwaltung`.`Booking_Service` (
  `BSID` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `SID` INT NOT NULL,
  `BID` INT NOT NULL,
  PRIMARY KEY (`BSID`),
  INDEX `SID_idx` (`SID` ASC),
  INDEX `fk_Booking_idx` (`BID` ASC),
  CONSTRAINT `fk_Service`
    FOREIGN KEY (`SID`)
    REFERENCES `hotelverwaltung`.`Service` (`SID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_BookingOfService`
    FOREIGN KEY (`BID`)
    REFERENCES `hotelverwaltung`.`Booking` (`BID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Booking_Room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotelverwaltung`.`Booking_Room` ;

CREATE TABLE IF NOT EXISTS `hotelverwaltung`.`Booking_Room` (
  `BRID` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `RID` INT NOT NULL,
  `BID` INT NOT NULL,
  PRIMARY KEY (`BRID`),
  INDEX `fk_Room_idx` (`RID` ASC),
  UNIQUE INDEX `Room_Date_unique` (`Date` ASC, `RID` ASC),
  INDEX `fk_Booking_idx` (`BID` ASC),
  CONSTRAINT `fk_Room`
    FOREIGN KEY (`RID`)
    REFERENCES `hotelverwaltung`.`Room` (`RID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_BookingOfRoom`
    FOREIGN KEY (`BID`)
    REFERENCES `hotelverwaltung`.`Booking` (`BID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
