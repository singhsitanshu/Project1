import mayflower.*;
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoveBlock extends Actor
{
    
    public MoveBlock() {
        setImage("img/Tiles/2.png"); 
    }
    
    public void act(){
        setLocation(getX() - 0.25, getY());
    }
    
}
