package ru.cucumber_template.service;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Service;
import ru.cucumber_template.page.LoginPage;
import ru.cucumber_template.page.Page;

@AllArgsConstructor
@Service
public class PageMap {

    @NotNull
    private LoginPage loginPage;


    public Page getSelectedPage(String page) throws NoSuchElementException {
        switch (page.toLowerCase()) {
            case "страница авторизации":
                return loginPage;

            default:
                throw new IllegalStateException("указана несуществующая страница: " + page.toLowerCase());
        }
    }

}
