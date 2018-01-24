-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: oauth; Type: SCHEMA; Schema: -; Owner: race2earn
--

CREATE SCHEMA oauth;


ALTER SCHEMA oauth OWNER TO postgres;

SET search_path = oauth, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: app; Type: TABLE; Schema: oauth; Owner: race2earn
--

CREATE TABLE app (
    id integer NOT NULL,
    name character varying(255),
    secret character varying(255)
);


ALTER TABLE app OWNER TO postgres;

--
-- Name: oauth_token; Type: TABLE; Schema: oauth; Owner: race2earn
--

CREATE TABLE oauth_token (
    access_token character varying(255) NOT NULL,
    access_expires timestamp without time zone,
    app_code character varying(255),
    refresh_expires timestamp without time zone,
    refresh_token character varying(255),
    app integer,
    user_sql integer
);


ALTER TABLE oauth_token OWNER TO postgres;

--
-- Name: user_sql; Type: TABLE; Schema: oauth; Owner: race2earn
--

CREATE TABLE user_sql (
    id integer NOT NULL,
    password character varying(255),
    salt character varying(255),
    username character varying(255)
);


ALTER TABLE user_sql OWNER TO postgres;

--
-- Name: user_token; Type: TABLE; Schema: oauth; Owner: race2earn
--

CREATE TABLE user_token (
    access_token character varying(255) NOT NULL,
    access_expires timestamp without time zone,
    refresh_expires timestamp without time zone,
    refresh_token character varying(255),
    user_sql integer
);


ALTER TABLE user_token OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: account; Owner: race2earn
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

--
-- Name: app app_pkey; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY app
    ADD CONSTRAINT app_pkey PRIMARY KEY (id);


--
-- Name: oauth_token oauth_token_pkey; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY oauth_token
    ADD CONSTRAINT oauth_token_pkey PRIMARY KEY (access_token);


--
-- Name: app app_name_is_unique; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY app
    ADD CONSTRAINT app_name_is_unique UNIQUE (name);


--
-- Name: user_sql user_sql_username_is_unique; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY user_sql
    ADD CONSTRAINT user_sql_username_is_unique UNIQUE (username);


--
-- Name: user_token user_token_refresh_token_is_unique; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY user_token
    ADD CONSTRAINT user_token_refresh_token_is_unique UNIQUE (refresh_token);


--
-- Name: oauth_token oauth_token_refresh_token_is_unique; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY oauth_token
    ADD CONSTRAINT oauth_token_refresh_token_is_unique UNIQUE (refresh_token);


--
-- Name: user_sql user_sql_pkey; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY user_sql
    ADD CONSTRAINT user_sql_pkey PRIMARY KEY (id);


--
-- Name: user_token user_token_pkey; Type: CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY user_token
    ADD CONSTRAINT user_token_pkey PRIMARY KEY (access_token);


--
-- Name: user_token user_token_constraint_to_user_sql; Type: FK CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY user_token
    ADD CONSTRAINT user_token_constraint_to_user_sql FOREIGN KEY (user_sql) REFERENCES user_sql(id);


--
-- Name: oauth_token oauth_token_constraint_to_app; Type: FK CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY oauth_token
    ADD CONSTRAINT oauth_token_constraint_to_app FOREIGN KEY (app) REFERENCES app(id);


--
-- Name: oauth_token oauth_token_constraint_to_user_sql; Type: FK CONSTRAINT; Schema: oauth; Owner: race2earn
--

ALTER TABLE ONLY oauth_token
    ADD CONSTRAINT oauth_token_constraint_to_user_sql FOREIGN KEY (user_sql) REFERENCES user_sql(id);
