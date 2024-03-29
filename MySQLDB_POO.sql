CREATE DATABASE BeatoJuanPabloII;

USE BeatoJuanPabloII ;

CREATE TABLE Empleados ( 
    id_Empleado INTEGER NOT NULL AUTO_INCREMENT, 
    Nombre       VARCHAR(30) NOT NULL,
    Apellidos    VARCHAR(30) NOT NULL,
    Cargo        VARCHAR(20) NOT NULL,
    Sueldo       FLOAT       NOT NULL,
    PRIMARY KEY (id_Empleado)
);

CREATE TABLE Profesores ( 
    id_Profesor   INTEGER     NOT NULL AUTO_INCREMENT,
    Nombre        VARCHAR(60) NOT NULL,
    Apellidos     VARCHAR(60) NOT NULL,
    Sueldo        FLOAT       NOT NULL,
    PRIMARY KEY (id_Profesor)
);

CREATE TABLE Estudiantes (
    id_Estudiante     INTEGER         NOT NULL AUTO_INCREMENT,
    Nombre            VARCHAR(255)    NOT NULL,
    Apellidos         VARCHAR(255)    NOT NULL,
    DNI               CHAR(8)         NOT NULL,
    Email             VARCHAR (255)   NOT NULL,
    numero_telefonico INTEGER         NOT NULL,
    PRIMARY KEY (id_Estudiante)
);

CREATE TABLE Clases (
    id_Clase    INTEGER      NOT NULL AUTO_INCREMENT,
    Nivel       VARCHAR(10)  NOT NULL,
    Grado       TINYINT      NOT NULL,
    Seccion     CHAR (1)     NOT NULL,
    id_Profesor INTEGER      NOT NULL,
    FOREIGN KEY (id_Profesor) REFERENCES Profesores(id_Profesor),
    PRIMARY KEY (id_Clase)
);

CREATE TABLE Pago (
    id_Pago     INTEGER     NOT NULL AUTO_INCREMENT,
    DNI_cliente CHAR(8)     NOT NULL,
    Fecha       DATE        NOT NULL,
    id_Empleado INTEGER     NOT NULL,
    FOREIGN KEY (id_Empleado) REFERENCES Empleados(id_Empleado),
    PRIMARY KEY (id_Pago)
);

 CREATE TABLE Estudiantes_Clases (
    id_Est_Clase  INTEGER       NOT NULL AUTO_INCREMENT,
    id_Clase      INTEGER       NOT NULL,
    id_Estudiante INTEGER       NOT NULL,
    FOREIGN KEY (id_Clase)      REFERENCES Clases(id_Clase),
    FOREIGN KEY (id_Estudiante) REFERENCES Estudiantes(id_Estudiante),
    Estado        VARCHAR(20)   NOT NULL,
    PRIMARY KEY (id_Est_Clase)
);

CREATE TABLE Detalle_Pago (
    id_DetallePago      INTEGER       NOT NULL AUTO_INCREMENT,
    id_Pago             INTEGER       NOT NULL,
    costo               INTEGER       NOT NULL,
    descripcion         VARCHAR(255)  NOT NULL,
    razon               VARCHAR(255)  NOT NULL,
    id_Est_Clase INTEGER       NOT NULL,
    FOREIGN KEY (id_Pago)      REFERENCES Pago(id_Pago),
    FOREIGN KEY (id_Est_Clase) REFERENCES Estudiantes_Clases(id_Est_Clase),
    PRIMARY KEY (id_DetallePago)
);

CREATE TABLE Cursos (
    id_Curso    INTEGER            NOT NULL AUTO_INCREMENT,
    Titulo      VARCHAR(50)        NOT NULL,
    id_Profesor INTEGER            NOT NULL,
    id_Clase    INTEGER            NOT NULL,
    FOREIGN KEY (id_Profesor) REFERENCES Profesores(id_Profesor),
    FOREIGN KEY (id_Clase)    REFERENCES Clases(id_Clase),
    PRIMARY KEY (id_Curso)
);