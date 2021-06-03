import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("��������� ������� ��������")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("���� ����������� {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository);
        $(".header-search-input").pressEnter();
    }
    @Step("��������� � ����������� {repository}")
    public void goToRepository(String repository) {
        $(byAttribute("href", "/" + repository)).click();
    }
    @Step("��������� ��� Issues � �����������")
    public void openIssueTab() {
        $(withText("Issues")).click();
    }
    @Step("���������, ��� Issue � ������� {number} ���������")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(exist);
    }
}