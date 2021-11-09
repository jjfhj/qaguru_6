package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepLambdaTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    private static final String REPOSITORY = "jjfhj/qaguru_6";

    @Test
    public void checkingTheIssueNameInTheRepository() {
        step("Открыть главную страницу Github", () -> {
            open("https://github.com");
        });
        step("Найти репозиторий " + REPOSITORY, () -> {
            $("[name=q]").setValue("jjfhj/qaguru_6").submit();
        });
        step("Перейти в найденный репозиторий " + REPOSITORY, () -> {
            $(linkText("jjfhj/qaguru_6")).click();
        });
        step("Найти название Issues в репозитории " + REPOSITORY, () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }
}
