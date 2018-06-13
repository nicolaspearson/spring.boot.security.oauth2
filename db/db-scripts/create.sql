-- The microservices database is created in init and specified in docker-compose.yml
SET search_path TO microservices;
CREATE SCHEMA IF NOT EXISTS auth;

BEGIN;

CREATE TABLE IF NOT EXISTS auth.sys_authority (
	id bigint NOT NULL,
	"name" character varying(255),
	"value" character varying(255),
	created_by character varying(50) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT NOW(),
	updated_by character varying(50),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
	PRIMARY KEY (id)
);

COMMIT;

BEGIN;

CREATE TABLE IF NOT EXISTS auth.sys_role (
	id bigint NOT NULL,
	"name" character varying(255),
    "value" character varying(255),
	created_by character varying(50) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT NOW(),
	updated_by character varying(50),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
	PRIMARY KEY (id)
);

COMMIT;

BEGIN;

CREATE TABLE IF NOT EXISTS auth.sys_role_authorities (
	sys_role_id bigint NOT NULL,
	authorities_id bigint NOT NULL,
	PRIMARY KEY (authorities_id)
);

COMMIT;

BEGIN;

CREATE TABLE IF NOT EXISTS auth.sys_user (
	id bigint NOT NULL,
    username varchar(255) DEFAULT NULL,
    password varchar(255) DEFAULT NULL,
	created_by character varying(50) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT NOW(),
	updated_by character varying(50),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
	PRIMARY KEY (id)
);

COMMIT;

BEGIN;

CREATE TABLE IF NOT EXISTS auth.sys_user_roles (
	sys_user_id bigint NOT NULL,
	roles_id bigint NOT NULL,
	PRIMARY KEY (roles_id)
);

COMMIT;