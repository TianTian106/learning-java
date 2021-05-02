# 175. Combine Two Tables
drop table if exists Person;
drop table if exists Address;
Create table Person (PersonId int, FirstName varchar(20), LastName varchar(20));
Create table Address (AddressId int, PersonId int, City varchar(20), State varchar(20));
# method :
select FirstName, LastName, City, State
from Person t1
left outer join Address t2
on t1.PersonId=t2.PersonId;



# 176. Second Highest Salary
drop table if exists Employee;
Create table Employee (Id int, Salary int);
insert into Employee (Id, Salary) values('1', '100');
insert into Employee (Id, Salary) values('2', '200');
insert into Employee (Id, Salary) values('3', '300');
# method 1 :
select ( select Salary from Employee group by Salary order by Salary desc limit 1,1 ) as SecondHighestSalary;
# method 2 :
select IFNULL((select Salary from Employee group by Salary order by Salary desc limit 1,1), null ) as SecondHighestSalary



# 177. Nth Highest Salary
drop table if exists Employee;
Create table Employee (Id int, Salary int);
insert into Employee (Id, Salary) values('1', '100');
insert into Employee (Id, Salary) values('2', '200');
insert into Employee (Id, Salary) values('3', '300');
# method :
DELIMITER $$
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  BEGIN
    set N = N - 1;
    RETURN (
      SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT N, 1
    );
  END $$
DELIMITER ;



# 178. Rank Scores
drop table if exists Scores;
Create table Scores (Id int,Score DECIMAL(3,2));
insert into Scores (Id, Score) values ('1','3.5');
insert into Scores (Id, Score) values ('2','3.65');
insert into Scores (Id, Score) values ('3','4.0');
insert into Scores (Id, Score) values ('4','3.85');
insert into Scores (Id, Score) values ('5','4.0');
insert into Scores (Id, Score) values ('6','3.65');
# method 1 :
select Score,(select count(distinct Score) from Scores t2 where t1.Score<=t2.Score ) Rank from Scores t1 order by Score desc;
# method 2 :
# mysql case when 返回第一个符合条件的值
# (@preValue := Score)>=0 而非 @preValue := Score（当只有一条数据时应返回1而后者返回null）
SELECT Score, cast(CASE WHEN Score = @preValue THEN @preRank WHEN (@preValue := Score)>=0 THEN @preRank := @preRank + 1 END as unsigned) AS Rank
FROM Scores, (SELECT @preValue := NULL, @preRank := 0) t
ORDER BY Score DESC;



# 180. Consecutive Numbers
drop table if exists Logs;
Create table Logs (Id int,Num int);
insert into Logs (Id, Num) values ('1','1');
insert into Logs (Id, Num) values ('2','1');
insert into Logs (Id, Num) values ('3','1');
insert into Logs (Id, Num) values ('4','2');
insert into Logs (Id, Num) values ('5','1');
insert into Logs (Id, Num) values ('6','2');
insert into Logs (Id, Num) values ('7','2');
# method 1 :
select Num as ConsecutiveNums from
  ( select Num, case when @preValue = Num then @counter := @counter + 1
                when @preValue := Num then @counter := 1 end var
    from Logs, (select @preValue := NULL, @counter := 0) t
  ) a
where var=3
group by Num;
# method 1.1 :
select distinct num as ConsecutiveNums
from
  ( select num, @counter := if(@preValue = num, @counter + 1, 1) as n, @preValue := num
    from logs, (select @counter := 0, @preValue := null) as a
  ) as t
where t.n >= 3;



# 181. Employees Earning More Than Their Managers
drop table if exists Employee;
Create table Employee (Id int, Name varchar(20), Salary int, ManagerId int);
insert into Employee (Id, Name, Salary,ManagerId) values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary,ManagerId) values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary,ManagerId) values ('3', 'Sam', '60000', Null);
insert into Employee (Id, Name, Salary,ManagerId) values ('4', 'Max', '90000', Null);
# method 1 :
select t1.Name Employee from Employee t1 , Employee t2 where t1.ManagerId = t2.Id and t1.Salary > t2.Salary;
# method 2 :
select t1.Name Employee from Employee t1  inner join Employee t2 on t1.ManagerId = t2.Id and t1.Salary > t2.Salary;



# 182. Duplicate Emails
drop table if exists Person;
Create table Person (Id int,Email varchar(50));
insert into Person (Id, Email) values ('1','a@b.com');
insert into Person (Id, Email) values ('2','c@d.com');
insert into Person (Id, Email) values ('3','a@b.com');
# method :
select Email from Person group by Email having count(1)>1;



