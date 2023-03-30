CREATE DATABASE IF NOT EXISTS BEDU_JSE2;

create user if not exists 'admin'@'localhost' identified by '%ADMiN_PWD_5^';

grant all on BEDU_JSE2.* to 'admin'@'localhost';

create user if not exists 'usuario'@'localhost' identified by '$PAsSWD0-';

grant SELECT on BEDU_JSE2.* to 'usuario'@'localhost';

flush privileges;