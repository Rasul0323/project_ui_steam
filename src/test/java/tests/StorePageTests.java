package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.StoreGamesPage;
import pages.StoreMainPage;

import static io.qameta.allure.Allure.step;

@Epic("UI Steam")
@Feature("Store")
public class StorePageTests extends TestBase {

    StoreMainPage storeMainPage = new StoreMainPage();
    StoreGamesPage storeGamesPage = new StoreGamesPage();
    CartPage cartPage = new CartPage();

    String searchPanelSectionName1 = "Your Store";
    String searchPanelSectionName2 = "New & Noteworthy";
    String searchPanelSectionName3 = "Categories";
    String searchPanelSectionName4 = "Points Shop";
    String searchPanelSectionName5 = "News";
    String searchPanelSectionName6 = "Labs";
    String sidebarSectionName1 = "GIFT CARDS";
    String sidebarSectionName2 = "RECOMMENDED";
    String sidebarSectionName3 = "DISCOVERY QUEUES";
    String sidebarSectionName4 = "BROWSE CATEGORIES";
    String sidebarSectionName5 = "BROWSE BY GENRE";
    String gameName = "Stray";

    @Test
    @Owner("r.shikhveliev")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Checking displaying of top and sidebar sections on main Store page")
    void sectionDisplayOnStorePageTest() {
        step("Open main Steam community page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Check top sections", () -> {
            storeMainPage.checkNavigationPanelElement(searchPanelSectionName1)
                    .checkNavigationPanelElement(searchPanelSectionName2)
                    .checkNavigationPanelElement(searchPanelSectionName3)
                    .checkNavigationPanelElement(searchPanelSectionName4)
                    .checkNavigationPanelElement(searchPanelSectionName5)
                    .checkNavigationPanelElement(searchPanelSectionName6);
        });
        step("Check sidebar sections", () -> {
            storeMainPage.checkSidebarSections(sidebarSectionName1)
                    .checkSidebarSections(sidebarSectionName2)
                    .checkSidebarSections(sidebarSectionName3)
                    .checkSidebarSections(sidebarSectionName4)
                    .checkSidebarSections(sidebarSectionName5);
        });
    }

    @Test
    @Owner("r.shikhveliev")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Adding game to the cart checking")
    void addToCartTest() {
        step("Open main Steam community page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Find game by search field", () -> {
            storeMainPage.searchInput(gameName);
        });
        step("Click on game with name " + gameName, () -> {
            storeGamesPage.clickOnGame(gameName);
        });
        step("Add to cart", () -> {
            storeGamesPage.addToCart();
        });
        step("Check that game " + gameName + " was added to cart", () -> {
            cartPage.checkGameInCart(gameName);
        });
    }

    @Test
    @Owner("r.shikhveliev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Delete game from cart checking")
    void deleteFromCartTest() {
        step("Open main Steam community page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Find game by search field", () -> {
            storeMainPage.searchInput(gameName);
        });
        step("Click on game with name " + gameName, () -> {
            storeGamesPage.clickOnGame(gameName);
        });
        step("Add to cart", () -> {
            storeGamesPage.addToCart();
        });
        step("Check that game " + gameName + " was added to cart", () -> {
            cartPage.checkGameInCart(gameName);
        });
        step("Delete game from Cart", () -> {
            cartPage.deleteGameFromCart();
        });
        step("Check the game was deleted", () -> {
            cartPage.checkDeletedGameMessage();
        });
    }
}
