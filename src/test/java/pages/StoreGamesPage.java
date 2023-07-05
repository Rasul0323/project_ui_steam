package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StoreGamesPage {

    private final SelenideElement game = $(".responsive_search_name_combined"),
            addToCartBtn = $(".btn_addtocart");

    public StoreGamesPage clickOnGame(String gameName) {
        game.find(byText(gameName)).click();
        return this;
    }

    public StoreGamesPage addToCart() {
        addToCartBtn.click();
        return this;
    }
}
