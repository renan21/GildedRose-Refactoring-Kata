package com.gildedrose.model.impl;

import com.gildedrose.model.Item;

public class Pass extends Item {

	public Pass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void increaseQuality() {
		int qualityPoints = getQualityPoints();
		while(qualityPoints > 0) {
			if (isQualityIncreaseble()) {
				this.quality++;
			}
			qualityPoints--;
		}
	}
	
	@Override
	public void decreaseSellIn() {		
		this.sellIn--;        
        if (this.isSellInLowerThan(0)) {
        	this.resetQuality();
        } 		
	}
	
	@Override
	public void decreaseQuality() {
		/**
		 * Pass objects do not decrease quality.
		 */
	}
	
	private int getQualityPoints() {
		if(this.isSellInLowerThan(6)) {
			return 3;
		} else if(this.isSellInLowerThan(11)) {
			return 2;
		}
		return 1;
	}
	
	private void resetQuality() {
		this.quality = 0;
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