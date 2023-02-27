-- password is 'password' but encrypted using https://bcrypt-generator.com/
insert into organizations (id, name) values (1, 'test-org');
insert into accounts (id, email, password, enabled, role, organization_id)  values (1, 'user', '$2a$12$gwc5FfLm5e/ecDtyZ.Ypie24/igWrd/l00hO1phxiC6w/3jkI6pKC', true, 'SUPER_ADMIN', 1);
insert into users (id, account_id) VALUE (1, 1);
UPDATE accounts SET user_id = 1 WHERE id = 1;