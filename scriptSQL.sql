create database AO2_medicos;
use AO2_medicos;

CREATE TABLE `medico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `especialidad` varchar(45) NOT NULL,
  `dAtencion` varchar(45) NOT NULL,
  `horario` varchar(45) NOT NULL,
  `imagen` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into medico(nombre, apellido, especialidad, dAtencion, horario)
values("Luis", "Herrera", "Clínica General", "Lunes - Miércoles - Viernes", "16 a 19 hs");

insert into medico(nombre, apellido, especialidad, dAtencion, horario)
values("Adriana", "Suárez", "Gastroenterología", "Jueves - Viernes", "15 a 19 hs");

insert into medico(nombre, apellido, especialidad, dAtencion, horario)
values("Gustavo", "Silva", "Cardiología", "Martes - Jueves - Viernes", "09 a 13 hs");

insert into medico(nombre, apellido, especialidad, dAtencion, horario)
values("Guillermo", "Wagner", "Pediatría", "Lunes - Martes - Jueves", "12 a 16 hs");

insert into medico(nombre, apellido, especialidad, dAtencion, horario)
values("Cecilia", "Rodriguez", "Oncología", "Martes - Miércoles - Jueves", "14 a 18 hs");