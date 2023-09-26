import mayflower.*;
/**
 * Write a description of class Dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spike extends Actor
{
    public Spike()
    {
        setImage("img/spikes.png");
        scale(128, 128);
    }
    
    public void act()
    {
        if (isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat)a;
            c.decreaseLives(1);
            
            if (c.getLives() < 1)
            {            
                World w = getWorld();
                w.removeObject(c);
            }
        }
    }
}
