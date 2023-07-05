package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DiscussionsPage {

    private static final String DISCUSSIONS_PAGE_TITLE = "Welcome to the Steam Discussions";

    private final SelenideElement mainDiscussionsHeader = $(".large_title");

    public DiscussionsPage checkDiscussionsPageHeader() {
        mainDiscussionsHeader.shouldHave(text(DISCUSSIONS_PAGE_TITLE));
        return this;
    }
}
