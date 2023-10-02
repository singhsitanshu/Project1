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

        leftMissile.scale(100, 85);
        leftMissile.crop(18, 35, 70, 40);
    }

    public void act(){

        double x = getX();
        double y = getY();

        if (!isDeflected)
            setLocation(x - 1, y);
        else 
            setLocation(x + 1, y);
    }

    public void setIsDeflected(boolean bool){

        isDeflected = bool;

        if (bool)
            setImage(rightMissile);
    }
}
