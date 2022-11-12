#language: ru

@ApplicationRequest
Функциональность: CRUD -> api -> post


  Структура сценария:  получения записей

    Дано эндпоинт "запись" получаем и проверяем и "<статус код>"

      | title  | <описание>           |
      | body   | <тело>               |
      | userId | <номер пользователя> |

    Примеры:
      | описание                                                                   | тело                                                                                                                                                                        | номер пользователя | статус код |
      | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto           | 1                  | 200        |
      | qui est esse                                                               | quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error                                        | 1                  | 200        |
      | ea molestias quasi exercitationem repellat qui ipsa sit aut                | est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non | 1                  | 200        |


  Структура сценария:  создание записи

    Дано эндпоинт "запись" и создаем запись и "<статус код>"
      | title  | <title>  |
      | body   | <body>   |
      | userId | <userId> |

    Примеры:
      | title | body | userId | статус код |
      | ti    | bo   | 33     | 201        |
      | ti    | bo   |        | 400        |
      | ti    |      |        | 400        |
      |       | bo   | 33     | 400        |
      |       |      |        | 400        |

  Структура сценария:  редактирование записи

    Дано эндпоинт "запись" и редактируем запись и "<статус код>"
      | title  | <title>  |
      | body   | <body>   |
      | userId | <userId> |

    Примеры:
      | title | body | userId | статус код |
      | ti    | bo   | 33     | 201        |
      | ti    | bo   |        | 400        |
      | ti    |      |        | 400        |
      |       | bo   | 33     | 400        |
      |       |      |        | 400        |


  Сценарий:  удаление записи

    Затем  на эдпоинте "запись" удалем запись "1" и код "200"