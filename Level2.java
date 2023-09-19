import mayflower.*;

public class Level2 extends World
{
    
    private String[][] tiles;
    
    public Level2() {
        setBackground("img/BG/BGWater.png");
        
        tiles = new String[6][8];
        
        buildWorld();
    }
    
    public void buildWorld() {
        for(int i = 0; i < tiles[0].length; i++) {
            tiles[0][i] = "surface";
            addObject(new Water(waterType.SURFACE), i * 100, 0);
        }
        for(int i = 1; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = "depths";
                addObject(new Water(waterType.DEPTHS), j * 100, i * 100);
            }
        }
    }
    
    public void act() {
    }
    
}
