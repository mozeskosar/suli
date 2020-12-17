-- A feladatok megoldására elkészített SQL parancsokat illessze be a feladat sorszáma után!


-- 1. feladat:
CREATE DATABASE tenisz DEFAULCT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;

-- 3. feladat:
SELECT COUNT(*) AS "visszalepes" 
  FROM merkozes 
  WHERE jatszma1=-1 OR jatszma2=-1;

-- 4. feladat:
SELECT MIN(kezdes) AS "legkorabban",MAX(kezdes) AS "legkesobben" 
  FROM merkozes 
  WHERE fordulo="d8";

-- 5. feladat:
SELECT merkozes.datum,jatekos1.orszagKod, jatekos2.nev AS "egyik jatekos", jatekos2.nev AS "masik jatekos" 
  FROM merkozes 
  LEFT JOIN jatekos AS jatekos1 ON merkozes.jatekos1Id =jatekos1.id 
  LEFT JOIN jatekos AS jatekos2 ON merkozes.jatekos2Id =jatekos2.id 
  WHERE jatekos1.orszagKod=jatekos2.orszagKod 
  ORDER BY jatekos1.orszagKod;

-- 6. feladat:
SELECT orszagKod, COUNT(*) AS "letszam"
  FROM jatekos
  GROUP BY orszagKod
  ORDER BY letszam DESC;

-- 7. feladat:
SELECT YEAR(datum) AS "evszam",COUNT(*) as "2:0 vagy 0:2"
  FROM merkozes
  WHERE (jatszma1=0 AND jatszma2=2) OR (jatszma1=2 AND jatszma2=0)
  GROUP BY evszam
  ORDER BY evszam DESC;
