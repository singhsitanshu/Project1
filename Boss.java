import mayflower.*;

public class Boss extends AnimatedActor{
    
    private Animation idle;
    private Animation attack;
    
    public Boss(){
      
        String[] files = new String[10];
        
        for (int i = 0; i < 10; i++){
            
            files[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        
        idle = new Animation(100000000, files);
        idle.scale(300, 261);
        idle.mirrorHorizontally();
        idle.setBounds(84, 15, 162, 240);
        
        setAnimation(idle);
    }
    
    public void act(){
     
        super.act();
    }
}