# 183. Customers Who Never Order
drop table if exists Customers;
drop table if exists Orders;
Create table Customers (Id int, Name varchar(20));
Create table Orders (Id int,CustomerId int);
insert into Customers (Id, Name) values('1', 'Joe');
insert into Customers (Id, Name) values('2', 'Henry');
insert into Customers (Id, Name) values('3', 'Sam');
insert into Customers (Id, Name) values('4', 'Max');
insert into Orders (Id, CustomerId) values('1', '3');
insert into Orders (Id, CustomerId) values('2', '1');
# method :
select Name Customers from Customers where Id not in ( select CustomerId from Orders );



# 184. Department Highest Salary
drop table if exists Employee;
drop table if exists Department;
Create table Employee (Id int, Name varchar(20), Salary int, DepartmentId int);
Create table Department (Id int, Name varchar(20));
insert into Employee (Id, Name, Salary,DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary,DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary,DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary,DepartmentId) values ('4', 'Max', '90000', '1');
insert into Department (Id, Name) values('1', 'IT');
insert into Department (Id, Name) values('2', 'Sales');
# method :
select t2.Name Department, t1.Name Employee,  Salary from Employee t1 inner join Department t2 on t1.DepartmentId=t2.Id
where (t1.DepartmentId,t1.Salary) in ( select DepartmentId,max(Salary) from Employee group by DepartmentId );



# 185. Department Top Three Salaries
drop table if exists Employee;
drop table if exists Department;
Create table Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table Department (Id int, Name varchar(255));
insert into Employee (Id, Name, Salary,DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary,DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary,DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary,DepartmentId) values ('4', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary,DepartmentId) values ('5', 'Janet', '69000', '1');
insert into Employee (Id, Name, Salary,DepartmentId) values ('6', 'Randy', '85000', '1');
insert into Employee (Id, Name, Salary,DepartmentId) values ('7', 'Test', '90000', '1');
insert into Department (Id, Name) values('1', 'IT');
insert into Department (Id, Name) values('2', 'Sales');
# method 1 :
select t2.Name Department, t1.Name Employee,  Salary from Employee t1 inner join Department t2 on t1.DepartmentId=t2.Id
where (t1.DepartmentId,t1.Salary) in
( select DepartmentId,Salary from
  ( select DepartmentId,Salary,case
    when DepartmentId = @preDepartmentId and Salary = @preSalary then @counter
    when DepartmentId = @preDepartmentId and Salary != @preSalary then @counter := @counter + 1
    when @preDepartmentId := DepartmentId then @counter := 1 end rank,@preSalary := Salary
    from Employee, ( select @counter := 0, @preDepartmentId := null, @preSalary := null ) a order by DepartmentId,Salary desc
  ) b
  where rank <=3
);
# method 2 : // TODO:
# @num := if(@course = course, @num + 1, 1) as row_number,
# @course := course as dummy


