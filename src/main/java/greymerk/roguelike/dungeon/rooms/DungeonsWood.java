package greymerk.roguelike.dungeon.rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import greymerk.roguelike.dungeon.Dungeon;
import greymerk.roguelike.dungeon.base.DungeonBase;
import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.treasure.Treasure;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldEditor;
import greymerk.roguelike.worldgen.blocks.BlockType;
import greymerk.roguelike.worldgen.blocks.Cake;
import greymerk.roguelike.worldgen.blocks.Log;
import greymerk.roguelike.worldgen.blocks.Wood;

public class DungeonsWood extends DungeonBase {
	



	@Override
	public boolean generate(WorldEditor editor, Random rand, LevelSettings settings, Cardinal[] entrances, Coord origin) {
		
		int x = origin.getX();
		int y = origin.getY();
		int z = origin.getZ();
		final int HEIGHT = 3;
		final int WIDTH = rand.nextInt(2) + 2;
		final int LENGTH = rand.nextInt(2) + 3;

		MetaBlock pillar = Log.getLog(Wood.values()[rand.nextInt(Wood.values().length)]);
		MetaBlock planks = Wood.getPlank(Wood.OAK);
		Wood.applyType(pillar, planks);
		
		MetaBlock glowstone = BlockType.get(BlockType.GLOWSTONE);
		MetaBlock air = BlockType.get(BlockType.AIR);
		
		
		editor.fillRectSolid(rand, x - WIDTH, y, z - LENGTH, x + WIDTH, y + HEIGHT, z + LENGTH, air);
		editor.fillRectHollow(rand, new Coord(x - WIDTH - 1, y - 1, z - LENGTH - 1), new Coord(x + WIDTH + 1, y + HEIGHT + 1, z + LENGTH + 1), planks, false, true);
		
		// log beams
		editor.fillRectSolid(rand, x - WIDTH, y, z - LENGTH, x - WIDTH, y + HEIGHT, z - LENGTH, pillar, true, true);
		editor.fillRectSolid(rand, x - WIDTH, y, z + LENGTH, x - WIDTH, y + HEIGHT, z + LENGTH, pillar, true, true);
		editor.fillRectSolid(rand, x + WIDTH, y, z - LENGTH, x + WIDTH, y + HEIGHT, z - LENGTH, pillar, true, true);
		editor.fillRectSolid(rand, x + WIDTH, y, z + LENGTH, x + WIDTH, y + HEIGHT, z + LENGTH, pillar, true, true);

		// glowstone
		glowstone.setBlock(editor, new Coord(x - WIDTH + 1, y - 1, z - LENGTH + 1));
		glowstone.setBlock(editor, new Coord(x - WIDTH + 1, y - 1, z + LENGTH - 1));
		glowstone.setBlock(editor, new Coord(x + WIDTH - 1, y - 1, z - LENGTH + 1));
		glowstone.setBlock(editor, new Coord(x + WIDTH - 1, y - 1, z + LENGTH - 1));
		
		editor.setBlock(rand, x, y, z, planks, true, true);
		Cake.get().setBlock(editor, new Coord(x, y + 1, z));
		
		List<Coord> space = new ArrayList<Coord>();
		space.add(new Coord(x - WIDTH, y, z - LENGTH + 1));
		space.add(new Coord(x - WIDTH, y, z + LENGTH - 1));
		space.add(new Coord(x + WIDTH, y, z - LENGTH + 1));
		space.add(new Coord(x + WIDTH, y, z + LENGTH - 1));
		
		Treasure.generate(editor, rand, space, Treasure.FOOD, Dungeon.getLevel(y));
		
		return true;
	}
	
	public int getSize(){
		return 6;
	}

}
