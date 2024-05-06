package com.gildedrose.model.impl;

import com.gildedrose.model.Item;

public class Lendary extends Item {

	public Lendary(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void increaseQuality() { 
		/**
		 * Lendary objects do not increase quality.
		 */
	}
	
	@Override
	public void decreaseSellIn() {
		/**
		 * Lendary objects do not decrease sell in.
		 */
	}

	@Override
	public void decreaseQuality() {
		/**
		 * Lendary objects do not decrease quality.
		 */
	}

	@Override
	protected void normalizeQuality() {
		this.quality = 80;
	}

}