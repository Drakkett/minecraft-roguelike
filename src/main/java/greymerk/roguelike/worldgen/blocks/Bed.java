package greymerk.roguelike.worldgen.blocks;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldEditor;
import net.minecraft.init.Blocks;

public class Bed {

	public static void generate(WorldEditor editor, Cardinal dir, Coord pos){
		
		Coord cursor = new Coord(pos);
		
		
		
		MetaBlock head = new MetaBlock(Blocks.air);
		head.setBlock(editor, cursor);
		
		MetaBlock foot = new MetaBlock(Blocks.air);
		cursor.add(dir);
		foot.setBlock(editor, cursor);
	}
}
