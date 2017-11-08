--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-11-08 16:54:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2474 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 25718)
-- Name: aereolinea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE aereolinea (
    codigo_ar integer NOT NULL,
    nombre_ar character varying(500) NOT NULL,
    estado_ar character varying(1) NOT NULL,
    usuario_act_ar integer NOT NULL,
    fecha_act_ar date NOT NULL
);


ALTER TABLE aereolinea OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 25724)
-- Name: aereolinea_codigo_ar_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE aereolinea_codigo_ar_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aereolinea_codigo_ar_seq OWNER TO postgres;

--
-- TOC entry 2475 (class 0 OID 0)
-- Dependencies: 186
-- Name: aereolinea_codigo_ar_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE aereolinea_codigo_ar_seq OWNED BY aereolinea.codigo_ar;


--
-- TOC entry 187 (class 1259 OID 25726)
-- Name: aereopuerto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE aereopuerto (
    codigo_ae integer NOT NULL,
    nombre_ae character varying(500) NOT NULL,
    estado_ae character varying(1) NOT NULL,
    usuario_act_ae integer NOT NULL,
    fecha_act_ae date NOT NULL,
    nemonico_ae character varying(500),
    ciudad integer NOT NULL
);


ALTER TABLE aereopuerto OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 25732)
-- Name: aereopuerto_codigo_ae_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE aereopuerto_codigo_ae_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aereopuerto_codigo_ae_seq OWNER TO postgres;

--
-- TOC entry 2476 (class 0 OID 0)
-- Dependencies: 188
-- Name: aereopuerto_codigo_ae_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE aereopuerto_codigo_ae_seq OWNED BY aereopuerto.codigo_ae;


--
-- TOC entry 189 (class 1259 OID 25734)
-- Name: cabina_vuelo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cabina_vuelo (
    codigo_cv integer NOT NULL,
    tipo_asiento integer NOT NULL,
    numero_asientos_cv integer NOT NULL,
    numero_asientos_disponibles_cv integer NOT NULL,
    vuelo integer NOT NULL,
    estado_cv character varying(1) NOT NULL,
    usuario_act_cv integer NOT NULL,
    fecha_act_cv date NOT NULL
);


ALTER TABLE cabina_vuelo OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 25737)
-- Name: cabina_vuelo_codigo_cv_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cabina_vuelo_codigo_cv_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cabina_vuelo_codigo_cv_seq OWNER TO postgres;

--
-- TOC entry 2477 (class 0 OID 0)
-- Dependencies: 190
-- Name: cabina_vuelo_codigo_cv_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cabina_vuelo_codigo_cv_seq OWNED BY cabina_vuelo.codigo_cv;


--
-- TOC entry 191 (class 1259 OID 25739)
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ciudad (
    codigo_ci integer NOT NULL,
    nombre_ci character varying(100) NOT NULL,
    estado_ci character varying(1) NOT NULL,
    usuario_act_ci integer NOT NULL,
    fecha_act_ci date NOT NULL,
    pais integer NOT NULL
);


ALTER TABLE ciudad OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 25742)
-- Name: ciudad_codigo_ci_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ciudad_codigo_ci_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ciudad_codigo_ci_seq OWNER TO postgres;

--
-- TOC entry 2478 (class 0 OID 0)
-- Dependencies: 192
-- Name: ciudad_codigo_ci_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ciudad_codigo_ci_seq OWNED BY ciudad.codigo_ci;


--
-- TOC entry 193 (class 1259 OID 25744)
-- Name: condiciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE condiciones (
    codigo_co integer NOT NULL,
    nombre_co character varying(100) NOT NULL,
    estado_co character varying(1) NOT NULL,
    usuario_act_co integer NOT NULL,
    fecha_act_co date NOT NULL
);


ALTER TABLE condiciones OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 25747)
-- Name: condiciones_codigo_co_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE condiciones_codigo_co_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE condiciones_codigo_co_seq OWNER TO postgres;

--
-- TOC entry 2479 (class 0 OID 0)
-- Dependencies: 194
-- Name: condiciones_codigo_co_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE condiciones_codigo_co_seq OWNED BY condiciones.codigo_co;


--
-- TOC entry 195 (class 1259 OID 25749)
-- Name: contacto_pasajero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE contacto_pasajero (
    codigo_cp integer NOT NULL,
    numero_cp character varying(20) NOT NULL,
    estado_cp character varying(1) NOT NULL,
    usuario_act_cp integer NOT NULL,
    fecha_act_cp date NOT NULL,
    tipo_contacto integer NOT NULL,
    pasajero integer NOT NULL
);


ALTER TABLE contacto_pasajero OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 25752)
-- Name: contacto_pasajero_codigo_cp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE contacto_pasajero_codigo_cp_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE contacto_pasajero_codigo_cp_seq OWNER TO postgres;

--
-- TOC entry 2480 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacto_pasajero_codigo_cp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE contacto_pasajero_codigo_cp_seq OWNED BY contacto_pasajero.codigo_cp;


--
-- TOC entry 197 (class 1259 OID 25754)
-- Name: direccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE direccion (
    codigo_di integer NOT NULL,
    calle_principal_di character varying(1000) NOT NULL,
    calle_secundaria_di character varying(1000) NOT NULL,
    numero_di character varying(20) NOT NULL,
    codigo_postal character varying(100) NOT NULL
);


ALTER TABLE direccion OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 25760)
-- Name: direccion_codigo_di_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE direccion_codigo_di_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE direccion_codigo_di_seq OWNER TO postgres;

--
-- TOC entry 2481 (class 0 OID 0)
-- Dependencies: 198
-- Name: direccion_codigo_di_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE direccion_codigo_di_seq OWNED BY direccion.codigo_di;


--
-- TOC entry 238 (class 1259 OID 26130)
-- Name: impuesto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE impuesto (
    codigo_im integer NOT NULL,
    valor_im integer NOT NULL,
    tipo_impuesto integer NOT NULL,
    descripcion_im character varying(500) NOT NULL,
    nemonico_im character varying(20) NOT NULL,
    estado_im character varying(1) NOT NULL,
    usuario_act_im integer NOT NULL,
    fecha_act_im date NOT NULL
);


ALTER TABLE impuesto OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 26128)
-- Name: impuesto_codigo_im_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE impuesto_codigo_im_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE impuesto_codigo_im_seq OWNER TO postgres;

--
-- TOC entry 2482 (class 0 OID 0)
-- Dependencies: 237
-- Name: impuesto_codigo_im_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE impuesto_codigo_im_seq OWNED BY impuesto.codigo_im;


--
-- TOC entry 199 (class 1259 OID 25762)
-- Name: pais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pais (
    codigo_pa integer NOT NULL,
    nombre_pa character varying(100) NOT NULL,
    estado_pa character varying(1) NOT NULL,
    usuario_act_pa integer NOT NULL,
    fecha_act_pa date NOT NULL
);


ALTER TABLE pais OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 25765)
-- Name: pais_codigo_pa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pais_codigo_pa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pais_codigo_pa_seq OWNER TO postgres;

--
-- TOC entry 2483 (class 0 OID 0)
-- Dependencies: 200
-- Name: pais_codigo_pa_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pais_codigo_pa_seq OWNED BY pais.codigo_pa;


--
-- TOC entry 201 (class 1259 OID 25767)
-- Name: pasajero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pasajero (
    codigo_ps integer NOT NULL,
    nombre_ps character varying(100) NOT NULL,
    apellido_ps character varying(100) NOT NULL,
    identifiacion_ps character varying(20) NOT NULL,
    correo_ps character varying(100) NOT NULL,
    tipo_identificacion integer NOT NULL,
    direccion integer NOT NULL,
    estado_ps character varying(1) NOT NULL,
    usuario_act_ps integer NOT NULL,
    fecha_act_ps date NOT NULL,
    tipo_pasajero integer NOT NULL
);


ALTER TABLE pasajero OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 25770)
-- Name: pasajero_codigo_ps_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pasajero_codigo_ps_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pasajero_codigo_ps_seq OWNER TO postgres;

