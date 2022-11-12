package ru.cucumber_template.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Service
public class LoginPage implements Page {


    @Override
    public SelenideElement getElements(String element) {
        HashMap<String, SelenideElement> seleniumElement = new HashMap<>();
        seleniumElement.put("email", $x("//input[@name='email']"));
        seleniumElement.put("password", $x("//input[@name='password']"));
        seleniumElement.put("come in", $x("//*[@name='go']"));

        return seleniumElement.get(element);
    }

    @Override
    public ElementsCollection getElementsCollection(String element) {
        HashMap<String, ElementsCollection> seleniumElement = new HashMap<>();
        seleniumElement.put("коллекции", $$x("//*[@class='form__field-label']"));

        return seleniumElement.get(element);
    }


    @Override
    public SelenideElement getElementsContainsText(String element) {
        return $x("//*[@class='" + element + "']");
    }
}
