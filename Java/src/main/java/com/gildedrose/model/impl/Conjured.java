package com.gildedrose.model.impl;

import com.gildedrose.model.Item;

public class Conjured extends Item {

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void increaseQuality() { 
		/**
		 * Conjured objects do not increase quality.
		 */
	}
	
	@Override
	public void decreaseSellIn() {
		this.sellIn--;        
        if (this.isSellInLowerThan(0)) {                           
        	this.decreaseQuality();
        }		
	}

	@Override
	public void decreaseQuality() {
		int qualityPoints = 2;
		while(qualityPoints > 0) {
			if (isQualityDecreaseble()) {
				this.quality--;
			}
			qualityPoints--;
		}
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
