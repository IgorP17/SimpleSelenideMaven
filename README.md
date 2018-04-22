# SimpleSelenideMaven

## 1. задача номер 1...
1. `src/main/java/fizzbuzz/FizzBuzz.java`
2. Время написания кода(цикл + if структура) - 2 мин 26 сек
3. Поменять `String pathToFile` на свой 

## 2. задача номер 2...

1. Качаем мавен, раззиповываем, добавляем в PATH `bin` и   
`mvn -v` - должно что то внятное сказать

2. В директории с проектами делаем cmd  
`mvn archetype:generate -DgroupId=org.selenide.examples -DartifactId=SimpleSelenideMaven`

3. Заходим в проект/директорию SimpleSelenideMaven и  
`mvn idea:idea`

4. Открываем проект в IDEA

5. Открываем pom и добавляем зависимость (после junit)  
`<dependency>`  
    `<groupId>com.codeborne</groupId>`  
    `<artifactId>selenide</artifactId>`  
    `<version>4.11.1</version>`  
    `<scope>test</scope>`  
`</dependency>`

6. В консоли (там где проект, мы оттуда не уходили)
`mvn test`
Скачает зависимости

7. Заново запускаем команду для обновления проекта
`mvn idea:idea`

8. В IDEA идем в настройки проекта, Modules -> Dependencies и должны увидеть кучу зависимостей selenide, selenium, etc

9. Удалить классы в test AppTest и в main App

10. Пишем класс в тестах типа такого `test/java/org/selenide/examples/TestSomething.java`  
`package org.selenide.examples;`  
`import com.codeborne.selenide.ElementsCollection;`  
`import org.junit.Test;`  
`import org.openqa.selenium.By;`  
`import static com.codeborne.selenide.Selenide.*;`    
`import static com.codeborne.selenide.Condition.*;`  
`public class TestSomething {`  
    `@Test`  
    `public void userCanLoginByUsername() {`  
        `open("https://yandex.ru");`  
        `$(By.id("text")).setValue("selenide").pressEnter();`  
`//        $("#submit").click();`  
        `System.out.println("=== Проверим первые 3 выдачи ===");`  
        `ElementsCollection ress = $$(By.className("extended-text__short"));`  
        `for (int i = 0; i < 2; i++) {`  
            `ress.get(i).shouldHave(text("selenide"));`  
        `}`  
    `}`  
`}`  

11. В cmd (мы же еще там? :-) делаем `mvn clean test` и по идее все запустилось и отработало. Но, я еще дополню тест :-)

12. Запуск под не FF  
* `mvn clean test -Dselenide.browser=edge`  
* или через код `Configuration.browser = "chrome";`  
* Смотрим тут `http://ru.selenide.org/javadoc.html` `Class Configuration` поле `browser`