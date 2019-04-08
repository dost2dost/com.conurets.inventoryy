package com.conurets.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author MSA
 */

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class InventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }
}
/*public class InventoryApplication extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InventoryApplication.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(InventoryApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}*/
