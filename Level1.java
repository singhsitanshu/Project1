import mayflower.*;


public class Level1 extends World {
    
    //instance variables 
    private Cat cat;
    private Dog dog;
    private Barrier barrier;
    private String[][] tiles;
    private Ninja blevins;
    private Block[] blocks;
    private Ladder[] ladders;
    private Spike[] spikes;
    
    public Level1() 
    {
        //set background
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(false);
        
        //2D array to represent world
        tiles = new String[99][99];
        
        //arrays store references to all objects in world in order to move them
        blocks = new Block[108];
        
        ladders = new Ladder[4];
        
        spikes = new Spike[3];
        
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
        //all objects move in order to move world
        for (int i = 0; i < blocks.length; i++)
        {
            blocks[i].setLocation(blocks[i].getX() - 0.25, blocks[i].getY());
        }
        
        for (int i = 0; i < ladders.length; i++)
        {
            ladders[i].setLocation(ladders[i].getX() - 0.25, ladders[i].getY());
        }
        
        for (int i = 0; i < spikes.length; i++)
        {
            spikes[i].setLocation(spikes[i].getX() - 0.25, spikes[i].getY());
        }
        
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
    
    public void buildWorld()
    {
        Spike spike = new Spike();
        spikes[0] = spike;
        addObject(spike, 600, 600 - 256);
        
        Spike spike2 = new Spike();
        spikes[1] = spike2;
        addObject(spike2, 700, 600 - 256);
        
        Spike spike3 = new Spike();
        spikes[2] = spike3;
        addObject(spike3, 742, 600 - 256);
        
        Block block = new Block();
        blocks[blocks.length-1] = block;
        addObject(block, 500, 600-256);
        
        Block block2 = new Block();
        blocks[blocks.length-2] = block2;
        addObject(block2, 600, 600-384);
        
        Block block3 = new Block();
        blocks[blocks.length-3] = block3;
        addObject(block3, 1200, 600-256);
        
        Block block4 = new Block();
        blocks[blocks.length-4] = block4;
        addObject(block4, 1300, 600-256);
        
        Block block5 = new Block();
        blocks[blocks.length-5] = block5;
        addObject(block5, 1400, 600-256);
        
        Block block6 = new Block();
        blocks[blocks.length-6] = block6;
        addObject(block6, 1500, 600-256);
        
        Block block7 = new Block();
        blocks[blocks.length-7] = block7;
        addObject(block7, 1600, 600-256);
        
        Block block8 = new Block();
        blocks[blocks.length-8] = block8;
        addObject(block8, 1700, 600-256);
        
        Block block9 = new Block();
        blocks[blocks.length-9] = block9;
        addObject(block9, 1800, 600-384);
        
        Ladder ladder = new Ladder();
        ladders[0] = ladder;
        addObject(ladder, 428, 600 - 256);
        
        Ladder ladder2 = new Ladder();
        ladders[1] = ladder2;
        addObject(ladder2, 528, 600-384);
        
        Ladder ladder3 = new Ladder();
        ladders[2] = ladder3;
        addObject(ladder3, 1128, 600 - 256);
        
        Ladder ladder4 = new Ladder();
        ladders[3] = ladder4;
        addObject(ladder4, 1728, 600-384);
        
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
                    Block ground = new Block();
                    blocks[c] = ground;
                    addObject(ground, c * 128, 600 - 128);
                }
            }
        }
    }
    
    
    
}
