package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private static final String CART_PAGE_TITLE = "YOUR SHOPPING CART";
    private static final String SUCCESS_MESSAGE = "Your item has been added!";
    private static final String DELETE_MESSAGE = "Your item has been removed!";

    private final SelenideElement cartPageHeader = $(".pageheader"),
            statusMessage = $(".cart_status_message"),
            cartItem = $(".cart_item"),
            removeFromCartBtn = $(".remove_link");

    public CartPage checkGameInCart(String gameName) {
        cartPageHeader.shouldHave(text(CART_PAGE_TITLE));
        statusMessage.shouldHave(text(SUCCESS_MESSAGE));
        cartItem.shouldHave(text(gameName));
        return this;
    }

    public CartPage deleteGameFromCart() {
        removeFromCartBtn.click();
        return this;
    }

    public CartPage checkDeletedGameMessage() {
        statusMessage.shouldHave(text(DELETE_MESSAGE));
        return this;
    }
}
