1.
CREATE DATABASE konyvtar DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;

2.
SELECT hallgato.nev 
  FROM kar INNER JOIN hallgato ON kar.id = hallgato.karid 
  WHERE kar.nev="MED" 
  ORDER BY hallgato.nev ASC;

3.
SELECT SUM(lap)/500 AS "csomag" 
  FROM masolat;

4.
SELECT DISTINCT hallgato.nev
  FROM kar
  INNER JOIN hallgato
  ON kar.id = hallgato.karid
  INNER JOIN masolat
  ON hallgato.id = masolat.hallgatoid
    WHERE kar.nev IN("PPK","TKK")
    AND masolat.datum BETWEEN "2012.12.24" AND "2013.01.01";

5.
SELECT DISTINCT hallgato.nev
  FROM hallgato
  INNER JOIN masolat
  ON hallgato.id = masolat.hallgatoid
    GROUP BY hallgato.nev,masolat.datum
    HAVING COUNT(*)>2;

6.
SELECT hallgato.nev,MAX(masolat.datum)
  FROM kar
  INNER JOIN hallgato
  ON kar.id = hallgato.karid
  INNER JOIN masolat
  ON hallgato.id = masolat.hallgatoid
    WHERE kar.nev="IK"
    GROUP BY hallgato.nev
    ORDER BY masolat.datum ASC;

7.
SELECT DISTINCT hallgato.nev
  FROM hallgato
  INNER JOIN masolat
    ON hallgato.id = masolat.hallgatoid
      WHERE masolat.datum=(
SELECT MIN(masolat.datum)
  FROM kar
  INNER JOIN hallgato
  ON kar.id = hallgato.karid
  INNER JOIN masolat
  ON hallgato.id = masolat.hallgatoid
    WHERE hallgato.nev="Eszes Albert") 
    AND hallgato.nev !="Eszes Albert";

8.


9.
SELECT hallgato.nev 
  FROM hallgato 
  WHERE hallgato.id NOT IN (
    SELECT hallgatoid FROM masolat);


