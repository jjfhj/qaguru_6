package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@DisplayName("Поиск элементов на странице репозитория с использованием Listener")

public class SelenideTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Owner("Карина Гордиенко (jjfhj)")
    @Feature("Страница репозитория")
    @Story("Элементы на странице репозитория")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест: Selenide с Listener")
    @Link(name = "GitHub", url = "https://github.com")

    public void checkingTheIssueNameInTheRepository() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        //Открыть главную страницу Github
        open("https://github.com/");
        //Найти репозиторий jjfhj/qaguru_6
        $("[name=q]").setValue("jjfhj/qaguru_6").submit();
        //Перейти в найденный репозиторий
        $(linkText("jjfhj/qaguru_6")).click();
        //Найти название Issues в репозитории
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
