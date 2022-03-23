CREATE TABLE exame (cd_exame bigint auto_increment, nm_exame VARCHAR(255), PRIMARY KEY (cd_exame));

INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');


CREATE TABLE funcionario (cd_funcionario bigint auto_increment, nm_funcionario VARCHAR(255), PRIMARY KEY (cd_funcionario));

INSERT INTO funcionario (nm_funcionario) VALUES	('Renato'), ('Leonardo'), ('Marcos');


CREATE TABLE consulta (cd_consulta bigint auto_increment, cd_exame_consulta bigint, cd_funcionario_consulta bigint, dt_consulta date,
PRIMARY KEY (cd_exame_consulta, cd_funcionario_consulta),
CONSTRAINT fk_exame_consulta FOREIGN KEY (cd_exame_consulta) REFERENCES exame(cd_exame) ON DELETE CASCADE, 
CONSTRAINT fk_funcionario_consulta FOREIGN KEY (cd_funcionario_consulta) REFERENCES funcionario(cd_funcionario) 
ON DELETE CASCADE);

INSERT INTO consulta (cd_exame_consulta, cd_funcionario_consulta, dt_consulta) VALUES (1, 1, '2022-03-22'), (2, 1, '2022-03-23');

SELECT cd_consulta id, nm_exame exame, nm_funcionario funcionario, dt_consulta data
FROM consulta LEFT JOIN exame ON exame.cd_exame = consulta.cd_exame_consulta
LEFT JOIN funcionario ON funcionario.cd_funcionario = consulta.cd_funcionario_consulta