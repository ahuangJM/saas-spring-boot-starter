docker pull mysql/mysql-server:tag
docker run --name saas-spring-boot-starter-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password mysql
docker exec -it saas-spring-boot-starter-mysql bash
mysql -u root -ppassword