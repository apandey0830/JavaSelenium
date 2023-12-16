package exercise.testcases;

import exercise.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Scanner;

public class AmazonUKShoppingTest extends BaseClass {

    String searchResultPagePrice;
    String productDetailPagePrice;
    String shoppingBasketPagePrice;
    String shoppingBasketSubTotalPrice;

    @Test(priority=1)
    public void verifyLandingPage() {

        CapchaPage capchaPage = new CapchaPage(driver);

        if (capchaPage.isCaptchaPresent()) {
            System.out.println("CAPTCHA detected! Please solve it manually and press Enter to resume...");
            waitForEnterKey();
        }

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickAcceptCookieButton();
        Assert.assertTrue(landingPage.verifyAmazonLogo());
        Assert.assertTrue(landingPage.verifySearchBar());
        landingPage.enterSearchTextToSearchBar("Harry Potter and the Cursed Child, Parts One and Two");
        landingPage.clickSearchButton();
    }

    @Test(priority=2)
    public void verifySearchResultPage() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        Assert.assertTrue(searchResultPage.verifyBookTitle("Harry Potter and the Cursed Child - Parts One and Two"));
        Assert.assertTrue(searchResultPage.verifyPaperbackFormat());
        searchResultPagePrice = searchResultPage.getBookPrice();
        Assert.assertTrue(searchResultPage.verifyPaperbackAvailability());
        searchResultPage.clickPaperback();
    }

    @Test(priority=3)
    public void verifyProductDetailPage() {
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        Assert.assertTrue(productDetailPage.verifyBookTitle("Harry Potter and the Cursed Child - Parts One and Two"));
        productDetailPagePrice = productDetailPage.getBookPrice();
        productDetailPage.clickCheckBox();
        Assert.assertTrue(productDetailPagePrice.contains(searchResultPagePrice));
        Assert.assertTrue(productDetailPage.verifyPaperbackFormat());
        Assert.assertTrue(productDetailPage.verifyPaperbackAvailability());
        productDetailPage.clickAddToCartButton();
    }

    @Test(priority=4)
    public void verifyBasketInfoPage() {
        BasketInfoPage basketInfoPage = new BasketInfoPage(driver);

        Assert.assertTrue(basketInfoPage.verifyAddedToBasketIcon());
        Assert.assertTrue(basketInfoPage.verifyAddedToBasketText());
        basketInfoPage.clickGoToBasketButton();
    }

    @Test(priority=5)
    public void verifyShoppingBasketPage() {
        ShoppingBasketPage shoppingBasketPage = new ShoppingBasketPage(driver);

        Assert.assertTrue(shoppingBasketPage.verifyBookTitle("Harry Potter and the Cursed Child - Parts One and Two"));
        shoppingBasketPagePrice = shoppingBasketPage.getPaperbackPrice();
        shoppingBasketSubTotalPrice = shoppingBasketPage.getSubTotalPrice();
        Assert.assertEquals(shoppingBasketPagePrice.trim(), shoppingBasketSubTotalPrice.trim());
        Assert.assertEquals(productDetailPagePrice.trim(), shoppingBasketSubTotalPrice.trim());
        Assert.assertEquals(productDetailPagePrice.trim(), shoppingBasketPagePrice.trim());
        Assert.assertTrue(shoppingBasketPage.verifyGiftCheckBoxSelected());
        Assert.assertTrue(shoppingBasketPage.verifySubTotalItemCount("1"));
        Assert.assertTrue(shoppingBasketPage.verifyQuantityItemCount("1"));
        Assert.assertTrue(shoppingBasketPage.verifyProceedToCheckoutButtonDisplayed());
    }
}
