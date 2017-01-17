package site.verity.common.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "site.verity.web.error" })
public class CommonWebConfig {

    public CommonWebConfig() {
        super();
    }

}
