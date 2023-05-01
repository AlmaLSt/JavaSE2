
-- MySQL Script generated by MySQL Workbench
-- jue 14 nov 2019 20:56:19 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema javase2_bedu_pw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema javase2_bedu_pw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `javase2_bedu_pw` ;
USE `javase2_bedu_pw` ;

-- -----------------------------------------------------
-- Table `javase2_bedu_pw`.`estudiantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javase2_bedu_pw`.`estudiantes` ;

CREATE TABLE IF NOT EXISTS `javase2_bedu_pw`.`estudiantes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_completo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `javase2_bedu_pw`.`materias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javase2_bedu_pw`.`materias` ;

CREATE TABLE IF NOT EXISTS `javase2_bedu_pw`.`materias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `javase2_bedu_pw`.`cursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javase2_bedu_pw`.`cursos` ;

CREATE TABLE IF NOT EXISTS `javase2_bedu_pw`.`cursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ciclo` CHAR(4) NOT NULL,
  `materias_fk` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cursos_materias`
    FOREIGN KEY (`materias_fk`)
    REFERENCES `javase2_bedu_pw`.`materias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cursos_materias_idx` ON `javase2_bedu_pw`.`cursos` (`materias_fk` ASC);


-- -----------------------------------------------------
-- Table `javase2_bedu_pw`.`cursos_has_estudiantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javase2_bedu_pw`.`cursos_has_estudiantes` ;

CREATE TABLE IF NOT EXISTS `javase2_bedu_pw`.`cursos_has_estudiantes` (
  `cursos_fk` INT NOT NULL,
  `estudiantes_fk` INT NOT NULL,
  `calificacion` INT NOT NULL,
  CONSTRAINT `fk_cursos_has_estudiantes_cursos1`
    FOREIGN KEY (`cursos_fk`)
    REFERENCES `javase2_bedu_pw`.`cursos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursos_has_estudiantes_estudiantes1`
    FOREIGN KEY (`estudiantes_fk`)
    REFERENCES `javase2_bedu_pw`.`estudiantes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cursos_has_estudiantes_estudiantes1_idx` ON `javase2_bedu_pw`.`cursos_has_estudiantes` (`estudiantes_fk` ASC);

CREATE INDEX `fk_cursos_has_estudiantes_cursos1_idx` ON `javase2_bedu_pw`.`cursos_has_estudiantes` (`cursos_fk` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;