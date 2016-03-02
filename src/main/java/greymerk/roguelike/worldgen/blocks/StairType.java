package greymerk.roguelike.worldgen.blocks;

import com.bioxx.tfc.api.TFCBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public enum StairType {

	COBBLE, STONEBRICK, BRICK, SANDSTONE, RED_SANDSTONE, QUARTZ, NETHERBRICK, OAK, SPRUCE, BIRCH, JUNGLE, ACACIA, DARKOAK;
	
	public static Block getBlock(StairType type){
		switch(type){
		case COBBLE: return TFCBlocks.stoneMMSmooth;
		case STONEBRICK: return TFCBlocks.stoneMMBrick;
		case BRICK: return TFCBlocks.stoneSedBrick;
		case RED_SANDSTONE:
		case SANDSTONE: return TFCBlocks.stoneIgInSmooth;
		case QUARTZ: return TFCBlocks.stoneSedSmooth;
		case NETHERBRICK: return Blocks.nether_brick_stairs;
		case OAK: return TFCBlocks.planks;
		case SPRUCE: return TFCBlocks.stoneIgExSmooth;
		case BIRCH: return TFCBlocks.stoneIgExBrick;
		case JUNGLE: return TFCBlocks.stoneIgInBrick;
		case ACACIA: return TFCBlocks.planks2;
		case DARKOAK: return TFCBlocks.planks2;
		default: return TFCBlocks.planks;
		}
	}
}
