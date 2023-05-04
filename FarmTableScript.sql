CREATE TABLE `sector` (
	`id` VARCHAR(15) NOT NULL COLLATE 'utf8mb4_thai_520_w2',
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;
CREATE TABLE `center` (
	`sectorId` VARCHAR(2) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`id` VARCHAR(3) NOT NULL COLLATE 'utf8mb4_thai_520_w2',
	`name` VARCHAR(75) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`initials` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`mass` INT(11) NULL DEFAULT NULL,
	`date` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_center_sector` (`sectorId`) USING BTREE,
	CONSTRAINT `FK_center_sector` FOREIGN KEY (`sectorId`) REFERENCES `farmdb`.`sector` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;
CREATE TABLE `farmer` (
	`centerId` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`id` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_thai_520_w2',
	`fpName` INT(11) NULL DEFAULT NULL,
	`fName` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`sName` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`birthDate` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`address` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`tumbon` VARCHAR(25) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`ampur` VARCHAR(25) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`provice` VARCHAR(25) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`f3` INT(11) NULL DEFAULT NULL,
	`time` INT(11) NULL DEFAULT NULL,
	`amountCow` INT(11) NULL DEFAULT NULL,
	`status` INT(11) NULL DEFAULT NULL,
	`startDate` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_farmer_center` (`centerId`) USING BTREE,
	CONSTRAINT `FK_farmer_center` FOREIGN KEY (`centerId`) REFERENCES `farmdb`.`center` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;




CREATE TABLE `breed` (
	`id` VARCHAR(5) NOT NULL COLLATE 'utf8mb4_thai_520_w2',
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`country` VARCHAR(1) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;
CREATE TABLE `breeder` (
	`id` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_thai_520_w2',
	`name` VARCHAR(35) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`dadId` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`momId` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_breeder_breeder` (`dadId`) USING BTREE,
	CONSTRAINT `FK_breeder_breeder` FOREIGN KEY (`dadId`) REFERENCES `farmdb`.`breeder` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;

CREATE TABLE `cow` (
	`farmerId` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`id` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_thai_520_w2',
	`status` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`date` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`nickName` VARCHAR(25) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`c_oth` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`birthDate` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`momId` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`dadId` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`gender` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`outfg` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`milk` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`eurbrd` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`eurper` FLOAT NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_cow_farmer` (`farmerId`) USING BTREE,
	INDEX `FK_cow_breeder` (`dadId`) USING BTREE,
	INDEX `FK_cow_cow` (`momId`) USING BTREE,
	CONSTRAINT `FK_cow_farmer` FOREIGN KEY (`farmerId`) REFERENCES `farmdb`.`farmer` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;




CREATE TABLE `cowbreed` (
	`cowId` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`breedId` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`percen` DOUBLE NULL DEFAULT NULL,
	`perInt` INT(11) NULL DEFAULT NULL,
	INDEX `FK_cowbreed_cow` (`cowId`) USING BTREE,
	INDEX `FK_cowbreed_breed` (`breedId`) USING BTREE,
	CONSTRAINT `FK_cowbreed_breed` FOREIGN KEY (`breedId`) REFERENCES `farmdb`.`breed` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_cowbreed_cow` FOREIGN KEY (`cowId`) REFERENCES `farmdb`.`cow` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;

CREATE TABLE `breederbreed` (
	`breederId` VARCHAR(15) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`breedId` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8mb4_thai_520_w2',
	`percen` INT(11) NULL DEFAULT NULL,
	`perInt` INT(11) NULL DEFAULT NULL,
	INDEX `FK__breeder` (`breederId`) USING BTREE,
	INDEX `FK__breed` (`breedId`) USING BTREE,
	CONSTRAINT `FK__breed` FOREIGN KEY (`breedId`) REFERENCES `farmdb`.`breed` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK__breeder` FOREIGN KEY (`breederId`) REFERENCES `farmdb`.`breeder` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_thai_520_w2'
ENGINE=InnoDB
;

