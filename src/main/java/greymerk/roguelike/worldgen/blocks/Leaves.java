package greymerk.roguelike.worldgen.blocks;

import com.bioxx.tfc.api.TFCBlocks;

import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Block;


public enum Leaves {
	
	OAK, SPRUCE, BIRCH, JUNGLE, ACACIA, DARKOAK;
	
	public static MetaBlock get(Leaves type, boolean decay){
		
		int meta = getType(type);
		
		if(decay){
			meta += 4;
		}
		
		
		return new MetaBlock(getBlockId(type), meta);		
	}
	
	public static Block getBlockId(Leaves type){
		switch(type){
		case OAK: return TFCBlocks.leaves;
		case SPRUCE: return TFCBlocks.leaves;
		case BIRCH: return TFCBlocks.leaves;
		case JUNGLE: return TFCBlocks.leaves;
		case ACACIA: return TFCBlocks.leaves;
		case DARKOAK: return TFCBlocks.leaves;
		default: return TFCBlocks.leaves;
		}
	}
	
	private static int getType(Leaves type){
		
		switch(type){
		
		default: return 0;
		}		
	}
}
