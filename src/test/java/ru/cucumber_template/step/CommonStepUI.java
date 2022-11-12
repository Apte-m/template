package ru.cucumber_template.step;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.И;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.cucumber_template.service.PageMap;

import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

@Slf4j
public class CommonStepUI {

    @Autowired
    private PageMap pageMap;


    @Дано("переходим на {string} и вводим для эедемента {string} значение в поле {string}")
    public void goToAndInputText(String page, String element, String text) {
        pageMap.getSelectedPage(page)
                .getElements(element)
                .sendKeys(text);


    }

    @Затем("на {string} нажать {string}")
    public void click(String page, String element) {
        pageMap.getSelectedPage(page)
                .getElements(element)
                .click();


    }

    @И("проверяем, что url соотвествует {string}")
    public void checkToPageAndUrl(String url) {
        assertEquals(url(), url);
    }


    @Затем("на {string}  провереям наличие текста  {string} и он равен ожидаемому {string}")
    public void checkText(String page, String expected, String actual) {
        pageMap.getSelectedPage(page)
                .getElementsContainsText(expected)
                .shouldHave(exactText(actual));
    }


    @Затем("на {string}  провереям наличие  {string}")
    public void checkToCollection(String page, String element, Map<String, String> map) {
        pageMap.getSelectedPage(page)
                .getElementsCollection(element)
                .shouldBe(texts(map.get("Почта")
                        , map.get("Пароль")
                        , map.get("Другое")));
    }


}



