CREATE DATABASE galaxyCinema;
USE galaxyCinema;

CREATE TABLE Film (
    film_id CHAR(5),
    name VARCHAR(100),
    length_min INT,
    genre VARCHAR(50),
    country VARCHAR(50)
);

CREATE TABLE Room (
    room_id CHAR(5),
    name VARCHAR(100)
);

CREATE TABLE Screening (
    screening_id CHAR(5),
    film_id CHAR(5),
    room_id CHAR(5),
    start_time VARCHAR(50)
);

CREATE TABLE Customer (
    customer_id CHAR(5),
    name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE Booking (
    booking_id CHAR(5),
    customer_id CHAR(5),
    screening_id CHAR(5),
    booking_time VARCHAR(50),
    total VARCHAR(20)
);

CREATE TABLE Seat (
    seat_id CHAR(5),
    room_id CHAR(5),
    row CHAR(5),
    number INT,
    x INT,
    y INT
);

CREATE TABLE Reserved_seat (
    rs_id CHAR(5),
    booking_id CHAR(5),
    seat_id CHAR(5),
    price VARCHAR(20)
);

INSERT INTO Film VALUES
    ('FM001', 'Movie A', 120, 'Comedy', 'VN'),
    ('FM002', 'Movie B', 125, 'Horror', 'AU'),
    ('FM003', 'Movie C', 162, 'Horror', 'JP');

INSERT INTO Room VALUES
    ('T001', 'Theater A'),
    ('T002', 'Theater B'),
    ('T003', 'Theater C');

INSERT INTO Screening VALUES
    ('SC001', 'FM003', 'T002', '10/10/2025 10:00'),
    ('SC002', 'FM002', 'T001', '10/11/2025 8:00'),
    ('SC003', 'FM002', 'T001', '10/12/2025 9:00'),
    ('SC004', 'FM001', 'T003', '10/13/2025 18:00');

INSERT INTO Customer VALUES
   ('C001', 'Leslie', NULL),
   ('C002', 'Noah', NULL),
   ('C003', 'Ivy', NULL),
   ('C004', 'Jayden', NULL),
   ('C005', 'Jonathan', NULL);

INSERT INTO Booking VALUES
   ('B001', 'C001', 'SC002', NULL, NULL),
   ('B002', 'C001', 'SC003', NULL, NULL),
   ('B003', 'C003', 'SC004', NULL, NULL),
   ('B004', 'C004', 'SC004', NULL, NULL);

INSERT INTO Seat VALUES
   ('S001', 'T001', 'A', 1, 1, 1),
   ('S002', 'T001', 'A', 5, 1, 3),
   ('S003', 'T002', 'G', 4, 1, 1),
   ('S004', 'T003', 'F', 6, 2, 1),
   ('S005', 'T003', 'F', NULL, NULL, NULL);

INSERT INTO Reserved_seat VALUES
   ('RS001', 'B001', 'S001', NULL),
   ('RS002', 'B002', 'S002', NULL),
   ('RS003', 'B003', 'S004', NULL),
   ('RS004', 'B003', 'S003', NULL),
   ('RS005', 'B004', 'S005', NULL);
