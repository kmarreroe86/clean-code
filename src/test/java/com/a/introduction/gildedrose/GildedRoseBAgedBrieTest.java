package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseBAgedBrieTest {

	public static final String AGED_BRIE = "Aged Brie";
	public static final int NOT_EXPIRED_SELL_IN = 4;
	public static final int EXPIRED_SELL_IN = -1;
	public static final int QUALITY = 3;
	public static final int MAX_QUALITY = 50;

	@Test
	public void updateQualityForAgedBrieWithUnExpiredSellInDecreaseSellInBy1AndIncreaseQualityBy1() {
		// Given
		GildedRose app = getGildedRoseItem(NOT_EXPIRED_SELL_IN, QUALITY);

		// When
		app.updateQuality();

		// Then
		Item actualItemUpdated = app.items[0];
		Item expectedItemUpdated = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, QUALITY + 1);

		assertItem(expectedItemUpdated, actualItemUpdated);
	}

	@Test
	public void updateQualityForAgedBrieWithExpiredSellInShouldDecreaseSellInBy1AndIncreaseQualityBy2() {
		// Given
		GildedRose app = getGildedRoseItem(EXPIRED_SELL_IN, QUALITY);

		// When
		app.updateQuality();

		// Then
		Item actualItem = app.items[0];
		Item expectedUpdatedItem = new Item(AGED_BRIE, EXPIRED_SELL_IN - 1, QUALITY + 2);
		assertItem(expectedUpdatedItem, actualItem);
	}

	@Test
	public void updateQualityForAgedBrieWithMaxQualityShouldDecreaseSellInAndKeepQualityValue() {
		// Given
		GildedRose app = getGildedRoseItem(NOT_EXPIRED_SELL_IN, MAX_QUALITY);

		// When
		app.updateQuality();

		// Then
		Item expectedUpdatedItem = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, MAX_QUALITY);
		assertItem(expectedUpdatedItem, app.items[0]);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose getGildedRoseItem(int sellIn, int quality) {
		Item item = new Item(AGED_BRIE, sellIn, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}
}
