package greymerk.roguelike.dungeon.segment.part;

import java.util.Random;

import greymerk.roguelike.dungeon.IDungeonLevel;
import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IStair;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldEditor;
import greymerk.roguelike.worldgen.blocks.BlockType;
import greymerk.roguelike.worldgen.blocks.TallPlant;
import greymerk.roguelike.worldgen.blocks.Trapdoor;

public class SegmentPlant extends SegmentBase {
	
	@Override
	protected void genWall(WorldEditor editor, Random rand, IDungeonLevel level, Cardinal dir, ITheme theme, int x, int y, int z) {
		
		MetaBlock air = BlockType.get(BlockType.AIR);
		IStair stair = theme.getSecondaryStair();
		
		Coord cursor = new Coord(x, y, z);
		Coord start;
		Coord end;
		
		Cardinal[] orth = Cardinal.getOrthogonal(dir);
		
		cursor.add(dir, 2);
		start = new Coord(cursor);
		start.add(orth[0], 1);
		end = new Coord(cursor);
		end.add(orth[1], 1);
		end.add(Cardinal.UP, 2);
		editor.fillRectSolid(rand, start, end, air, true, true);
		
		start.add(dir, 1);
		end.add(dir, 1);
		editor.fillRectSolid(rand, start, end, theme.getSecondaryWall(), false, true);

		cursor.add(Cardinal.UP, 2);
		for(Cardinal d : orth){
			Coord c = new Coord(cursor);
			c.add(d, 1);
			stair.setOrientation(Cardinal.reverse(d), true);
			editor.setBlock(rand, c, stair, true, true);
		}
		
		cursor = new Coord(x, y, z);
		cursor.add(dir, 2);
		plant(editor, rand, theme, cursor);		
		
	}
	
	private void plant(WorldEditor editor, Random rand, ITheme theme, Coord origin){
		Coord cursor;
		BlockType.get(BlockType.DIRT_PODZOL).setBlock(editor, origin);
		
		for(Cardinal dir : Cardinal.directions){
			cursor = new Coord(origin);
			cursor.add(dir);
			Trapdoor.get(Trapdoor.OAK, Cardinal.reverse(dir), true, true).setBlock(editor, rand, cursor, true, false);
		}
		
		cursor = new Coord(origin);
		cursor.add(Cardinal.UP);
		TallPlant[] plants = new TallPlant[]{TallPlant.FERN, TallPlant.ROSE, TallPlant.PEONY};
		TallPlant.generate(editor, plants[rand.nextInt(plants.length)], cursor);
	}
}
