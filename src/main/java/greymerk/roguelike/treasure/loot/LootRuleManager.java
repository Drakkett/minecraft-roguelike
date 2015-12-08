package greymerk.roguelike.treasure.loot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import greymerk.roguelike.treasure.Treasure;
import greymerk.roguelike.treasure.TreasureManager;
import greymerk.roguelike.util.IWeighted;
import greymerk.roguelike.util.WeightedRandomizer;
import net.minecraft.item.ItemStack;

public class LootRuleManager {

	private List<LootRule> rules;
	
	public LootRuleManager(){
		this.rules = new ArrayList<LootRule>();
	}
	
	public LootRuleManager(JsonElement e) {
		this.rules = new ArrayList<LootRule>();
		JsonArray arr = e.getAsJsonArray();
		for(JsonElement ruleElement : arr){
			
			JsonObject rule = ruleElement.getAsJsonObject();
			
			Treasure type = rule.has("type") ? Treasure.valueOf(rule.get("type").getAsString()) : null;
			
			if(!rule.has("loot")) continue;
			JsonElement loot = rule.get("loot");
			IWeighted<ItemStack> item = this.parseProvider(loot);

			int level = rule.get("level").getAsInt();
			boolean each = rule.get("each").getAsBoolean();
			int amount = rule.get("quantity").getAsInt();
			
			this.add(type, item, level, each, amount);
		}
	}

	public void add(Treasure type, IWeighted<ItemStack> item, int level, boolean toEach, int amount){
		this.rules.add(new LootRule(type, item, level, toEach, amount));
	}
	
	public void add(LootRuleManager other){
		this.rules.addAll(other.rules);
	}
	
	public void process(Random rand, ILoot loot, TreasureManager treasure){
		for(LootRule rule : this.rules){
			rule.process(rand, loot, treasure);
		}
	}
	
	private IWeighted<ItemStack> parseProvider(JsonElement data) {
		
		if(data.isJsonObject()){
			JsonObject loot = data.getAsJsonObject();
			return new WeightedRandomLoot(loot.getAsJsonObject(), 1);
		}

		JsonArray loot = data.getAsJsonArray();
		WeightedRandomizer<ItemStack> items = new WeightedRandomizer<ItemStack>(1);		
		for(JsonElement e : loot){
			items.add(parseProvider(e.getAsJsonObject()));
		}
		
		return items;
	}
}