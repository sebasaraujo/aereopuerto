CREATE TABLE PAIS (
	CODIGO_PA serial NOT NULL,
	NOMBRE_PA varchar(100) NOT NULL,
	ESTADO_PA varchar(1) NOT NULL,
	USUARIO_ACT_PA integer NOT NULL,
	FECHA_ACT_PA DATE NOT NULL,
	CONSTRAINT PAIS_pk PRIMARY KEY (CODIGO_PA)
) WITH (
  OIDS=FALSE
);



CREATE TABLE CIUDAD (
	CODIGO_CI serial NOT NULL,
	NOMBRE_CI varchar(100) NOT NULL,
	ESTADO_CI varchar(1) NOT NULL,
	USUARIO_ACT_CI integer NOT NULL,
	FECHA_ACT_CI DATE NOT NULL,
	PAIS integer NOT NULL,
	CONSTRAINT CIUDAD_pk PRIMARY KEY (CODIGO_CI)
) WITH (
  OIDS=FALSE
);



CREATE TABLE AEREOPUERTO (
	CODIGO_AE serial NOT NULL,
	NOMBRE_AE varchar(500) NOT NULL,
	ESTADO_AE varchar(1) NOT NULL,
	USUARIO_ACT_AE integer NOT NULL,
	FECHA_ACT_AE DATE NOT NULL,
	NEMONICO_AE varchar(500),
	CIUDAD integer NOT NULL,
	CONSTRAINT AEREOPUERTO_pk PRIMARY KEY (CODIGO_AE)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TIPO_PASAJERO (
	CODIGO_TP serial NOT NULL,
	NOMBRE_TP varchar(100) NOT NULL,
	ESTADO_TP varchar(1) NOT NULL,
	USUARIO_ACT_TP integer NOT NULL,
	FECHA_ACT_TP DATE NOT NULL,
	CONSTRAINT TIPO_PASAJERO_pk PRIMARY KEY (CODIGO_TP)
) WITH (
  OIDS=FALSE
);



CREATE TABLE PASAJERO (
	CODIGO_PS serial NOT NULL,
	NOMBRE_PS varchar(100) NOT NULL,
	APELLIDO_PS varchar(100) NOT NULL,
	IDENTIFIACION_PS varchar(20) NOT NULL,
	CORREO_PS varchar(100) NOT NULL,
	TIPO_IDENTIFICACION integer NOT NULL,
	DIRECCION integer NOT NULL,
	ESTADO_PS varchar(1) NOT NULL,
	USUARIO_ACT_PS integer NOT NULL,
	FECHA_ACT_PS DATE NOT NULL,
	TIPO_PASAJERO integer NOT NULL,
	CONSTRAINT PASAJERO_pk PRIMARY KEY (CODIGO_PS)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TIPO_IDENTIFICACION (
	CODIGO_TI serial NOT NULL,
	NOMBRE_TI varchar(100) NOT NULL,
	ESTADO_TI varchar(1) NOT NULL,
	USUARIO_ACT_TI integer NOT NULL,
	FECHA_ACT_TI DATE NOT NULL,
	CONSTRAINT TIPO_IDENTIFICACION_pk PRIMARY KEY (CODIGO_TI)
) WITH (
  OIDS=FALSE
);



CREATE TABLE DIRECCION (
	CODIGO_DI serial NOT NULL,
	CALLE_PRINCIPAL_DI varchar(1000) NOT NULL,
	CALLE_SECUNDARIA_DI varchar(1000) NOT NULL,
	NUMERO_DI varchar(20) NOT NULL,
	CODIGO_POSTAL varchar(100) NOT NULL,
	CONSTRAINT DIRECCION_pk PRIMARY KEY (CODIGO_DI)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TIPO_CONTACTO (
	CODIGO_TC serial NOT NULL,
	NOMBRE_TC varchar(500) NOT NULL,
	ESTADO_TC varchar(1) NOT NULL,
	USUARIO_ACT_TP integer NOT NULL,
	FECHA_ACT_TP DATE NOT NULL,
	CONSTRAINT TIPO_CONTACTO_pk PRIMARY KEY (CODIGO_TC)
) WITH (
  OIDS=FALSE
);



CREATE TABLE CONTACTO_PASAJERO (
	CODIGO_CP serial NOT NULL,
	NUMERO_CP varchar(20) NOT NULL,
	ESTADO_CP varchar(1) NOT NULL,
	USUARIO_ACT_CP integer NOT NULL,
	FECHA_ACT_CP DATE NOT NULL,
	TIPO_CONTACTO integer NOT NULL,
	PASAJERO integer NOT NULL,
	CONSTRAINT CONTACTO_PASAJERO_pk PRIMARY KEY (CODIGO_CP)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TIPO_VUELO (
	CODIGO_TV serial NOT NULL,
	NOMBRE_TV varchar(100) NOT NULL,
	ESTADO_TV varchar(1) NOT NULL,
	USUARIO_ACT_TV integer NOT NULL,
	FECHA_ACT_TV DATE NOT NULL,
	CONSTRAINT TIPO_VUELO_pk PRIMARY KEY (CODIGO_TV)
) WITH (
  OIDS=FALSE
);



CREATE TABLE VUELO (
	CODIGO_VU serial NOT NULL,
	NUMERO_VU varchar(100) NOT NULL,
	FECHA_VU DATE NOT NULL,
	HORA_VU FLOAT,
	DURACION_VU FLOAT NOT NULL,
	ESTADO_VU varchar(1) NOT NULL,
	USUARIO_ACT_VU integer NOT NULL,
	FECHA_ACT_VU DATE NOT NULL,
	TIPO_ESTADO integer NOT NULL,
	TIPO_VUELO integer NOT NULL,
	AEREOPUERTO integer NOT NULL,
	AEREOPUERTO_LLEGADA INTEGER,
	AEREOLINEA integer NOT NULL,
	CONSTRAINT VUELO_pk PRIMARY KEY (CODIGO_VU)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TIPO_ESTADO (
	CODIGO_TE serial NOT NULL,
	NOMBRE_TE varchar(100) NOT NULL,
	ESTADO_TE varchar(1) NOT NULL,
	USUARIO_ACT_TE integer NOT NULL,
	FECHA_ACT_TE DATE NOT NULL,
	CONSTRAINT TIPO_ESTADO_pk PRIMARY KEY (CODIGO_TE)
) WITH (
  OIDS=FALSE
);



CREATE TABLE AEREOLINEA (
	CODIGO_AR serial NOT NULL,
	NOMBRE_AR varchar(500) NOT NULL,
	ESTADO_AR varchar(1) NOT NULL,
	USUARIO_ACT_AR integer NOT NULL,
	FECHA_ACT_AR DATE NOT NULL,
	CONSTRAINT AEREOLINEA_pk PRIMARY KEY (CODIGO_AR)
) WITH (
  OIDS=FALSE
);



CREATE TABLE RESERVA (
	CODIGO_RS serial NOT NULL,
	DESDE_RS integer NOT NULL,
	HACIA_RS integer NOT NULL,
	FECHA_SALIDA DATE NOT NULL,
	FECHA_RETORNO DATE NOT NULL,
	NUMERO_RS varchar(100) NOT NULL,
	PRODUCTO_IDA_RS integer NOT NULL,
	PRODUCTO_RETORNO_RS integer,
	ESTADO_RS varchar(1) NOT NULL,
	USUARIO_ACT_RS integer NOT NULL,
	FECHA_ACT_RS DATE NOT NULL,
	TIPO_RESERVA integer,
	CONSTRAINT RESERVA_pk PRIMARY KEY (CODIGO_RS)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TIPO_RESERVA (
	CODIGO_TR serial NOT NULL,
	NOMBRE_TR varchar(100) NOT NULL,
	ESTADO_TR varchar(1) NOT NULL,
	USUARIO_ACT_TR integer NOT NULL,
	FECHA_ACT_TR DATE NOT NULL,
	CONSTRAINT TIPO_RESERVA_pk PRIMARY KEY (CODIGO_TR)
) WITH (
  OIDS=FALSE
);



CREATE TABLE PASAJERO_RESERVA (
	CODIGO_PR serial NOT NULL,
	PASAJERO integer NOT NULL,
	RESERVA integer NOT NULL,
	CONSTRAINT PASAJERO_RESERVA_pk PRIMARY KEY (CODIGO_PR)
) WITH (
  OIDS=FALSE
);


CREATE TABLE TIPO_PRODUCTO (
	CODIGO_TPR serial NOT NULL,
	NOMBRE_TPR varchar(500) NOT NULL,
	ESTADO_TPR varchar(1) NOT NULL,
	USUARIO_ACT_TPR integer NOT NULL,
	FECHA_ACT_TPR DATE NOT NULL,
	CONSTRAINT TIPO_PRODUCTO_pk PRIMARY KEY (CODIGO_TPR)
) WITH (
  OIDS=FALSE
);



CREATE TABLE PRODUCTO (
	CODIGO_PO serial NOT NULL,
	NOMBRE_PO varchar(500) NOT NULL,
	AEREOPUERTO_LLEGADA integer NOT NULL,
	AEREOPUERTO_SALIDA integer NOT NULL,
	AEREOLINEA integer NOT NULL,
	TIPO_PRODUCTO integer NOT NULL,
	PRECIO_PO FLOAT NOT NULL,
	ESTADO_PO varchar(1) NOT NULL,
	USUARIO_ACT_PO integer NOT NULL,
	FECHA_ACT_PO DATE NOT NULL,
	CONSTRAINT PRODUCTO_pk PRIMARY KEY (CODIGO_PO)
) WITH (
  OIDS=FALSE
);


CREATE TABLE PRODUCTO_VUELO (
	CODIGO_PV serial NOT NULL,
	PRODUCTO integer NOT NULL,
	VUELO integer NOT NULL,
	CONSTRAINT PRODUCTO_VUELO_pk PRIMARY KEY (CODIGO_PV)
) WITH (
  OIDS=FALSE
);

CREATE TABLE TIPO_CABINA (
	CODIGO_TC serial NOT NULL,
	NOMBRE_TC varchar(500) NOT NULL,
	ESTADO_TC varchar(1) NOT NULL,
	USUARIO_ACT_TC integer NOT NULL,
	FECHA_ACT_TC DATE NOT NULL,
	CONSTRAINT TIPO_CABINA_pk PRIMARY KEY (CODIGO_TC)
) WITH (
  OIDS=FALSE
);



CREATE TABLE CABINA_VUELO (
	CODIGO_CV serial NOT NULL,
	TIPO_ASIENTO integer NOT NULL,
	NUMERO_ASIENTOS_CV integer NOT NULL,
	NUMERO_ASIENTOS_DISPONIBLES_CV integer NOT NULL,
	VUELO integer NOT NULL,
	ESTADO_CV varchar(1) NOT NULL,
	USUARIO_ACT_CV integer NOT NULL,
	FECHA_ACT_CV DATE NOT NULL,
	CONSTRAINT CABINA_VUELO_pk PRIMARY KEY (CODIGO_CV)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TIPO_TARIFA (
	CODIGO_TT serial NOT NULL,
	NOMBRE_TT varchar(500) NOT NULL,
	ESTADO_TT varchar(1) NOT NULL,
	USUARIO_ACT_TT integer NOT NULL,
	FECHA_ACT_TT DATE NOT NULL,
	CONSTRAINT TIPO_TARIFA_pk PRIMARY KEY (CODIGO_TT)
) WITH (
  OIDS=FALSE
);



CREATE TABLE TARIFA_PRODUCTO (
	CODIGO_TP serial NOT NULL,
	PRODUCTO integer NOT NULL,
	TIPO_TARIFA integer NOT NULL,
	TIPO_CABINA integer NOT NULL,
	COSTO_TP FLOAT NOT NULL,
	ESTADO_TP varchar(1) NOT NULL,
	USUARIO_ACT_TP integer NOT NULL,
	FECHA_ACT_TP DATE NOT NULL,
	CONSTRAINT TARIFA_PRODUCTO_pk PRIMARY KEY (CODIGO_TP)
) WITH (
  OIDS=FALSE
);


ALTER TABLE CIUDAD ADD CONSTRAINT CIUDAD_fk0 FOREIGN KEY (PAIS) REFERENCES PAIS(CODIGO_PA);

ALTER TABLE AEREOPUERTO ADD CONSTRAINT AEREOPUERTO_fk0 FOREIGN KEY (CIUDAD) REFERENCES CIUDAD(CODIGO_CI);


ALTER TABLE PASAJERO ADD CONSTRAINT PASAJERO_fk0 FOREIGN KEY (TIPO_IDENTIFICACION) REFERENCES TIPO_IDENTIFICACION(CODIGO_TI);
ALTER TABLE PASAJERO ADD CONSTRAINT PASAJERO_fk1 FOREIGN KEY (DIRECCION) REFERENCES DIRECCION(CODIGO_DI);
ALTER TABLE PASAJERO ADD CONSTRAINT PASAJERO_fk2 FOREIGN KEY (TIPO_PASAJERO) REFERENCES TIPO_PASAJERO(CODIGO_TP);




ALTER TABLE CONTACTO_PASAJERO ADD CONSTRAINT CONTACTO_PASAJERO_fk0 FOREIGN KEY (TIPO_CONTACTO) REFERENCES TIPO_CONTACTO(CODIGO_TC);
ALTER TABLE CONTACTO_PASAJERO ADD CONSTRAINT CONTACTO_PASAJERO_fk1 FOREIGN KEY (PASAJERO) REFERENCES PASAJERO(CODIGO_PS);


ALTER TABLE VUELO ADD CONSTRAINT VUELO_fk0 FOREIGN KEY (TIPO_ESTADO) REFERENCES TIPO_ESTADO(CODIGO_TE);
ALTER TABLE VUELO ADD CONSTRAINT VUELO_fk1 FOREIGN KEY (TIPO_VUELO) REFERENCES TIPO_VUELO(CODIGO_TV);
ALTER TABLE VUELO ADD CONSTRAINT VUELO_fk2 FOREIGN KEY (AEREOPUERTO) REFERENCES AEREOPUERTO(CODIGO_AE);
ALTER TABLE VUELO ADD CONSTRAINT VUELO_fk3 FOREIGN KEY (AEREOLINEA) REFERENCES AEREOLINEA(CODIGO_AR);
ALTER TABLE VUELO ADD CONSTRAINT VUELO_fk4 FOREIGN KEY (AEREOPUERTO_LLEGADA) REFERENCES AEREOPUERTO(CODIGO_AE);


ALTER TABLE RESERVA ADD CONSTRAINT RESERVA_fk0 FOREIGN KEY (DESDE_RS) REFERENCES AEREOPUERTO(CODIGO_AE);
ALTER TABLE RESERVA ADD CONSTRAINT RESERVA_fk1 FOREIGN KEY (HACIA_RS) REFERENCES AEREOPUERTO(CODIGO_AE);
ALTER TABLE RESERVA ADD CONSTRAINT RESERVA_fk2 FOREIGN KEY (PRODUCTO_IDA_RS) REFERENCES PRODUCTO(CODIGO_PO);
ALTER TABLE RESERVA ADD CONSTRAINT RESERVA_fk3 FOREIGN KEY (PRODUCTO_RETORNO_RS) REFERENCES PRODUCTO(CODIGO_PO);
ALTER TABLE RESERVA ADD CONSTRAINT RESERVA_fk4 FOREIGN KEY (TIPO_RESERVA) REFERENCES TIPO_RESERVA(CODIGO_TR);


ALTER TABLE PASAJERO_RESERVA ADD CONSTRAINT PASAJERO_RESERVA_fk0 FOREIGN KEY (PASAJERO) REFERENCES PASAJERO(CODIGO_PS);
ALTER TABLE PASAJERO_RESERVA ADD CONSTRAINT PASAJERO_RESERVA_fk1 FOREIGN KEY (RESERVA) REFERENCES RESERVA(CODIGO_RS);

ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_fk0 FOREIGN KEY (AEREOPUERTO_LLEGADA) REFERENCES AEREOPUERTO(CODIGO_AE);
ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_fk1 FOREIGN KEY (AEREOPUERTO_SALIDA) REFERENCES AEREOPUERTO(CODIGO_AE);
ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_fk2 FOREIGN KEY (AEREOLINEA) REFERENCES AEREOLINEA(CODIGO_AR);
ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_fk3 FOREIGN KEY (TIPO_PRODUCTO) REFERENCES TIPO_PRODUCTO(CODIGO_TPR);

ALTER TABLE PRODUCTO_VUELO ADD CONSTRAINT PRODUCTO_VUELO_fk0 FOREIGN KEY (PRODUCTO) REFERENCES PRODUCTO(CODIGO_PO);
ALTER TABLE PRODUCTO_VUELO ADD CONSTRAINT PRODUCTO_VUELO_fk1 FOREIGN KEY (VUELO) REFERENCES VUELO(CODIGO_VU);

ALTER TABLE CABINA_VUELO ADD CONSTRAINT CABINA_VUELO_fk0 FOREIGN KEY (TIPO_ASIENTO) REFERENCES TIPO_CABINA(CODIGO_TC);
ALTER TABLE CABINA_VUELO ADD CONSTRAINT CABINA_VUELO_fk1 FOREIGN KEY (VUELO) REFERENCES VUELO(CODIGO_VU);


ALTER TABLE TARIFA_PRODUCTO ADD CONSTRAINT TARIFA_PRODUCTO_fk0 FOREIGN KEY (PRODUCTO) REFERENCES PRODUCTO(CODIGO_PO);
ALTER TABLE TARIFA_PRODUCTO ADD CONSTRAINT TARIFA_PRODUCTO_fk1 FOREIGN KEY (TIPO_TARIFA) REFERENCES TIPO_TARIFA(CODIGO_TT);
ALTER TABLE TARIFA_PRODUCTO ADD CONSTRAINT TARIFA_PRODUCTO_fk2 FOREIGN KEY (TIPO_CABINA) REFERENCES TIPO_CABINA(CODIGO_TC);

