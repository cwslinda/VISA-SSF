package vttp2022.ssf.ssfworkshop11;

import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.slf4j.Logger;



@SpringBootApplication
public class SsfWorkshop11Application {
	private static final Logger logger = LoggerFactory.getLogger(SsfWorkshop11Application.class);
	private static final String DEFAULT_PORT_NUMBER = "3000";
	@Bean
	public CommonsRequestLoggingFilter requestLoggerFilter(){
		// need to override some parameters hence need to instantiate
		CommonsRequestLoggingFilter requestLoggingFilter = new CommonsRequestLoggingFilter();
		requestLoggingFilter.setIncludeClientInfo(true);
		requestLoggingFilter.setIncludeHeaders(true);
		requestLoggingFilter.setIncludeQueryString(true);
		requestLoggingFilter.setIncludePayload(true);
		return requestLoggingFilter;
	}
	
	
			public static void main(String[] args) {
				// two execution 
				SpringApplication app = new SpringApplication(SsfWorkshop11Application.class);
				logger.info("Web App");
				// default args 
				DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
				List opsVal = appArgs.getOptionValues("port");
				logger.info("opsVal > " + opsVal);
				String portNumber;

				if(opsVal == null || opsVal.get(0) == null){
					// if cannot get value from command line
					// get it from the environmental variable
						portNumber = System.getenv("PORT");
							if(portNumber == null)
							portNumber = DEFAULT_PORT_NUMBER;
							logger.info("PORT NUMBER >");
				} else {
					portNumber = (String) opsVal.get(0);
				}
		
				
				// String port = "3000";
				// ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
				// if(cliOpts.containsOption("port"))			
				// 	port = cliOpts.getOptionValues("port").get(0);
				// else if (System.getenv("PORT") != null)
				// 	port = System.getenv("PORT");
				
				// app.setDefaultProperties(
				// 	Collections.singletonMap("server.port", port)
				// );
				
		
				// System.out.printf("\nApplication started on port %s\n", port);

				if(portNumber != null){
					app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
				}

				app.run(args);
		
				

			
			}
		
}
	