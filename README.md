Please execute following commands to reproduce the example.

```bash
./mvnw clean package
```

After building and packaging you have the folder `./mods` with the `module-0.0.1-SNAPSHOT.jar` and `app-0.0.1-SNAPSHOT.jar` and the `./lib` folder with a all our dependency jars.

Now we can start our application with the following command (requires java 17):

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
 :: Spring Boot ::                (v2.7.3)

2022-09-22 15:16:51.779  INFO 84219 --- [           main] com.example.app.AppApplication           : Starting AppApplication using Java 17.0.4 on Rudolfs-MBP.fritz.box with PID 84219 (/Users/rudolfgrauberger/Dev/Rest/jpms-multi-modules-example/./mods/app-0.0.1-SNAPSHOT.jar started by rudolfgrauberger in /Users/rudolfgrauberger/Dev/Rest/jpms-multi-modules-example)
2022-09-22 15:16:51.781  INFO 84219 --- [           main] com.example.app.AppApplication           : No active profile set, falling back to 1 default profile: "default"
2022-09-22 15:16:52.047  INFO 84219 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-09-22 15:16:52.077  INFO 84219 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 24 ms. Found 1 JPA repository interfaces.
2022-09-22 15:16:52.246  WARN 84219 --- [           main] s.c.a.AnnotationConfigApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'testController': Unsatisfied dependency expressed through field 'bookApi'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'bookApi': Unsatisfied dependency expressed through field 'repository'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'bookRepository' defined in com.example.module.repositories.BookRepository defined in @EnableJpaRepositories declared on AppApplication: Cannot create inner bean '(inner bean)#547c04c4' of type [org.springframework.orm.jpa.SharedEntityManagerCreator] while setting bean property 'entityManager'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#547c04c4': Cannot resolve reference to bean 'entityManagerFactory' while setting constructor argument; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'entityManagerFactory' available
2022-09-22 15:16:52.255  INFO 84219 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-09-22 15:16:52.268 ERROR 84219 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

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

You see, that after Upgrade to Spring-Boot 2.7.3 and Java 17 this application not working anymore.
