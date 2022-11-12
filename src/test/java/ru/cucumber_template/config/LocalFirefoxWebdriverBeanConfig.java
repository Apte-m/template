package ru.cucumber_template.config;


import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan(lazyInit = true, basePackages = "ru.cucumber_template")
@Profile("local-firefox")
@Import({DBBeanConfig.class, PropertiesConfig.class})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class LocalFirefoxWebdriverBeanConfig {




    @Bean
    @Qualifier("webDriver")
    public WebDriver webDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opt = new FirefoxOptions();

        FirefoxDriver driver = new FirefoxDriver(opt);
        WebDriverRunner.setWebDriver(driver);
        com.codeborne.selenide.Configuration.timeout = 7000;
        return WebDriverRunner.getWebDriver();


    }
}