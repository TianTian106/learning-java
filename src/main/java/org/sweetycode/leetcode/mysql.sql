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
