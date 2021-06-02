import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @Test
    public void op() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example");
        $(".header-search-input").pressEnter();
        $(byAttribute("href","/eroshenkoam/allure-example")).click();
        $(withText("Issues")).click();
        $(withText("#68")).should(exist);

    }
}
