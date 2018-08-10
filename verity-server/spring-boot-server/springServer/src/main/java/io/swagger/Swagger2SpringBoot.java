package io.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"io.swagger", "site.verity"})
public class Swagger2SpringBoot implements CommandLineRunner {
    
	//Needed if deploying as a war file to tomcat on AWS. override for SpringBootServletInitializer
	//see: https://mtdevuk.com/2015/07/16/how-to-make-a-spring-boot-jar-into-a-war-to-deploy-on-tomcat/
	//and: https://www.mkyong.com/spring-boot/spring-boot-deploy-war-file-to-tomcat/
	
	//extends SpringBootServletInitializer (add to class def )
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Swagger2SpringBoot.class);
//    }
    
	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		
		new SpringApplication(Swagger2SpringBoot.class).run(args);
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}
}
