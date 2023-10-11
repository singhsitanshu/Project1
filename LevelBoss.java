import mayflower.*;


public class LevelBoss extends World {

    private Cat cat;
    private String[][] tiles;
    private int missileCoolDownTimer;
    final private int MISSILE_COOL_DOWN = 90;
    private int fireballCoolDownTimer;
    final private int FIREBALL_COOL_DOWN = 75;
    final private int ENRAGED_COOL_DOWN = 40;
    private Boss boss;
    
    public LevelBoss() 
    {
        setBackground("img/BG/BGBoss.png");
        Mayflower.showBounds(false);
        
        tiles = new String[6][8];
        
        cat = new Cat(3);
        addObject(cat, 50, 370);
        
        boss = new Boss();
        
        //barrier = new Barrier();
        //addObject(barrier, 0, 300);
        
        buildWorld();

        missileCoolDownTimer = 0;
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        showText("Boss Lives: " + boss.getLives(), 600, 30, Color.BLACK);
    }
    
    public void act()
    {
        
        if (missileCoolDownTimer == MISSILE_COOL_DOWN){

            int randomNum = (int)(Math.random() * 5);
            addObject(new Missile(boss), 500, randomNum * 100);
            missileCoolDownTimer = 1;
        } else{

            missileCoolDownTimer++;
        }
        
        if (boss.getLives() > 5){
            
            if (fireballCoolDownTimer == FIREBALL_COOL_DOWN){
    
                int randomNum = (int)(Math.random() * 12);
                addObject(new Fireball(), randomNum * 50, 0);
                fireballCoolDownTimer = 1;
            } else{
    
                fireballCoolDownTimer++;
            }
        } else {
            
            if (fireballCoolDownTimer == ENRAGED_COOL_DOWN){
    
                int randomNum = (int)(Math.random() * 12);
                addObject(new Fireball(), randomNum * 50, 0);
                fireballCoolDownTimer = 1;
            } else{
    
                fireballCoolDownTimer++;
            }
        }
        if (boss.getLives() == 0)
            cat.setHasWon(true);
    }
    
    public void buildWorld()
    {   
       
        addObject(boss, 600, 200);
        addObject(new Shield(), 200, 300);
        
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