--
-- TOC entry 2484 (class 0 OID 0)
-- Dependencies: 202
-- Name: pasajero_codigo_ps_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pasajero_codigo_ps_seq OWNED BY pasajero.codigo_ps;


--
-- TOC entry 240 (class 1259 OID 26146)
-- Name: pasajero_costo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pasajero_costo (
    codigo_pc integer NOT NULL,
    tarifa_pc double precision,
    impuesto_pc double precision,
    pasajero integer,
    reserva integer,
    estado_pc character varying(1) NOT NULL,
    usuario_act_pc integer NOT NULL,
    fecha_act_pc date NOT NULL
);


ALTER TABLE pasajero_costo OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 26144)
-- Name: pasajero_costo_codigo_pc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pasajero_costo_codigo_pc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pasajero_costo_codigo_pc_seq OWNER TO postgres;

--
-- TOC entry 2485 (class 0 OID 0)
-- Dependencies: 239
-- Name: pasajero_costo_codigo_pc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pasajero_costo_codigo_pc_seq OWNED BY pasajero_costo.codigo_pc;


--
-- TOC entry 203 (class 1259 OID 25772)
-- Name: pasajero_reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pasajero_reserva (
    codigo_pr integer NOT NULL,
    pasajero integer NOT NULL,
    reserva integer NOT NULL
);


ALTER TABLE pasajero_reserva OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 25775)
-- Name: pasajero_reserva_codigo_pr_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pasajero_reserva_codigo_pr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pasajero_reserva_codigo_pr_seq OWNER TO postgres;

--
-- TOC entry 2486 (class 0 OID 0)
-- Dependencies: 204
-- Name: pasajero_reserva_codigo_pr_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pasajero_reserva_codigo_pr_seq OWNED BY pasajero_reserva.codigo_pr;


--
-- TOC entry 205 (class 1259 OID 25777)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE producto (
    codigo_po integer NOT NULL,
    nombre_po character varying(500) NOT NULL,
    aereopuerto_llegada integer NOT NULL,
    aereopuerto_salida integer NOT NULL,
    aereolinea integer NOT NULL,
    tipo_producto integer NOT NULL,
    precio_po double precision NOT NULL,
    estado_po character varying(1) NOT NULL,
    usuario_act_po integer NOT NULL,
    fecha_act_po date NOT NULL,
    fecha_po date
);


ALTER TABLE producto OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 25783)
-- Name: producto_codigo_po_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE producto_codigo_po_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE producto_codigo_po_seq OWNER TO postgres;

--
-- TOC entry 2487 (class 0 OID 0)
-- Dependencies: 206
-- Name: producto_codigo_po_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE producto_codigo_po_seq OWNED BY producto.codigo_po;


--
-- TOC entry 207 (class 1259 OID 25785)
-- Name: producto_vuelo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE producto_vuelo (
    codigo_pv integer NOT NULL,
    producto integer NOT NULL,
    vuelo integer NOT NULL
);


ALTER TABLE producto_vuelo OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 25788)
-- Name: producto_vuelo_codigo_pv_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE producto_vuelo_codigo_pv_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE producto_vuelo_codigo_pv_seq OWNER TO postgres;

--
-- TOC entry 2488 (class 0 OID 0)
-- Dependencies: 208
-- Name: producto_vuelo_codigo_pv_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE producto_vuelo_codigo_pv_seq OWNED BY producto_vuelo.codigo_pv;


--
-- TOC entry 209 (class 1259 OID 25790)
-- Name: reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE reserva (
    codigo_rs integer NOT NULL,
    desde_rs integer NOT NULL,
    hacia_rs integer NOT NULL,
    fecha_salida date NOT NULL,
    fecha_retorno date,
    numero_rs character varying(100) NOT NULL,
    producto_ida_rs integer NOT NULL,
    producto_retorno_rs integer,
    estado_rs character varying(1) NOT NULL,
    usuario_act_rs integer NOT NULL,
    fecha_act_rs date NOT NULL,
    tipo_reserva integer,
    tipo_cabina integer,
    tipo_tarifa_ida integer,
    tipo_tarifa_regreso integer,
    costo_total_rs double precision
);


ALTER TABLE reserva OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 25793)
-- Name: reserva_codigo_rs_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE reserva_codigo_rs_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE reserva_codigo_rs_seq OWNER TO postgres;

--
-- TOC entry 2489 (class 0 OID 0)
-- Dependencies: 210
-- Name: reserva_codigo_rs_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE reserva_codigo_rs_seq OWNED BY reserva.codigo_rs;


--
-- TOC entry 211 (class 1259 OID 25795)
-- Name: tarifa_condiciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tarifa_condiciones (
    codigo_tc integer NOT NULL,
    condicion integer NOT NULL,
    tipo_tarifa integer NOT NULL,
    descripcion character varying(500) NOT NULL,
    estado_tc character varying(1) NOT NULL,
    usuario_act_tc integer NOT NULL,
    fecha_act_tc date NOT NULL
);


ALTER TABLE tarifa_condiciones OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 25801)
-- Name: tarifa_condiciones_codigo_tc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tarifa_condiciones_codigo_tc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tarifa_condiciones_codigo_tc_seq OWNER TO postgres;

--
-- TOC entry 2490 (class 0 OID 0)
-- Dependencies: 212
-- Name: tarifa_condiciones_codigo_tc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarifa_condiciones_codigo_tc_seq OWNED BY tarifa_condiciones.codigo_tc;


--
-- TOC entry 213 (class 1259 OID 25803)
-- Name: tarifa_producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tarifa_producto (
    codigo_tp integer NOT NULL,
    producto integer NOT NULL,
    tipo_tarifa integer NOT NULL,
    tipo_cabina integer NOT NULL,
    costo_tp double precision NOT NULL,
    estado_tp character varying(1) NOT NULL,
    usuario_act_tp integer NOT NULL,
    fecha_act_tp date NOT NULL
);


ALTER TABLE tarifa_producto OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 25806)
-- Name: tarifa_producto_codigo_tp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tarifa_producto_codigo_tp_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tarifa_producto_codigo_tp_seq OWNER TO postgres;

--
-- TOC entry 2491 (class 0 OID 0)
-- Dependencies: 214
-- Name: tarifa_producto_codigo_tp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarifa_producto_codigo_tp_seq OWNED BY tarifa_producto.codigo_tp;


--
-- TOC entry 215 (class 1259 OID 25808)
-- Name: tipo_cabina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_cabina (
    codigo_tc integer NOT NULL,
    nombre_tc character varying(500) NOT NULL,
    estado_tc character varying(1) NOT NULL,
    usuario_act_tc integer NOT NULL,
    fecha_act_tc date NOT NULL
);


ALTER TABLE tipo_cabina OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 25814)
-- Name: tipo_cabina_codigo_tc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_cabina_codigo_tc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_cabina_codigo_tc_seq OWNER TO postgres;

--
-- TOC entry 2492 (class 0 OID 0)
-- Dependencies: 216
-- Name: tipo_cabina_codigo_tc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_cabina_codigo_tc_seq OWNED BY tipo_cabina.codigo_tc;


--
-- TOC entry 217 (class 1259 OID 25816)
-- Name: tipo_contacto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_contacto (
    codigo_tc integer NOT NULL,
    nombre_tc character varying(500) NOT NULL,
    estado_tc character varying(1) NOT NULL,
    usuario_act_tp integer NOT NULL,
    fecha_act_tp date NOT NULL
);


ALTER TABLE tipo_contacto OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 25822)
-- Name: tipo_contacto_codigo_tc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_contacto_codigo_tc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_contacto_codigo_tc_seq OWNER TO postgres;

--
-- TOC entry 2493 (class 0 OID 0)
-- Dependencies: 218
-- Name: tipo_contacto_codigo_tc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_contacto_codigo_tc_seq OWNED BY tipo_contacto.codigo_tc;


