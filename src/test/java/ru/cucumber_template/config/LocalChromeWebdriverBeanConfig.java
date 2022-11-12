package ru.cucumber_template.config;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan(lazyInit = true, basePackages = "ru.cucumber_template")
@Profile("local-chrome")
@Import({DBBeanConfig.class, PropertiesConfig.class})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class LocalChromeWebdriverBeanConfig {




    @Bean
    @Qualifier("webDriver")
    public  WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("w3c", true);
        opt.addArguments("--ignore-certificate-errors");
        ChromeDriver driver = new ChromeDriver(opt);
        WebDriverRunner.setWebDriver(driver);
        com.codeborne.selenide.Configuration.timeout = 7000;
        return WebDriverRunner.getWebDriver();
    }

}