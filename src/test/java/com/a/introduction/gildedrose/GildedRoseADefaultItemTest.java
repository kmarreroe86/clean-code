package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

    public static final String NAME = "DEFAULT_ITEM";
    public static final int NOT_EXPIRED_SELL_IN = 15;
    public static final int EXPIRED_SELL_IN = -1;
    public static final int DEFAULT_QUALITY = 3;

    @Test
    public void updateQualityForDefaultNotExpiredItemShouldDecreaseQualityAndSellBy1() {

        // Given
        GildedRose app = getGildedRoseItem(NAME, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);

        // When
        app.updateQuality();

        // Then
        Item expectedUpdatedItem = new Item(NAME, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 1);
        assertItem(app.items[0], expectedUpdatedItem);
    }

    @Test
    @DisplayName("The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.")
    public void updateQualityForDefaultExpiredItemShouldDecreaseQualityBy2AndSellBy1() {
        // Given
        GildedRose app = getGildedRoseItem(NAME, EXPIRED_SELL_IN, DEFAULT_QUALITY);

        // When
        app.updateQuality();

        // Then
        Item expectedUpdateItem = new Item(NAME, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 2);
        assertItem(expectedUpdateItem, app.items[0]);
    }

    private void assertItem(Item actual, Item expectedUpdatedItem) {
        assertEquals(expectedUpdatedItem.name, actual.name);
        assertEquals(expectedUpdatedItem.sellIn, actual.sellIn);
        assertEquals(expectedUpdatedItem.quality, actual.quality);
    }

    private GildedRose getGildedRoseItem(String name, int sellIn, int quality) {
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        return app;
    }
}