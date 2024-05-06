package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.model.Item;
import com.gildedrose.model.impl.Lendary;

class GildedRoseTest {

	@Test
	void whenDefaultItemSellInIsLowerThanZeroQualityDecreaseTwiceFaster() {
		Item[] items = new Item[] { ItemFactory.buildItem("foo", -1, 2),
									ItemFactory.buildItem("+5 Dexterity Vest", -1, 2),
									ItemFactory.buildItem("Elixir of the Mongoose", -1, 2) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			assertEquals(0, item.getQuality());
		}
	}

	@Test
	void qualityShouldNotBeNegative() {
		Item[] items = new Item[] { ItemFactory.buildItem("foo", -1, -1),
									ItemFactory.buildItem("foo", -1, 0),
									ItemFactory.buildItem("foo", -1, 1),
									ItemFactory.buildItem("Aged Brie", 2, -1),
									ItemFactory.buildItem("Aged Brie", 2, 0),
									ItemFactory.buildItem("Aged Brie", 2, 1),
									ItemFactory.buildItem("Conjured Mana Cake", 3, -1),
									ItemFactory.buildItem("Conjured Mana Cake", 3, 0),
									ItemFactory.buildItem("Conjured Mana Cake", 3, 1),
									ItemFactory.buildItem("+5 Dexterity Vest", 10, -1),
									ItemFactory.buildItem("+5 Dexterity Vest", 10, 0),
									ItemFactory.buildItem("+5 Dexterity Vest", 10, 1),
									ItemFactory.buildItem("Elixir of the Mongoose", 5, -1),
									ItemFactory.buildItem("Elixir of the Mongoose", 5, 0),
									ItemFactory.buildItem("Elixir of the Mongoose", 5, 1),
									ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 10, -1),
									ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 10, 0),
									ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 10, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			assertTrue(item.getQuality() >= 0);
		}
	}

	@Test
	void whenSellInIncreasesOneQualityOfMaturedFoodIncreasesOne() {
		Item[] items = new Item[] { ItemFactory.buildItem("Aged Brie", 2, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			assertEquals(1, item.getSellIn());
			assertEquals(2, item.getQuality());
		}
	}

	@Test
	void qualityShouldNotBeHigherThanFiftyExceptLendaryItems() {
		Item[] items = new Item[] { ItemFactory.buildItem("foo", -1, 49), ItemFactory.buildItem("foo", -1, 50),
				ItemFactory.buildItem("foo", -1, 51), ItemFactory.buildItem("Aged Brie", 2, 49),
				ItemFactory.buildItem("Aged Brie", 2, 50), ItemFactory.buildItem("Aged Brie", 2, 51),
				ItemFactory.buildItem("Conjured Mana Cake", 3, 49), ItemFactory.buildItem("Conjured Mana Cake", 3, 50),
				ItemFactory.buildItem("Conjured Mana Cake", 3, 51), ItemFactory.buildItem("+5 Dexterity Vest", 10, 49),
				ItemFactory.buildItem("+5 Dexterity Vest", 10, 50), ItemFactory.buildItem("+5 Dexterity Vest", 10, 51),
				ItemFactory.buildItem("Elixir of the Mongoose", 5, 49),
				ItemFactory.buildItem("Elixir of the Mongoose", 5, 50),
				ItemFactory.buildItem("Elixir of the Mongoose", 5, 51),
				ItemFactory.buildItem("Sulfuras, Hand of Ragnaros", 0, 49),
				ItemFactory.buildItem("Sulfuras, Hand of Ragnaros", 0, 50),
				ItemFactory.buildItem("Sulfuras, Hand of Ragnaros", 0, 51),
				ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 10, 50),
				ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 10, 51) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			if (!isLendaryItem(item)) {
				assertTrue(item.getQuality() <= 50);
			}
		}
	}

	@Test
	void whenLendaryItemShouldNotIncreaseSellInAndQuality() {
		Item[] items = new Item[] { ItemFactory.buildItem("Sulfuras, Hand of Ragnaros", 0, 49),
									ItemFactory.buildItem("Sulfuras, Hand of Ragnaros", 0, 50)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			assertEquals(0, item.getSellIn());
			assertEquals(80,item.getQuality());
		}
	}
	
	@Test
	void whenSellInLowerThanTenQualityOfPassIncreasesTwo() {
		Item[] items = new Item[] { ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 10, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			assertEquals(9, item.getSellIn());
			assertEquals(3, item.getQuality());
		}
	}
	
	@Test
	void whenSellInLowerThanFiveQualityOfPassIncreasesThree() {
		Item[] items = new Item[] { ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 5, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			assertEquals(4, item.getSellIn());
			assertEquals(4, item.getQuality());
		}
	}

	@Test
	void whenSellInLowerThanZeroQualityOfPassDecreasesToZero() {
		Item[] items = new Item[] { ItemFactory.buildItem("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateItem();

		for (Item item : items) {
			assertEquals(-1, item.getSellIn());
			assertEquals(0, item.getQuality());
		}
	}
	
	private boolean isLendaryItem(Item item) {
		return item instanceof Lendary;
	}

}
