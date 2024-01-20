SELECT * FROM student WHERE age >= 15 AND age <= 20;
SELECT * FROM student WHERE age BETWEEN 10 AND 20;
SELECT name FROM student;
SELECT name FROM student WHERE name ilike '%O%';
SELECT name, age, faculty_id FROM student WHERE age < 20;
SELECT * FROM student ORDER BY age;