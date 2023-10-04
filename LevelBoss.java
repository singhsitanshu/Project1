import mayflower.*;


public class LevelBoss extends World {

    private Cat cat;
    private String[][] tiles;
    private int missileCoolDownTimer;
    final private int MISSILE_COOL_DOWN = 400;
    private Barrier barrier;
    private int fireballCoolDownTimer;
    final private int FIREBALL_COOL_DOWN = 300;
    private Boss boss;
    
    public LevelBoss() 
    {
        setBackground("img/BG/BGBoss.png");
        Mayflower.showBounds(true);
        
        tiles = new String[6][8];
        
        cat = new Cat(3);
        addObject(cat, 50, 370);
        
        boss = new Boss();
        
        barrier = new Barrier();
        addObject(barrier, 0, 300);
        
        buildWorld();

        missileCoolDownTimer = 0;
    }
    
    public void act()
    {
        
        if (missileCoolDownTimer == MISSILE_COOL_DOWN){

            int randomNum = (int)(Math.random() * 5);
            addObject(new Missile(), 500, randomNum * 100);
            missileCoolDownTimer = 1;
        } else{

            missileCoolDownTimer++;
        }
        
        if (fireballCoolDownTimer == FIREBALL_COOL_DOWN){

            int randomNum = (int)(Math.random() * 6);
            addObject(new Fireball(), randomNum * 100, 0);
            fireballCoolDownTimer = 1;
        } else{

            fireballCoolDownTimer++;
        }
        
        if (boss.getLives() == 0)
            cat.setHasLost(true);
    }
    
    public void buildWorld()
    {   
       
        addObject(boss, 600, 200);
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