--
-- TOC entry 219 (class 1259 OID 25824)
-- Name: tipo_estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_estado (
    codigo_te integer NOT NULL,
    nombre_te character varying(100) NOT NULL,
    estado_te character varying(1) NOT NULL,
    usuario_act_te integer NOT NULL,
    fecha_act_te date NOT NULL
);


ALTER TABLE tipo_estado OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 25827)
-- Name: tipo_estado_codigo_te_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_estado_codigo_te_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_estado_codigo_te_seq OWNER TO postgres;

--
-- TOC entry 2494 (class 0 OID 0)
-- Dependencies: 220
-- Name: tipo_estado_codigo_te_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_estado_codigo_te_seq OWNED BY tipo_estado.codigo_te;


--
-- TOC entry 221 (class 1259 OID 25829)
-- Name: tipo_identificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_identificacion (
    codigo_ti integer NOT NULL,
    nombre_ti character varying(100) NOT NULL,
    estado_ti character varying(1) NOT NULL,
    usuario_act_ti integer NOT NULL,
    fecha_act_ti date NOT NULL
);


ALTER TABLE tipo_identificacion OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 25832)
-- Name: tipo_identificacion_codigo_ti_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_identificacion_codigo_ti_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_identificacion_codigo_ti_seq OWNER TO postgres;

--
-- TOC entry 2495 (class 0 OID 0)
-- Dependencies: 222
-- Name: tipo_identificacion_codigo_ti_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_identificacion_codigo_ti_seq OWNED BY tipo_identificacion.codigo_ti;


--
-- TOC entry 236 (class 1259 OID 26122)
-- Name: tipo_impuesto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_impuesto (
    codigo_ti integer NOT NULL,
    nombre_ti character varying(100) NOT NULL,
    estado_ti character varying(1) NOT NULL,
    usuario_act_ti integer NOT NULL,
    fecha_act_ti date NOT NULL
);


ALTER TABLE tipo_impuesto OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 26120)
-- Name: tipo_impuesto_codigo_ti_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_impuesto_codigo_ti_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_impuesto_codigo_ti_seq OWNER TO postgres;

--
-- TOC entry 2496 (class 0 OID 0)
-- Dependencies: 235
-- Name: tipo_impuesto_codigo_ti_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_impuesto_codigo_ti_seq OWNED BY tipo_impuesto.codigo_ti;


--
-- TOC entry 223 (class 1259 OID 25834)
-- Name: tipo_pasajero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_pasajero (
    codigo_tp integer NOT NULL,
    nombre_tp character varying(100) NOT NULL,
    estado_tp character varying(1) NOT NULL,
    usuario_act_tp integer NOT NULL,
    fecha_act_tp date NOT NULL,
    porcentaje_tarifa_tp double precision
);


ALTER TABLE tipo_pasajero OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 25837)
-- Name: tipo_pasajero_codigo_tp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_pasajero_codigo_tp_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_pasajero_codigo_tp_seq OWNER TO postgres;

--
-- TOC entry 2497 (class 0 OID 0)
-- Dependencies: 224
-- Name: tipo_pasajero_codigo_tp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_pasajero_codigo_tp_seq OWNED BY tipo_pasajero.codigo_tp;


--
-- TOC entry 225 (class 1259 OID 25839)
-- Name: tipo_producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_producto (
    codigo_tpr integer NOT NULL,
    nombre_tpr character varying(500) NOT NULL,
    estado_tpr character varying(1) NOT NULL,
    usuario_act_tpr integer NOT NULL,
    fecha_act_tpr date NOT NULL
);


ALTER TABLE tipo_producto OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 25845)
-- Name: tipo_producto_codigo_tpr_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_producto_codigo_tpr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_producto_codigo_tpr_seq OWNER TO postgres;

--
-- TOC entry 2498 (class 0 OID 0)
-- Dependencies: 226
-- Name: tipo_producto_codigo_tpr_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_producto_codigo_tpr_seq OWNED BY tipo_producto.codigo_tpr;


--
-- TOC entry 227 (class 1259 OID 25847)
-- Name: tipo_reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_reserva (
    codigo_tr integer NOT NULL,
    nombre_tr character varying(100) NOT NULL,
    estado_tr character varying(1) NOT NULL,
    usuario_act_tr integer NOT NULL,
    fecha_act_tr date NOT NULL
);


ALTER TABLE tipo_reserva OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 25850)
-- Name: tipo_reserva_codigo_tr_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_reserva_codigo_tr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_reserva_codigo_tr_seq OWNER TO postgres;

--
-- TOC entry 2499 (class 0 OID 0)
-- Dependencies: 228
-- Name: tipo_reserva_codigo_tr_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_reserva_codigo_tr_seq OWNED BY tipo_reserva.codigo_tr;


--
-- TOC entry 229 (class 1259 OID 25852)
-- Name: tipo_tarifa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_tarifa (
    codigo_tt integer NOT NULL,
    nombre_tt character varying(500) NOT NULL,
    estado_tt character varying(1) NOT NULL,
    usuario_act_tt integer NOT NULL,
    fecha_act_tt date NOT NULL
);


ALTER TABLE tipo_tarifa OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 25858)
-- Name: tipo_tarifa_codigo_tt_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_tarifa_codigo_tt_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_tarifa_codigo_tt_seq OWNER TO postgres;

--
-- TOC entry 2500 (class 0 OID 0)
-- Dependencies: 230
-- Name: tipo_tarifa_codigo_tt_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_tarifa_codigo_tt_seq OWNED BY tipo_tarifa.codigo_tt;


--
-- TOC entry 231 (class 1259 OID 25860)
-- Name: tipo_vuelo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_vuelo (
    codigo_tv integer NOT NULL,
    nombre_tv character varying(100) NOT NULL,
    estado_tv character varying(1) NOT NULL,
    usuario_act_tv integer NOT NULL,
    fecha_act_tv date NOT NULL
);


ALTER TABLE tipo_vuelo OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 25863)
-- Name: tipo_vuelo_codigo_tv_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_vuelo_codigo_tv_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_vuelo_codigo_tv_seq OWNER TO postgres;

--
-- TOC entry 2501 (class 0 OID 0)
-- Dependencies: 232
-- Name: tipo_vuelo_codigo_tv_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_vuelo_codigo_tv_seq OWNED BY tipo_vuelo.codigo_tv;


--
-- TOC entry 233 (class 1259 OID 25865)
-- Name: vuelo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE vuelo (
    codigo_vu integer NOT NULL,
    numero_vu character varying(100) NOT NULL,
    fecha_vu date NOT NULL,
    duracion_vu double precision NOT NULL,
    estado_vu character varying(1) NOT NULL,
    usuario_act_vu integer NOT NULL,
    fecha_act_vu date NOT NULL,
    tipo_estado integer NOT NULL,
    tipo_vuelo integer NOT NULL,
    aereopuerto integer NOT NULL,
    aereopuerto_llegada integer,
    aereolinea integer NOT NULL,
    hora_salida_vu time without time zone,
    hora_llegada_vu time without time zone
);


ALTER TABLE vuelo OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 25868)
-- Name: vuelo_codigo_vu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE vuelo_codigo_vu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vuelo_codigo_vu_seq OWNER TO postgres;

--
-- TOC entry 2502 (class 0 OID 0)
-- Dependencies: 234
-- Name: vuelo_codigo_vu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE vuelo_codigo_vu_seq OWNED BY vuelo.codigo_vu;


--
-- TOC entry 2173 (class 2604 OID 25870)
-- Name: aereolinea codigo_ar; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aereolinea ALTER COLUMN codigo_ar SET DEFAULT nextval('aereolinea_codigo_ar_seq'::regclass);


--
-- TOC entry 2174 (class 2604 OID 25871)
-- Name: aereopuerto codigo_ae; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aereopuerto ALTER COLUMN codigo_ae SET DEFAULT nextval('aereopuerto_codigo_ae_seq'::regclass);


--
-- TOC entry 2175 (class 2604 OID 25872)
-- Name: cabina_vuelo codigo_cv; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cabina_vuelo ALTER COLUMN codigo_cv SET DEFAULT nextval('cabina_vuelo_codigo_cv_seq'::regclass);


