package com.gildedrose.model.impl;

import com.gildedrose.model.Item;

public class Default extends Item {

	public Default(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void increaseQuality() {		
		/**
		 * Default objects do not increase quality as the days go by
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
		if(this.isQualityDecreaseble()) {
			this.quality--;
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
