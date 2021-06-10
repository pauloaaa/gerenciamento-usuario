insert into cargo (nome) values ('Administrativo');
insert into cargo (nome) values ('Financeiro');
insert into cargo (nome) values ('Diretor');
insert into cargo (nome) values ('Departamento Pessoal');

insert into usuario (cpf, dt_nascimento, nome, sexo, cargo_id) values ('11111111111', current_timestamp, 'Maria', 'F', 1);
insert into usuario (cpf, dt_nascimento, nome, sexo, cargo_id) values ('22222222222', current_timestamp, 'João', 'M', 2);
insert into usuario (cpf, dt_nascimento, nome, sexo, cargo_id) values ('33333333333', current_timestamp, 'Carlos', 'M', 3);
insert into usuario (cpf, dt_nascimento, nome, sexo, cargo_id) values ('44444444444', current_timestamp, 'Fernanda', 'F', 4);

insert into perfil (nome, usuario_id) values ('Liderança', 1);
insert into perfil (nome, usuario_id) values ('Resiliente', 1);
insert into perfil (nome, usuario_id) values ('Inovador(a)', 3);