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
    
    public Coin()
    {
        String[] files = new String[6];
        
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
        
        setLocation(getX() - 0.25, getY());
        if (getY() > 600)
        {
            World w = getWorld();
            w.removeObject(this);
        }
        super.act();
    }
}
