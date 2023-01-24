package core.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends Item {

    private final By elementsNames = By.xpath("//div[contains(@class, 'inventory_item_name')]");
    private final By elementsDetailInfo = By.xpath("//div[@class='inventory_item_desc']");
    private final By elementsPrice = By.xpath("//div[@class='inventory_item_price']");

    public List<SelenideElement> getElement() {
        return getElements(elementsNames);
    }

    public List<Item> getItems() {
        List<Item> itemsList = new ArrayList<>();
        List<SelenideElement> elements = getElements(elementsNames);
        List<String> elementsName = getElementsText(elementsNames);
        List<String> elementsDetails = getElementsText(elementsDetailInfo);
        List<String> elementsPrices = getElementsText(elementsPrice);
        for (int i = 0; i < elements.size(); i++) {
            Item item = new Item();
            item.setItemName(String.valueOf(elementsName.get(i)));
            item.setItemInfo(String.valueOf(elementsDetails.get(i)));
            item.setPrice(String.valueOf(elementsPrices.get(i)));
            itemsList.add(item);
        }
        return itemsList;
    }
}
