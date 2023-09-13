import mayflower.*;
/**
 * Write a description of class Jack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ninja extends AnimatedActor
{
    private Animation attack;
    
    public Ninja() {
        String[] files = new String[10];
        for(int i = 0; i <10; i++) {
            files[i] = "img/ninjagirl/Attack__00" + i + ".png";
        }
        
        attack = new Animation(100000000, files);
        attack.scale(300,75);
        attack.setTransparency(10);
        setAnimation(attack);
    }
    
    public void act() {
        super.act();
    }
    
}
