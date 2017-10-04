package Pages;

import Constants.XPositionChange;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;

import static Constants.Sliders.LEFT;
import static Constants.Sliders.RIGHT;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;

public class Dates {
    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    public void moveLeftSliderAndCheckValue(XPositionChange newPosition) {
        actions().clickAndHold(sliders.get(LEFT.slider))
                .moveByOffset(newPosition.xPositionChange, 0)
                .release()
                .build()
                .perform();
        sliders.get(LEFT.slider).shouldHave(exactText(newPosition.setValue));

    }

    public void moveRightSliderAndCheckValue(XPositionChange newPosition) {
        actions().clickAndHold(sliders.get(RIGHT.slider))
                .moveByOffset(newPosition.xPositionChange, 0)
                .release()
                .build()
                .perform();
        sliders.get(RIGHT.slider).shouldHave(exactText(newPosition.setValue));
    }
}
