package com.gildedrose;

import com.gildedrose.model.Item;

class GildedRose {
    
	private Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}
	
	public void updateItem() {
		for (Item item : items) {
			item.decreaseQuality();	               	
			item.increaseQuality();
			item.decreaseSellIn(); 
		}		
	}
}