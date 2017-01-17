package site.verity.common.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "site.verity.web.error" })
public class CommonWebConfig {

    public CommonWebConfig() {
        super();
    }

}
