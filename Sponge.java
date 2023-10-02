import mayflower.*;

public class Sponge extends Actor
{
    public void act() {
    }
    
    public void clean() {
        DMGWater dWater = (DMGWater) getOneIntersectingObject(DMGWater.class);
        Water water = (Water) getOneIntersectingObject(Water.class);
        World w = getWorld();
        
        if(isTouching(DMGWater.class)) {
            w.removeObject(dWater);
        }
        if(isTouching(Water.class)) {
            w.removeObject(water);
        }
        
        w.removeObject(this);
    }
}
