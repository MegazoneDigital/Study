package mz.academy.config;


import lombok.extern.slf4j.Slf4j;
import mz.common.Constant;
import mz.common.security.LoginSessionInfo;
import mz.common.util.ServletUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Configuration
@EnableJpaAuditing
public class AuditAwareConfig implements AuditorAware<String> {
    //
    private final String SYSTEM_USER = "system";
    @Override
    public Optional<String> getCurrentAuditor() {

        String userId = SYSTEM_USER;
        try {
            HttpSession session = ServletUtils.getSession();
            LoginSessionInfo loginInfo
                    = (LoginSessionInfo) session.getAttribute(Constant.LOGIN_SESSION_INFO);
            if (loginInfo != null) {
                userId = loginInfo.getId();
            }
        } catch (Exception e) {
            log.debug("Auditor is System User !!");
        }
        return Optional.of(userId);
    }
}