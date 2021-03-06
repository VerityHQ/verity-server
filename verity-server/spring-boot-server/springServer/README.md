# Swagger generated server

Spring Boot Server 
http://docs.spring.io/spring-boot/docs

## Overview  
Some components of this server were generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  

We are building a swagger-enabled server in Java using the SpringBoot framework.  
You can run the codegen tool locally on your swagger file to get the SpringBoot code scaffolded up by doing something like this:
swagger-codegen generate -i mySwaggerApiFile.json -l spring

By changing the -l (language) parameter to java you can generate a java client library
swagger-codegen generate -i verityCore-swagger20.json -l java  -o clients/java/

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

Start your server as an simple java application (with maven) mvn spring-boot:run

You can view the api documentation in swagger-ui by pointing to  
/swagger-ui.html or for the raw json http://localhost:8080/{API endpoint}/api-docs 

Change default port value in application.properties

applicaiton.properties sets the path to the API and the API definition. 
e.g. swagger json api definition is here: http://localhost:8080/verity/core/api-docs
and live API is here: http://localhost:8080/verity/core/
and html docs are here: http://localhost:8080/verity/core/swagger-ui.html

The persistence layer architecture and details are documented here: http://www.baeldung.com/hibernate-4-spring

## Random issues with Eclipse STS, JRebel, Maven solved along the way

objc[5489]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.7.0_79.jdk/Contents/Home/jre/bin/java and /Library/Java/JavaVirtualMachines/jdk1.7.0_79.jdk/Contents/Home/jre/lib/libinstrument.dylib. One of the two will be used. Which one is undefined.
Fix: http://stackoverflow.com/questions/18794573/objc10012-class-javalaunchhelper-is-implemented-in-both-libinstrument-dyl

[agent throws java.net.MalformedURLException when host name is set to all numeric value](http://stackoverflow.com/questions/20093854/jmx-agent-throws-java-net-malformedurlexception-when-host-name-is-set-to-all-num)
Fix: add machine name to host file with the ip 127.0.0.1

[spring boot fails to run - IllegalAccessError on startup](http://stackoverflow.com/questions/20123504/spring-boot-fails-to-run-illegalaccesserror-on-startup)
Fix: make sure pom for both projects use the same spring parent pom so they sync up to the same versions of spring-boot and spring

## Useful Resources
https://www.javacodegeeks.com/2016/05/approaches-binding-spring-boot-application-service-cloud-foundry.html

## Logging to Cloud Foundry logs

Many frameworks write to an app log that is separate from STDOUT and STDERR. This is not supported by Loggregator. Your app must write to STDOUT or STDERR for its logs to be included in the Loggregator stream. Check the buildpack your app uses to determine whether it automatically insures that your app correctly writes logs to STDOUT and STDERR only. Some buildpacks do this, and some do not. https://docs.pivotal.io/pivotalcf/1-8/devguide/deploy-apps/streaming-logs.html