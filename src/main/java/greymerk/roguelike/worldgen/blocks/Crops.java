package greymerk.roguelike.worldgen.blocks;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import com.bioxx.tfc.api.TFCBlocks;
import net.minecraft.init.Blocks;

public enum Crops {

	WHEAT, CARROTS, NETHERWART, MELON, PUMPKIN, POTATOES;
	
	public static MetaBlock get(Crops type){
		switch(type){
		case WHEAT: return new MetaBlock(TFCBlocks.crops, 2);
		case CARROTS: return new MetaBlock(TFCBlocks.crops,11);
		case NETHERWART: return new MetaBlock(Blocks.nether_wart);
		case MELON: return new MetaBlock(Blocks.melon_block);
		case PUMPKIN: return new MetaBlock(TFCBlocks.crops,19);
		case POTATOES: return new MetaBlock(TFCBlocks.crops,7);
		default: return new MetaBlock(TFCBlocks.crops,1);
		}
	}
	
	public static MetaBlock getCocao(Cardinal dir){
		MetaBlock cocao = new MetaBlock(Blocks.cocoa, dirMeta(Cardinal.reverse(dir)) + 12);
		return cocao;
	}
	
	public static MetaBlock getPumpkin(Cardinal dir, boolean lit){
		MetaBlock pumpkin = new MetaBlock(lit ? Blocks.lit_pumpkin : Blocks.pumpkin, dirMeta(Cardinal.reverse(dir)));
		return pumpkin;
	}
	
	public static int dirMeta(Cardinal dir){
		switch(dir){
		case NORTH: return 0;
		case EAST: return 1;
		case SOUTH: return 2;
		case WEST: return 3;
		default: return 0;
		}
	}
	
	
}