# 196. Delete Duplicate Emails
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
 `Id` int(11) DEFAULT NULL,
 `Email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `person` VALUES ('1','john@example.com');
INSERT INTO `person` VALUES ('2','bob@example.com');
INSERT INTO `person` VALUES ('3','john@example.com');
# method : (不能先select出同一表中的某些值，再在同一语句中update这个表)
delete from Person where Id not in ( select min(Id) Id from (select * from Person) t group by Email );
delete from Person where Id not in ( select Id from ( select min(Id) Id from Person group by Email ) t1 );



# 197. Rising Temperature
DROP TABLE IF EXISTS `Weather`;
CREATE TABLE `Weather` (
 `Id` int(11) DEFAULT NULL,
 `RecordDate` date DEFAULT NULL,
 `Temperature` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `Weather` VALUES ('1','2015-01-01', '10');
INSERT INTO `Weather` VALUES ('2','2015-01-02', '25');
INSERT INTO `Weather` VALUES ('3','2015-01-03', '20');
INSERT INTO `Weather` VALUES ('4','2015-01-04', '30');
# method 1 :
select t1.Id from Weather t1 left outer join Weather t2 on t1.RecordDate = date_add(t2.RecordDate, interval 1 Day) where t1.Temperature > t2.Temperature;
# method 2 :
select t1.Id from weather t1,weather t2 where t1.Temperature > t2.Temperature and DATEDIFF(t1.Recorddate,t2.Recorddate) = 1;



# 262. Trips and Users
drop table if exists Trips;
drop table if exists Users;
Create table Trips (Id int,Client_Id int, Driver_Id int, City_Id int, Status ENUM('completed','cancelled_by_driver', 'cancelled_by_client'), Request_at Date);
Create table Users (Users_Id int,Banned varchar(50), Role ENUM('client', 'driver', 'partner'));

insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('1', '1', '10', '1', 'completed','2013-10-01');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('2', '2', '11', '1','cancelled_by_driver', '2013-10-01');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('3', '3', '12', '6', 'completed','2013-10-01');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('4', '4', '13', '6','cancelled_by_client', '2013-10-01');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('5', '1', '10', '1', 'completed','2013-10-02');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('6', '2', '11', '6', 'completed','2013-10-02');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('7', '3', '12', '6', 'completed','2013-10-02');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('8', '2', '12', '12', 'completed','2013-10-03');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('9', '3', '10', '12', 'completed','2013-10-03');
insert into Trips (Id, Client_Id, Driver_Id,City_Id, Status, Request_at) values ('10', '4', '13', '12','cancelled_by_driver', '2013-10-03');

insert into Users (Users_Id, Banned, Role)values ('1', 'No', 'client');
insert into Users (Users_Id, Banned, Role)values ('2', 'Yes', 'client');
insert into Users (Users_Id, Banned, Role)values ('3', 'No', 'client');
insert into Users (Users_Id, Banned, Role)values ('4', 'No', 'client');
insert into Users (Users_Id, Banned, Role)values ('10', 'No', 'driver');
insert into Users (Users_Id, Banned, Role)values ('11', 'No', 'driver');
insert into Users (Users_Id, Banned, Role)values ('12', 'No', 'driver');
insert into Users (Users_Id, Banned, Role)values ('13', 'No', 'driver');
# method 1 :
select Request_at Day,round(count(case when Status!='completed' then true end)/count(1),2) 'Cancellation Rate'
from Trips
where Request_at between STR_TO_DATE('2013-10-01','%Y-%m-%d') and STR_TO_DATE('2013-10-03','%Y-%m-%d') and Client_Id not in ( select Users_Id from Users where Banned='Yes' )
group by Request_at;



# 595. Big Countries
DROP TABLE IF EXISTS `World`;
CREATE TABLE `World` (
  `name`varchar(20) DEFAULT NULL,
 `continent` varchar(20) DEFAULT NULL,
  `area`int(11) DEFAULT NULL,
 `population` int(11) DEFAULT NULL,
  `gdp`bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `World` VALUES ('Afghanistan','Asia', '652230', '25500100', '20343000000');
INSERT INTO `World` VALUES ('Albania','Europe', '28748', '2831741', '12960000000');
INSERT INTO `World` VALUES ('Algeria','Africa', '2381741', '37100000', '188681000000');
INSERT INTO `World` VALUES ('Andorra','Europe', '468', '78115', '3712000000');
INSERT INTO `World` VALUES ('Angola', 'Africa','1246700', '20609294', '100990000000');
# method :
select name,population,area from World where area>3000000 or population>25000000;


# 596. Classes More Than 5 Students
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
 `student` varchar(10) DEFAULT NULL,
  `class`varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `courses` VALUES ('A', 'Math');
INSERT INTO `courses` VALUES ('B', 'English');
INSERT INTO `courses` VALUES ('C', 'Math');
INSERT INTO `courses` VALUES ('D', 'Biology');
INSERT INTO `courses` VALUES ('E', 'Math');
INSERT INTO `courses` VALUES ('F', 'Computer');
INSERT INTO `courses` VALUES ('G', 'Math');
INSERT INTO `courses` VALUES ('H', 'Math');
INSERT INTO `courses` VALUES ('I', 'Math');
# method :
select class from courses group by class having count(distinct student) >= 5;



# 601. Human Traffic of Stadium
drop table if exists stadium;
Create table stadium (id int,date DATE NULL, people int);
insert into stadium(id,date,people) values(1,'2017-01-01',10);
insert into stadium(id,date,people) values(2,'2017-01-02',109);
insert into stadium(id,date,people) values(3,'2017-01-03',150);
insert into stadium(id,date,people) values(4,'2017-01-04',99);
insert into stadium(id,date,people) values(5,'2017-01-05',145);
insert into stadium(id,date,people) values(6,'2017-01-06',1455);
insert into stadium(id,date,people) values(7,'2017-01-07',199);
insert into stadium(id,date,people) values(8,'2017-01-08',188);

# method 1 :
select distinct a.*
from stadium a, stadium b, stadium c
where a.people >= 100 and b.people >= 100 and c.people >= 100 and
      (
        ( a.id = b.id - 1 and a.id = c.id - 2 ) or
        ( a.id = b.id + 1 and a.id = c.id - 1 ) or
        ( a.id = b.id + 2 and a.id = c.id + 1 )
      )
order by a.id;

# method 2 :
select *
from stadium a
where people >= 100 and
      (
        ( select count(1) from stadium b where people >= 100 and (a.id = b.id - 1 or a.id = b.id - 2) ) = 2 or
        ( select count(1) from stadium b where people >= 100 and (a.id = b.id + 1 or a.id = b.id - 1) ) = 2 or
        ( select count(1) from stadium b where people >= 100 and (a.id = b.id + 2 or a.id = b.id + 1) ) = 2
      );



# 620. Not Boring Movies
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `id`int(11) NOT NULL,
  `movie`varchar(20) DEFAULT NULL,
 `description` varchar(50) DEFAULT NULL,
 `rating` float(2,1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `cinema` VALUES ('1', 'War', 'great3D', '8.9');
INSERT INTO `cinema` VALUES ('2', 'Science','fiction', '8.5');
INSERT INTO `cinema` VALUES ('3', 'irish','boring', '6.2');
INSERT INTO `cinema` VALUES ('4', 'Ice song','Fantacy', '8.6');
INSERT INTO `cinema` VALUES ('5', 'House card','Interesting', '9.1');
# method :
select * from cinema where id%2=1 and description!='boring' order by rating desc;



# 626. Exchange Seats
drop table if exists seat;
Create table seat(id int, student varchar(20));
insert into seat (id, student) values ('1','Abbot');
insert into seat (id, student) values ('2','Doris');
insert into seat (id, student) values ('3','Emerson');
insert into seat (id, student) values ('4','Green');
insert into seat (id, student) values ('5','Jeames');
# method :
select case when id%2=1 and id=last_id then id when id%2=1 then id+1 else id-1 end id, student
from seat , (select max(id) last_id from seat) t1
order by case when id%2=1 and id=last_id then id when id%2=1 then id+1 else id-1 end ;



# 627. Swap Salary
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id`int(11) NOT NULL,
  `name`varchar(10) NOT NULL,
  `sex`varchar(10) NOT NULL,
 `salary` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `salary` VALUES ('1', 'A', 'm','2500');
