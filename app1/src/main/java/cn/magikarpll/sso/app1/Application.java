package cn.magikarpll.sso.app1;

import org.jasig.cas.client.boot.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCasClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
