package mz.usergate.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.Constant;
import mz.common.security.AuthorityCode;
import mz.common.security.LoginSessionInfo;
import mz.common.util.ServletUtils;
import mz.common.util.security.PasswordEncoder;
import mz.usergate.domain.dto.AccountDto;
import mz.usergate.domain.dto.LoginDto;
import mz.usergate.domain.entity.Account;
import mz.usergate.store.AccountStore;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountStore accountStore;

    public String saveAccount(AccountDto accountDto) {

        PasswordEncoder encoder = new PasswordEncoder();
        Account account = accountDto.toDomain();
        account.setPassword(
                encoder.encode(accountDto.getPassword())
        );
        return accountStore.save(account);
    }

    public void removeAccount(String id) {

        accountStore.delete(id);
    }

    public Boolean login(LoginDto loginDto) {

        List<Account> accounts = accountStore.findByLoginId(loginDto.getLoginId());
        if( accounts.size() == 0 )
            return Boolean.FALSE;

        PasswordEncoder encoder = new PasswordEncoder();

        for(Account account : accounts) {
            if(encoder.check(loginDto.getPassword(), account.getPassword())) {
                HttpServletRequest request = ServletUtils.getRequest();
                HttpSession session = request.getSession();
                session.setAttribute(Constant.LOGIN_SESSION_INFO, toLoginSessionInfo(account));
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private LoginSessionInfo toLoginSessionInfo(Account account) {
        LoginSessionInfo sessionInfo
                = LoginSessionInfo.builder()
                .id(account.getLoginId())
                .name(account.getLoginId())
                .uuid(account.getId())
                .authority(AuthorityCode.USER)
                .build();
        sessionInfo.setAdditionInfo(Map.of("email", account.getEmail()));
        return sessionInfo;
    }
}
