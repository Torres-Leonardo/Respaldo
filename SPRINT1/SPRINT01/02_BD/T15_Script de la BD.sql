-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-03-25 04:50:59.255

-- tables
-- Table: APODERADO
CREATE TABLE APODERADO (
    IDAPO char(6)  NOT NULL COMMENT 'Contiene el identificador digital del apoderado.',
    NOMAPO varchar(50)  NOT NULL COMMENT 'Contiene los nombres del apoderado.',
    APEAPO varchar(50)  NOT NULL COMMENT 'Contiene los apellidos del apoderado.',
    DNIAPO char(8)  NOT NULL COMMENT 'Contiene el género del apoderado F o M.',
    SEXAPO char(1)  NOT NULL COMMENT 'Contiene el número de celular del apoderado.',
    PARAPO varchar(50)  NOT NULL COMMENT 'Contiene el parentesco del apoderado con el apoderado.',
    FECNACAPO date  NOT NULL COMMENT 'Contiene la fecha de nacimiento del apoderado.',
    NUMDONIDEAPO varchar(100)  NOT NULL COMMENT 'Contiene el correo del apoderado.',
    DIRACTAPO Varchar(100)  NOT NULL COMMENT 'Contiene la dirección actual del apoderado.',
    CELAPO Char(9)  NOT NULL COMMENT 'Contiene el celular del apoderado.',
    IDUBI char(6)  NOT NULL COMMENT 'Contiene le ID del ubigeo.',
    CONSTRAINT APODERADO_pk PRIMARY KEY (IDAPO)
) COMMENT 'Contiene los datos del apoderado.';

-- Table: AULA
CREATE TABLE AULA (
    IDGRAYSEC Char(2)  NOT NULL COMMENT '  ',
    CONSTRAINT AULA_pk PRIMARY KEY (IDGRAYSEC)
) COMMENT 'Contiene la información del grado y sección.';

-- Table: ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    IDEST char(6)  NOT NULL COMMENT 'Contiene el identificador digital del estudiante.',
    NOMEST varchar(50)  NOT NULL COMMENT 'Contiene los nombres del estudiante.',
    APEEST varchar(50)  NOT NULL COMMENT 'Contiene los apellidos del estudiante.',
    DNIEST char(8)  NOT NULL COMMENT 'Contiene el género del estudiante F o M.',
    DIRACTEST Varchar(100)  NOT NULL COMMENT 'contiene la dirección actual del estudiante.',
    FECNACEST date  NOT NULL COMMENT 'Contiene la fecha de nacimiento del estudiante.',
    NUMDOCIDEEST varchar(100)  NOT NULL COMMENT 'Contiene el numero de documento de identidad del estudiante.',
    IDAPO char(6)  NOT NULL COMMENT 'Contiene el ID del apoderado.',
    IDUBI char(6)  NOT NULL COMMENT 'Contiene el ID del ubigeo.',
    CONSTRAINT ESTUDIANTE_pk PRIMARY KEY (IDEST)
) COMMENT 'Contiene los datos del estudiante.';

-- Table: IEP
CREATE TABLE IEP (
    IDIEP char(7)  NOT NULL COMMENT 'Contiene el Identificador Digital del código modular del colegio.',
    NOMIEP varchar(80)  NOT NULL COMMENT 'Contiene el nombre de la Institución Educativa.',
    IDMAT char(6)  NOT NULL COMMENT 'Contiene el Identificador digital de la matrícula.',
    CONSTRAINT IEP_pk PRIMARY KEY (IDIEP)
) COMMENT 'Contiene la información de la I.E.P.';

