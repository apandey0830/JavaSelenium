package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CapchaPage extends BasePage {

    public CapchaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@href='/cart?ref_=sw_gtc']")
    public WebElement capchaIdentifier;


    public boolean isCaptchaPresent() {
        try {
            return capchaIdentifier.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
