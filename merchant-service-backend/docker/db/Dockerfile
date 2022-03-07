FROM mysql:5.7.15

MAINTAINER me

ENV MYSQL_DATABASE=guusto \
    MYSQL_ROOT_PASSWORD=admin123

ADD setup.sql /docker-entrypoint-initdb.d

EXPOSE 3306