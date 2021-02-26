package cn.magikarpll.sso.server.cas;

import groovy.util.logging.Slf4j;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.CasWebflowConfigurer;
import org.apereo.cas.web.flow.config.CasWebflowContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

import static org.reflections.Reflections.log;

@Configuration("customerAuthWebflowConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
@AutoConfigureBefore(value = CasWebflowContextConfiguration.class)
@Slf4j
public class CustomerAuthWebflowConfiguration extends CasWebflowContextConfiguration{

    @Autowired
    @Qualifier("logoutFlowRegistry")
    private FlowDefinitionRegistry logoutFlowRegistry;
    @Autowired
    @Qualifier("loginFlowRegistry")
    private FlowDefinitionRegistry loginFlowRegistry;
    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;
    @Autowired
    private CasConfigurationProperties casConfigurationProperties;

    @Autowired
    @Qualifier("builder")
    private FlowBuilderServices builder;

    @ConditionalOnMissingBean(name = "userWebflowConfigurer")
    @Bean
    @Order(0)
    @RefreshScope
    @Lazy(false)
    @Override
    public CasWebflowConfigurer defaultWebflowConfigurer() {
        final UserLoginWebflowConfigurer c = new UserLoginWebflowConfigurer(builder, loginFlowRegistry,configurableApplicationContext,casConfigurationProperties);
        c.setLogoutFlowDefinitionRegistry(logoutFlowRegistry);
        return c;
    }

}
