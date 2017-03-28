#!/bin/bash

sh /usr/local/glassfish4/bin/asadmin change-admin-password
sh /usr/local/glassfish4/bin/asadmin start-domain domain1 
sh /usr/local/glassfish4/bin/asadmin enable-secure-admin 
sh /usr/local/glassfish4/bin/asadmin restart-domain domain1
sh /usr/local/glassfish4/bin/asadmin create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --steadypoolsize 2 --maxpoolsize 4 --poolresize 1 --idletimeout 300 --maxwait 60000 --ping true --property user=root:password=murcia:servername=127.0.0.1:portnumber=3306:databasename=CasosAcad myjdbc_mariaconglassfish-pool
sh /usr/local/glassfish4/bin/asadmin create-jdbc-resource --connectionpoolid myjdbc_mariaconglassfish-pool jdbc/tpi.2017.MariaGlass-resource

