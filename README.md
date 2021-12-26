# Проект автотестов для waytohey.com

![Главная сайта](https://github.com/vkos15/waytohey_tests/blob/main/images/WayToHey%20%E2%9D%A4%EF%B8%8F%20Main%20page.png)

# Сборка для запуска в Jenkins 

https://jenkins.autotests.cloud/job/08-vkulikova15-waytohey-tests/

Предусмотрена возможность сборки со следущими параметрами:

- **browser** - браузер, в котором будут выполняться тесты
-  **browserVersion** - версия браузера
- **browserSize** - размер окна браузера
- **browserMobileView** - запуск в режиме эмуляции мобильного устройства
- **remoteDriverUrl** - адрес удаленного сервера
- **videoStorage** - адрес удаленного сервера для сохранения видео
- **threads** - количество потоков
- **environment** - выбор окружения, на котором будут запускаться тесты (prod/test)

![Сборка в Jenkins](https://github.com/vkos15/waytohey_tests/blob/main/images/Jenkins-1.png)



