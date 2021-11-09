package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import com.github.jjfhj.steps.WebSteps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    private static final String REPOSITORY = "jjfhj/qaguru_6";

    private WebSteps steps = new WebSteps();

    @Test
    public void checkingTheIssueNameInTheRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.findIssuesTitle(REPOSITORY);
    }
}
