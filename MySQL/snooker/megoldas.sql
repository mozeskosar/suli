1.
CREATE DATABASE snooker DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;

3.
SELECT CONCAT("3. feladat: A világranglistán ",COUNT(*)," versenyzõ szerepel") AS "3. feladat" 
FROM lista;

4.
SELECT CONCAT("4. feladat: A versenyzõk átlagosan ",ROUND(AVG(`Nyeremeny`),2)," fontot kerestek") AS "4. feladat" 
FROM lista;

5.
SELECT CONCAT("Helyezés :",Helyezes) as "helyezés",CONCAT("Név: ",Nev) as "név",CONCAT("Ország: ",Orszag) as "ország",CONCAT("Nyeremény összege: ",SUM(`Nyeremeny`*380)," Ft") as "nyeremény"
  FROM lista
  WHERE Orszag LIKE "%Kína"
  GROUP BY Nev
  ORDER BY Nyeremeny DESC
  limit 1;

6.
SELECT IF(Orszag LIKE "%Norvégia%","6. feladat: A versenyzõk között van norvég versenyzõ.","6. feladat: a versenyzõk között nincs norvég versenyzõ.") as "6. feladat"
  FROM lista
  GROUP By Orszag
  HAVING IF(Orszag LIKE "%Norvégia%",1,0);

7.
SELECT Orszag,CONCAT(COUNT(*)," fõ") as "statisztika"
  FROM lista
  GROUP By Orszag
  HAVING COUNT(*)>4;