package com.gildedrose.model;

public abstract class Item {

	protected int sellIn;
	protected String name;
	protected int quality;

	protected Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
		normalizeQuality();
	}
	
	public abstract void increaseQuality();

	public abstract void decreaseSellIn();

	public abstract void decreaseQuality();

	public int getQuality() {
		return Integer.valueOf(this.quality);
	}

	public int getSellIn() {
		return Integer.valueOf(this.sellIn);
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}

	protected boolean isQualityHigherThan(int quality) {
		return this.quality > quality;
	}

	protected boolean isQualityLowerThan(int quality) {
		return this.quality < quality;
	}
	
	protected abstract void normalizeQuality();

	protected boolean isSellInLowerThan(int sellIn) {
		return this.sellIn < sellIn;
	}

	protected boolean isQualityDecreaseble() {
		return this.quality - 1 >= 0;
	}

	protected boolean isQualityIncreaseble() {
		return this.quality + 1 <= 50;
	}

}