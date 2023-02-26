-- password is 'password' but encrypted using https://bcrypt-generator.com/
insert into accounts (id, email, password, enabled, role)  values (1, 'user', '$2a$12$gwc5FfLm5e/ecDtyZ.Ypie24/igWrd/l00hO1phxiC6w/3jkI6pKC', true, 'SUPER_ADMIN');
insert into users (id, account_id) VALUE (1, 1);
UPDATE accounts SET user_id = 1 WHERE id = 1;