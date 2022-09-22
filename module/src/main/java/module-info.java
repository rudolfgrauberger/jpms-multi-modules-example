module module {

    requires java.sql;

    requires java.persistence;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.beans;

    exports com.example.module.api to app, spring.beans;

    opens com.example.module.api to spring.core;
    opens com.example.module.entities to org.hibernate.orm.core, spring.core;
}
