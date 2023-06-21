# Study

### MariaDB Create Database
```
docker pull mariadb
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mariadb mariadb 
docker exec -ti mariadb /bash/bash
mysql --protocol=tcp -hlocalhost -P3306 -uroot -proot
MariaDB> CREATE DATABASE course_application DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

MariaDB 접속 정보

* host / port: `localhost:3306`
* username: `root`
* password: `root`

### Data Migration (flyway)

최초로 마이그레이션을 실행할 때는 전체 데이터베이스를 초기화 할 수 있습니다.

```
./flyway-migration.sh
또는
./gradlew flywayClean flywayBaseline flywayMigrate
```

이후부터는 `flywayMigrate` 만 실행하여 테스트 데이터는 남겨두고 계속 DB 스키마만 변경할 수 있습니다.

```
./gradlew flywayMigrate
```
