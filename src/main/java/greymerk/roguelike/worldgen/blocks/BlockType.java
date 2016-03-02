package greymerk.roguelike.worldgen.blocks;

import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.bioxx.tfc.api.TFCBlocks;

public enum BlockType {

	AIR, WATER_STILL, WATER_FLOWING, LAVA_STILL, LAVA_FLOWING, FIRE, IRON_BAR,
	STONE_SMOOTH, GRANITE, GRANITE_POLISHED, DIORITE, DIORITE_POLISHED, ANDESITE, 
	ANDESITE_POLISHED, GRASS, DIRT, DIRT_COARSE, DIRT_PODZOL, COBBLESTONE, COBBLESTONE_WALL, BEDROCK,
	SAND, SAND_RED, GRAVEL, ORE_GOLD, ORE_IRON, ORE_COAL, GLASS, ORE_LAPIS, ORE_EMERALD, LAPIS_BLOCK,
	SANDSTONE, SANDSTONE_CHISELED, SANDSTONE_SMOOTH, GOLD_BLOCK, IRON_BLOCK,
	BRICK, COBBLESTONE_MOSSY, OBSIDIAN, ORE_DIAMOND, DIAMOND_BLOCK, FARMLAND, 
	ORE_REDSTONE, ICE, SNOW, CLAY, NETHERRACK, SOUL_SAND, GLOWSTONE,
	STONE_BRICK, STONE_BRICK_MOSSY, STONE_BRICK_CRACKED, STONE_BRICK_CHISELED,
	MYCELIUM, NETHERBRICK, END_STONE, EMERALD_BLOCK, ORE_QUARTZ,
	PRISMITE, PRISMARINE, PRISMARINE_DARK, SEA_LANTERN, COAL_BLOCK, ICE_PACKED,
	SANDSTONE_RED, SANDSTONE_RED_CHISELED, SANDSTONE_RED_SMOOTH,
	QUARTZ, REDSTONE_BLOCK, PRESSURE_PLATE_STONE, PRESSURE_PLATE_WOODEN, SHELF, REDSTONE_WIRE,
	COCAO, REEDS, CRAFTING_TABLE, NOTEBLOCK, REDSTONE_LAMP, REDSTONE_LAMP_LIT, JUKEBOX, FENCE,
	TNT, ENCHANTING_TABLE, FENCE_NETHER_BRICK, WEB, PUMPKIN_LIT, VINE;
	
	
	public static MetaBlock get(BlockType type){
		
		switch(type){
		case AIR: return new MetaBlock(Blocks.air);
		case WATER_STILL: return new MetaBlock(TFCBlocks.saltWaterStationary);
		case WATER_FLOWING: return new MetaBlock(TFCBlocks.saltWater);
		case LAVA_STILL: return new MetaBlock(TFCBlocks.lavaStationary);
		case LAVA_FLOWING: return new MetaBlock(TFCBlocks.lava);
		case FIRE: return new MetaBlock(Blocks.fire);
		case IRON_BAR: return new MetaBlock(Blocks.iron_bars);
		case GRANITE: return new MetaBlock(TFCBlocks.stoneMMSmooth, 1);
		case GRANITE_POLISHED: return new MetaBlock(TFCBlocks.stoneMMSmooth, 1);
		case DIORITE: return new MetaBlock(TFCBlocks.stoneMMSmooth, 1);
		case DIORITE_POLISHED: return new MetaBlock(TFCBlocks.stoneMMSmooth, 1);
		case ANDESITE: return new MetaBlock(TFCBlocks.stoneIgExBrick, 2);
		case ANDESITE_POLISHED: return new MetaBlock(TFCBlocks.stoneMMSmooth, 1);
		case STONE_SMOOTH: return new MetaBlock(TFCBlocks.stoneMMSmooth, 1);
		case GRASS: return new MetaBlock(TFCBlocks.grass);
		case DIRT: return new MetaBlock(TFCBlocks.dirt);
		case DIRT_COARSE:
		case DIRT_PODZOL: return new MetaBlock(TFCBlocks.dirt2);
		case COBBLESTONE: return new MetaBlock(TFCBlocks.stoneMM, 2);
		case COBBLESTONE_WALL: return new MetaBlock(TFCBlocks.wallCobbleMM, 2);
		case BEDROCK: return new MetaBlock(Blocks.bedrock);
		case SAND: return new MetaBlock(TFCBlocks.stoneIgInSmooth, 1);
		case SAND_RED: return new MetaBlock(TFCBlocks.stoneIgInBrick, 1);
		case GRAVEL: return new MetaBlock(TFCBlocks.stoneIgExSmooth);
		case ORE_GOLD: return new MetaBlock(TFCBlocks.ore);
		case ORE_IRON: return new MetaBlock(TFCBlocks.ore2);
		case GLASS: return new MetaBlock(Blocks.glass);
		case ORE_LAPIS: return new MetaBlock(TFCBlocks.ore3);
		case LAPIS_BLOCK: return new MetaBlock(Blocks.lapis_block);
		case ORE_EMERALD: return new MetaBlock(Blocks.emerald_ore);
		case SANDSTONE_RED:
		case SANDSTONE: return new MetaBlock(TFCBlocks.stoneSed, 3);
		case SANDSTONE_RED_CHISELED:
		case SANDSTONE_CHISELED: return new MetaBlock(TFCBlocks.stoneSedBrick, 3);
		case SANDSTONE_RED_SMOOTH:
		case SANDSTONE_SMOOTH: return new MetaBlock(TFCBlocks.stoneSedSmooth, 3);
		case GOLD_BLOCK: return new MetaBlock(Blocks.gold_block);
		case IRON_BLOCK: return new MetaBlock(Blocks.iron_block);
		case BRICK: return new MetaBlock(TFCBlocks.stoneSedBrick, 6);
		case COBBLESTONE_MOSSY: return new MetaBlock(TFCBlocks.stoneMM, 3);
		case OBSIDIAN: return new MetaBlock(TFCBlocks.stoneIgExSmooth, 1);
		case ORE_DIAMOND: return new MetaBlock(Blocks.diamond_ore);
		case DIAMOND_BLOCK: return new MetaBlock(Blocks.diamond_block);
		case FARMLAND: return new MetaBlock(TFCBlocks.dirt2,4);
		case ORE_REDSTONE: return new MetaBlock(Blocks.redstone_ore);
		case ICE: return new MetaBlock(TFCBlocks.ice);
		case SNOW: return new MetaBlock(TFCBlocks.snow);
		case CLAY: return new MetaBlock(TFCBlocks.clay2);
		case NETHERRACK: return new MetaBlock(Blocks.netherrack);
		case SOUL_SAND: return new MetaBlock(Blocks.soul_sand);
		case GLOWSTONE: return new MetaBlock(Blocks.glowstone);
		case STONE_BRICK: return new MetaBlock(TFCBlocks.stoneIgExBrick, 2);
		case STONE_BRICK_MOSSY: return new MetaBlock(TFCBlocks.stoneMMBrick, 3);
		case STONE_BRICK_CRACKED: return new MetaBlock(TFCBlocks.stoneMMBrick, 4);
		case STONE_BRICK_CHISELED: return new MetaBlock(TFCBlocks.stoneIgInBrick, 1);
		case MYCELIUM: return new MetaBlock(TFCBlocks.dirt2,3);
		case NETHERBRICK: return new MetaBlock(Blocks.nether_brick);
		case END_STONE: return new MetaBlock(Blocks.end_stone);
		case EMERALD_BLOCK: return new MetaBlock(Blocks.emerald_block);
		case ORE_QUARTZ: return new MetaBlock(Blocks.quartz_ore);
		case PRISMITE: 
		case PRISMARINE: 
		case PRISMARINE_DARK: return new MetaBlock(Blocks.cobblestone);
		case COAL_BLOCK: return new MetaBlock(TFCBlocks.charcoal);
		case ICE_PACKED: return new MetaBlock(Blocks.packed_ice);
		case QUARTZ: return new MetaBlock(TFCBlocks.stoneMMSmooth, 5);
		case REDSTONE_BLOCK: return new MetaBlock(Blocks.redstone_block);
		case PRESSURE_PLATE_STONE: return new MetaBlock(Blocks.stone_pressure_plate);
		case PRESSURE_PLATE_WOODEN: return new MetaBlock(Blocks.wooden_pressure_plate);
		case SHELF: return new MetaBlock(TFCBlocks.bookshelf);
		case REDSTONE_WIRE: return new MetaBlock(Blocks.redstone_wire);
		case COCAO: return new MetaBlock(TFCBlocks.flowers);
		case REEDS: return new MetaBlock(TFCBlocks.reeds);
		case CRAFTING_TABLE: return new MetaBlock(Blocks.crafting_table);
		case NOTEBLOCK: return new MetaBlock(Blocks.noteblock);
		case REDSTONE_LAMP: return new MetaBlock(Blocks.redstone_lamp);
		case REDSTONE_LAMP_LIT: return new MetaBlock(Blocks.lit_redstone_lamp);
		case JUKEBOX: return new MetaBlock(Blocks.jukebox);
		case FENCE: return new MetaBlock(TFCBlocks.fence);
		case TNT: return new MetaBlock(Blocks.tnt);
		case ENCHANTING_TABLE: return new MetaBlock(Blocks.enchanting_table);
		case FENCE_NETHER_BRICK: return new MetaBlock(Blocks.nether_brick_fence);
		case WEB: return new MetaBlock(Blocks.web);
		case PUMPKIN_LIT: return new MetaBlock(TFCBlocks.litPumpkin);
		case VINE: return new MetaBlock(TFCBlocks.vine);
		default: return new MetaBlock(Blocks.air);
		}
	}
	
	public static ItemStack getItem(BlockType type){
		
		MetaBlock block = BlockType.get(type);
		Block b = block.getBlock();
		Item i = Item.getItemFromBlock(b);
		ItemStack item = new ItemStack(i);
		
		return item;
	}
}
