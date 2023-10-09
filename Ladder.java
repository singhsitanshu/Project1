import mayflower.*;
/**
 * Write a description of class Ladder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ladder extends Actor
{
    public Ladder() {
        setImage("img/Object/ladder.png");
        scale(10, 10);
    }
    
    public void act(){
        setLocation(getX() - 0.25, getY());
    }
}
