package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CommunityMainPage;
import pages.DiscussionsPage;
import pages.StoreMainPage;
import pages.UsersSearchPage;
import pages.components.CommonNavigationBarComponent;

import static io.qameta.allure.Allure.step;

@Epic("UI Steam")
@Feature("Community")
public class CommunityPageTests extends TestBase {

    CommunityMainPage communityMainPage = new CommunityMainPage();
    CommonNavigationBarComponent commonNavigationBar = new CommonNavigationBarComponent();
    StoreMainPage storeMainPage = new StoreMainPage();
    DiscussionsPage discussionsPage = new DiscussionsPage();
    UsersSearchPage usersSearchPage = new UsersSearchPage();

    String firstSearchPanelSectionName = "Your Store";
    String sectionName = "Community";
    String pageName = "Discussions";
    String playerName = "play_on_xbox";

    @Owner("r.shikhveliev")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "Check if header name {1} in locale {0}")
    @CsvSource(value = {
            "Русский (Russian), Активность сообщества",
            "Suomi (Finnish), Yhteisön toiminta",
            "Deutsch (German), Communityaktivität"
    })
    void languageChangeTest(String language, String expectedHeader) {
        step("Open main Steam community page", () -> {
            communityMainPage.openMainCommunityPage();
        });
        step("Choose language " + language, () -> {
            communityMainPage.changeLanguage(language);
        });
        step("Check presence of header " + expectedHeader, () -> {
            communityMainPage.checkCommunityPageTitle(expectedHeader);
        });
    }

    @Test
    @Owner("r.shikhveliev")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Checking transition to the Store main page by clicking logo Steam")
    void moveToStorePageByLogoButtonTest() {
        step("Open main Steam community page", () -> {
            communityMainPage.openMainCommunityPage();
        });
        step("Click on logo Steam", () -> {
            commonNavigationBar.clickOnLogo();
        });
        step("Check if " + firstSearchPanelSectionName + " section presents", () -> {
            storeMainPage.checkNavigationPanelElement(firstSearchPanelSectionName);
        });
    }

    @Test
    @Owner("r.shikhveliev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking open 'Discussions' page from drop-down Community menu")
    void discussionOpenPageTest() {
        step("Open main Steam community page", () -> {
            communityMainPage.openMainCommunityPage();
        });
        step("Click on " + pageName + " page in " + sectionName + " section", () -> {
            commonNavigationBar.clickOnPageInSection(sectionName, pageName);
        });
        step("Check header of 'Discussions' page", () -> {
            discussionsPage.checkDiscussionsPageHeader();
        });
    }

    @Test
    @Owner("r.shikhveliev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking friends search")
    void friendsSearchTest() {
        step("Open main Steam community page", () -> {
            communityMainPage.openMainCommunityPage();
        });
        step("Enter player name " + playerName + " in find people search field", () -> {
            communityMainPage.searchPlayersInput(playerName);
        });
        step("Verify that results have player with name " + playerName, () -> {
            usersSearchPage.checkSearchPlayersPageHeader()
                    .checkPlayerResultPresence(playerName);
        });
    }
}
