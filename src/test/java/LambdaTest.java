import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void issueSearchLambdaTest() {
        step("��������� ������� ��������", (s) -> {
            s.parameter("URL", BASE_URL);
            open(BASE_URL);
        });
        step("���� �����������", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").pressEnter();
        });
        step("��������� � �����������", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(byAttribute("href", "/" + REPOSITORY)).click();
        });
        step("��������� ��� Issues � �����������", () -> {
            $(withText("Issues")).click();
        });
        step("���������, ��� Issue � ������� " + ISSUE_NUMBER + " ���������", (s) -> {
            s.parameter("Number", ISSUE_NUMBER);
            $(withText("#" + ISSUE_NUMBER)).should(exist);
        });
    }
}
