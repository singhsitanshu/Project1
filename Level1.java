import mayflower.*;


public class Level1 extends World {

    private Cat cat;
    private Dog dog;
    private String[][] tiles;
    private Ninja blevins;
    
    public Level1() 
    {
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        
        tiles = new String[10][10];
        
        cat = new Cat();
        addObject(cat, 400, 100);
        
        /*dog = new Dog();
        addObject(dog, 400, 400);
        
        blevins = new Ninja();
        addObject(blevins, 300, 200);*/
        
        buildWorld();
    }
    
    public void act()
    {
    }
    
    public void buildWorld()
    {   
        addObject(new Block(), 500, 600-256);
        addObject(new Ladder(), 400, 600 - 256);
        
        for (int x = 0; x < tiles.length; x++)
        {
            for (int y = 0; y < tiles[x].length; y++)
            {
                tiles[x][y] = "";
            }
        }
        
        for (int i = 0; i < tiles.length; i++)
        {
            int x = (int)(Math.random() * 100);
            if (x < 15)
            {
                addObject(new Bush(), i * 100, 405);
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