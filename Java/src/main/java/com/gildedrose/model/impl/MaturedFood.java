package com.gildedrose.model.impl;

import com.gildedrose.model.Item;

public class MaturedFood extends Item {

	public MaturedFood(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}	
	
	@Override
	public void increaseQuality() {
		if (isQualityIncreaseble()) {
			this.quality++;
		}
	}
	
	@Override
	public void decreaseSellIn() {		
		this.sellIn--;		
        if (this.isSellInLowerThan(0)) { 
        	this.increaseQuality();
        }	
	}

	@Override
	public void decreaseQuality() { 
		/*
		 * MaturedFood objects do not decrease quality.
		 */
	}

	@Override
	protected void normalizeQuality() {
		if(this.isQualityLowerThan(0)) {
			this.quality = 0;
		} else if(this.isQualityHigherThan(50)) {
			this.quality = 50;
		}		
	}
}