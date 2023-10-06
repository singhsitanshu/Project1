import mayflower.*;

public class HollowPurple extends GravityActor
{
    private Animation unreal;
    
    public HollowPurple()
    {
        setImage("img/hollow_purple.png");
    }
    
    public void act()
    {   
        if (isTouching(Block.class))
        {
            World w = getWorld();
            w.removeObject(this);
        }
        
        setLocation(getX(), getY() + 1);
        
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
