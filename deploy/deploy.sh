cd ../
mvn package -Dmaven.test.skip=true
cd target
scp ROOT.war root@192.168.80.128:/usr/local/src/tomcat/tomcat8/webapps/
scp -r /d/pic/ root@192.168.80.128:/usr/local/src/tomcat/tomcat8/webapps/ROOT/pic/