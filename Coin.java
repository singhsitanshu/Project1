import mayflower.*;
/**
 * Write a description of class Coin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coin extends MoveableAnimatedActor
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
        
        spin = new Animation(100000000, files);
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
        
        super.act();
    }
}
