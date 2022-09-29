module app {
    requires java.sql;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.beans;
    requires module;
    requires spring.data.jpa;
    requires java.instrument;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;
    requires jakarta.activation;
    requires com.zaxxer.hikari;

    exports com.example.app to spring.beans, spring.context;
    exports com.example.app.rest to spring.beans;

    opens com.example.app to spring.core;
    opens com.example.app.rest to spring.core;
}
