package eng.opp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("forward:/index.html");
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/curriculum").setViewName("forward:/index.html");
        registry.addViewController("/news").setViewName("forward:/index.html");
        registry.addViewController("/get-involved").setViewName("forward:/index.html");
        registry.addViewController("/about").setViewName("forward:/index.html");
        registry.addViewController("/contact").setViewName("forward:/index.html");
        registry.addViewController("/login").setViewName("forward:/index.html");
    }

}