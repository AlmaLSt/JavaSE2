CREATE DATABASE IF NOT EXISTS javase2_bedu_pw;

create user if not exists 'pwadmin'@'localhost' identified by '&ADMiN_PW_D^7';

grant all on javase2_bedu_pw.* to 'pwadmin'@'localhost';


flush privileges;
