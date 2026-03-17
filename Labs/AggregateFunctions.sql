-- Creating a table student to perform the aggregate functions on its age column

--creating a table student in jdbc_data database
create table student(
    -> id int primary key,
    -> name varchar(30) not null,
    -> address varchar(3) not null,
    -> age int(2) not null
    -> );

desc student;
/*
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| id      | int         | NO   | PRI | NULL    |       |
| name    | varchar(30) | NO   |     | NULL    |       |
| address | varchar(3)  | NO   |     | NULL    |       |
| age     | int         | NO   |     | NULL    |       |
+---------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

*/

-- inserting the data to my table
insert into student values
    -> (101,"Sam","San Francisco",26),
    -> (102,"Ronaldo","Madrid",33),
    -> (103,"Franko","Brazil",60),
    -> (104,"Vien Diesel","London",45),
    -> (105,"Brian o corner","Pamplona",18);
/*
Query OK, 5 rows affected (0.01 sec)
Records: 5  Duplicates: 0  Warnings: 0
*/

select * from student;
/*
+-----+----------------+---------------+-----+
| id  | name           | address       | age |
+-----+----------------+---------------+-----+
| 101 | Sam            | San Francisco |  26 |
| 102 | Ronaldo        | Madrid        |  33 |
| 103 | Franko         | Brazil        |  60 |
| 104 | Vien Diesel    | London        |  45 |
| 105 | Brian o corner | Pamplona      |  18 |
+-----+----------------+---------------+-----+
5 rows in set (0.00 sec)
*/

-- performing the aggregate functions

mysql> select sum(age) as total_age from student;
+-----------+
| total_age |
+-----------+
|       182 |
+-----------+
1 row in set (0.01 sec)

mysql> select avg(age) as total_average from student;
+---------------+
| total_average |
+---------------+
|       36.4000 |
+---------------+
1 row in set (0.00 sec)

mysql> select min(age) as min_age from student;
+---------+
| min_age |
+---------+
|      18 |
+---------+
1 row in set (0.00 sec)

mysql> select max(age) as max_age from student;
+---------+
| max_age |
+---------+
|      60 |
+---------+
1 row in set (0.00 sec)

mysql> select count(age) as total_count from student;
+-------------+
| total_count |
+-------------+
|           5 |
+-------------+
1 row in set (0.01 sec)