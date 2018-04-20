# SimpleSelenideMaven

## Инструкция ГМ, по задаче 2

0. Качаем мавен, раззиповываем, добавляем в PATH и   
`mvn -v` - должно что то внятное сказать

1. В директории с проектами делаем cmd  
`mvn archetype:generate -DgroupId=org.selenide.examples -DartifactId=SimpleSelenideMaven`

2. Заходим в проект/директорию SimpleSelenideMaven и  
`mvn idea:idea`

3. Открываем проект в IDEA

4. Открываем pom и добавляем зависимость (после junit)  
`<dependency>`  
    `<groupId>com.codeborne</groupId>`  
    `<artifactId>selenide</artifactId>`  
    `<version>4.11.1</version>`  
    `<scope>test</scope>`  
`</dependency>`

5. В консоли (там где проект, мы оттуда не уходили)
`mvn test`
Скачает зависимости

6. Заново запускаем команду для обновления проекта
`mvn idea:idea`

7. В IDEA идем в настройки проекта, Modules -> Dependencies и должны увидеть кучу зависимостей selenide, selenium, ets

8. Удалить классы в test AppTest и в main App

9. Пишем класс в тестах типа такого  
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

10. В cmd (мы же еще там? :-) делаем `mvn clean test` и по идее все запустилось и отработало. Но, я еще допполню тест :-)

