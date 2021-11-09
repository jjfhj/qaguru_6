package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import com.github.jjfhj.steps.WebSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    private static final String REPOSITORY = "jjfhj/qaguru_6";

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("Карина Гордиенко (jjfhj)")
    @Feature("Страница репозитория")
    @Story("Элементы на странице репозитория")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест: Шаги с аннотацией @Step")
    @Link(name = "GitHub", url = "https://github.com")

    public void checkingTheIssueNameInTheRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.findIssuesTitle();
    }
}
