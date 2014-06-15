SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `hotelverwaltung` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `hotelverwaltung` ;

-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Room`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotelverwaltung`.`Room` (
  `RID` INT NOT NULL AUTO_INCREMENT ,
  `Price` DECIMAL(5,2) NOT NULL ,
  `isDoubleRoom` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`RID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Service`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotelverwaltung`.`Service` (
  `SID` INT NOT NULL AUTO_INCREMENT ,
  `Type` VARCHAR(45) NOT NULL ,
  `Price` DECIMAL(5,2) NOT NULL ,
  PRIMARY KEY (`SID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotelverwaltung`.`Customer` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `FName` VARCHAR(45) NOT NULL ,
  `LName` VARCHAR(45) NOT NULL ,
  `Address` VARCHAR(150) NOT NULL ,
  `BDate` DATE NOT NULL ,
  `Title` VarChar(45) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Booking_Room`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotelverwaltung`.`Booking_Room` (
  `BRID` INT NOT NULL AUTO_INCREMENT ,
  `Date` DATE NOT NULL ,
  `RID` INT NOT NULL ,
  `CID` INT NOT NULL ,
  PRIMARY KEY (`BRID`) ,
  INDEX `fk_Room` (`RID` ASC) ,
  UNIQUE INDEX `Room_Date_unique` (`Date` ASC, `RID` ASC) ,
  INDEX `fk_Customer` (`CID` ASC) ,
  CONSTRAINT `fk_Room`
    FOREIGN KEY (`RID` )
    REFERENCES `hotelverwaltung`.`Room` (`RID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer`
    FOREIGN KEY (`CID` )
    REFERENCES `hotelverwaltung`.`Customer` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelverwaltung`.`Booking_Service`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotelverwaltung`.`Booking_Service` (
  `BSID` INT NOT NULL AUTO_INCREMENT ,
  `Date` DATE NOT NULL ,
  `SID` INT NOT NULL ,
  `BRID` INT NOT NULL ,
  PRIMARY KEY (`BSID`) ,
  INDEX `SID` (`SID` ASC) ,
  INDEX `fk_Booking_Room` (`BRID` ASC) ,
  CONSTRAINT `SID`
    FOREIGN KEY (`SID` )
    REFERENCES `hotelverwaltung`.`Service` (`SID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_Room`
    FOREIGN KEY (`BRID` )
    REFERENCES `hotelverwaltung`.`Booking_Room` (`BRID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
