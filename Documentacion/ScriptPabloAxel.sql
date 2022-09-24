--Tablas
drop table usuario;
create table usuario(
    username varchar(50) primary key,
    password varchar(50) not null,
    correo varchar(50)
    );

drop table modo;
create table modo(
    id number generated always as identity primary key,
    cantJugadores int not null,
    tipo varchar(50) not null
    );

drop table lugar;
create table lugar(
    id number generated always as identity primary key,
    Tipo varchar(50),
    Nombre varchar(50) not null,
    Popularidad varchar(50)
    );

drop table cosmetico;
create table cosmetico(
    id number generated always as identity primary key,
    Tipo varchar(50) not null,
    Nombre varchar(50) not null,
    Rareza varchar(50) not null,
    Precio int not null
    );

drop table arma;
create table arma(
    id number generated always as identity primary key,
    Tipo varchar(50),
    Nombre varchar(50) not null,
    Rareza varchar(50),
    damage int not null,
    cargador int not null,
    cadencia float not null
    );

create table tipo_arma (
id number generated always as identity primary key,
nombre varchar(50)
);

create table relacion(
id_tipo number,
id_arma number,
primary key(id_tipo, id_arma),
foreign key(id_tipo) REFERENCES tipo_arma(id),
foreign key(id_arma) references arma(id)
);

create table control( 
 operacion varchar2(20), 
 fecha date, 
 usuario varchar2(30), 
 tabla varchar2(30), 
 id_registro number, 
 datos_anteriores varchar(100), 
 datos_nuevos varchar(100) 
 );

create table temp(
    username varchar2,
    password varchar2,
    correo varchar2,
    cantJugadores number,
    tipo_modo varchar2,
    tipo_lugar varchar2, 
    nombre varchar2, 
    popularidad varchar2,
    tipo_cosmetico varchar2,
    nombre varchar2,
    rareza varchar2,
    precio number,
    tipo_arma varchar2,
    nombre varchar2,
    rareza varchar2,
    damage number, 
    cargador number,
    cadencia float;
);


--Indices
create index I_usuario_username on usuario(username);
create index I_modo_id on modo(id);
create index I_lugar_id on lugar(id);
create index I_cosmetico_id on cosmetico(id);
create index I_arma_id on arma(id);


--Triggers
alter session set NLS_DATE_FORMAT = 'DD/MM/YYYY HH24:MI';

create or replace trigger tr_cambios_usuario 
 before insert or update or delete 
 on usuario 
 for each row 
begin 
 if inserting then 
   insert into control values ('Insercion',sysdate,user,'Usuario',null,:old.username || :old.password || :old.correo,:new.username || :new.password || :new.correo); 
 end if; 
 if updating then 
  insert into control values ('Actualizacion',sysdate,user,'Usuario',null,:old.username || :old.password || :old.correo,:old.username || :new.password || :new.correo); 
 end if; 
 if deleting then 
   insert into control values ('Borrado',sysdate,user,'Usuario',null,:old.username || :old.password || :old.correo,:old.username || :old.password || :old.correo); 
 end if; 
end tr_cambios_usuarios; 


create or replace trigger tr_cambios_modo 
 before insert or update or delete 
 on modo 
 for each row 
begin 
 if inserting then 
   insert into control values ('Insercion',sysdate,user,'Modo',:new.id,:old.cantJugadores || :old.tipo, :new.cantJugadores || :new.tipo); 
 end if; 
 if updating then 
  insert into control values ('Actualizacion',sysdate,user,'Modo',:old.id,:old.cantJugadores || :old.tipo, :new.cantJugadores || :new.tipo); 
 end if; 
 if deleting then 
   insert into control values ('Borrado',sysdate,user,'Modo',:old.id,:old.cantJugadores || :old.tipo, :old.cantJugadores || :old.tipo); 
 end if; 
end tr_cambios_modo;


create or replace trigger tr_cambios_lugar
 before insert or update or delete 
 on lugar 
 for each row 