--
-- TOC entry 2176 (class 2604 OID 25873)
-- Name: ciudad codigo_ci; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ciudad ALTER COLUMN codigo_ci SET DEFAULT nextval('ciudad_codigo_ci_seq'::regclass);


--
-- TOC entry 2177 (class 2604 OID 25874)
-- Name: condiciones codigo_co; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY condiciones ALTER COLUMN codigo_co SET DEFAULT nextval('condiciones_codigo_co_seq'::regclass);


--
-- TOC entry 2178 (class 2604 OID 25875)
-- Name: contacto_pasajero codigo_cp; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contacto_pasajero ALTER COLUMN codigo_cp SET DEFAULT nextval('contacto_pasajero_codigo_cp_seq'::regclass);


--
-- TOC entry 2179 (class 2604 OID 25876)
-- Name: direccion codigo_di; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY direccion ALTER COLUMN codigo_di SET DEFAULT nextval('direccion_codigo_di_seq'::regclass);


--
-- TOC entry 2199 (class 2604 OID 26133)
-- Name: impuesto codigo_im; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY impuesto ALTER COLUMN codigo_im SET DEFAULT nextval('impuesto_codigo_im_seq'::regclass);


--
-- TOC entry 2180 (class 2604 OID 25877)
-- Name: pais codigo_pa; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pais ALTER COLUMN codigo_pa SET DEFAULT nextval('pais_codigo_pa_seq'::regclass);


--
-- TOC entry 2181 (class 2604 OID 25878)
-- Name: pasajero codigo_ps; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero ALTER COLUMN codigo_ps SET DEFAULT nextval('pasajero_codigo_ps_seq'::regclass);


--
-- TOC entry 2200 (class 2604 OID 26149)
-- Name: pasajero_costo codigo_pc; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_costo ALTER COLUMN codigo_pc SET DEFAULT nextval('pasajero_costo_codigo_pc_seq'::regclass);


--
-- TOC entry 2182 (class 2604 OID 25879)
-- Name: pasajero_reserva codigo_pr; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_reserva ALTER COLUMN codigo_pr SET DEFAULT nextval('pasajero_reserva_codigo_pr_seq'::regclass);


--
-- TOC entry 2183 (class 2604 OID 25880)
-- Name: producto codigo_po; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto ALTER COLUMN codigo_po SET DEFAULT nextval('producto_codigo_po_seq'::regclass);


--
-- TOC entry 2184 (class 2604 OID 25881)
-- Name: producto_vuelo codigo_pv; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto_vuelo ALTER COLUMN codigo_pv SET DEFAULT nextval('producto_vuelo_codigo_pv_seq'::regclass);


--
-- TOC entry 2185 (class 2604 OID 25882)
-- Name: reserva codigo_rs; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva ALTER COLUMN codigo_rs SET DEFAULT nextval('reserva_codigo_rs_seq'::regclass);


--
-- TOC entry 2186 (class 2604 OID 25883)
-- Name: tarifa_condiciones codigo_tc; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_condiciones ALTER COLUMN codigo_tc SET DEFAULT nextval('tarifa_condiciones_codigo_tc_seq'::regclass);


--
-- TOC entry 2187 (class 2604 OID 25884)
-- Name: tarifa_producto codigo_tp; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_producto ALTER COLUMN codigo_tp SET DEFAULT nextval('tarifa_producto_codigo_tp_seq'::regclass);


--
-- TOC entry 2188 (class 2604 OID 25885)
-- Name: tipo_cabina codigo_tc; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_cabina ALTER COLUMN codigo_tc SET DEFAULT nextval('tipo_cabina_codigo_tc_seq'::regclass);


--
-- TOC entry 2189 (class 2604 OID 25886)
-- Name: tipo_contacto codigo_tc; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_contacto ALTER COLUMN codigo_tc SET DEFAULT nextval('tipo_contacto_codigo_tc_seq'::regclass);


--
-- TOC entry 2190 (class 2604 OID 25887)
-- Name: tipo_estado codigo_te; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_estado ALTER COLUMN codigo_te SET DEFAULT nextval('tipo_estado_codigo_te_seq'::regclass);


--
-- TOC entry 2191 (class 2604 OID 25888)
-- Name: tipo_identificacion codigo_ti; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_identificacion ALTER COLUMN codigo_ti SET DEFAULT nextval('tipo_identificacion_codigo_ti_seq'::regclass);


--
-- TOC entry 2198 (class 2604 OID 26125)
-- Name: tipo_impuesto codigo_ti; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_impuesto ALTER COLUMN codigo_ti SET DEFAULT nextval('tipo_impuesto_codigo_ti_seq'::regclass);


--
-- TOC entry 2192 (class 2604 OID 25889)
-- Name: tipo_pasajero codigo_tp; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_pasajero ALTER COLUMN codigo_tp SET DEFAULT nextval('tipo_pasajero_codigo_tp_seq'::regclass);


--
-- TOC entry 2193 (class 2604 OID 25890)
-- Name: tipo_producto codigo_tpr; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_producto ALTER COLUMN codigo_tpr SET DEFAULT nextval('tipo_producto_codigo_tpr_seq'::regclass);


--
-- TOC entry 2194 (class 2604 OID 25891)
-- Name: tipo_reserva codigo_tr; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_reserva ALTER COLUMN codigo_tr SET DEFAULT nextval('tipo_reserva_codigo_tr_seq'::regclass);


--
-- TOC entry 2195 (class 2604 OID 25892)
-- Name: tipo_tarifa codigo_tt; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_tarifa ALTER COLUMN codigo_tt SET DEFAULT nextval('tipo_tarifa_codigo_tt_seq'::regclass);


--
-- TOC entry 2196 (class 2604 OID 25893)
-- Name: tipo_vuelo codigo_tv; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_vuelo ALTER COLUMN codigo_tv SET DEFAULT nextval('tipo_vuelo_codigo_tv_seq'::regclass);


--
-- TOC entry 2197 (class 2604 OID 25894)
-- Name: vuelo codigo_vu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vuelo ALTER COLUMN codigo_vu SET DEFAULT nextval('vuelo_codigo_vu_seq'::regclass);


--
-- TOC entry 2412 (class 0 OID 25718)
-- Dependencies: 185
-- Data for Name: aereolinea; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY aereolinea (codigo_ar, nombre_ar, estado_ar, usuario_act_ar, fecha_act_ar) FROM stdin;
1	TAME	A	1	2017-10-28
\.


--
-- TOC entry 2503 (class 0 OID 0)
-- Dependencies: 186
-- Name: aereolinea_codigo_ar_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('aereolinea_codigo_ar_seq', 1, true);


--
-- TOC entry 2414 (class 0 OID 25726)
-- Dependencies: 187
-- Data for Name: aereopuerto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY aereopuerto (codigo_ae, nombre_ae, estado_ae, usuario_act_ae, fecha_act_ae, nemonico_ae, ciudad) FROM stdin;
1	JOSE JOAQUIN DE OLMEDO	A	1	2017-10-28	GYE	1
2	MARISCAL SUCRE	A	1	2017-10-28	UIO	1
\.


--
-- TOC entry 2504 (class 0 OID 0)
-- Dependencies: 188
-- Name: aereopuerto_codigo_ae_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('aereopuerto_codigo_ae_seq', 2, true);


--
-- TOC entry 2416 (class 0 OID 25734)
-- Dependencies: 189
-- Data for Name: cabina_vuelo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cabina_vuelo (codigo_cv, tipo_asiento, numero_asientos_cv, numero_asientos_disponibles_cv, vuelo, estado_cv, usuario_act_cv, fecha_act_cv) FROM stdin;
\.


--
-- TOC entry 2505 (class 0 OID 0)
-- Dependencies: 190
-- Name: cabina_vuelo_codigo_cv_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cabina_vuelo_codigo_cv_seq', 1, false);


