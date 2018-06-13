BEGIN;

INSERT INTO "auth"."sys_user" (id, username, password, created_by) VALUES
(1, 'system', '$2y$12$w1RqSPfogfOOF9f/x/OEQ.0OjmgShbq7E0Ca0JVfG6NYicaho7pNm', 'system'),
(2, 'admin', '$2y$12$V/cy0S9GGTNfYNTVBX9p6OcMKi8nhJlFl85WpoOCivOYHM5gTA.bW', 'system'),
(3, 'user', '$2y$12$cJKQA8hOCsOtBfD4aJp1x.vesQKEzqrphDhZkgXaZUYs2x2mUeRby', 'system');

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