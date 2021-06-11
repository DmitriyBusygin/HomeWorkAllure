import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private WebSteps steps = new WebSteps();

    @Test
    public void issueSearchingAnnotationsTest() {
        steps.openMainPage();
        steps.searchForRepository("eroshenkoam/allure-example");
        steps.goToRepository("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(68);
        //комментарий для ДЗ к 8ому таску
    }
}
