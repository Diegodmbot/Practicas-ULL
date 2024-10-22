/* Borramos todas las tablas */
DROP TABLE IF EXISTS Trabaja;
DROP TABLE IF EXISTS Subscrito;
DROP TABLE IF EXISTS Asistencia; 
DROP TABLE IF EXISTS Clase;
DROP TABLE IF EXISTS Pago;
DROP TABLE IF EXISTS Ofrece;
DROP TABLE IF EXISTS Producto CASCADE;
DROP TABLE IF EXISTS Monitor; 
DROP TABLE IF EXISTS Socio;
DROP TABLE IF EXISTS Maquina;
DROP TABLE IF EXISTS Gimnasio; 

/* 
 * Tabla Gimnasio: registra los diferentes ginmasios de la misma dueña,
 * guarda en ella datos que permiten identificarlo como su id único, 
 * nombre, la cantidad de socios que tiene etc. 
 */

CREATE TABLE IF NOT EXISTS Gimnasio (
   id INT PRIMARY KEY,
   nombre VARCHAR(45) NOT NULL,
   direccion VARCHAR(45) NOT NULL,
   no_plantas INT NOT NULL,
   n_socios INT NOT NULL
);


/* 
 * Tabla Monitor: registra a los monitores
 */


CREATE TABLE IF NOT EXISTS Monitor (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(45) NOT NULL,
  n_telefono VARCHAR(45) NOT NULL,
  hora_entrada TIME,
  hora_salida TIME,
  salario INT
);

/* 
 * Tabla Socio: registra los socios de la cadena de gimnasios
 */

CREATE TABLE IF NOT EXISTS Socio (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(45) NOT NULL,
  n_telefono VARCHAR(45) NOT NULL,
  id_socio INT
);

/*
 * Tabla Pago: registra los pagos realizados por los socios
 */

CREATE TABLE IF NOT EXISTS Pago (
  dni VARCHAR(9) PRIMARY KEY,
  tarifa FLOAT NOT NULL,
  fecha DATE NOT NULL,
  metodo_pago VARCHAR(45) NOT NULL,
  FOREIGN KEY (dni) REFERENCES Socio(dni)
);

/* 
 * Tabla Clase: registra las sesiones programadas que ofrece el gimnasio
 * y guarda su horario, de que es la clase (zumba, spinning, etc) y 
 * monitor que imparte dicha clase
 */

CREATE TABLE IF NOT EXISTS Clase (
   id_gimnasio INT,
   deporte VARCHAR(45),
   dni_monitor VARCHAR(9) NOT NULL,
   hora_inicio TIME NOT NULL,
   hora_fin TIME NOT NULL,
   FOREIGN KEY (id_gimnasio) REFERENCES Gimnasio (id),
   FOREIGN KEY (dni_monitor) REFERENCES Monitor (dni)
);

/* 
* Tabla Producto: registra una serie de productos que el gimnasio ofrece
* a la venta a sus clientes.
*/

CREATE TABLE IF NOT EXISTS Producto (
   prod_id INT PRIMARY KEY,
   stock INT NOT NULL,
   nombre VARCHAR(45) NOT NULL,
   fabricante VARCHAR(45),
   tipo VARCHAR(45),
   talla VARCHAR(3),
   precio FLOAT NOT NULL
);

/* 
 * Tabla Asistencia: registra la asistencia de los socios a las instalaciones
 */

CREATE TABLE IF NOT EXISTS Asistencia (
   id_gimnasio INT PRIMARY KEY,
   id_socio INT,
   fecha DATE NOT NULL,
   hora_entrada TIME NOT NULL,
   hora_salida TIME NOT NULL,
   FOREIGN KEY (id_gimnasio) REFERENCES Gimnasio (id)
);

/* 
 * Tabla Maquina: registra las maquinas que el gimnasio posee
 */

CREATE TABLE IF NOT EXISTS Maquina (
   id_maquina INT PRIMARY KEY,
   id_gimnasio INT NOT NULL,
   fabricante VARCHAR(45) NOT NULL,
   tipo VARCHAR(45) NOT NULL,
   FOREIGN KEY (id_gimnasio) REFERENCES Gimnasio (id)
);

/* 
 * Tabla Subscrito: registra los socios que están subscritos a un gimnasio
 */

CREATE TABLE IF NOT EXISTS Subscrito (
   dni_socio VARCHAR(9),
   id_gimnasio INT,
   FOREIGN KEY (id_gimnasio) REFERENCES Gimnasio (id),
   FOREIGN KEY (dni_socio) REFERENCES Socio (dni)
);

/* 
 * Tabla Trabaja: registra los monitores que trabajan en un gimnasio
 */

CREATE TABLE IF NOT EXISTS Trabaja (
   dni_monitor VARCHAR(9),
   id_gimnasio INT,
   FOREIGN KEY (id_gimnasio) REFERENCES Gimnasio (id),
   FOREIGN KEY (dni_monitor) REFERENCES Monitor (dni)
);

/*
 * Tabla Ofrece: Registra los productos que un gimnasio ofrece
 */

CREATE TABLE IF NOT EXISTS Ofrece (
   id_gimnasio INT NOT NULL,
   prod_id INT NOT NULL,
   FOREIGN KEY (id_gimnasio) REFERENCES Gimnasio (id),
   FOREIGN KEY (prod_id) REFERENCES Producto (prod_id)
);
