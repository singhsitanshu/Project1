import mayflower.*;
/**
 * Write a description of class Coin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coin extends AnimatedActor
{
    private Animation spin;
    private Timer timer;
    
    public Coin()
    {
        String[] files = new String[6];
        timer = new Timer(999999);
        
        //Coin1.png
        for(int i = 0; i < 6; i++)
        {
            files[i] = "img/GoldCoinSprite/Coin" + (i + 1) + ".png";
        }
        
        spin = new Animation(99999999, files);
        setAnimation(spin);
    }
    
    public void act()
    {
        if (isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat)a;
            
            World w = getWorld();
            w.removeObject(this);
            
            c.increaseScore(1);
        }
        
        setLocation(getX() - 0.1, getY());
        
        super.act();
    }
    
    public void remove()
    {
        World w = getWorld();
        w.removeObject(this);
    }
}
