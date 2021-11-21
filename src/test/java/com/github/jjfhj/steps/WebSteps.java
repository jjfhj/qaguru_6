package com.github.jjfhj.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открыть главную страницу Github")
    public WebSteps openMainPage() {
        open("https://github.com");

        return this;
    }

    @Step("Найти репозиторий {repository}")
    public WebSteps searchForRepository(String repository) {
        $("[name=q]").setValue(repository).submit();

        return this;
    }

    @Step("Перейти в найденный репозиторий {repository}")
    public WebSteps goToRepository(String repository) {
        $(linkText(repository)).click();

        return this;
    }

    @Step("Найти название Issues в репозитории jjfhj/qaguru_6")
    public WebSteps findIssuesTitle() {
        $("#issues-tab").shouldHave(text("Issues"));

        return this;
    }
}
