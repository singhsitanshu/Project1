import mayflower.*;

public class Water extends Actor
{
    public Water(waterType type) {
        MayflowerImage img = null;
        
        if(type == waterType.SURFACE) {
            img = new MayflowerImage("img/Tiles/17.png");
        } else if(type == waterType.DEPTHS) {
            img = new MayflowerImage("img/Tiles/18.png");
        }
        
        img.scale(100, 100);
        setImage(img);
    }
    
    public void act() {
    }
}
