alter table producto add FECHA_PO date;

alter table vuelo add hora_llegada_vu time without time zone;

alter table vuelo add hora_salida_vu time without time zone;

alter table vuelo drop hora_vu;