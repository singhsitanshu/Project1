import mayflower.*;
import mayflower.*;

public class FloorWater extends Actor
{
    public FloorWater() {
        MayflowerImage img = new MayflowerImage("img/Tiles/FloorWater2.png");
        img.scale(100, 100);
        setImage(img);
    }
    
    public void act() {
        // if the Cat comes into contact with the bottom of Level2, send it to the Boss Level
        if(isTouching(Cat.class)) {
            Mayflower.setWorld(new LevelBoss());
        }
    }
}
