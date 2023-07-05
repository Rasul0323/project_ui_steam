package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UsersSearchPage {

    private static final String SEARCH_FRIENDS_PAGE_TITLE = "Search for friends";

    private final SelenideElement mainSearchPlayersHeader = $(".community_search_container"),
            resultPlayersRows = $(".search_row");

    public UsersSearchPage checkSearchPlayersPageHeader() {
        mainSearchPlayersHeader.shouldHave(text(SEARCH_FRIENDS_PAGE_TITLE));
        return this;
    }

    public UsersSearchPage checkPlayerResultPresence(String playerName) {
        resultPlayersRows.shouldHave(text(playerName));
        return this;
    }
}
