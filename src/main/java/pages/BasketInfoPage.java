package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketInfoPage extends BasePage {
    public BasketInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@href='/cart?ref_=sw_gtc']")
    public WebElement goToBasketButton;

    @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    public WebElement addedToBasket;

    @FindBy(xpath = "//div[@class='a-box a-alert-inline a-alert-inline-success sw-atc-message']//i[@class='a-icon a-icon-alert']")
    public WebElement addedToBasketIcon;


    public void clickGoToBasketButton() {
        if (goToBasketButton.isDisplayed()) {
            goToBasketButton.click();
        }
    }

    public boolean verifyAddedToBasketIcon() {
        return addedToBasketIcon.isDisplayed();
    }

    public boolean verifyAddedToBasketText() {
        return addedToBasket.isDisplayed();
    }


}
