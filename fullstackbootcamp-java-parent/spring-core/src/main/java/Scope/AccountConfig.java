package Scope;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AccountConfig {
	@Bean
	//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AccountService accountService() {
        return new AccountService(aaa());
    }

    @Bean
    public AccountRepository aaa() {
        return new AccountRepository();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("config/messages");
        return messageSource;
    }

}
