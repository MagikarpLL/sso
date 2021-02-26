package cn.magikarpll.sso.server.cas;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.beanutils.BeanUtils;
import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.credential.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;

import javax.security.auth.login.AccountNotFoundException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class KjsAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    protected KjsAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

    @SneakyThrows
    @Override
    protected AuthenticationHandlerExecutionResult doAuthentication(final Credential credential) {
        val originalUserPass = (UsernamePasswordCredential) credential;
//        val userPass = (UsernamePasswordCredential) credential.getClass().getDeclaredConstructor().newInstance();
//
//        BeanUtils.copyProperties(userPass, originalUserPass);
//
//        transformUsername(userPass);
//        transformPassword(userPass);


        return authenticateUsernamePasswordInternal(originalUserPass, null);
    }

    @Override
    protected AuthenticationHandlerExecutionResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential, String originalPassword) throws GeneralSecurityException, PreventedException {
        UserLoginCredentials userLoginCredentials = (UserLoginCredentials) credential;
        if ("casuser".equals(userLoginCredentials.getAccount()) && "Mellon".equals(userLoginCredentials.getPassword())) {
            //这里可以自定义属性数据
            val strategy = getPasswordPolicyHandlingStrategy();
            val principal = this.principalFactory.createPrincipal(((UserLoginCredentials) credential).getId());
            val messageList = strategy.handle(principal, getPasswordPolicyConfiguration());
            return createHandlerResult(credential, principal, messageList);
        } else {
            throw new AccountNotFoundException("必须是admin用户才允许通过");
        }
    }

    @Override
    public boolean supports(Credential credential) {
        return credential instanceof UserLoginCredentials;
    }
}
