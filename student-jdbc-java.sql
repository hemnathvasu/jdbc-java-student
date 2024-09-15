drop database student;

create database student;
use student;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT,
    class VARCHAR(50),
    email VARCHAR(100)
);

INSERT INTO students (name, age, class, email)
VALUES
('John Doe', 20, 'Junior', 'john.doe@gmail.com'),
('Jane Smith', 22, 'Senior', 'jane.smith@gmail.com'),
('Alice Brown', 21, 'Junior', 'alice.brown@gmail.com'),
('Bob Johnson', 19, 'Junior', 'bob.johnson@gmail.com'),
('Chris Evans', 23, 'Senior', 'chris.evans@gmail.com'),
('David Lee', 20, 'Senior', 'david.lee@gmail.com'),
('Emma Watson', 18, 'Senior', 'emma.watson@gmail.com'),
('Frank Miller', 22, 'Junior', 'frank.miller@gmail.com'),
('Grace Park', 21, 'Senior', 'grace.park@gmail.com'),
('Henry White', 23, 'Junior', 'henry.white@gmail.com');

select * from students;
UPDATE students SET name = 'Mike', age = 'Junior' ,email = 'mike@gmail.com' WHERE id = 11