-- Table: MATRICULA
CREATE TABLE MATRICULA (
    IDMAT char(6)  NOT NULL COMMENT 'Contiene el identificador digital de las matricula.',
    NUM_VAC varchar(150)  NOT NULL COMMENT 'Contiene el número de matricula disponible.',
    IDEST char(6)  NOT NULL COMMENT 'Contiene el identificador digital del estudiante.',
    IDAPO char(6)  NOT NULL COMMENT 'Contiene el identificador digital del apoderado.',
    IDTUT char(5)  NOT NULL COMMENT 'Contiene el identificador digital del tutor.',
    IDAUL char(2)  NOT NULL COMMENT 'Contiene el identificador digital del aula.',
    IDUBI char(6)  NOT NULL COMMENT 'Contiene el identificador digital del ubigeo.',
    IDMATPER char(6)  NOT NULL COMMENT 'Contiene el identificador digital de la matrícula personal.',
    MODINGMAT char(1)  NOT NULL COMMENT 'Contiene la modalidad de ingreso del estudiante (Nuevo, Continuador, Traslado).',
    FECMAT Date  NOT NULL COMMENT 'Contiene la fecha en la que se realizo la matricula.',
    CONSTRAINT MATRICULA_pk PRIMARY KEY (IDMAT)
) COMMENT 'Contiene los datos de la Matricula.';

-- Table: MATRICULA_DETALLE
CREATE TABLE MATRICULA_DETALLE (
    IDMATDET Char(6)  NOT NULL COMMENT 'Contiene el Identificador digital de la matrícula detalle.',
    IDEST char(6)  NOT NULL COMMENT 'Contiene el Identificador digital del estudiante.',
    IDMAT char(6)  NOT NULL COMMENT 'Contiene el Identificador digital de matricula.',
    IDAUL Char(2)  NOT NULL COMMENT ' ',
    CONSTRAINT MATRICULA_DETALLE_pk PRIMARY KEY (IDMATDET)
) COMMENT 'Contiene los detalles de la matricula.';

-- Table: MATRICULA_PERSONAL
CREATE TABLE MATRICULA_PERSONAL (
    IDMATPER char(6)  NOT NULL COMMENT 'Contiene el ID del personal de matrícula.',
    NOMPER varchar(50)  NOT NULL COMMENT 'Contiene los nombres del personal.',
    APEPER varchar(50)  NOT NULL COMMENT 'Contiene los apellidos del personal.',
    CARPER Varchar(30)  NOT NULL COMMENT ' ',
    CONSTRAINT MATRICULA_PERSONAL_pk PRIMARY KEY (IDMATPER)
) COMMENT 'Contiene al personal de la matrícula.';

-- Table: TUTOR
CREATE TABLE TUTOR (
    IDTUT char(5)  NOT NULL COMMENT 'Contiene el identificador digital del tutor(a).',
    NOMTUT varchar(50)  NOT NULL COMMENT 'Contiene el nombre  del tutor(a).',
    APETUT varchar(50)  NOT NULL COMMENT 'Contiene el apellido  del tutor(a).',
    DNITUT char(8)  NOT NULL COMMENT 'Contiene el DNI  del tutor(a).',
    CELTUT char(9)  NOT NULL COMMENT 'Contiene el número de teléfono  del tutor(a).',
    EMAILTUT Varchar(100)  NOT NULL COMMENT 'Contiene el email del tutor.',
    DIRACTTUT varchar(100)  NOT NULL COMMENT 'Contiene la dirección actual del tutor.',
    IDEST char(6)  NOT NULL COMMENT 'Contiene el identificador digital del estudiante.',
    IDUBI char(6)  NOT NULL COMMENT 'Contiene el identificador digital del ubigeo.',
    CONSTRAINT TUTOR_pk PRIMARY KEY (IDTUT)
) COMMENT 'Contiene la información  del tutor(a).';

-- Table: UBIGEO
CREATE TABLE UBIGEO (
    IDUBI char(6)  NOT NULL COMMENT 'Contiene el identificador digital del ubigeo.',
    DEPUBU varchar(100)  NOT NULL COMMENT 'Contiene  el nombre del departamento.',
    PROUBI varchar(10)  NOT NULL COMMENT 'Contiene  el nombre de la provincia.',
    DISTUBI varchar(100)  NOT NULL COMMENT 'Contiene el nombre del distrito.',
    CONSTRAINT UBIGEO_pk PRIMARY KEY (IDUBI)
) COMMENT 'Contiene el información del ubigeo.';

-- foreign keys
-- Reference: APODERADO_UBIGEO (table: APODERADO)
ALTER TABLE APODERADO ADD CONSTRAINT APODERADO_UBIGEO FOREIGN KEY APODERADO_UBIGEO (IDUBI)
    REFERENCES UBIGEO (IDUBI);

