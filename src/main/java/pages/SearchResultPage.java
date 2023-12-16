package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }


    private String bookPrice;

    @FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'Harry Potter and the Cursed Child - Parts One and ')]")
    public WebElement bookTitle;

    @FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-bold'][normalize-space()='Paperback']")
    public WebElement paperbackFormat;

    @FindBy(xpath="//span[@class='a-size-base a-color-price' and contains(text(),'left in stock (more on the way)')]")
    public WebElement availableStock;

    @FindBy(css="div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style'] span[class='a-price-whole']")
    public WebElement paperbackPrice;

    public Boolean verifyBookTitle(String titleText) {
        return bookTitle.getText().contains(titleText);
    }

    public Boolean verifyPaperbackFormat() {
        return paperbackFormat.isDisplayed();
    }

    public String getBookPrice() {
        if (paperbackPrice.isDisplayed()) {
            bookPrice =  paperbackPrice.getText();
        }

        return bookPrice;
    }

    public void clickPaperback() {
        paperbackFormat.click();
    }

    public boolean verifyPaperbackAvailability() {
        return availableStock.getText().contains("in stock");
    }







}
