package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
    @Owner("Карина Гордиенко (jjfhj)")
    @Feature("Страница репозитория")
    @Story("Элементы на странице репозитория")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест: Лямбда шаги через step (name, () -> {})")
    @Link(name = "GitHub", url = "https://github.com")

    public void checkingTheIssueNameInTheRepository() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

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
            lifecycle.addAttachment("Screenshot репозитория " + REPOSITORY, "image/png",
                    "png", takeScreenshot());
        });
    }

    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
