create database if not exists carros;

use carros;

drop table if exists carro;
drop table if exists modelo;
drop table if exists marca;

create table marca
(
	id integer not null,
    nome varchar(50) not null,
    primary key(id)
);

create table modelo
(
	id integer not null,
    id_marca integer not null,
    nome varchar(50) not null,
    primary key(id),
    foreign key(id_marca) references marca(id)
);

create table carro
(
	id integer not null,
    id_modelo integer not null,
    nome varchar(50) not null,
    renavam integer not null,
    placa varchar(7) not null,
    valor decimal(10, 2) not null,
    ano year not null,
    primary key(id),
    foreign key(id_modelo) references modelo(id)
);

insert into marca (id, nome) values (1, 'chevrolet');
insert into marca (id, nome) values (2, 'volkswagen');
insert into marca (id, nome) values (3, 'ford');
insert into marca (id, nome) values (4, 'toyota');

insert into modelo (id, id_marca, nome) values (1, 1, 'joy');
insert into modelo (id, id_marca, nome) values (2, 1, 'prisma');
insert into modelo (id, id_marca, nome) values (3, 2, 'gol');
insert into modelo (id, id_marca, nome) values (4, 2, 'polo');
insert into modelo (id, id_marca, nome) values (5, 3, 'ka');
insert into modelo (id, id_marca, nome) values (6, 3, 'fiesta');
insert into modelo (id, id_marca, nome) values (7, 4, 'corolla');
insert into modelo (id, id_marca, nome) values (8, 4, 'hilux');

insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (1, 1, 'joy', 123456789, 'ABC1234', 15000.00, 2015);
insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (2, 2, 'prisma', 987654321, 'DEF5678', 20000.00, 2017);
insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (3, 3, 'gol', 567891234, 'GHI9012', 18000.00, 2016);
insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (4, 4, 'polo', 432198765, 'JKL3456', 22000.00, 2018);
insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (5, 5, 'ka', 789123456, 'MNO5678', 17000.00, 2015);
insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (6, 6, 'fiesta', 345678912, 'PQR9012', 19000.00, 2017);
insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (7, 7, 'corolla', 891234567, 'STU3456', 30000.00, 2016);
insert into carro (id, id_modelo, nome, renavam, placa, valor, ano) values (8, 8, 'hilux', 456789123, 'VWX9012', 40000.00, 2018);



create table carro_seq
(
	next_val integer
);
insert into carro_seq(next_val) values (9);

create table marca_seq
(
	next_val integer
);
insert into marca_seq(next_val) values (9);

create table modelo_seq
(
	next_val integer
);
insert into modelo_seq(next_val) values (9);