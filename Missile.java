import mayflower.*;

public class Missile extends Actor{
    
    private boolean isDeflected;
    private MayflowerImage leftMissile;
    private MayflowerImage rightMissile;
    private int missileSpeed;
    private Boss boss;
    private Cat c;
    private double slope;
    private double deltaY;
    private double deltaX;

    public Missile(Boss boss){

        leftMissile = new MayflowerImage("img/Object/MissileLeft.png");
        rightMissile = new MayflowerImage("img/Object/MissileRight.png");
        isDeflected = false;

        setImage(leftMissile);

        leftMissile.scale(70, 40);
        leftMissile.crop(5, 5 , 65, 35);

        missileSpeed = 3;
        this.boss = boss;
    }

    public void act(){

        double x = getX();
        double y = getY();

        if(isTouching(Cat.class)) {
            
            c = (Cat) getOneIntersectingObject(Cat.class);
            
            if (c.getIsDeflecting()){

                isDeflected = true;

                int catX = c.getX();
                int catY = c.getY();

                int bossX = boss.getX();
                int bossY = boss.getY();

                deltaY = bossY - catY;
                deltaX = bossX - catX;

                double degree = (deltaY > 0) ? Math.atan((deltaY)/(deltaX)) : Math.atan((deltaY * -1)/(deltaX));
                rightMissile.rotate(degree);
                slope = ((deltaY/deltaX) * 15.0);
            }
            else
                c.decreaseLives(1);
        } 

        if (!isDeflected)

            setLocation(x - missileSpeed, y);
        else {
                
            setImage(rightMissile);
            setLocation(x + missileSpeed * 5, y + slope);
        }    

        if(isTouching(Boss.class)) {
            
            Boss c = (Boss) getOneIntersectingObject(Boss.class);
            c.decreaseLives(1);
            World w = getWorld();
            w.removeObject(this);
        } 
    }

    public void setIsDeflected(boolean bool){

        isDeflected = bool;
    }
}
