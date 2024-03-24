## Demo ##

Demo framework/language：Java\Docker\Python

## Install steps ##
```shell
mvn package
docker-compose up
```

## API ##

http://localhost:8080/api/foods

## Comments ##
This project is based on springboot.Only below api is available :`http://localhost:8080/api/foods` 

### Structures: ###

### spring boot ###

logback-spring 
mybatis
```shell
drwxr-xr-x  5 xiong  staff   160 Mar 24 15:48 ffp-aggregator-adapter
drwxr-xr-x  5 xiong  staff   160 Mar 24 15:48 ffp-aggregator-app
drwxr-xr-x  5 xiong  staff   160 Mar 24 15:48 ffp-aggregator-client
drwxr-xr-x  5 xiong  staff   160 Mar 24 15:48 ffp-aggregator-domain
drwxr-xr-x  5 xiong  staff   160 Mar 24 15:48 ffp-aggregator-infrastructure
-rw-r--r--  1 xiong  staff  6258 Mar 24 11:00 pom.xml
drwxr-xr-x  6 xiong  staff   192 Mar 24 15:48 start
```

### Database Scripts ###

All the data are set as text type just for simple.
```shell
drwxr-xr-x@ 6 xiong  staff   192 Mar 24 09:40 tools
```

### Docker   ###

mysql & service 
```shell
-rw-r--r--@ 1 xiong  staff   167 Mar 24 09:34 MYSQL_Dockerfile
-rw-r--r--@ 1 xiong  staff   275 Mar 24 15:51 SPRING_Dockerfile
-rw-r--r--@ 1 xiong  staff   660 Mar 24 16:04 docker-compose.yaml
```
