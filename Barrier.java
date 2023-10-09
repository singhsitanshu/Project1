import mayflower.*;
/**
 * Write a description of class Dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Barrier extends Actor
{
    public Barrier()
    {
        setImage("img/barrier.png");
    }
    
    public void act()
    {
        if (isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat)a;     
            World w = getWorld();
            w.removeObject(c);
        }
        
        if (isTouching(Block.class))
        {
            Object a = getOneIntersectingObject(Block.class);
            Block c = (Block)a;     
            World w = getWorld();
            w.removeObject(c);
        }
        
        if (isTouching(Ladder.class))
        {
            Object a = getOneIntersectingObject(Ladder.class);
            Ladder c = (Ladder)a;     
            World w = getWorld();
            w.removeObject(c);
        }
        
        if (isTouching(Spike.class))
        {
            Object a = getOneIntersectingObject(Spike.class);
            Spike c = (Spike)a;     
            World w = getWorld();
            w.removeObject(c);
        }
        
        if (isTouching(MoveBlock.class))
        {
            Object a = getOneIntersectingObject(MoveBlock.class);
            MoveBlock c = (MoveBlock)a;     
            World w = getWorld();
            w.removeObject(c);
        }
    }
}
