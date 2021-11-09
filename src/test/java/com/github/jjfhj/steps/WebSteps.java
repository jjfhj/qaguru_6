package com.github.jjfhj.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открыть главную страницу Github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий {repository}")
    public void searchForRepository(String repository) {
        $("[name=q]").setValue("jjfhj/qaguru_6").submit();
    }

    @Step("Перейти в найденный репозиторий {repository}")
    public void goToRepository(String repository) {
        $(linkText("jjfhj/qaguru_6")).click();
    }

    @Step("Найти название Issues в репозитории {repository}")
    public void findIssuesTitle(String repository) {
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
