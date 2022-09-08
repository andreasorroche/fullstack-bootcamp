package Scope;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

public class AccountService {
	@Autowired
	@Qualifier("aaa")
    private AccountRepository accountRepository;

    @Autowired
    private MessageSource messageSource;

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String getAccountName() {
        return messageSource.getMessage("account.name", null, Locale.ENGLISH);
    }

}
