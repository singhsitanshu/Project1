import mayflower.*;


public class Shield extends Actor
{
    public Shield()
    {
        setImage("img/Object/shield.png");
    }
    
    public void act(){
        
        if (isTouching(Cat.class)){
        
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            
            World w = getWorld();
            w.removeObject(this);
            
            c.setHasShield(true);
        }
    }
}
