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
        Mayflower.showBounds(true);
        
        
        tiles = new String[99][99];
        blocks = new Block[101];
        ladders = new Ladder[2];
        spikes = new Spike[3];
        
        cat = new Cat();
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
        addObject(new Coin(), randNum * 100, 0);
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
        
        Ladder ladder = new Ladder();
        ladders[0] = ladder;
        addObject(ladder, 400, 600 - 256);
        
        Ladder ladder2 = new Ladder();
        ladders[1] = ladder2;
        addObject(ladder2, 500, 600-384);
        
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
