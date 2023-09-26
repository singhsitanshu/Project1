import mayflower.*;

public class Cat extends MoveableAnimatedActor
{
    private Animation idle;
    private Animation idleLeft;
    private Animation walkRight;
    private Animation walkLeft;
    private Animation fall;
    private Animation fallLeft;
    private World currentLevel;
    private boolean hasCompletedLevel1;
    private boolean hasCompletedLevel2;
    private boolean hasWon;
    private boolean hasLost;
    private boolean hasShield;
    private int lives;
    private Timer invulTimer;
    
    public Cat(int lives) 
    {
        String[] files = new String[10];
        for(int i = 0; i < 10; i++) {
            files[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        
        walkRight = new Animation(100000000, files);
        walkRight.scale(100, 87);
        walkRight.setBounds(18, 5, 54, 80);
        
        walkLeft = new Animation(100000000, files);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        
        for(int i = 0; i < 10; i++) {
            files[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        
        idle = new Animation(100000000, files);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        idleLeft = new Animation(100000000, files);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28, 5, 54, 80);
        
        files = new String[8];
        
        for(int i = 0; i < 8; i++) {
            files[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        
        fall = new Animation(100000000, files);
        fall.scale(100, 87);
        fall.setBounds(11, 5, 56, 80);
        
        fallLeft = new Animation(100000000, files);
        fallLeft.scale(100,87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(31, 5, 56, 80);
        
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleAnimation(idle);
        setIdleLeftAnimation(idleLeft);
        setFallAnimation(fall);
        setFallLeftAnimation(fallLeft);
        
        hasShield = false;
        hasCompletedLevel1 = false;
        hasCompletedLevel2 = false;
        hasWon = false;
        hasLost = false;
        this.lives = lives;
        invulTimer = new Timer(2000000000);
    }
    
    public void act()
    {
        super.act();

        if (hasWon)
            Mayflower.setWorld(new GameWinScreen());
        else if (hasLost)
            Mayflower.setWorld(new GameLostScreen());
        else if (hasCompletedLevel2)
            Mayflower.setWorld(new LevelBoss());
        else if (hasCompletedLevel1)
            Mayflower.setWorld(new Level2());
 
    }
    
    public void setHasShield(boolean bool){
     
        hasShield = bool;
    }

    public void decreaseLives(int amount)
    {
        if(invulTimer.isDone()) {
            invulTimer.reset();
            
            this.lives -= amount;
            updateText();
        }
    }
    
    public int getLives()
    {
        return this.lives;
    }

    public int getX() {
        return super.getX();
    }
    
    public int getY() {
        return super.getY();
    }
    
    private void updateText()
    {
        World w = getWorld();
        
        w.removeText(10, 30);
        w.showText("Lives: " + lives, 10, 30, Color.BLACK);
    }
}
