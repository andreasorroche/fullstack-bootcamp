package Scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopesConfig {

    @Bean
    @Scope("singleton")
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    @Scope("prototype")
    public Person personPrototype() {
        return new Person();
    }
/*
    @Bean
    @RequestScope
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @ApplicationScope
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator websocketScopedBean() {
        return new HelloMessageGenerator();
    }
    */
}
