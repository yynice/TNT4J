ABOUT TNT4J
======================================

Track and Trace 4 Java API, Application logging framework for correlation, diagnostics and tracking of application activities. This API is specifically designed to troubleshoot concurrent, mutithreaded, multi-user applications and includes
activity correlation, application state dumps, performance and user defined metrics.

Here is short list of TNT4J features:

* Simple programming model to facilitate fast root-cause, log analysis
* Automated timing of application activities and sub-activities (elapsed, idle time, message age)
* Application state dump framework for reporting internal variables, data structures
* Granular conditional logging based on application tokens, patterns
* Inter-log correlation of log entries (correlators and tags) between multiple related applications
* Intra-log correlation of related activities and sub-activities between multiple applications and threads
* Event location tags such as GPS, server etc.
* Message flow direction for composite applications that exchange messages (e.g. SOAP, JMS, and SQL etc.)
* User defined properties such as CPU, memory logging, thread statistics per process/thread
* Granular context such as thread id, process id, server, application name


HOW TO BUILD TNT4J
=========================================

Requirements
* JDK 1.6
* ANT (http://ant.apache.org/)

TNT4J depends on the following external packages:
* Apache commons configuration 1.10 (http://commons.apache.org/proper/commons-configuration/)
* Apache commons lang 2.6 (http://commons.apache.org/proper/commons-lang/)
* Apache commons lang3 3.0.1 (http://commons.apache.org/proper/commons-lang/)
* Apache commons logging 1.2.17 (http://commons.apache.org/proper/commons-logging/)
* Apache Log4J 1.2.17 (http://logging.apache.org/log4j/1.2/)

To build TNT4J:
* Download the above libraries and place into the tnt4j/lib folder
* Compile and build using ANT: 
	* ant all
* Run a test program (com.nastel.jkool.tnt4j.examples.TNT4JTest) using the following (Windows):
	* java -javaagent:tnt4j-api.jar -Dlog4j.configuration=file:log4j.properties -Dtnt4j.dump.on.vm.shutdown=true
	-Dtnt4j.dump.provider.default=true -Dtnt4j.formatter.json.newline=true -classpath tnt4j-api-0.5-all.jar
	com.nastel.jkool.tnt4j.examples.TNT4JTest %*

