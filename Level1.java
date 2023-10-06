import mayflower.*;


public class Level1 extends World {

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
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(false);
        
        tiles = new String[99][99];
        
        blocks = new Block[108];
        
        ladders = new Ladder[4];
        
        spikes = new Spike[3];
        
        cat = new Cat(3);
        addObject(cat, 100, 100);
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        
        barrier = new Barrier();
        addObject(barrier, 0, 300);
        
        //addObject(obj, x, y);
        /*dog = new Dog();
        addObject(dog, 400, 400);
        
        blevins = new Ninja();
        addObject(blevins, 300, 200);*/
        
        buildWorld();
    }
    
    public void act()
    {
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
        
       int randNum = (int)(Math.random() * 7) + 1;
       int chance = (int)(Math.random() * 300);
       
       if (chance < 1)
       {
           Coin coin = new Coin();
           addObject(coin, randNum * 100, 0);
           
           HollowPurple hollow1 = new HollowPurple();
           HollowPurple hollow2 = new HollowPurple();
           
           addObject(hollow1, (randNum * 100) - 150, 0);
           addObject(hollow2, (randNum * 100) - 300, 0);
        }

        if(cat.getScore() >= 3)
        {
            cat.setHasCompletedLevel1(true);
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
                    Block ground = new Block();
                    blocks[c] = ground;
                    addObject(ground, c * 128, 600 - 128);
                }
            }
        }
    }
    
    
    
}