--
-- TOC entry 2418 (class 0 OID 25739)
-- Dependencies: 191
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ciudad (codigo_ci, nombre_ci, estado_ci, usuario_act_ci, fecha_act_ci, pais) FROM stdin;
1	QUITO	A	1	2017-10-28	1
2	GUAYAQUIL	A	1	2017-10-28	1
\.


--
-- TOC entry 2506 (class 0 OID 0)
-- Dependencies: 192
-- Name: ciudad_codigo_ci_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ciudad_codigo_ci_seq', 2, true);


--
-- TOC entry 2420 (class 0 OID 25744)
-- Dependencies: 193
-- Data for Name: condiciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY condiciones (codigo_co, nombre_co, estado_co, usuario_act_co, fecha_act_co) FROM stdin;
1	Equipaje de bodega (Pieza de 23 kg)	A	1	2017-10-31
2	Equipaje de mano (1 pieza de 8 Kg)	A	1	2017-10-31
3	Asiento favorito	A	1	2017-10-31
4	Selección de asiento	A	1	2017-10-31
5	Devolución *	A	1	2017-10-31
6	Cambios *	A	1	2017-10-31
7	Costo	A	1	2017-10-31
\.


--
-- TOC entry 2507 (class 0 OID 0)
-- Dependencies: 194
-- Name: condiciones_codigo_co_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('condiciones_codigo_co_seq', 7, true);


--
-- TOC entry 2422 (class 0 OID 25749)
-- Dependencies: 195
-- Data for Name: contacto_pasajero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY contacto_pasajero (codigo_cp, numero_cp, estado_cp, usuario_act_cp, fecha_act_cp, tipo_contacto, pasajero) FROM stdin;
\.


--
-- TOC entry 2508 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacto_pasajero_codigo_cp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('contacto_pasajero_codigo_cp_seq', 1, false);


--
-- TOC entry 2424 (class 0 OID 25754)
-- Dependencies: 197
-- Data for Name: direccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY direccion (codigo_di, calle_principal_di, calle_secundaria_di, numero_di, codigo_postal) FROM stdin;
\.


--
-- TOC entry 2509 (class 0 OID 0)
-- Dependencies: 198
-- Name: direccion_codigo_di_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('direccion_codigo_di_seq', 1, false);


--
-- TOC entry 2465 (class 0 OID 26130)
-- Dependencies: 238
-- Data for Name: impuesto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY impuesto (codigo_im, valor_im, tipo_impuesto, descripcion_im, nemonico_im, estado_im, usuario_act_im, fecha_act_im) FROM stdin;
2	12	1	I.V.A	IVA	A	1	2017-11-08
1	3	2	Impuesto combustible	ICO	A	1	2017-11-08
3	2	1	Impuesto salida del pais	ISP	A	1	2017-11-08
\.


--
-- TOC entry 2510 (class 0 OID 0)
-- Dependencies: 237
-- Name: impuesto_codigo_im_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('impuesto_codigo_im_seq', 3, true);


--
-- TOC entry 2426 (class 0 OID 25762)
-- Dependencies: 199
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pais (codigo_pa, nombre_pa, estado_pa, usuario_act_pa, fecha_act_pa) FROM stdin;
1	ECUADOR	A	1	2017-10-28
\.


--
-- TOC entry 2511 (class 0 OID 0)
-- Dependencies: 200
-- Name: pais_codigo_pa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pais_codigo_pa_seq', 1, true);


--
-- TOC entry 2428 (class 0 OID 25767)
-- Dependencies: 201
-- Data for Name: pasajero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pasajero (codigo_ps, nombre_ps, apellido_ps, identifiacion_ps, correo_ps, tipo_identificacion, direccion, estado_ps, usuario_act_ps, fecha_act_ps, tipo_pasajero) FROM stdin;
\.


--
-- TOC entry 2512 (class 0 OID 0)
-- Dependencies: 202
-- Name: pasajero_codigo_ps_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pasajero_codigo_ps_seq', 1, false);


--
-- TOC entry 2467 (class 0 OID 26146)
-- Dependencies: 240
-- Data for Name: pasajero_costo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pasajero_costo (codigo_pc, tarifa_pc, impuesto_pc, pasajero, reserva, estado_pc, usuario_act_pc, fecha_act_pc) FROM stdin;
\.


--
-- TOC entry 2513 (class 0 OID 0)
-- Dependencies: 239
-- Name: pasajero_costo_codigo_pc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pasajero_costo_codigo_pc_seq', 1, false);


--
-- TOC entry 2430 (class 0 OID 25772)
-- Dependencies: 203
-- Data for Name: pasajero_reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pasajero_reserva (codigo_pr, pasajero, reserva) FROM stdin;
\.


--
-- TOC entry 2514 (class 0 OID 0)
-- Dependencies: 204
-- Name: pasajero_reserva_codigo_pr_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pasajero_reserva_codigo_pr_seq', 1, false);


--
-- TOC entry 2432 (class 0 OID 25777)
-- Dependencies: 205
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY producto (codigo_po, nombre_po, aereopuerto_llegada, aereopuerto_salida, aereolinea, tipo_producto, precio_po, estado_po, usuario_act_po, fecha_act_po, fecha_po) FROM stdin;
2	QUITO - GUAYAQUIL	1	2	1	1	90	A	1	2017-10-29	2017-11-10
1	QUITO - GUAYAQUIL	1	2	1	1	98	A	1	2017-10-29	2017-11-10
3	GUAYAQUIL - QUITO	2	1	1	1	120	A	1	2017-10-30	2017-11-15
\.


--
-- TOC entry 2515 (class 0 OID 0)
-- Dependencies: 206
-- Name: producto_codigo_po_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('producto_codigo_po_seq', 3, true);


--
-- TOC entry 2434 (class 0 OID 25785)
-- Dependencies: 207
-- Data for Name: producto_vuelo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY producto_vuelo (codigo_pv, producto, vuelo) FROM stdin;
2	1	3
3	2	2
4	3	4
\.


--
-- TOC entry 2516 (class 0 OID 0)
-- Dependencies: 208
-- Name: producto_vuelo_codigo_pv_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('producto_vuelo_codigo_pv_seq', 4, true);


--
-- TOC entry 2436 (class 0 OID 25790)
-- Dependencies: 209
-- Data for Name: reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY reserva (codigo_rs, desde_rs, hacia_rs, fecha_salida, fecha_retorno, numero_rs, producto_ida_rs, producto_retorno_rs, estado_rs, usuario_act_rs, fecha_act_rs, tipo_reserva, tipo_cabina, tipo_tarifa_ida, tipo_tarifa_regreso, costo_total_rs) FROM stdin;
3	2	1	2017-11-10	2017-11-15	RES001	1	3	A	1	2017-11-08	1	1	3	3	276.60000000000002
\.


--
-- TOC entry 2517 (class 0 OID 0)
-- Dependencies: 210
-- Name: reserva_codigo_rs_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reserva_codigo_rs_seq', 3, true);


--
-- TOC entry 2438 (class 0 OID 25795)
-- Dependencies: 211
-- Data for Name: tarifa_condiciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tarifa_condiciones (codigo_tc, condicion, tipo_tarifa, descripcion, estado_tc, usuario_act_tc, fecha_act_tc) FROM stdin;
1	6	2	Antes del vuelo por $20	A	1	2017-10-31
2	5	2	Antes del vuelo por $15	A	1	2017-10-31
3	2	3	2 piezas	A	1	2017-10-31
4	1	3	Si	A	1	2017-10-31
5	4	3	Si	A	1	2017-10-31
6	3	3	Si	A	1	2017-10-31
7	6	3	Si	A	1	2017-10-31
8	5	3	Si	A	1	2017-10-31
9	2	1	Costo extra desde $10	A	1	2017-01-31
10	1	1	Si	A	1	2017-10-31
11	4	1	Costo extra	A	1	2017-10-31
12	3	1	Costo extra	A	1	2017-10-31
13	6	1	X	A	1	2017-10-31
14	5	1	X	A	1	2017-10-31
15	2	2	1 pieza	A	1	2017-10-21
16	1	2	Si	A	1	2017-10-31
17	4	2	Costo extra	A	1	2017-10-31
18	3	2	Si	A	1	2017-10-31
\.


