/* 1. feladat:  */
CREATE DATABASE monthypython DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;
/* 3. feladat:  */
SELECT nev 
FROM epizodok 
WHERE sorozat="1/5";
/* 4. feladat:  */
SELECT COUNT(*) AS "epizódok száma"
FROM epizodok;
/* 5. feladat:  */
SELECT DISTINCT szinesz 
FROM forgatokonyv
WHERE szinesz IS NOT NULL
ORDER BY szinesz;
/* 6. feladat:  */
SELECT reszletek 
FROM forgatokonyv 
WHERE szinesz="John Cleese" AND resz="Italian lesson";
/* 7. feladat:  */
SELECT szinesz,COUNT(*) AS "bejegyzések száma"
FROM forgatokonyv
WHERE szinesz IS NOT NULL
GROUP BY szinesz
ORDER BY 2 DESC
LIMIT 1;