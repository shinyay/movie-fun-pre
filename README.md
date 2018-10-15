# Movie Fun!

## Database Setup

```
$ docker-compose up -d
```

```
$ mysql -h127.0.0.1 -uroot -pmysql

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+

mysql> create database movies;
mysql> create database albums;
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| albums             |
| movies             |
| mysql              |
| performance_schema |
| sys                |
+--------------------+

mysql> \q
```

Smoke Tests require server running on port 8080 by default.

## Build WAR ignoring Smoke Tests

```
$ mvn clean package -DskipTests -Dmaven.test.skip=true
```

## Run Smoke Tests against specific URL

```
$ MOVIE_FUN_URL=http://moviefun.example.com mvn test
```
