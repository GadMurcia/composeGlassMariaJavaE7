#/bin/bash


cd glassfish4/glassfish/bin/ 
asadmin start-domain domain1 && \
echo "AS_ADMIN_PASSWORD=${PASSWORD}" > /tmp/glassfishpwd && \
asadmin --user=admin --passwordfile=/tmp/glassfishpwd deploy /CasosAcadAppMvn-ear-1.0-SNAPSHOT.ear && \
asadmin stop-domain domain1&& \
rm /tmp/glassfishpwd
