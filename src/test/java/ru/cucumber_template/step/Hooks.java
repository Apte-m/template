package ru.cucumber_template.step;


import com.sun.istack.NotNull;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.cucumber_template.config.LocalChromeWebdriverBeanConfig;
import ru.cucumber_template.config.LocalFirefoxWebdriverBeanConfig;
import ru.cucumber_template.config.PropertiesConfig;
import ru.cucumber_template.config.RemoteWebdriverBeanConfig;

@AllArgsConstructor
@ContextConfiguration(classes = {
        LocalChromeWebdriverBeanConfig.class, LocalFirefoxWebdriverBeanConfig.class,
        RemoteWebdriverBeanConfig.class})
public class Hooks implements TestWatcher {

    @NotNull
    WebDriver webDriver;

    @Autowired
    PropertiesConfig config;


    @Before
    @Step("start browser session")
    public void before() {
        webDriver.manage().window().maximize();
        webDriver.get(config.getWeb().getBaseurl());


    }

    @After(value = "@tearDown")
    public void ternDown() {
        webDriver.quit();
    }

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        WebDriver driver = this.webDriver;
        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );


    }
}
