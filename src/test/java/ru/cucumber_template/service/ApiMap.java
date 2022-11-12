package ru.cucumber_template.service;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Service;
import ru.cucumber_template.api.CrudEntity;
import ru.cucumber_template.api.Post;

@AllArgsConstructor
@Service
public class ApiMap {

    @NotNull
    private Post post;

    public CrudEntity getCrud(String page) throws NoSuchElementException {
        switch (page.toLowerCase()) {
            case "запись":
                return post;

            default:
                throw new IllegalStateException("указан несуществующий эндпоинт: " + page.toLowerCase());
        }
    }
}
