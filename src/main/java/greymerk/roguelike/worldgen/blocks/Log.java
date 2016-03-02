package greymerk.roguelike.worldgen.blocks;

import com.bioxx.tfc.api.TFCBlocks;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Block;


public class Log {

	public static MetaBlock getLog(Wood type, Cardinal dir){
		
		MetaBlock log = new MetaBlock(getBlockId(type), getMeta(type, dir));
		return log;
		
	}
	
	public static MetaBlock getLog(Wood type){
		return getLog(type, Cardinal.UP);
	}
	
	public static Block getBlockId(Wood type){
		switch(type){
		case OAK: return TFCBlocks.fence;
		case SPRUCE: return TFCBlocks.fence;
		case BIRCH: return TFCBlocks.fence;
		case JUNGLE: return TFCBlocks.fence;
		case ACACIA: return TFCBlocks.fence2;
		case DARKOAK: return TFCBlocks.fence;
		default: return TFCBlocks.fence;
		}
	}
	
	public static int getMeta(Wood type, Cardinal dir){
		
		int orientation;

		switch(dir){
		case NORTH:
		case SOUTH: orientation = 8; break;
		case EAST:
		case WEST: orientation = 4; break;
		default: orientation = 0;
		}
		
		switch(type){
		case OAK: return orientation;
		case SPRUCE: return orientation + 1;
		case BIRCH: return orientation + 2;
		case JUNGLE: return orientation + 3;
		case ACACIA: return orientation;
		case DARKOAK: return orientation + 1;
		default: return 0;
		}
		
	}
}
