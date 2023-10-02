import mayflower.*;
import mayflower.*;

public class FloorWater extends Actor
{
    public FloorWater() {
        MayflowerImage img = new MayflowerImage("img/Tiles/FloorWater.png");
        img.scale(100, 100);
        setImage(img);
    }
    
    public void act() {
        if(isTouching(Cat.class)) {
            Cat c = (Cat) getOneIntersectingObject(Cat.class);
            c.setHasCompletedLevel2(true);
        }
    }
}
