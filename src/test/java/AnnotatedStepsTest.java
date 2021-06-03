import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private WebSteps steps = new WebSteps();

    @Test
    public void issueSearchAnnotationsTest() {
        steps.openMainPage();
        steps.searchForRepository("eroshenkoam/allure-example");
        steps.goToRepository("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(68);
    }
}
