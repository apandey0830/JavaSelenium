package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@aria-label='Amazon.co.uk']")
    public WebElement amazonLogo;

    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    public WebElement searchBar;

    @FindBy(id="sp-cc-accept")
    public WebElement acceptCookieButton;

    @FindBy(xpath="//input[@id='nav-search-submit-button']")
    public WebElement searchButton;


    public Boolean verifyAmazonLogo() {
        return amazonLogo.isDisplayed();
    }

    public Boolean verifySearchBar() {
        return searchBar.isDisplayed();
    }

    public void clickAcceptCookieButton() {
        if (acceptCookieButton.isDisplayed()) {
            acceptCookieButton.click();
        }
    }

    public void enterSearchTextToSearchBar(String searchTerm) {
        searchBar.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        if (searchButton.isDisplayed() && searchButton.isEnabled()) {
            searchButton.click();
        }
    }





}
