import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную старницу")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").setValue(repository).submit();       
    }
    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(byAttribute("href", "/" + repository)).click();
    }
    @Step("Открываем таб Issues в репозитории")
    public void openIssueTab() {
        $(withText("Issues")).click();
    }
    @Step("Проверяем, что Issue с номером {number} существет")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(visible);
    }
}
