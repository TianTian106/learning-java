# 175. Combine Two Tables
Create table Person (PersonId int, FirstName varchar(20), LastName varchar(20));
Create table Address (AddressId int, PersonId int, City varchar(20), State varchar(20));
# method :
select FirstName, LastName, City, State
from Person t1
left outer join Address t2
on t1.PersonId=t2.PersonId;



# 176. Second Highest Salary
Create table Employee (Id int, Salary int);
insert into Employee (Id, Salary) values('1', '100');
insert into Employee (Id, Salary) values('2', '200');
insert into Employee (Id, Salary) values('3', '300');
# method 1 :
select ( select Salary from Employee group by Salary order by Salary desc limit 1,1 ) as SecondHighestSalary;
# method 2 :
select IFNULL((select Salary from Employee group by Salary order by Salary desc limit 1,1), null ) as SecondHighestSalary



# 177. Nth Highest Salary
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





# 262. Trips and Users
Create table Trips (Id int,Client_Id int, Driver_Id int, City_Id int, Status ENUM('completed','cancelled_by_driver', 'cancelled_by_client'), Request_at varchar(50));
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







#  601. Human Traffic of Stadium
CREATE TABLE `stadium` (
  `id` INT(10) UNSIGNED NOT NULL COMMENT 'id',
  `date` Date NOT NULL COMMENT '时间',
  `people` INT(10) UNSIGNED NULL DEFAULT NULL COMMENT '人流量',
  PRIMARY KEY (`id`)
)
  COMMENT='体育馆的人流量'
  COLLATE='utf8_general_ci'
  ENGINE=InnoDB;

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
