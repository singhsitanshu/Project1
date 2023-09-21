import mayflower.*;


public class LevelBoss extends World {

    private Cat cat;
    private String[][] tiles;
    
    public LevelBoss() 
    {
        setBackground("img/BG/BGBoss.png");
        Mayflower.showBounds(true);
        
        tiles = new String[10][10];
        
        cat = new Cat();
        addObject(cat, 50, 370);
        
        buildWorld();
    }
    
    public void act()
    {
        
    }
    
    public void buildWorld()
    {   
        addObject(new Block(), 500, 600-256);
        addObject(new Ladder(), 400, 600 - 256);
        
        addObject(new Shield(), 400, 300);
        tiles[2][5] = "Shield";
        
        for (int x = 0; x < tiles.length; x++)
        {
            for (int y = 0; y < tiles[x].length; y++)
            {
                tiles[x][y] = "";
            }
        }
        
        for (int i = 0; i < tiles[5].length; i++)
        {
            tiles[5][i] = "ground";
        }
        
        for (int r = 0; r < tiles.length; r++)
        {
            for (int c = 0; c < tiles[r].length; c++)
            {
                if (tiles[r][c].equals("ground"))
                {   
                    addObject(new Block(), c * 100, 600 - 128);
                }
            }
        }


    }
}    
