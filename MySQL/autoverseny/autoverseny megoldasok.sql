/* 1. feladat*/
CREATE DATABASE verseny DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;


/* 3. feladat*/
SELECT `nev` FROM `versenyzo` ORDER BY `eletkor` DESC;
/* 4. feladat*/
SELECT COUNT(`id`) AS "Pályák száma" FROM `palya`
/* 5. feladat*/
SELECT `csapat`.`nev` AS "csapat", `versenyzo`.`nev` AS "versenyző" FROM `csapat` LEFT JOIN `versenyzo` ON `versenyzo`.`csapatid` = `csapat`.`id` WHERE `csapat`.`nev` LIKE "%z%" ORDER BY `csapat`.`nev`;
/* 6. feladat*/
SELECT palya.nev AS "pályanév",versenyzo.nev AS "versenyzőnév",korido.korido FROM `versenyzo` , `palya` LEFT JOIN `korido` ON `korido`.`palyaid` = `palya`.`id` WHERE palya.orszag="Olaszország" AND korido.kor=1;
