package me.rn00n.demoinfleanrestapi.configs;

import me.rn00n.demoinfleanrestapi.accounts.Account;
import me.rn00n.demoinfleanrestapi.accounts.AccountRepository;
import me.rn00n.demoinfleanrestapi.accounts.AccountRole;
import me.rn00n.demoinfleanrestapi.accounts.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Autowired
            AccountService accountService;
            @Autowired
            AccountRepository accountRepository;
            @Override
            public void run(ApplicationArguments args) throws Exception {
                String username = "rn00n@naver.com";
                Optional<Account> optionalAccount = accountRepository.findByEmail(username);
                if (optionalAccount.isEmpty()) {
                    Account account = Account.builder()
                            .email(username)
                            .password("1234")
                            .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
                            .build();

                    accountService.saveAccount(account);
                }
            }
        };
    }
}
