package ru.cucumber_template.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public interface Page {

    SelenideElement getElements(String element);

    ElementsCollection getElementsCollection(String element);

    SelenideElement getElementsContainsText(String element);
}
