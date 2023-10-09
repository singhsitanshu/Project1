import mayflower.*;


public class Level1 extends World {
    
    //instance variables 
    private Cat cat;
    private Dog dog;
    private Barrier barrier;
    private String[][] tiles;
    private Ninja blevins;
    private int shift;
    
    public Level1() 
    {
        //set background
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(false);
        
        //2D array to represent world
        tiles = new String[99][99];
        
        //spawn cat
        cat = new Cat(3);
        addObject(cat, 100, 100);
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        
        //spawn barrier to clean as world moves
        barrier = new Barrier();
        addObject(barrier, 0, 300);
        
        buildWorld();
    }
    
    public void act()
    {
       //randomly generating numbers for projectile spawning
       int randNum = (int)(Math.random() * 7) + 1;
       //random number to determine whether to spawn a coin or not
       int chance = (int)(Math.random() * 300);
       
       if (chance < 1)
       {
           //use random number to place coin
           Coin coin = new Coin();
           addObject(coin, (randNum * 100) + 50, 0);
           
           //spawn 2 hazardous projectiles for every positive one
           HollowPurple hollow1 = new HollowPurple();
           HollowPurple hollow2 = new HollowPurple();
           
           addObject(hollow1, (randNum * 100) - 150, 0);
           addObject(hollow2, (randNum * 100) - 300, 0);
        }

        if(cat.getScore() >= 3)
        {
            //if cat has won then move to next world
            Mayflower.setWorld(new Level2());
            // LevelTwo() is a class that extends World()
        }
    }
    
    private void buildTemplate(int shift)
    {
        Spike spike = new Spike();
        addObject(spike, 600 + shift, 600 - 256);
        
        Spike spike2 = new Spike();
        addObject(spike2, 700 + shift, 600 - 256);
        
        Spike spike3 = new Spike();
        addObject(spike3, 742+ shift, 600 - 256);
        
        MoveBlock block = new MoveBlock();
        addObject(block, 500+ shift, 600-256);
        
        MoveBlock block2 = new MoveBlock();
        addObject(block2, 600+ shift, 600-384);
        
        MoveBlock block3 = new MoveBlock();
        addObject(block3, 1200+ shift, 600-256);
        
        MoveBlock block4 = new MoveBlock();
        addObject(block4, 1300+ shift, 600-256);
        
        MoveBlock block5 = new MoveBlock();
        addObject(block5, 1400+ shift, 600-256);
        
        MoveBlock block6 = new MoveBlock();
        addObject(block6, 1500+ shift, 600-256);
        
        MoveBlock block7 = new MoveBlock();
        addObject(block7, 1600+ shift, 600-256);
        
        MoveBlock block8 = new MoveBlock();
        addObject(block8, 1700+ shift, 600-256);
        
        MoveBlock block9 = new MoveBlock();
        addObject(block9, 1800+ shift, 600-384);
        
        Ladder ladder = new Ladder();
        addObject(ladder, 428+ shift, 600 - 256);
        
        Ladder ladder2 = new Ladder();
        addObject(ladder2, 528+ shift, 600-384);
        
        Ladder ladder3 = new Ladder();
        addObject(ladder3, 1128+ shift, 600 - 256);
        
        Ladder ladder4 = new Ladder();
        addObject(ladder4, 1728+ shift, 600-384);
    }
    
    public void buildWorld()
    {   
        for (shift = 0; shift < 8001; shift += 2000)
        { buildTemplate(shift);}
        //populate 2d array
        for (int x = 0; x < tiles.length; x++)
        {
            for (int y = 0; y < tiles[x].length; y++)
            {
                tiles[x][y] = "";
            }
        }
        
        //randomly add bushes
        for (int i = 0; i < tiles.length; i++)
        {
            int x = (int)(Math.random() * 100);
            if (x < 15)
            {
                addObject(new Bush(), (i * 100) + 300, 405);
            }
        }
        
        //set ground in 2d array
        for (int i = 0; i < tiles[5].length; i++)
        {
            tiles[5][i] = "ground";
        }
        
        //set ground in world using array
        for (int r = 0; r < tiles.length; r++)
        {
            for (int c = 0; c < tiles[r].length; c++)
            {
                if (tiles[r][c].equals("ground"))
                {
                    MoveBlock ground = new MoveBlock();
                    addObject(ground, c * 128, 600 - 128);
                }
            }
        }
    }
    
    
    
}
