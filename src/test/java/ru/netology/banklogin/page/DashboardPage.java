package ru.netology.banklogin.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement header = $("[data-test-id='dashboard']");


    public DashboardPage() {
        header.shouldHave(exactText("Личный кабинет")).shouldBe(visible);
    }
}
