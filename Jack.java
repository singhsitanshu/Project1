import mayflower.*;
/**
 * Write a description of class Jack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jack extends AnimatedActor
{
    private Animation jump;
    
    public Jack() {
        String[] files = new String[10];
        for(int i = 0; i < 10; i++) {
            files[i] = "img/jack/Jump (" + (i + 1) + ").png";
        }
        
        jump = new Animation(100000000, files);
        setAnimation(jump);
    }
    
    public void act() {
        super.act();
    }
    
}
