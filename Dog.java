import mayflower.*;
/**
 * Write a description of class Jack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dog extends AnimatedActor
{
    private Animation fall;
    
    public Dog() {
        String[] files = new String[8];
        for(int i = 0; i < 8; i++) {
            files[i] = "img/dog/Fall (" + (i + 1) + ").png";
        }
        
        fall = new Animation(100000000, files);
        fall.scale(200, 150);
        fall.setTransparency(90);
        setAnimation(fall);
    }
    
    public void act() {
        super.act();
    }
    
}
