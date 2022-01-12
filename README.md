# Проект автотестов для [waytohey.com](https://waytohey.com/)

![Главная сайта](https://github.com/vkos15/waytohey_tests/blob/main/images/WayToHey%20%E2%9D%A4%EF%B8%8F%20Main%20page.png)

# Сборка для запуска в Jenkins 

https://jenkins.autotests.cloud/job/08-vkulikova15-waytohey-tests/

Предусмотрена возможность сборки со следущими параметрами:

- **browser** - браузер, в котором будут выполняться тесты
- **browserVersion** - версия браузера
- **browserSize** - размер окна браузера
- **browserMobileView** - запуск в режиме эмуляции мобильного устройства
- **remoteDriverUrl** - адрес удаленного сервера
- **videoStorage** - адрес удаленного сервера для сохранения видео
- **threads** - количество потоков
- **environment** - выбор окружения, на котором будут запускаться тесты (prod/test)


# Пример запуска тестов из терминала: #

**Когда параметры заданы в local.properties**:

```bash
gradle clean  test
```

**Когда параметры не заданы**:
```bash
gradle clean test
-Dbrowser=${BROWSER}
-Denvironment=${ENVIRONMENT}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://user:pass@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

![Сборка в Jenkins](https://github.com/vkos15/waytohey_tests/blob/main/images/Jenkins-1.png)

**Для запуска так же необходимы тестовые данные:**  

Для хранения используются Property-файлы prod.properties и test.properties, нужные данные выбираются в зависимости
от переданного окружения (-Denvironment)
```bash
base_url=https://waytohey.com/
user_active_login=
user_active_pass=
user_wrong_login=
user_wrong_pass=
exist_email=
auth_key_user=
user_parametrize_test_login=
user_parametrize_test_pass=
user_chat_login=
```


# Реализованы тесты на следующие разделы сайта:

- главная страница сайта
- окно входа
- API + UI тесты страницы профиля (добавление, удаление информации из анкеты)
- список контактов

# Отчеты о прохождении автотестов: #
Формируются с помощью библиотеки **Allure**

**Команда для генерации отчета**:

```bash
allure serve build/allure-results
```

![Отчет Allure](https://github.com/vkos15/waytohey_tests/blob/main/images/Allure%20Report.png)


## Отчет содержит скриншоты, а так же видео-записи прохождения тестов: ##

![Видео прохождения теста](https://github.com/vkos15/waytohey_tests/blob/main/images/test_profile_video.gif)

## Интеграция с Allure TestOps ##

![Allure TestOps](https://github.com/vkos15/waytohey_tests/blob/main/images/Allure%20TestOps.png)

## Интеграция с Jira ##

Доступен список тест-кейсов, а так же приложен результат запуска автотестов 

![Jira](https://github.com/vkos15/waytohey_tests/blob/main/images/WayToHey%20tests%20Jira%20.png)


# Уведомления о прохождении автотестов: # 

Оповещения о статусе сборки со ссылкой на детальный отчет отправляются в **Telegram**

![Отчет Allure](https://github.com/vkos15/waytohey_tests/blob/main/images/Telegram%20notification.png)







