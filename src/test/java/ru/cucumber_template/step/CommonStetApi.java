package ru.cucumber_template.step;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Затем;
import dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.cucumber_template.service.ApiMap;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class CommonStetApi {
    @Autowired
    private ApiMap apiMap;


    @Дано("эндпоинт {string} получаем и проверяем и {string}")
    public void getPost(String endpoint, String code, Map<String, String> map) {
        PostDTO[] postDTOS = apiMap.getCrud(endpoint)
                .getId(code)
                .as(PostDTO[].class);

        assertThat(Arrays.stream(postDTOS)
                .map(PostDTO::getTitle)
                .collect(Collectors.toList()), hasItem(map.get("title")));

        assertThat(Arrays.stream(postDTOS)
                .map(PostDTO::getBody)
                .collect(Collectors.toList()), hasItem(map.get("body")));
    }

    @Дано("эндпоинт {string} и создаем запись и {string}")
    public void createPost(String endpoint,String code, Map<String, String> map) {
        PostDTO postDTO = new PostDTO(map.get("title")
                , map.get("body")
                , map.get("userId"));

        apiMap.getCrud(endpoint)
                .create(postDTO,code);
    }

    @Дано("эндпоинт {string} и редактируем запись и {string}")
    public void EditePost(String endpoint, String code,Map <String,String> map) {
        PostDTO postDTO = new PostDTO(map.get("title")
                , map.get("body")
                , map.get("userId"));

        apiMap.getCrud(endpoint)
                .update(postDTO,code);
    }

    @Затем("на эдпоинте {string} удалем запись {string} и код {string}")
    public void deletePost(String endpoint, String number, String code) {
        apiMap.getCrud(endpoint)
                .delete(number,code);
    }
}
