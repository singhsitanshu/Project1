import mayflower.*;
/**
 * Write a description of class GravityActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GravityActor extends Actor
{
    public boolean isBlocked() {
        return isTouching(Block.class) || isTouching(MoveBlock.class);
    }
    
    public boolean isLadder() {
        return isTouching(Ladder.class);
    }
    
    public boolean isFalling() {
        boolean touch;
        
        touch = true;
        
        if (!isLadder())
        {
            setLocation(getX(), getY() + 1);
            touch = isBlocked();
            setLocation(getX(), getY() - 1);
        }
        
        return !touch;
    }
    
    public void act() {
        setLocation(getX(), getY() + 1);
        if(isBlocked()) {
            setLocation(getX(), getY() - 1);
        }
    }
}
