ALTER TABLE `MySQLHibernateDB`.`Phone` 
DROP FOREIGN KEY `user_id`;
ALTER TABLE `MySQLHibernateDB`.`Phone` 
ADD CONSTRAINT `user_id_fk`
  FOREIGN KEY (`phone_id`)
  REFERENCES `MySQLHibernateDB`.`User` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  --- ONE-TO-ONE-----
  
  CREATE TABLE `MySQLHibernateDB`.`User` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`));

  
  CREATE TABLE `MySQLHibernateDB`.`Phone` (
  `phone_id` INT NOT NULL,
  `phone_name` VARCHAR(45) NULL,
  PRIMARY KEY (`phone_id`),
  CONSTRAINT `user_id_fk`
    FOREIGN KEY (`phone_id`)
    REFERENCES `MySQLHibernateDB`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
   
    --- ONE-TO-MANY---
   CREATE TABLE `MySQLHibernateDB`.`UserAccount` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC));
  
  CREATE TABLE `MySQLHibernateDB`.`Account` (
  `acc_id` INT NOT NULL AUTO_INCREMENT,
  `acc_number` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`acc_id`),
  UNIQUE INDEX `acc_number_UNIQUE` (`acc_number` ASC),
  INDEX `user_acc_fk_idx` (`user_id` ASC),
  CONSTRAINT `user_acc_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `MySQLHibernateDB`.`UserAccount` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
    
    
    
    