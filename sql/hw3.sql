--1.
use new_cinema;
SELECT * FROM film WHERE length_min > 100;

--2.
SELECT * FROM film WHERE length_min > (SELECT AVG(length_min) FROM film);

--3.
SELECT * FROM film WHERE name LIKE 't%';

--4.
SELECT * FROM film WHERE name LIKE '%a%';

--5.
SELECT COUNT(*) FROM film WHERE country_code = 'US';

--6.
SELECT * FROM film WHERE length_min = (SELECT MIN(length_min) FROM film)
OR length_min = (SELECT MAX(length_min) FROM film);

--7.
SELECT DISTINCT type FROM film;

--8.
SELECT DATEDIFF(MAX(start_time), MIN(start_time)) AS day_distance FROM screening;

--9.
--skipped

--10.
SELECT * FROM screening WHERE DATE(start_time) = '2022-05-24' OR DATE(start_time) = '2022-05-25';

--10.1
SELECT * FROM film WHERE id NOT IN (SELECT DISTINCT film_id FROM screening);

--11.
SELECT room_id, DATE(start_time) AS show_date, COUNT(DISTINCT film_id) AS films_count FROM screening
GROUP BY room_id, DATE(start_time) HAVING COUNT(DISTINCT film_id) > 2;

--12.
SELECT room_id, DATE(start_time) AS show_date, COUNT(DISTINCT film_id) AS films_count FROM screening
GROUP BY room_id, DATE(start_time) HAVING COUNT(DISTINCT film_id) > 2;

--13.
SELECT room_id, COUNT(DISTINCT film_id) AS films_count FROM screening GROUP BY room_id
ORDER BY films_count ASC LIMIT 1;

--14.
SELECT * FROM film WHERE id NOT IN (SELECT DISTINCT film_id FROM screening
WHERE id IN (SELECT DISTINCT screening_id FROM booking));
