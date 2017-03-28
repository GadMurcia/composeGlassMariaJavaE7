# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
# 
# Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
# 
# GlassFish on Docker with Oracle Linux and OpenJDK
FROM oraclelinux:latest

# Maintainer
MAINTAINER Bruno Borges <bruno.borges@oracle.com>

# Set environment variables and default password for user 'admin'
ENV GLASSFISH_PKG=glassfish-4.1.1.zip \
    GLASSFISH_URL=http://download.oracle.com/glassfish/4.1.1/release/glassfish-4.1.1.zip \
    GLASSFISH_HOME=/glassfish4 \
    MD5=4e7ce65489347960e9797d2161e0ada2 \
    PATH=$PATH:/glassfish4/bin \
    PASSWORD=glassfish \
    JAVA_HOME=/usr/lib/jvm/java-openjdk

# Install packages, download and extract GlassFish
# Setup password file
# Enable DAS
RUN yum -y install wget unzip java-1.8.0-openjdk-devel && \
    wget  --no-check-certificate $GLASSFISH_URL && \
    echo "$MD5 *$GLASSFISH_PKG" | md5sum -c - && \
    unzip -o $GLASSFISH_PKG && \
    rm -f $GLASSFISH_PKG && \
    echo "--- Setup the password file ---" && \
    echo "AS_ADMIN_PASSWORD=" > /tmp/glassfishpwd && \
    echo "AS_ADMIN_NEWPASSWORD=${PASSWORD}" >> /tmp/glassfishpwd  && \
    echo "--- Enable DAS, change admin password, and secure admin access ---" && \
    asadmin --user=admin --passwordfile=/tmp/glassfishpwd change-admin-password --domain_name domain1 && \
    asadmin start-domain && \
    echo "AS_ADMIN_PASSWORD=${PASSWORD}" > /tmp/glassfishpwd && \
    asadmin --user=admin --passwordfile=/tmp/glassfishpwd enable-secure-admin && \
    asadmin --user=admin stop-domain 

RUN	curl -L -o /mysql-connector-java-5.1.41.zip https://cdn.mysql.com//Downloads/Connector-J/mysql-connector-java-5.1.41.zip && \
	unzip /mysql-connector-java-5.1.41.zip -d / 	
	
RUN	cp /mysql-connector-java-5.1.41/mysql-connector-java-5.1.41-bin.jar /glassfish4/glassfish/modules/mysql-connector-java-5.1.41-bin.jar && \
	rm -r /mysql-connector-java-5.1.41 && rm /mysql-connector-java-5.1.41.zip && \
	echo "AS_ADMIN_PASSWORD=${PASSWORD}" > /tmp/glassfishpwd && \
	asadmin start-domain domain1 && \
	asadmin --user=admin --passwordfile=/tmp/glassfishpwd create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --steadypoolsize 2 --maxpoolsize 4 --poolresize 1 --idletimeout 300 --maxwait 60000 --ping true --property user=root:password=murcia:servername=maria:portnumber=3306:databasename=CasosAcad myjdbc_mariaconglassfish-pool && \
	asadmin --user=admin --passwordfile=/tmp/glassfishpwd create-jdbc-resource --connectionpoolid myjdbc_mariaconglassfish-pool jdbc/casosacad && \
    	asadmin stop-domain domain1&& \
    	rm /tmp/glassfishpwd

COPY	CasosAcadMvn-Trabajo/CasosAcadAppMvn/CasosAcadAppMvn-ear/target/CasosAcadAppMvn-ear-1.0-SNAPSHOT.ear /CasosAcadAppMvn-ear-1.0-SNAPSHOT.ear
COPY	deployapp.sh etc/init.d/deploy	

# Ports being exposed
EXPOSE 4848 8080 8181 9009

# Start asadmin console and the domain
ENTRYPOINT	sh /etc/init.d/deploy && asadmin start-domain -v
