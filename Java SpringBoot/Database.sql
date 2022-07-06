create database AngularSpringBoot;
use AngularSpringBoot;

create table Persona(id_usuario int not null auto_increment,
nombre varchar(30),
apellido varchar(30),
email varchar(30),
telefono varchar(30),
edad int,
primary key(id_usuario)
);

insert into Persona(nombre,apellido,email,telefono,edad)
values('Kenneth','Garcia','kgarcia@gmail.com','12345678',0);