package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBasketPage extends BasePage {
    public ShoppingBasketPage(WebDriver driver) {
        super(driver);
    }

    private String bookPrice;

    @FindBy(xpath="//span[@class='a-truncate-cut'][contains(text(),'Harry Potter and the Cursed Child - Parts One and ')]")
    public WebElement bookTitle;

    @FindBy(xpath="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement paperbackPrice;

    @FindBy(xpath="//span[@id='sc-subtotal-amount-activecart']")
    public WebElement subTotalPrice;

    @FindBy(xpath="//div[@class='a-checkbox sc-gift-option a-align-top a-size-small a-spacing-top-micro']//input[@type='checkbox']")
    public WebElement giftOptionsCheckBox;

    @FindBy(xpath="//span[@id='sc-subtotal-label-activecart']")
    public WebElement subTotalItemCount;

    @FindBy(id="a-autoid-0-announce")
    public WebElement quantityItemCount;

    @FindBy(id="sc-buy-box-ptc-button")
    public WebElement proceedToCheckOutButton;


    public Boolean verifyBookTitle(String titleText) {
        return bookTitle.getText().contains(titleText);
    }

    public String getPaperbackPrice() {
        if (paperbackPrice.isDisplayed()) {
            bookPrice =  paperbackPrice.getText();
        }

        return bookPrice;
    }

    public String getSubTotalPrice() {
        if (subTotalPrice.isDisplayed()) {
            bookPrice =  subTotalPrice.getText();
        }

        return bookPrice;
    }

    public boolean verifyGiftCheckBoxSelected() {
        return giftOptionsCheckBox.isSelected();
    }

    public boolean verifySubTotalItemCount(String count) {
        return subTotalItemCount.getText().contains(count);
    }

    public boolean verifyQuantityItemCount(String count) {
        return quantityItemCount.getText().contains(count);
    }


    public boolean verifyProceedToCheckoutButtonDisplayed() {
        return proceedToCheckOutButton.isDisplayed();
    }

}
