package core.pages;

import core.config.PageTools;

import java.util.Objects;

public class Item extends PageTools {
    private String itemName;
    private String itemInfo;
    private String price;

    public Item() {
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName) && Objects.equals(itemInfo, item.itemInfo) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemInfo, price);
    }

    @Override
    public String toString() {
        return "ItemPage{" +
                "itemName='" + itemName + '\'' +
                ", itemInfo='" + itemInfo + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
