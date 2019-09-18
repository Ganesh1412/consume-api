
package hello;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
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
import java.lang.*; 
import java.io.*; 
import java.util.*; 

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

	@RequestMapping(value = "/reverse", method = RequestMethod.POST, consumes = "application/json")
        public String response1(@RequestBody String input) {
		byte [] strAsByteArray = input.getBytes(); 
  
        	byte [] result = new byte [strAsByteArray.length]; 
  
        	for (int i = 0; i<strAsByteArray.length; i++) 
            		result[i] = strAsByteArray[strAsByteArray.length-i-1]; 
		return new String(result);
        }


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
