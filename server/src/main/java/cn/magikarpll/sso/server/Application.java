package cn.magikarpll.sso.server;

import lombok.Generated;
import org.apereo.cas.CasEmbeddedContainerUtils;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.CasWebApplication;
import org.apereo.cas.web.CasWebApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.actuate.autoconfigure.metrics.KafkaMetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Instant;

@EnableDiscoveryClient
@SpringBootApplication(
        exclude = {HibernateJpaAutoConfiguration.class, JerseyAutoConfiguration.class, GroovyTemplateAutoConfiguration.class, GsonAutoConfiguration.class, JmxAutoConfiguration.class, DataSourceAutoConfiguration.class, RedisAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, KafkaAutoConfiguration.class, KafkaMetricsAutoConfiguration.class, CassandraAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class},
        proxyBeanMethods = false
)
@EnableConfigurationProperties({CasConfigurationProperties.class})
@EnableAsync
@EnableAspectJAutoProxy(
        proxyTargetClass = true
)
@EnableTransactionManagement(
        proxyTargetClass = true
)
@EnableScheduling
public class Application {

    @Generated
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        Banner banner = CasEmbeddedContainerUtils.getCasBannerInstance();
        (new SpringApplicationBuilder(new Class[]{CasWebApplication.class})).banner(banner).web(WebApplicationType.SERVLET).logStartupInfo(true).contextClass(CasWebApplicationContext.class).run(args);
    }

    @EventListener
    public void handleApplicationReadyEvent(final ApplicationReadyEvent event) {
//        AsciiArtUtils.printAsciiArtReady(LOGGER, "");
//        LOGGER.info("Ready to process requests @ [{}]", DateTimeUtils.zonedDateTimeOf(Instant.ofEpochMilli(event.getTimestamp())));
    }

    @Generated
    public Application() {
    }

}