--
-- TOC entry 2518 (class 0 OID 0)
-- Dependencies: 212
-- Name: tarifa_condiciones_codigo_tc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tarifa_condiciones_codigo_tc_seq', 18, true);


--
-- TOC entry 2440 (class 0 OID 25803)
-- Dependencies: 213
-- Data for Name: tarifa_producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tarifa_producto (codigo_tp, producto, tipo_tarifa, tipo_cabina, costo_tp, estado_tp, usuario_act_tp, fecha_act_tp) FROM stdin;
1	2	3	2	160	A	1	2017-10-31
2	2	3	1	130	A	1	2017-10-31
3	3	1	2	130	A	1	2017-10-31
4	3	1	1	90	A	1	2017-10-31
5	3	2	2	140	A	1	2017-10-31
6	3	2	1	100	A	1	2017-10-31
7	3	3	2	160	A	1	2017-10-31
8	3	3	1	120	A	1	2017-10-31
9	1	1	2	130	A	1	2017-10-31
10	1	1	1	90	A	1	2017-10-31
11	1	2	2	140	A	1	2017-10-31
12	1	2	1	100	A	1	2017-10-31
13	1	3	2	160	A	1	2017-10-31
14	1	3	1	120	A	1	2017-10-31
15	2	1	2	100	A	1	2017-10-31
16	2	1	1	85	A	1	2017-10-31
17	2	2	2	160	A	1	2017-10-31
18	2	2	1	120	A	1	2017-10-31
\.


--
-- TOC entry 2519 (class 0 OID 0)
-- Dependencies: 214
-- Name: tarifa_producto_codigo_tp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tarifa_producto_codigo_tp_seq', 18, true);


--
-- TOC entry 2442 (class 0 OID 25808)
-- Dependencies: 215
-- Data for Name: tipo_cabina; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_cabina (codigo_tc, nombre_tc, estado_tc, usuario_act_tc, fecha_act_tc) FROM stdin;
2	PRIMERA CLASE	A	1	2017-10-31
1	ECONOMICA	A	1	2017-10-31
\.


--
-- TOC entry 2520 (class 0 OID 0)
-- Dependencies: 216
-- Name: tipo_cabina_codigo_tc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_cabina_codigo_tc_seq', 2, true);


--
-- TOC entry 2444 (class 0 OID 25816)
-- Dependencies: 217
-- Data for Name: tipo_contacto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_contacto (codigo_tc, nombre_tc, estado_tc, usuario_act_tp, fecha_act_tp) FROM stdin;
\.


--
-- TOC entry 2521 (class 0 OID 0)
-- Dependencies: 218
-- Name: tipo_contacto_codigo_tc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_contacto_codigo_tc_seq', 1, false);


--
-- TOC entry 2446 (class 0 OID 25824)
-- Dependencies: 219
-- Data for Name: tipo_estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_estado (codigo_te, nombre_te, estado_te, usuario_act_te, fecha_act_te) FROM stdin;
1	PROGRAMADO	A	1	2017-10-28
\.


--
-- TOC entry 2522 (class 0 OID 0)
-- Dependencies: 220
-- Name: tipo_estado_codigo_te_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_estado_codigo_te_seq', 1, true);


--
-- TOC entry 2448 (class 0 OID 25829)
-- Dependencies: 221
-- Data for Name: tipo_identificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_identificacion (codigo_ti, nombre_ti, estado_ti, usuario_act_ti, fecha_act_ti) FROM stdin;
1	Pasaporte	A	1	2017-11-07
2	Cedula	A	1	2017-11-07
\.


--
-- TOC entry 2523 (class 0 OID 0)
-- Dependencies: 222
-- Name: tipo_identificacion_codigo_ti_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_identificacion_codigo_ti_seq', 2, true);


--
-- TOC entry 2463 (class 0 OID 26122)
-- Dependencies: 236
-- Data for Name: tipo_impuesto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_impuesto (codigo_ti, nombre_ti, estado_ti, usuario_act_ti, fecha_act_ti) FROM stdin;
1	Porcentual	A	1	2017-11-08
2	Fijo	A	1	2017-11-08
\.


--
-- TOC entry 2524 (class 0 OID 0)
-- Dependencies: 235
-- Name: tipo_impuesto_codigo_ti_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_impuesto_codigo_ti_seq', 2, true);


--
-- TOC entry 2450 (class 0 OID 25834)
-- Dependencies: 223
-- Data for Name: tipo_pasajero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_pasajero (codigo_tp, nombre_tp, estado_tp, usuario_act_tp, fecha_act_tp, porcentaje_tarifa_tp) FROM stdin;
2	Niño	A	1	2017-10-31	50
1	Adulto	A	1	2017-10-31	100
3	Bebe	A	1	2017-10-31	9
\.


--
-- TOC entry 2525 (class 0 OID 0)
-- Dependencies: 224
-- Name: tipo_pasajero_codigo_tp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_pasajero_codigo_tp_seq', 3, true);


--
-- TOC entry 2452 (class 0 OID 25839)
-- Dependencies: 225
-- Data for Name: tipo_producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_producto (codigo_tpr, nombre_tpr, estado_tpr, usuario_act_tpr, fecha_act_tpr) FROM stdin;
1	DIRECTO	A	1	2017-10-29
\.


--
-- TOC entry 2526 (class 0 OID 0)
-- Dependencies: 226
-- Name: tipo_producto_codigo_tpr_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_producto_codigo_tpr_seq', 1, true);


--
-- TOC entry 2454 (class 0 OID 25847)
-- Dependencies: 227
-- Data for Name: tipo_reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_reserva (codigo_tr, nombre_tr, estado_tr, usuario_act_tr, fecha_act_tr) FROM stdin;
1	IDA Y VUELTA	A	1	2017-10-28
2	SOLO IDA	A	1	2017-10-28
\.


--
-- TOC entry 2527 (class 0 OID 0)
-- Dependencies: 228
-- Name: tipo_reserva_codigo_tr_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_reserva_codigo_tr_seq', 2, true);


--
-- TOC entry 2456 (class 0 OID 25852)
-- Dependencies: 229
-- Data for Name: tipo_tarifa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_tarifa (codigo_tt, nombre_tt, estado_tt, usuario_act_tt, fecha_act_tt) FROM stdin;
3	TOP	A	1	2017-10-31
2	PLUS	A	1	2017-10-31
1	LIGHT	A	1	2017-10-31
\.


--
-- TOC entry 2528 (class 0 OID 0)
-- Dependencies: 230
-- Name: tipo_tarifa_codigo_tt_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_tarifa_codigo_tt_seq', 3, true);


--
-- TOC entry 2458 (class 0 OID 25860)
-- Dependencies: 231
-- Data for Name: tipo_vuelo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_vuelo (codigo_tv, nombre_tv, estado_tv, usuario_act_tv, fecha_act_tv) FROM stdin;
1	SALIDA	A	1	2017-10-28
\.


--
-- TOC entry 2529 (class 0 OID 0)
-- Dependencies: 232
-- Name: tipo_vuelo_codigo_tv_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_vuelo_codigo_tv_seq', 1, true);


--
-- TOC entry 2460 (class 0 OID 25865)
-- Dependencies: 233
-- Data for Name: vuelo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY vuelo (codigo_vu, numero_vu, fecha_vu, duracion_vu, estado_vu, usuario_act_vu, fecha_act_vu, tipo_estado, tipo_vuelo, aereopuerto, aereopuerto_llegada, aereolinea, hora_salida_vu, hora_llegada_vu) FROM stdin;
3	UIO-10	2017-11-10	50	A	1	2017-10-29	1	1	1	2	1	10:15:00	11:05:00
2	UIO-11	2017-11-10	50	A	1	2017-10-29	1	1	1	2	1	08:50:00	09:40:00
4	GYE-35	2017-11-15	50	A	1	2017-10-30	1	1	2	1	1	15:30:00	16:20:00
\.