begin 
 if inserting then 
   insert into control values ('Insercion',sysdate,user,'Lugar',:new.id, :old.tipo || :old.nombre || :old.popularidad,:new.tipo || :new.nombre || :new.popularidad); 
 end if; 
 if updating then 
  insert into control values ('Actualizacion',sysdate,user,'Lugar',:old.id,:old.tipo || :old.nombre || :old.popularidad,:new.tipo || :new.nombre || :new.popularidad); 
 end if; 
 if deleting then 
   insert into control values ('Borrado',sysdate,user,'Lugar',:old.id,:old.tipo || :old.nombre || :old.popularidad,:old.tipo || :old.nombre || :old.popularidad); 
 end if; 
end tr_cambios_lugar;


create or replace trigger tr_cambios_cosmetico
 before insert or update or delete 
 on cosmetico 
 for each row 
begin 
 if inserting then 
   insert into control values ('Insercion',sysdate,user,'Cosmetico',:new.id, :old.tipo || :old.nombre || :old.rareza || :old.precio ,:new.tipo || :new.nombre || :new.rareza || :new.precio); 
 end if; 
 if updating then 
  insert into control values ('Actualizacion',sysdate,user,'Cosmetico',:old.id, :old.tipo || :old.nombre || :old.rareza || :old.precio ,:new.tipo || :new.nombre || :new.rareza || :new.precio); 
 end if; 
 if deleting then 
   insert into control values ('Borrado',sysdate,user,'Cosmetico',:old.id, :old.tipo || :old.nombre || :old.rareza || :old.precio ,:old.tipo || :old.nombre || :old.rareza || :old.precio); 
 end if; 
end tr_cambios_cosmetico;

create or replace trigger tr_cambios_arma 
 before insert or update or delete 
 on arma 
 for each row 
begin 
 if inserting then 
   insert into control values ('Insercion',sysdate,user,'Arma',:new.id, :old.tipo || :old.nombre || :old.rareza || :old.damage || :old.cargador || :old.cadencia,:new.tipo || :new.nombre || :new.rareza || :new.damage || :new.cargador || :new.cadencia); 
 end if; 
 if updating then 
  insert into control values ('Actualizacion',sysdate,user,'Arma',:old.id, :old.tipo || :old.nombre || :old.rareza || :old.damage || :old.cargador || :old.cadencia,:new.tipo || :new.nombre || :new.rareza || :new.damage || :new.cargador || :new.cadencia); 
 end if; 
 if deleting then 
   insert into control values ('Borrado',sysdate,user,'Arma',:old.id, :old.tipo || :old.nombre || :old.rareza || :old.damage || :old.cargador || :old.cadencia,:old.tipo || :old.nombre || :old.rareza || :old.damage || :old.cargador || :old.cadencia); 
 end if; 
end tr_cambios_arma;

--Procedimiento
create or replace procedure normalizacion is
Cursor hilera is select * from temp;
begin
for item in hilera
loop
insert into usuario values(item.username,item.password,item.correo);
insert into modo(cantJUgadores,tipo) values(item.cantJUgadores, item.tipo_modo);
insert into lugar(tipo, nombre, popularidad) values(item.tipo_lugar, item.nombre,item.popularidad);
insert into cosmetico(tipo,nombre,rareza,precio) values(item.tipo_cosmetico, item.nombre, item.rareza,item.precio);
insert into arma(tipo,nombre,rareza,damage,cargador,cadencia) values(item.tipo_arma,item.nombre,item.rareza,item.damage,item.cagador,item.cadencia);
end loop;
end;

--Funcion
create or replace function insert_tipo(nombreParam varchar2) return number is
temp_id number;
begin
select id into temp_id from tipo_arma where nombre = nombreParam;
return temp_id;
exception when no_data_found then
insert into tipo_arma(nombre) values(nombreParam);
select id into temp_id from tipo_arma where nombre = nombreParam;
return (temp_id);
end;

create procedure relacionArma is
cursor hilera is select * from arma;
temp_id number;
begin
for item in hilera loop
temp_id := insert_tipo(item.tipo);
insert into relacion values(temp_id, item.id);
end loop;
end;