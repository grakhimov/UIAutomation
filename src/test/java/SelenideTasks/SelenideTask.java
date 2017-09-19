package SelenideTasks;

import org.testng.annotations.Test;

import static pages.IndexPage.*;

public class SelenideTask {
    @Test
    public void task1() {
        selenideConfiguration();
        openIndexPage();
        login();
        indexPageElementsAreExist();
    }
}