--
-- TOC entry 2530 (class 0 OID 0)
-- Dependencies: 234
-- Name: vuelo_codigo_vu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('vuelo_codigo_vu_seq', 4, true);


--
-- TOC entry 2202 (class 2606 OID 25896)
-- Name: aereolinea aereolinea_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aereolinea
    ADD CONSTRAINT aereolinea_pk PRIMARY KEY (codigo_ar);


--
-- TOC entry 2204 (class 2606 OID 25898)
-- Name: aereopuerto aereopuerto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aereopuerto
    ADD CONSTRAINT aereopuerto_pk PRIMARY KEY (codigo_ae);


--
-- TOC entry 2206 (class 2606 OID 25900)
-- Name: cabina_vuelo cabina_vuelo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cabina_vuelo
    ADD CONSTRAINT cabina_vuelo_pk PRIMARY KEY (codigo_cv);


--
-- TOC entry 2208 (class 2606 OID 25902)
-- Name: ciudad ciudad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ciudad
    ADD CONSTRAINT ciudad_pk PRIMARY KEY (codigo_ci);


--
-- TOC entry 2210 (class 2606 OID 25904)
-- Name: condiciones condiciones_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY condiciones
    ADD CONSTRAINT condiciones_pk PRIMARY KEY (codigo_co);


--
-- TOC entry 2212 (class 2606 OID 25906)
-- Name: contacto_pasajero contacto_pasajero_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contacto_pasajero
    ADD CONSTRAINT contacto_pasajero_pk PRIMARY KEY (codigo_cp);


--
-- TOC entry 2214 (class 2606 OID 25908)
-- Name: direccion direccion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY direccion
    ADD CONSTRAINT direccion_pk PRIMARY KEY (codigo_di);


--
-- TOC entry 2254 (class 2606 OID 26138)
-- Name: impuesto impuesto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY impuesto
    ADD CONSTRAINT impuesto_pk PRIMARY KEY (codigo_im);


--
-- TOC entry 2216 (class 2606 OID 25910)
-- Name: pais pais_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pais
    ADD CONSTRAINT pais_pk PRIMARY KEY (codigo_pa);


--
-- TOC entry 2256 (class 2606 OID 26151)
-- Name: pasajero_costo pasajero_costo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_costo
    ADD CONSTRAINT pasajero_costo_pk PRIMARY KEY (codigo_pc);


--
-- TOC entry 2218 (class 2606 OID 25912)
-- Name: pasajero pasajero_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero
    ADD CONSTRAINT pasajero_pk PRIMARY KEY (codigo_ps);


--
-- TOC entry 2220 (class 2606 OID 25914)
-- Name: pasajero_reserva pasajero_reserva_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_reserva
    ADD CONSTRAINT pasajero_reserva_pk PRIMARY KEY (codigo_pr);


--
-- TOC entry 2222 (class 2606 OID 25916)
-- Name: producto producto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_pk PRIMARY KEY (codigo_po);


--
-- TOC entry 2224 (class 2606 OID 25918)
-- Name: producto_vuelo producto_vuelo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto_vuelo
    ADD CONSTRAINT producto_vuelo_pk PRIMARY KEY (codigo_pv);


--
-- TOC entry 2226 (class 2606 OID 25920)
-- Name: reserva reserva_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_pk PRIMARY KEY (codigo_rs);


--
-- TOC entry 2228 (class 2606 OID 25922)
-- Name: tarifa_condiciones tarifa_condiciones_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_condiciones
    ADD CONSTRAINT tarifa_condiciones_pk PRIMARY KEY (codigo_tc);


--
-- TOC entry 2230 (class 2606 OID 25924)
-- Name: tarifa_producto tarifa_producto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_producto
    ADD CONSTRAINT tarifa_producto_pk PRIMARY KEY (codigo_tp);


--
-- TOC entry 2232 (class 2606 OID 25926)
-- Name: tipo_cabina tipo_cabina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_cabina
    ADD CONSTRAINT tipo_cabina_pk PRIMARY KEY (codigo_tc);


--
-- TOC entry 2234 (class 2606 OID 25928)
-- Name: tipo_contacto tipo_contacto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_contacto
    ADD CONSTRAINT tipo_contacto_pk PRIMARY KEY (codigo_tc);


--
-- TOC entry 2236 (class 2606 OID 25930)
-- Name: tipo_estado tipo_estado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_estado
    ADD CONSTRAINT tipo_estado_pk PRIMARY KEY (codigo_te);


--
-- TOC entry 2238 (class 2606 OID 25932)
-- Name: tipo_identificacion tipo_identificacion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_identificacion
    ADD CONSTRAINT tipo_identificacion_pk PRIMARY KEY (codigo_ti);


--
-- TOC entry 2252 (class 2606 OID 26127)
-- Name: tipo_impuesto tipo_impuesto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_impuesto
    ADD CONSTRAINT tipo_impuesto_pk PRIMARY KEY (codigo_ti);


--
-- TOC entry 2240 (class 2606 OID 25934)
-- Name: tipo_pasajero tipo_pasajero_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_pasajero
    ADD CONSTRAINT tipo_pasajero_pk PRIMARY KEY (codigo_tp);


--
-- TOC entry 2242 (class 2606 OID 25936)
-- Name: tipo_producto tipo_producto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_producto
    ADD CONSTRAINT tipo_producto_pk PRIMARY KEY (codigo_tpr);


--
-- TOC entry 2244 (class 2606 OID 25938)
-- Name: tipo_reserva tipo_reserva_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_reserva
    ADD CONSTRAINT tipo_reserva_pk PRIMARY KEY (codigo_tr);


--
-- TOC entry 2246 (class 2606 OID 25940)
-- Name: tipo_tarifa tipo_tarifa_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_tarifa
    ADD CONSTRAINT tipo_tarifa_pk PRIMARY KEY (codigo_tt);


--
-- TOC entry 2248 (class 2606 OID 25942)
-- Name: tipo_vuelo tipo_vuelo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_vuelo
    ADD CONSTRAINT tipo_vuelo_pk PRIMARY KEY (codigo_tv);


--
-- TOC entry 2250 (class 2606 OID 25944)
-- Name: vuelo vuelo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vuelo
    ADD CONSTRAINT vuelo_pk PRIMARY KEY (codigo_vu);


--
-- TOC entry 2257 (class 2606 OID 25945)
-- Name: aereopuerto aereopuerto_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aereopuerto
    ADD CONSTRAINT aereopuerto_fk0 FOREIGN KEY (ciudad) REFERENCES ciudad(codigo_ci);


--
-- TOC entry 2258 (class 2606 OID 25950)
-- Name: cabina_vuelo cabina_vuelo_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cabina_vuelo
    ADD CONSTRAINT cabina_vuelo_fk0 FOREIGN KEY (tipo_asiento) REFERENCES tipo_cabina(codigo_tc);


--
-- TOC entry 2259 (class 2606 OID 25955)
-- Name: cabina_vuelo cabina_vuelo_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cabina_vuelo
    ADD CONSTRAINT cabina_vuelo_fk1 FOREIGN KEY (vuelo) REFERENCES vuelo(codigo_vu);


--
-- TOC entry 2260 (class 2606 OID 25960)
-- Name: ciudad ciudad_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ciudad
    ADD CONSTRAINT ciudad_fk0 FOREIGN KEY (pais) REFERENCES pais(codigo_pa);


--
-- TOC entry 2261 (class 2606 OID 25965)
-- Name: contacto_pasajero contacto_pasajero_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contacto_pasajero
    ADD CONSTRAINT contacto_pasajero_fk0 FOREIGN KEY (tipo_contacto) REFERENCES tipo_contacto(codigo_tc);


--
-- TOC entry 2262 (class 2606 OID 25970)
-- Name: contacto_pasajero contacto_pasajero_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contacto_pasajero
    ADD CONSTRAINT contacto_pasajero_fk1 FOREIGN KEY (pasajero) REFERENCES pasajero(codigo_ps);


