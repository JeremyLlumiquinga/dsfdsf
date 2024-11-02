drop table if exists registro_movimientos;
drop table if exists articulos;
drop table if exists grupos;

create table grupos(
	id char(5) not null,
	nombre char(50) not null,
	constraint grupos_pk primary key (id)
);

create table articulos(
	id char(5) not null,
	nombre char(50) not null,
	precio_venta money not null,
	precio_compra money not null,
	id_grupo char(5) not null,
	constraint articulos_pk primary key (id)
);

create table registro_movimientos(
	id serial not null,
	id_articulos char(5) not null,
	cantidad int not null,
	fecha_movimiento TIMESTAMP not null,
	constraint registro_movimientos_pk primary key (id)
);

alter table articulos
add constraint articulos_fk foreign key (id_grupo) references grupos(id);

alter table registro_movimientos
add constraint registro_movimientos_fk foreign key (id_articulos) references articulos(id);

insert into grupos (id,nombre)
values('G001','Aseo Personal');
insert into grupos (id,nombre)
values('G002','Tecnologia');
insert into grupos (id,nombre)
values('G003','Ropa');

insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A001','Jabón',5.2,4.1,'G001');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A002','Shampoo',6.2,5.1,'G001');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A003','Hilo Dental',3,1.5,'G001');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A004','Audífonos',35.5,20.1,'G002');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A005','Televisión',105,95.1,'G002');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A006','Teclado',45,34.5,'G002');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A007','Mouse',42.6,37.6,'G002');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A008','Gorra',15,10.1,'G003');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A009','Chompa',52.2,44.5,'G003');
insert into articulos(id,nombre,precio_venta,precio_compra,id_grupo)
values('A010','Camisa',65,60,'G003');

insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A001',5,'2019/05/21 10:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A002',2,'2019/06/23 11:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A003',6,'2019/07/26 12:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A004',2,'2019/08/28 01:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A005',1,'2020/09/01 02:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A006',2,'2020/01/05 03:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A007',3,'2020/02/09 04:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A008',5,'2020/03/15 05:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A009',3,'2021/04/19 06:35');
insert into registro_movimientos(id_articulos,cantidad,fecha_movimiento)
values('A010',2,'2021/05/22 07:35');

select gr.*,ar.*,rm.fecha_movimiento from grupos gr, articulos ar, registro_movimientos rm
where rm.fecha_movimiento >=(select fecha_movimiento from registro_movimientos where id = 1)
and  gr.id = ar.id_grupo and ar.id = rm.id_articulos

select * from articulos
select * from grupos
select * from registro_movimientos

