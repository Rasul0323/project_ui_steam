package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CommonNavigationBarComponent {

    private SelenideElement logo = $(".logo"),
            pages = $(".supernav_content");
    private ElementsCollection sections = $$(".supernav_container");

    public CommonNavigationBarComponent clickOnLogo() {
        logo.click();
        return this;
    }

    public CommonNavigationBarComponent clickOnPageInSection(String section, String page) {
        sections.find(text((section))).hover();
        pages.find(byText((page))).click();
        return this;
    }
}