--
-- TOC entry 2292 (class 2606 OID 26139)
-- Name: impuesto impuesto_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY impuesto
    ADD CONSTRAINT impuesto_fk1 FOREIGN KEY (tipo_impuesto) REFERENCES tipo_impuesto(codigo_ti);


--
-- TOC entry 2293 (class 2606 OID 26152)
-- Name: pasajero_costo pasajero_costo_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_costo
    ADD CONSTRAINT pasajero_costo_fk1 FOREIGN KEY (pasajero) REFERENCES pasajero(codigo_ps);


--
-- TOC entry 2294 (class 2606 OID 26157)
-- Name: pasajero_costo pasajero_costo_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_costo
    ADD CONSTRAINT pasajero_costo_fk2 FOREIGN KEY (reserva) REFERENCES reserva(codigo_rs);


--
-- TOC entry 2263 (class 2606 OID 25975)
-- Name: pasajero pasajero_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero
    ADD CONSTRAINT pasajero_fk0 FOREIGN KEY (tipo_identificacion) REFERENCES tipo_identificacion(codigo_ti);


--
-- TOC entry 2264 (class 2606 OID 25980)
-- Name: pasajero pasajero_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero
    ADD CONSTRAINT pasajero_fk1 FOREIGN KEY (direccion) REFERENCES direccion(codigo_di);


--
-- TOC entry 2265 (class 2606 OID 25985)
-- Name: pasajero pasajero_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero
    ADD CONSTRAINT pasajero_fk2 FOREIGN KEY (tipo_pasajero) REFERENCES tipo_pasajero(codigo_tp);


--
-- TOC entry 2266 (class 2606 OID 25990)
-- Name: pasajero_reserva pasajero_reserva_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_reserva
    ADD CONSTRAINT pasajero_reserva_fk0 FOREIGN KEY (pasajero) REFERENCES pasajero(codigo_ps);


--
-- TOC entry 2267 (class 2606 OID 25995)
-- Name: pasajero_reserva pasajero_reserva_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pasajero_reserva
    ADD CONSTRAINT pasajero_reserva_fk1 FOREIGN KEY (reserva) REFERENCES reserva(codigo_rs);


--
-- TOC entry 2268 (class 2606 OID 26000)
-- Name: producto producto_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_fk0 FOREIGN KEY (aereopuerto_llegada) REFERENCES aereopuerto(codigo_ae);


--
-- TOC entry 2269 (class 2606 OID 26005)
-- Name: producto producto_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_fk1 FOREIGN KEY (aereopuerto_salida) REFERENCES aereopuerto(codigo_ae);


--
-- TOC entry 2270 (class 2606 OID 26010)
-- Name: producto producto_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_fk2 FOREIGN KEY (aereolinea) REFERENCES aereolinea(codigo_ar);


--
-- TOC entry 2271 (class 2606 OID 26015)
-- Name: producto producto_fk3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_fk3 FOREIGN KEY (tipo_producto) REFERENCES tipo_producto(codigo_tpr);


--
-- TOC entry 2272 (class 2606 OID 26020)
-- Name: producto_vuelo producto_vuelo_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto_vuelo
    ADD CONSTRAINT producto_vuelo_fk0 FOREIGN KEY (producto) REFERENCES producto(codigo_po);


--
-- TOC entry 2273 (class 2606 OID 26025)
-- Name: producto_vuelo producto_vuelo_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto_vuelo
    ADD CONSTRAINT producto_vuelo_fk1 FOREIGN KEY (vuelo) REFERENCES vuelo(codigo_vu);


--
-- TOC entry 2274 (class 2606 OID 26030)
-- Name: reserva reserva_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk0 FOREIGN KEY (desde_rs) REFERENCES aereopuerto(codigo_ae);


--
-- TOC entry 2275 (class 2606 OID 26035)
-- Name: reserva reserva_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk1 FOREIGN KEY (hacia_rs) REFERENCES aereopuerto(codigo_ae);


--
-- TOC entry 2276 (class 2606 OID 26040)
-- Name: reserva reserva_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk2 FOREIGN KEY (producto_ida_rs) REFERENCES producto(codigo_po);


--
-- TOC entry 2277 (class 2606 OID 26045)
-- Name: reserva reserva_fk3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk3 FOREIGN KEY (producto_retorno_rs) REFERENCES producto(codigo_po);


--
-- TOC entry 2278 (class 2606 OID 26050)
-- Name: reserva reserva_fk4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk4 FOREIGN KEY (tipo_reserva) REFERENCES tipo_reserva(codigo_tr);


--
-- TOC entry 2279 (class 2606 OID 26055)
-- Name: reserva reserva_fk5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk5 FOREIGN KEY (tipo_cabina) REFERENCES tipo_cabina(codigo_tc);


--
-- TOC entry 2280 (class 2606 OID 26060)
-- Name: reserva reserva_fk6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk6 FOREIGN KEY (tipo_tarifa_ida) REFERENCES tipo_tarifa(codigo_tt);


--
-- TOC entry 2281 (class 2606 OID 26065)
-- Name: reserva reserva_fk7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_fk7 FOREIGN KEY (tipo_tarifa_regreso) REFERENCES tipo_tarifa(codigo_tt);


--
-- TOC entry 2282 (class 2606 OID 26070)
-- Name: tarifa_condiciones tarifa_condiciones_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_condiciones
    ADD CONSTRAINT tarifa_condiciones_fk1 FOREIGN KEY (tipo_tarifa) REFERENCES tipo_tarifa(codigo_tt);


--
-- TOC entry 2283 (class 2606 OID 26075)
-- Name: tarifa_condiciones tarifa_condiciones_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_condiciones
    ADD CONSTRAINT tarifa_condiciones_fk2 FOREIGN KEY (condicion) REFERENCES condiciones(codigo_co);


--
-- TOC entry 2284 (class 2606 OID 26080)
-- Name: tarifa_producto tarifa_producto_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_producto
    ADD CONSTRAINT tarifa_producto_fk0 FOREIGN KEY (producto) REFERENCES producto(codigo_po);


--
-- TOC entry 2285 (class 2606 OID 26085)
-- Name: tarifa_producto tarifa_producto_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_producto
    ADD CONSTRAINT tarifa_producto_fk1 FOREIGN KEY (tipo_tarifa) REFERENCES tipo_tarifa(codigo_tt);


--
-- TOC entry 2286 (class 2606 OID 26090)
-- Name: tarifa_producto tarifa_producto_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa_producto
    ADD CONSTRAINT tarifa_producto_fk2 FOREIGN KEY (tipo_cabina) REFERENCES tipo_cabina(codigo_tc);


--
-- TOC entry 2287 (class 2606 OID 26095)
-- Name: vuelo vuelo_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vuelo
    ADD CONSTRAINT vuelo_fk0 FOREIGN KEY (tipo_estado) REFERENCES tipo_estado(codigo_te);


--
-- TOC entry 2288 (class 2606 OID 26100)
-- Name: vuelo vuelo_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vuelo
    ADD CONSTRAINT vuelo_fk1 FOREIGN KEY (tipo_vuelo) REFERENCES tipo_vuelo(codigo_tv);


--
-- TOC entry 2289 (class 2606 OID 26105)
-- Name: vuelo vuelo_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vuelo
    ADD CONSTRAINT vuelo_fk2 FOREIGN KEY (aereopuerto) REFERENCES aereopuerto(codigo_ae);


--
-- TOC entry 2290 (class 2606 OID 26110)
-- Name: vuelo vuelo_fk3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vuelo
    ADD CONSTRAINT vuelo_fk3 FOREIGN KEY (aereolinea) REFERENCES aereolinea(codigo_ar);


--
-- TOC entry 2291 (class 2606 OID 26115)
-- Name: vuelo vuelo_fk4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vuelo
    ADD CONSTRAINT vuelo_fk4 FOREIGN KEY (aereopuerto_llegada) REFERENCES aereopuerto(codigo_ae);


-- Completed on 2017-11-08 16:54:20

--
-- PostgreSQL database dump complete
--

