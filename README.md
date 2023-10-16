# Running-SOAPUI-SOAP-mock-services-as-a-systemd-daemon
This projects aim to ease the process of running SOAP-UI based soap mock services in the background of a Linux system by turning running the mock services in JVM and running the JVM through a systemd daemon

Kindly find the dependencies for this project from [here](https://drive.google.com/drive/folders/1VE-jKAv9DL-5N1wJTg4wlTa5wXQ8les0?usp=drive_link)

Ensure the "SOAP_PROJECTS" environment variable is set in your system to the path where soap-ui project files are maintained.

Export the project as Runnable jar, and execute the command mentioned in systemd file to test if its working fine :

$JAVA_HOME/bin/java -jar {soap-ui-jar_name}


JDK version : 11.0.17

SOAP-UI SDK version : 5.7.0

Linux Version : Oracle Linux 7.9
