/* 1. feladat:  */ 
CREATE DATABASE centrum DEFAULT CHARACTER SET utf-8 COLLATE utf8_hungarian_ci;

/* 3. feladat:  */ 
SELECT `kezdet`,`veg`,`dij` FROM `kezeles`;

/* 4. feladat:  */
SELECT `nev`,`kerulet` FROM `gazda` WHERE `kerulet`=17 OR kerulet =18 ORDER BY kerulet,nev;

/* 5. feladat:  */
SELECT kezelestipus.jelleg,COUNT(kezeles.kutyaId) as "darabszám" FROM `kezeles` LEFT JOIN `kezelestipus` ON `kezeles`.`kezelestipusId` = `kezelestipus`.`id` GROUP by kezelestipus.jelleg;

/* 6. feladat:  */
SELECT kezelestipus.jelleg,kezeles.kezdet,kezeles.veg,kezeles.dij FROM `kezeles` LEFT JOIN `kezelestipus` ON `kezeles`.`kezelestipusId` = `kezelestipus`.`id` WHERE kezelestipus.jelleg LIKE "%gyógy%" and kezeles.veg BETWEEN "2017-09.01" and "2017-12-31";

/* 7. feladat:  */
SELECT gazda.nev,COUNT(kutya.gazdaId)as alkalom ,SUM(kezeles.dij) as összesen FROM `gazda` LEFT JOIN `kutya` ON `kutya`.`gazdaId` = `gazda`.`id` LEFT JOIN `kezeles` ON `kezeles`.`kutyaId` = `kutya`.`id` LEFT JOIN `kezelestipus` ON `kezeles`.`kezelestipusId` = `kezelestipus`.`id` WHERE gazda.nev LIKE "%Medgyessy%" GROUP BY gazda.nev HAVING SUM(kezeles.dij)>1;


