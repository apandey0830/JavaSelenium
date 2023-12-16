package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private String bookPrice;

    @FindBy(id = "productTitle")
    public WebElement bookTitle;

    @FindBy(xpath = "//a[@id='a-autoid-2-announce']/span[@class='slot-price']")
    public WebElement paperbackPrice;

    @FindBy(xpath = "//span[@class='slot-title']//span[contains(text(),'Paperback')]")
    public WebElement paperbackFormat;

    @FindBy(id = "gift-wrap")
    public WebElement giftOptionsCheckBox;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='a-size-base a-color-price a-text-bold' and contains(text(),'left in stock (more on the way)')]")
    public WebElement availableStock;

    public Boolean verifyBookTitle(String titleText) {
        return bookTitle.getText().contains(titleText);
    }

    public Boolean verifyPaperbackFormat() {
        return paperbackFormat.getText().contains("Paperback");
    }

    public String getBookPrice() {
        if (paperbackPrice.isDisplayed()) {
            bookPrice = paperbackPrice.getText();
        }

        return bookPrice;
    }

    public void clickCheckBox() {
        if (!giftOptionsCheckBox.isSelected()) {
            giftOptionsCheckBox.click();
        }
    }

    public void clickAddToCartButton() {
        if (addToCartButton.isDisplayed() && addToCartButton.isEnabled()) {
            addToCartButton.click();
        }
    }

    public boolean verifyPaperbackAvailability() {
        return availableStock.getText().contains("in stock");
    }

}
