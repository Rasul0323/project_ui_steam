package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CommunityMainPage {

    private final SelenideElement languageButton = $("#language_pulldown"),
            languageList = $("#language_dropdown"),
            communityHomeTitle = $(".community_home_title"),
            searchPlayersInputField = $("#SearchPlayers");

    public CommunityMainPage openMainCommunityPage() {
        open("https://steamcommunity.com/");
        return this;
    }

    public CommunityMainPage changeLanguage(String language) {
        languageButton.click();
        languageList.find(byText((language))).click();
        return this;
    }

    public CommunityMainPage checkCommunityPageTitle(String expectedHeader) {
        communityHomeTitle.shouldHave(text(expectedHeader));
        return this;
    }

    public CommunityMainPage searchPlayersInput(String inputPlayer) {
        searchPlayersInputField.setValue(inputPlayer).pressEnter();
        return this;
    }
}
