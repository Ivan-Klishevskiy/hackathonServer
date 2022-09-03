package by.tms.hackathonserver.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("by")
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                //  .allowedOrigins("http://localhost:3000/")//("http://localhost:3000")
                // .allowedHeaders("origin, content-type, accept, authorization")
                .allowCredentials(true)
                .allowedMethods("*");
    }
}
