BEGIN;

INSERT INTO "auth"."sys_user" (id, username, password, created_by) VALUES
(1, 'system', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 'system'),
(2, 'admin', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 'system'),
(3, 'user', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 'system');

INSERT INTO "auth"."sys_authority" (id, "name", "value", created_by) VALUES
(1, 'View the demo', 'query-demo', 'system');

INSERT INTO "auth"."sys_role" (id, "name", "value", created_by) VALUES
(1, 'administrator', 'ROLE_ADMIN', 'system'),
(2, 'general user', 'ROLE_USER', 'system');

INSERT INTO "auth"."sys_role_authorities" (sys_role_id, authorities_id) VALUES
(1, 1);

INSERT INTO "auth"."sys_user_roles" (sys_user_id, roles_id) VALUES
(1, 1),
(3, 2);

COMMIT;