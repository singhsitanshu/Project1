import mayflower.*;

public class Boss extends AnimatedActor{
    
    private Animation idle;
    private int lives;
    private Timer invulTimer;
    
    public Boss(){
      
        String[] files = new String[10];
        
        for (int i = 0; i < 10; i++){
            
            files[i] = "img/boss/Idle (" + (i + 1) + ").png";
        }
        
        idle = new Animation(100000000, files);
        idle.scale(300, 261);
        idle.mirrorHorizontally();
        idle.setBounds(84, 15, 162, 240);
        
        setAnimation(idle);
        lives = 10;
    }
    
    public void act(){
     
        super.act();
    }
    
    public void decreaseLives(int amount)
    {
   
         this.lives -= amount;
         updateText();
    
    }
    
    public int getLives(){
     
        return lives;
    }
    
    private void updateText()
    {
        World w = getWorld();
        
        w.removeText(600, 30);
        w.showText("Boss Lives: " + lives, 600, 30, Color.BLACK);
    }
}
