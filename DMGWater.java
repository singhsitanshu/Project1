import mayflower.*;

public class DMGWater extends Actor
{
    
    public DMGWater() {
        MayflowerImage img = new MayflowerImage("img/Tiles/DMGWater.png");
        img.scale(100, 100);
        setImage(img);
    }
    
    public void act() {
        if(isTouching(Cat.class)) {
            Cat c = (Cat) getOneIntersectingObject(Cat.class);
            c.decreaseLives(1);
        }
    }
    
}
