adaptTo() 2014 - Sling Rookie Session
=====================================

This is the companion source code for the Sling Rookie Session held at adaptTo() 2014 in Berlin.
http://adapt.to/2014/en/schedule/rookie-session---aem-certification.html


Running Demo in Sling Launchpad
-------------------------------

#### Requirements

- Make sure you have Maven 3.0.4 or higher installed
- Set system environment variable
```
MAVEN_OPTS="-Xmx512M -XX:MaxPermSize=512m"
```

#### Build and start Sling Launchpad

- Checkout Sling trunk via GIT
```
git clone https://github.com/apache/sling.git sling
```

  or alternatively use SVN
```
svn co http://svn.eu.apache.org/repos/asf/sling/trunk sling
```

- Build Sling from trunk (this will take some time)
```
cd sling
mvn -Dmaven.test.skip=true clean install
```

- Start Sling Launchpad
```
java -jar launchpad/builder/target/org.apache.sling.launchpad-7-SNAPSHOT-standalone.jar -f -
```

- Launchpad is now running at
http://localhost:8080
   

#### Deploy Demo Application

- Go to root folder of demo application
- Build demo application and deploy to Sling Launchpad
```
mvn -Dsling.url=http://localhost:8080 clean install sling:install
```

- Go to demo intro page
http://localhost:8080/content/adaptto.html


Running Demo in AEM6
--------------------

AEM6 has already everyting in place to run the demo.


#### Deploy Demo Application

- Go to root folder of demo application
- Build demo application and deploy to AEM6
```
mvn -Dsling.url=http://localhost:4502 clean install sling:install
```

- Go to demo intro page (http://localhost:4502/content/adaptto.html)



---

For developing the JSPs with instant feedback in the running instance deploy the Filesystem Resource Provider bundle:
http://central.maven.org/maven2/org/apache/sling/org.apache.sling.fsresource/1.1.4/org.apache.sling.fsresource-1.1.4.jar

And create a new configuration "Apache Sling Filesystem Resource Provider" with
- Provider Root = `/apps/rookiedemo`
- Filesystem Root = `<project root>\src\main\webapp\app-root`
