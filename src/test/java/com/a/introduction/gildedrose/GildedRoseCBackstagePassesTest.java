package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseCBackstagePassesTest {

    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final int QUALITY = 3;

    @Test
    public void updateQualityForBackstagePassesWithSellInBiggerThan10ShouldDecreaseSellInBy1AndIncreaseQualityBy1() {

        // Given
        int sellIn = 15;
        GildedRose app = getGildedRoseItem(sellIn);

        // When
        app.updateQuality();

        // Then
        Item expectedUpdatedItem = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn - 1, QUALITY + 1);
        assertItem(expectedUpdatedItem, app.items[0]);
    }

    @Test
    public void updateQualityForBackstagePassesWithSellInLessThan10ShouldDecreaseSellInBy1AndIncreaseQualityBy2() {
        // Given
        int sellIn = 7;
        GildedRose app = getGildedRoseItem(sellIn);

        // When
        app.updateQuality();

        // Then
        Item expectedUpdatedItem = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn - 1, QUALITY + 2);
        assertItem(expectedUpdatedItem, app.items[0]);
    }

    @Test
    public void updateQualityForBackstagePassesWithSellInLessThan5ShouldDecreaseSellInBy1AndIncreaseQualityBy3() {
        // Given
        int sellIn = 4;
        GildedRose app = getGildedRoseItem(sellIn);

        // When
        app.updateQuality();

        // Then
        Item expectedUpdatedItem = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn - 1, QUALITY + 3);
        assertItem(expectedUpdatedItem, app.items[0]);
    }

    private void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }

    private GildedRose getGildedRoseItem(int sellIn) {
        Item item = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn, QUALITY);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        return app;
    }

}