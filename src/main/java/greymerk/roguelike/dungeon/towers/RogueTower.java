package greymerk.roguelike.dungeon.towers;

import java.util.Random;

import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IBlockFactory;
import greymerk.roguelike.worldgen.IStair;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldEditor;
import greymerk.roguelike.worldgen.blocks.BlockType;
import greymerk.roguelike.worldgen.redstone.Torch;


public class RogueTower implements ITower{

	public void generate(WorldEditor editor, Random rand, ITheme theme, int x, int y, int z){
		
		MetaBlock air = BlockType.get(BlockType.AIR);
		
		IBlockFactory blocks = theme.getPrimaryWall();
		
		IStair stair = theme.getPrimaryStair();
		
		Coord floor = Tower.getBaseCoord(editor, x, y, z);
		int ground = floor.getY() - 1;
		int main = floor.getY() + 4;
		int roof = floor.getY() + 9;
		
		editor.fillRectSolid(rand, x - 3, ground, z - 3, x + 3, floor.getY() + 12, z + 3, air);
		editor.fillRectSolid(rand, new Coord(x - 2, y + 10, z - 2), new Coord(x + 2, floor.getY() - 1, z + 2), blocks, false, true);

		Coord start;
		Coord end;
		Coord cursor;
		
		editor.fillRectSolid(rand, x - 3, main, z - 3, x + 3, main, z + 3, theme.getSecondaryWall(), true, true);
		editor.fillRectSolid(rand, x - 3, roof, z - 3, x + 3, roof, z + 3, blocks, true, true);
		
		for(Cardinal dir : Cardinal.directions){
			for (Cardinal orth : Cardinal.getOrthogonal(dir)){
				// ground floor
				start = new Coord(floor);
				start.add(Cardinal.DOWN, 1);
				start.add(dir, 2);
				end = new Coord(start);
				end.add(dir, 3);
				end.add(orth, 1);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				start.add(orth, 2);
				end.add(Cardinal.reverse(dir), 2);
				end.add(orth, 2);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				
				cursor = new Coord(floor);
				cursor.add(dir, 5);
				cursor.add(orth, 1);
				start = new Coord(cursor);
				end = new Coord(cursor);
				end.add(Cardinal.reverse(dir), 1);
				end.add(Cardinal.UP, 2);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				start = new Coord(end);
				start.add(dir, 1);
				start.add(Cardinal.reverse(orth), 1);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				cursor.add(Cardinal.UP, 2);
				stair.setOrientation(orth, false);
				editor.setBlock(rand, cursor, stair, true, true);
				
				start = new Coord(floor);
				start.add(dir, 4);
				end = new Coord(start);
				end.add(Cardinal.UP, 9);
				end.add(orth, 2);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				
				start = new Coord(floor);
				start.add(dir, 3);
				start.add(orth, 3);
				end = new Coord(start);
				end.add(Cardinal.UP, 9);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				
				start = new Coord(floor);
				start.add(dir, 4);
				end = new Coord(start);
				end.add(dir, 1);
				end.add(Cardinal.UP, 1);
				editor.fillRectSolid(rand, start, end, air, true, true);
				
				cursor = new Coord(floor);
				cursor.add(dir, 3);
				cursor.add(orth, 2);
				cursor.add(Cardinal.UP, 3);
				stair.setOrientation(Cardinal.reverse(orth), true);
				editor.setBlock(rand, cursor, stair, true, true);
				cursor.add(Cardinal.UP, 5);
				stair.setOrientation(Cardinal.reverse(orth), true);
				editor.setBlock(rand, cursor, stair, true, true);
				
				start = new Coord(floor);
				start.add(dir, 4);
				start.add(orth, 3);
				start.add(Cardinal.UP, 4);
				stair.setOrientation(orth, true);
				editor.setBlock(rand, start, stair, true, true);
				
				start.add(Cardinal.UP, 1);
				end = new Coord(start);
				end.add(Cardinal.UP, 4);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				
				start = new Coord(floor);
				start.add(dir, 5);
				start.add(Cardinal.UP, 4);
				stair.setOrientation(dir, true);
				editor.setBlock(rand, start, stair, true, true);
				
				cursor = new Coord(start);
				cursor.add(orth, 1);
				stair.setOrientation(orth, true);
				editor.setBlock(rand, cursor, stair, true, true);
				
				start.add(Cardinal.UP, 3);
				stair.setOrientation(dir, true);
				editor.setBlock(rand, start, stair, true, true);
				
				cursor = new Coord(start);
				cursor.add(orth, 1);
				stair.setOrientation(orth, true);
				editor.setBlock(rand, cursor, stair, true, true);
				
				start.add(Cardinal.UP, 1);
				end = new Coord(start);
				end.add(orth, 1);
				end.add(Cardinal.UP, 1);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				
				cursor = new Coord(end);
				cursor.add(orth, 1);
				cursor.add(Cardinal.DOWN, 1);
				stair.setOrientation(orth, true);
				editor.setBlock(rand, cursor, stair, true, true);
				cursor.add(Cardinal.UP, 1);
				cursor.add(orth, 1);
				editor.setBlock(rand, cursor, stair, true, true);
				
				cursor.add(Cardinal.reverse(orth), 1);
				editor.setBlock(rand, cursor, blocks, true, true);
				cursor.add(Cardinal.UP, 1);
				editor.setBlock(rand, cursor, blocks, true, true);
				cursor.add(orth, 1);
				editor.setBlock(rand, cursor, blocks, true, true);
				cursor.add(Cardinal.UP, 1);
				this.addCrenellation(editor, rand, cursor, blocks);
				
				cursor.add(Cardinal.DOWN, 2);
				cursor.add(Cardinal.reverse(dir), 1);
				cursor.add(orth, 1);
				editor.setBlock(rand, cursor, blocks, true, true);
				cursor.add(Cardinal.DOWN, 1);
				editor.setBlock(rand, cursor, blocks, true, true);
				
				cursor = new Coord(floor);
				cursor.add(dir, 6);
				cursor.add(Cardinal.UP, 9);
				
				stair.setOrientation(dir, true);
				editor.setBlock(rand, cursor, stair, true, true);
				
				cursor.add(orth, 1);
				stair.setOrientation(orth, true);
				editor.setBlock(rand, cursor, stair, true, true);
				
				cursor.add(Cardinal.reverse(orth), 1);
				cursor.add(Cardinal.UP, 1);
				editor.setBlock(rand, cursor, blocks, true, true);
				cursor.add(orth, 1);
				editor.setBlock(rand, cursor, blocks, true, true);
				cursor.add(Cardinal.UP, 1);
				this.addCrenellation(editor, rand, cursor, blocks);
				
				cursor = new Coord(floor);
				cursor.add(dir, 4);
				cursor.add(Cardinal.UP, 5);
				editor.setBlock(rand, cursor, air, true, true);
				cursor.add(Cardinal.UP, 1);
				editor.setBlock(rand, cursor, air, true, true);
				cursor.add(orth, 2);
				editor.setBlock(rand, cursor, BlockType.get(BlockType.IRON_BAR), true, true);
			}
		}
		
		for(Cardinal dir : Cardinal.directions){
			for (Cardinal orth : Cardinal.getOrthogonal(dir)){
				start = new Coord(x, ground, z);
				start.add(dir, 4);
				end = new Coord(x, 60, z);
				end.add(dir, 4);
				start.add(Cardinal.reverse(orth), 2);
				end.add(orth, 2);
				
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				start = new Coord(x, ground, z);
				start.add(dir, 3);
				start.add(orth, 3);
				end = new Coord(x, 60, z);
				end.add(dir, 3);
				end.add(orth, 3);
				editor.fillRectSolid(rand, start, end, blocks, true, true);
				
			}
		}
		
		for(int i = main; i >= y; --i){
			editor.spiralStairStep(rand, new Coord(x, i, z), stair, theme.getPrimaryPillar());
		}
	}
	
	
	private void addCrenellation(WorldEditor editor, Random rand, Coord cursor, IBlockFactory blocks){
		
		editor.setBlock(rand, cursor, blocks, true, true);
		
		if(editor.isAirBlock(cursor)) return;

		cursor.add(Cardinal.UP, 1);
		Torch.generate(editor, Torch.WOODEN, Cardinal.UP, cursor);
	}
}
