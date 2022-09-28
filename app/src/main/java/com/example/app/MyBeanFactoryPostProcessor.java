package com.example.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Configuration
    public static class AppConfig {
        @Bean
        public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
            return new MyBeanFactoryPostProcessor();
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        final ClassLoader beanClassLoader = configurableListableBeanFactory.getBeanClassLoader();

        System.out.println("############################################################");
        System.out.println("");
        System.out.println("Defined packages");
        System.out.println("------------------------------------------------------------");
        List.of(beanClassLoader.getDefinedPackages()).forEach(System.out::println);
        System.out.println("------------------------------------------------------------");

        System.out.println("Bean names");
        System.out.println("------------------------------------------------------------");
        configurableListableBeanFactory.getBeanNamesIterator().forEachRemaining(System.out::println);
        System.out.println("------------------------------------------------------------");

        System.out.println("");
        System.out.println("############################################################");
    }
}
