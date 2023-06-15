package mz.study.config;

import mz.common.Constant;
import mz.common.security.LoginSessionInfo;
import mz.common.util.ServletUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditAwareConfig implements AuditorAware<String> {
    //
    private final String SYSTEM_USER = "SystemUser";
    @Override
    public Optional<String> getCurrentAuditor() {
        // SecurityContext 에서 인증정보를 가져와 주입시킨다.
        //return Optional.ofNullable(SecurityContextHolder.getContext()).get...
        String userId = SYSTEM_USER;
        HttpSession session = ServletUtils.getSession();
        LoginSessionInfo loginInfo
                = (LoginSessionInfo)session.getAttribute(Constant.LOGIN_SESSION_INFO);
        if( loginInfo != null ) {
            userId = loginInfo.getId();
        }
        return Optional.of(userId);
    }
}