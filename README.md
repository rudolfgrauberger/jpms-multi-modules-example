Please execute following commands to reproduce the example.

```bash
./mvnw clean package
```

After building and packaging you have the folder `./mods` with the `module-0.0.1-SNAPSHOT.jar` and `app-0.0.1-SNAPSHOT.jar` and the `./lib` folder with a all our dependency jars.

Now we can start our application with the following command (requires java 11 or java 17):

```bash
java --module-path ./mods:./lib -m app/com.example.app.AppApplication
```

You're going to see the following output:

```log

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.8.RELEASE)

2022-09-22 11:54:37.500  INFO 64502 --- [           main] com.example.app.AppApplication           : Starting AppApplication on Rudolfs-MBP.fritz.box with PID 64502 (/Users/rudolfgrauberger/Dev/Rest/module/./mods/app-0.0.1-SNAPSHOT.jar started by rudolfgrauberger in /Users/rudolfgrauberger/Dev/Rest/module)
2022-09-22 11:54:37.501  INFO 64502 --- [           main] com.example.app.AppApplication           : No active profile set, falling back to default profiles: default
2022-09-22 11:54:37.773  INFO 64502 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-09-22 11:54:37.805  INFO 64502 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 27ms. Found 1 JPA repository interfaces.
2022-09-22 11:54:38.209  INFO 64502 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-09-22 11:54:38.217  INFO 64502 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-09-22 11:54:38.217  INFO 64502 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
2022-09-22 11:54:38.259  INFO 64502 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-09-22 11:54:38.259  INFO 64502 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 718 ms
2022-09-22 11:54:38.303  WARN 64502 --- [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'testController': Unsatisfied dependency expressed through field 'bookApi'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'bookApi': Unsatisfied dependency expressed through field 'repository'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'bookRepository': Cannot create inner bean '(inner bean)#3901f6af' of type [org.springframework.orm.jpa.SharedEntityManagerCreator] while setting bean property 'entityManager'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#3901f6af': Cannot resolve reference to bean 'entityManagerFactory' while setting constructor argument; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'entityManagerFactory' available
2022-09-22 11:54:38.305  INFO 64502 --- [           main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
2022-09-22 11:54:38.315  INFO 64502 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-09-22 11:54:38.350 ERROR 64502 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Field repository in com.example.module.api.BookApi required a bean named 'entityManagerFactory' that could not be found.

The injection point has the following annotations:
        - @org.springframework.beans.factory.annotation.Autowired(required=true)


Action:

Consider defining a bean named 'entityManagerFactory' in your configuration.
```

You see, that after Upgrade to Spring-Boot 2.2.8.RELEASE this application not working anymore.
