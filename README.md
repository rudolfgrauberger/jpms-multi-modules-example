Please execute following commands to reproduce the example.

```bash
./mvnw clean package
```

After building and packaging you have the folder `./mods` with the `module-0.0.1-SNAPSHOT.jar` and `app-0.0.1-SNAPSHOT.jar` and the `./lib` folder with a all our dependency jars.

Now we can start our application with the following command (requires java 11):

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
 :: Spring Boot ::        (v2.2.7.RELEASE)

2022-09-22 11:48:59.485  INFO 63578 --- [           main] com.example.app.AppApplication           : Starting AppApplication on Rudolfs-MBP.fritz.box with PID 63578 (/Users/rudolfgrauberger/Dev/Rest/module/./mods/app-0.0.1-SNAPSHOT.jar started by rudolfgrauberger in /Users/rudolfgrauberger/Dev/Rest/module)
2022-09-22 11:48:59.487  INFO 63578 --- [           main] com.example.app.AppApplication           : No active profile set, falling back to default profiles: default
2022-09-22 11:48:59.747  INFO 63578 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-09-22 11:48:59.777  INFO 63578 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 25ms. Found 1 JPA repository interfaces.
2022-09-22 11:49:00.205  INFO 63578 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-09-22 11:49:00.212  INFO 63578 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-09-22 11:49:00.213  INFO 63578 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.34]
2022-09-22 11:49:00.254  INFO 63578 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-09-22 11:49:00.254  INFO 63578 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 731 ms
2022-09-22 11:49:00.338  INFO 63578 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-09-22 11:49:00.464  INFO 63578 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-09-22 11:49:00.500  INFO 63578 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-09-22 11:49:00.529  INFO 63578 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version [WORKING]
2022-09-22 11:49:00.612  INFO 63578 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2022-09-22 11:49:00.674  INFO 63578 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2022-09-22 11:49:00.968  INFO 63578 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-09-22 11:49:00.971  INFO 63578 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-09-22 11:49:01.137  WARN 63578 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-09-22 11:49:01.198  INFO 63578 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-09-22 11:49:01.355  INFO 63578 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-09-22 11:49:01.357  INFO 63578 --- [           main] com.example.app.AppApplication           : Started AppApplication in 2.07 seconds (JVM running for 2.422)
```
