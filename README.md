
# User-driven constraint modeling for entity models at runtime (EUMCF)

A framework to apply and validate constraints on variant-aware entity models at runtime.

This repository contains the theoretical as well as practical parts of the master's thesis **User-Driven Constraint Modeling for Entity Models at Runtime**

## Demonstration
A demo video can be found here -> [click](https://cloudstore.zih.tu-dresden.de/index.php/s/b6WqqQoH4NYrc54)

## Archived source
The archived sources can be found here -> [click](https://cloudstore.zih.tu-dresden.de/index.php/s/tAiG9596yJzJdXE)

## Modules description

The practical implemenentation of the framework consists of several modules. Below is a short description for each of them.

* **end-user-modeling-constraint-framework-spec** - contains the common domain classes, services, and interfaces that can be used by a platform-specific implemenentation of the framework as well by cleint software.
* **end-user-modeling-constraint-framework-gremlin** -  platform-specific implemenentation of the specification module using the *Gremlin* Query Language. More information about Gremlin can be found here -> [click](https://tinkerpop.apache.org/gremlin.html)
* **end-user-modeling-constraint-framework-shacl** - platform-specific implemenentation of the specification module using the *Shapes Constraint Language (SHACL)*. More information about SHACL can be found here -> [click](https://www.w3.org/TR/shacl/)
* **end-user-modeling-constraint-framework** - Spring Boot web application plays the role of the client software and uses the constraint modeling framework to impose constraints on the domain layer at runtime. This module has a dependecy on [Modicio](https://github.com/modicio) to manage and manipulate the domain layer dynamically at runtime.
* **end-user-modeling-constraint-framework-case-study** - a case-study application that compares the Gremlin and SHACL platform-specific implemenentations of the constraint modeling framework in terms of performance.

## Quick start
### Prerequisites
1. Installed Java SDK 11+
2. Installed Maven
3. Installed Git

### Guidelines
1. **Clone repo:** `git clone https://github.com/AntonSk98/master-thesis-user-driven-constraint-modelling-for-entity-models-at-runtime.git`
2. **Set envronment variable *MODICIO_JAR_PATH*** which is an abosolute path to modicio jar that is located in the cloned repository. Please note, that modicio is an ongoing project that is currently under an active development. Therefore, there is no guarantee that the showcase framework will be running with other versions of modicio. **Therefore, do one of the following:**
    * **for windows** -> `set MODICIO_JAR_PATH=C:/ansk/github/master-thesis-user-driven-constraint-modelling-for-entity-models-at-runtime/modicio_2.13.jar`;
    * **for linux** -> `export MODICIO_JAR_PATH=C:/ansk/github/master-thesis-user-driven-constraint-modelling-for-entity-models-at-runtime/modicio_2.13.jar`
3. **Go into the cloned repository:** `cd master-thesis-user-driven-constraint-modelling-for-entity-models-at-runtime`
4. **Compile the specification module:** `mvn -f end-user-modeling-constraint-framework-spec/pom.xml clean install`
5. **Compile the platform-specific implemenentation with Gremlin:** `mvn -f end-user-modeling-constraint-framework-gremlin/pom.xml clean install`
6. **Compile the platform-specific implementation with SHACL:** `mvn -f end-user-modeling-constraint-framework-shacl/pom.xml clean install`
7. Finally, **compile the showcase Spring boot application:** `mvn -f end-user-modeling-constraint-framework/pom.xml clean install`

**As a result**, an executable jar will be generated in the *end-user-modeling-constraint-framework/target* directory

#### Start the platform-specific implementation with Gremlin
1. **Navigate to:** `cd end-user-modeling-constraint-framework/target`
2. **Invoke:** `java -jar -Dspring.profiles.active=testdata,gremlin -Dserver.port=8080 end-user-modeling-constraint-framework-1.0.0.jar`, where

* testdata -> profile to generate a sample domain using Modicio
* gremlin -> profile that injects gremlin-related services in the configuration
* server.port=8080 -> the port number on which the embedded web server will listen for incoming requests

The application can be accessed under the following URI: localhost:8080

#### Start the platform-specific implementation with Shacl
1. **Navigate to:** `cd end-user-modeling-constraint-framework/target`
2. **Invoke:** `java -jar -Dspring.profiles.active=testdata,shacl -Dserver.port=8081 end-user-modeling-constraint-framework-1.0.0.jar`, where

* testdata -> profile to generate a sample domain using Modicio
* shacl -> profile that injects gremlin-related services in the configuration
* server.port=8081 -> the port number on which the embedded web server will listen for incoming requests

The showcase application can be accessed under the following URI: *localhost:<server.port>*