-- Reference: ESTUDIANTE_APODERADO (table: ESTUDIANTE)
ALTER TABLE ESTUDIANTE ADD CONSTRAINT ESTUDIANTE_APODERADO FOREIGN KEY ESTUDIANTE_APODERADO (IDAPO)
    REFERENCES APODERADO (IDAPO);

-- Reference: ESTUDIANTE_UBIGEO (table: ESTUDIANTE)
ALTER TABLE ESTUDIANTE ADD CONSTRAINT ESTUDIANTE_UBIGEO FOREIGN KEY ESTUDIANTE_UBIGEO (IDUBI)
    REFERENCES UBIGEO (IDUBI);

-- Reference: IEP_MATRICULA (table: IEP)
ALTER TABLE IEP ADD CONSTRAINT IEP_MATRICULA FOREIGN KEY IEP_MATRICULA (IDMAT)
    REFERENCES MATRICULA (IDMAT);

-- Reference: MATRICULA_APODERADO (table: MATRICULA)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_APODERADO FOREIGN KEY MATRICULA_APODERADO (IDAPO)
    REFERENCES APODERADO (IDAPO);

-- Reference: MATRICULA_AULA (table: MATRICULA)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_AULA FOREIGN KEY MATRICULA_AULA (IDAUL)
    REFERENCES AULA (IDGRAYSEC);

-- Reference: MATRICULA_DETALLE_AULA (table: MATRICULA_DETALLE)
ALTER TABLE MATRICULA_DETALLE ADD CONSTRAINT MATRICULA_DETALLE_AULA FOREIGN KEY MATRICULA_DETALLE_AULA (IDAUL)
    REFERENCES AULA (IDGRAYSEC);

-- Reference: MATRICULA_DETALLE_ESTUDIANTE (table: MATRICULA_DETALLE)
ALTER TABLE MATRICULA_DETALLE ADD CONSTRAINT MATRICULA_DETALLE_ESTUDIANTE FOREIGN KEY MATRICULA_DETALLE_ESTUDIANTE (IDEST)
    REFERENCES ESTUDIANTE (IDEST);

-- Reference: MATRICULA_DETALLE_MATRICULA (table: MATRICULA_DETALLE)
ALTER TABLE MATRICULA_DETALLE ADD CONSTRAINT MATRICULA_DETALLE_MATRICULA FOREIGN KEY MATRICULA_DETALLE_MATRICULA (IDMAT)
    REFERENCES MATRICULA (IDMAT);

-- Reference: MATRICULA_ESTUDIANTE (table: MATRICULA)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_ESTUDIANTE FOREIGN KEY MATRICULA_ESTUDIANTE (IDEST)
    REFERENCES ESTUDIANTE (IDEST);

-- Reference: MATRICULA_MATRICULA_PERSONAL (table: MATRICULA)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_MATRICULA_PERSONAL FOREIGN KEY MATRICULA_MATRICULA_PERSONAL (IDMATPER)
    REFERENCES MATRICULA_PERSONAL (IDMATPER);

-- Reference: MATRICULA_TUTOR (table: MATRICULA)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_TUTOR FOREIGN KEY MATRICULA_TUTOR (IDTUT)
    REFERENCES TUTOR (IDTUT);

-- Reference: MATRICULA_UBIGEO (table: MATRICULA)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_UBIGEO FOREIGN KEY MATRICULA_UBIGEO (IDUBI)
    REFERENCES UBIGEO (IDUBI);

-- Reference: TUTOR_ESTUDIANTE (table: TUTOR)
ALTER TABLE TUTOR ADD CONSTRAINT TUTOR_ESTUDIANTE FOREIGN KEY TUTOR_ESTUDIANTE (IDEST)
    REFERENCES ESTUDIANTE (IDEST);

-- Reference: TUTOR_UBIGEO (table: TUTOR)
ALTER TABLE TUTOR ADD CONSTRAINT TUTOR_UBIGEO FOREIGN KEY TUTOR_UBIGEO (IDUBI)
    REFERENCES UBIGEO (IDUBI);

-- End of file.

