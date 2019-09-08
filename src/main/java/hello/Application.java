
package hello;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration 
@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);


	@Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
                return builder.build();
        }

	@RequestMapping("/consume")
        public String home2(RestTemplate restTemplate) {
                Value value = restTemplate.getForObject(
                                        "http://ganeshs-macbook-pro.local:8081/greeting", Value.class);
                log.info(value.toString());
                return "The id from the REST API: " + value.id + "<br>The content from the REST API: " + value.content;
        }


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
