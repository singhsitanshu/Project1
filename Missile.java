import mayflower.*;

public class Missile extends Actor{
    
    private boolean isDeflected;
    private MayflowerImage leftMissile;
    private MayflowerImage rightMissile;

    public Missile(){

        leftMissile = new MayflowerImage("img/Object/MissileLeft.png");
        rightMissile = new MayflowerImage("img/Object/MissileRight.png");
        isDeflected = false;

        setImage(leftMissile);

        leftMissile.scale(70, 40);
        leftMissile.crop(5, 5 , 65, 35);
    }

    public void act(){

        double x = getX();
        double y = getY();

        if (!isDeflected)
            setLocation(x - 1, y);
        else 
            setLocation(x + 1, y);
            
        if(isTouching(Cat.class)) {
            
            Cat c = (Cat) getOneIntersectingObject(Cat.class);
            
            if (c.getIsDeflecting())
                isDeflected = true;
            else
                c.decreaseLives(1);
        } 
        
        if(isTouching(Boss.class)) {
            
            Boss c = (Boss) getOneIntersectingObject(Boss.class);
            c.decreaseLives(1);
            World w = getWorld();
            w.removeObject(this);
        } 
        
        if (isDeflected)
            setImage(rightMissile);
    }

    public void setIsDeflected(boolean bool){

        isDeflected = bool;
    }
}
