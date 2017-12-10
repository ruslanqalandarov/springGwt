package uz.ruslan.configuration;

import org.gwtwidgets.server.spring.GWTHandler;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * date 08/11/16.
 */

@Configuration
@EnableAspectJAutoProxy
@EnableJpaRepositories("uz.ruslan.managers")
@EnableWebMvc
@ComponentScan(
        basePackages = {
                "uz.ruslan.controllers",
        })
@Import(value = {
        AsyncConfiguration.class,
        DatabaseConfiguration.class,
})
public class MyApplicationContext extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.json();
        builder.indentOutput(true);
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver resolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver()  {
        InternalResourceViewResolver resolver =  new InternalResourceViewResolver ();
        resolver.setPrefix ("/WEB-INF/views/");
        resolver.setSuffix (".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/mumar/**").addResourceLocations("/mumar/");
    }

    @Bean
    public GWTHandler gwtHandler() {
        GWTHandler handler = new GWTHandler();

        return handler;
    }
}