INSERT INTO `salary` VALUES ('2', 'B', 'f','1500');
INSERT INTO `salary` VALUES ('3', 'C', 'm','5500');
INSERT INTO `salary` VALUES ('4', 'D', 'f','500');

# method :
show variables like 'SQL_SAFE_UPDATES';  #  查看开关状态。
SET SQL_SAFE_UPDATES = 0;  #  Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.
update salary set sex=case when sex='m' then 'f' else 'm' end ;
SET SQL_SAFE_UPDATES = 1;  #  恢复mysql执行update的时候，如果不是用主键当where语句报错。


# 1179. Reformat Department Table
drop table if exists department;
Create table department (id int,revenue int, month varchar(10));
insert into department(id,revenue,month) values(1,8000,'Jan');
insert into department(id,revenue,month) values(2,9000,'Jan');
insert into department(id,revenue,month) values(3,10000,'Feb');
insert into department(id,revenue,month) values(1,7000,'Feb');
insert into department(id,revenue,month) values(1,6000,'Mar');

# method :
select id,
max(if(month='Jan', revenue, null)) Jan_Revenue,
max(if(month='Feb', revenue, null)) Feb_Revenue,
max(if(month='Mar', revenue, null)) Mar_Revenue,
max(if(month='Apr', revenue, null)) Apr_Revenue,
max(if(month='May', revenue, null)) May_Revenue,
max(if(month='Jun', revenue, null)) Jun_Revenue,
max(if(month='Jul', revenue, null)) Jul_Revenue,
max(if(month='Aug', revenue, null)) Aug_Revenue,
max(if(month='Sep', revenue, null)) Sep_Revenue,
max(if(month='Oct', revenue, null)) Oct_Revenue,
max(if(month='Nov', revenue, null)) Nov_Revenue,
max(if(month='Dec', revenue, null)) Dec_Revenue
from department
group by id