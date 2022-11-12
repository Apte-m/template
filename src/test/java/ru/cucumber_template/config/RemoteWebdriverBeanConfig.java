package ru.cucumber_template.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan(lazyInit = true, basePackages = "ru.cucumber_template")
@Profile("remote")
@Import({DBBeanConfig.class, PropertiesConfig.class})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class RemoteWebdriverBeanConfig {




}