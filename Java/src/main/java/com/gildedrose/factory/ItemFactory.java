package com.gildedrose.factory;

import com.gildedrose.model.Item;
import com.gildedrose.model.impl.Default;
import com.gildedrose.model.impl.Lendary;
import com.gildedrose.model.impl.MaturedFood;
import com.gildedrose.model.impl.Pass;

public class ItemFactory {
		
	private static String[] maturedFoods = {"Aged Brie"};
	private static String[] passes = {"Backstage passes to a TAFKAL80ETC concert"};
	private static String[] legendaries = {"Sulfuras, Hand of Ragnaros"};
	// TODO: Quando implementar regra de itens conjurados basta descomentar.
	//private static String[] conjurieds = {"Conjured Mana Cake"};

	public static Item buildItem(String name, int sellIn, int quality) {		
		if (isMaturedFood(name)) {
			return new MaturedFood(name, sellIn, quality);
		} else if (isPass(name)) {
			return new Pass(name, sellIn, quality);
		} else if (isLegendary(name)) {
			return new Lendary(name, sellIn, quality);
		}/* TODO: Quando implementar regra de itens conjurados basta descomentar.
		 *  else if (isConjured(name)) {
		 		return new Conjured(name, sellIn, quality);
			}		
		*/
		return new Default(name, sellIn, quality);
	}	
	private static boolean isMaturedFood(String name) {
		for(String maturedFood : maturedFoods) {
			if(maturedFood.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}	
	private static boolean isPass(String name) {
		for(String pass : passes) {
			if(pass.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}	
	private static boolean isLegendary(String name) {
		for(String legendary : legendaries) {
			if(legendary.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	/*
	 * TODO: Quando implementar regra de itens conjurados basta descomentar.
	private static boolean isConjured(String name) {
		for(String conjured : conjurieds) {
			if(conjured.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	*/
}