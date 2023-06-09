--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    uuid character varying(255) NOT NULL,
    addressname character varying(255),
    country character varying(255),
    icp character varying(100),
    notformaddrname character varying(255),
    zipcode character varying(255)
);


ALTER TABLE public.address OWNER TO postgres;

--
-- Name: avatar_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.avatar_data (
    uuid character varying(50) NOT NULL,
    byte_size oid,
    file_size bigint,
    md5 character varying(255),
    name character varying(255)
);


ALTER TABLE public.avatar_data OWNER TO postgres;

--
-- Name: contact_medium; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact_medium (
    uuid character varying(255) NOT NULL
);


ALTER TABLE public.contact_medium OWNER TO postgres;

--
-- Name: documents; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.documents (
    uuid character varying(255) NOT NULL
);


ALTER TABLE public.documents OWNER TO postgres;

--
-- Name: email; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.email (
    uuid character varying(255) NOT NULL,
    is_active boolean,
    email_value character varying(255),
    emails character varying(255) NOT NULL
);


ALTER TABLE public.email OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: individual; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.individual (
    uuid character varying(255) NOT NULL,
    birthdate timestamp without time zone,
    countryofbirth character varying(255),
    fullname character varying(255),
    gender character varying(255),
    icp character varying(100),
    name character varying(255),
    patronymic character varying(255),
    placeofbirth character varying(255),
    qa_level integer,
    status integer,
    surname character varying(255),
    addresses character varying(255),
    contacts character varying(255),
    documents character varying(255),
    rf_passport uuid,
    wallets character varying(255)
);


ALTER TABLE public.individual OWNER TO postgres;

--
-- Name: phone_number; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.phone_number (
    uuid character varying(255) NOT NULL,
    is_active boolean,
    phone_number_value character varying(255),
    phone_numbers character varying(255) NOT NULL
);


ALTER TABLE public.phone_number OWNER TO postgres;

--
-- Name: rf_passports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rf_passports (
    uuid uuid NOT NULL,
    birthdate character varying(255),
    birthplace character varying(255),
    department_doc character varying(255),
    division character varying(255),
    gender character varying(255),
    invalidity_reason character varying(255),
    issued character varying(255),
    issued_by character varying(255),
    legal_force character varying(255),
    message character varying(255),
    name character varying(255),
    number character varying(255),
    passport_status character varying(255),
    patronymic character varying(255),
    receipt_doc_date character varying(255),
    series character varying(255),
    surname character varying(255),
    validate_date_doc character varying(255)
);


ALTER TABLE public.rf_passports OWNER TO postgres;

--
-- Name: wallet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wallet (
    uuid character varying(255) NOT NULL,
    dollarwallet character varying(255),
    eurowallet character varying(255),
    icp character varying(100),
    rubwallet character varying(255)
);


ALTER TABLE public.wallet OWNER TO postgres;

--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.address (uuid, addressname, country, icp, notformaddrname, zipcode) FROM stdin;
\.


--
-- Data for Name: avatar_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.avatar_data (uuid, byte_size, file_size, md5, name) FROM stdin;
\.


--
-- Data for Name: contact_medium; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contact_medium (uuid) FROM stdin;
\.


--
-- Data for Name: documents; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.documents (uuid) FROM stdin;
\.


--
-- Data for Name: email; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.email (uuid, is_active, email_value, emails) FROM stdin;
\.


--
-- Data for Name: individual; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.individual (uuid, birthdate, countryofbirth, fullname, gender, icp, name, patronymic, placeofbirth, qa_level, status, surname, addresses, contacts, documents, rf_passport, wallets) FROM stdin;
4800c301-50a5-46f9-8c5f-6d6b3fbc55dl	2023-03-08 21:41:56	testing update with delay3	not error	\N	2300000	\N	\N	\N	0	3	\N	\N	\N	\N	\N	\N
4800c301-50a5-46f9-8c5f-6d6b3fbc55nf	1970-01-10 08:00:29.052	USA	Bruce Willis	m	31200000	Bruce	Petrovich	LA	0	0	Willis	\N	\N	\N	\N	\N
\.


--
-- Data for Name: phone_number; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.phone_number (uuid, is_active, phone_number_value, phone_numbers) FROM stdin;
\.


--
-- Data for Name: rf_passports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rf_passports (uuid, birthdate, birthplace, department_doc, division, gender, invalidity_reason, issued, issued_by, legal_force, message, name, number, passport_status, patronymic, receipt_doc_date, series, surname, validate_date_doc) FROM stdin;
\.


--
-- Data for Name: wallet; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.wallet (uuid, dollarwallet, eurowallet, icp, rubwallet) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (uuid);


--
-- Name: avatar_data avatar_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avatar_data
    ADD CONSTRAINT avatar_data_pkey PRIMARY KEY (uuid);


--
-- Name: contact_medium contact_medium_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_medium
    ADD CONSTRAINT contact_medium_pkey PRIMARY KEY (uuid);


--
-- Name: documents documents_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documents
    ADD CONSTRAINT documents_pkey PRIMARY KEY (uuid);


--
-- Name: email email_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email
    ADD CONSTRAINT email_pkey PRIMARY KEY (uuid);


--
-- Name: individual individual_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT individual_pkey PRIMARY KEY (uuid);


--
-- Name: phone_number phone_number_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.phone_number
    ADD CONSTRAINT phone_number_pkey PRIMARY KEY (uuid);


--
-- Name: rf_passports rf_passports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rf_passports
    ADD CONSTRAINT rf_passports_pkey PRIMARY KEY (uuid);


--
-- Name: wallet wallet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wallet
    ADD CONSTRAINT wallet_pkey PRIMARY KEY (uuid);


--
-- Name: individual fkaqjaegcdxrdogjmjbbrxris0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkaqjaegcdxrdogjmjbbrxris0 FOREIGN KEY (rf_passport) REFERENCES public.rf_passports(uuid);


--
-- Name: individual fkcnlbpndyfsmxcojbxtf314pdp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkcnlbpndyfsmxcojbxtf314pdp FOREIGN KEY (wallets) REFERENCES public.wallet(uuid);


--
-- Name: individual fkgukweituikc062dyys6xcm2pw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkgukweituikc062dyys6xcm2pw FOREIGN KEY (contacts) REFERENCES public.contact_medium(uuid);


--
-- Name: phone_number fkh30ucqlh7yhnqrqi50jq2wme7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.phone_number
    ADD CONSTRAINT fkh30ucqlh7yhnqrqi50jq2wme7 FOREIGN KEY (phone_numbers) REFERENCES public.contact_medium(uuid);


--
-- Name: individual fkkrdia7mdtxhwo3vgfwsa9ah4s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fkkrdia7mdtxhwo3vgfwsa9ah4s FOREIGN KEY (documents) REFERENCES public.documents(uuid);


--
-- Name: individual fklgcke24thx5vs9vfucpa1xnyf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.individual
    ADD CONSTRAINT fklgcke24thx5vs9vfucpa1xnyf FOREIGN KEY (addresses) REFERENCES public.address(uuid);


--
-- Name: email fkprxs4jnjx1oef55sf8la3q66y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email
    ADD CONSTRAINT fkprxs4jnjx1oef55sf8la3q66y FOREIGN KEY (emails) REFERENCES public.contact_medium(uuid);


--
-- PostgreSQL database dump complete
--

