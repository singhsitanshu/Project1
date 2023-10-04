import mayflower.*;

public class Fireball extends Actor{
    
    private MayflowerImage fireball;
    
    public Fireball(){

        fireball = new MayflowerImage("img/Object/Fireball.png");
        
        setImage(fireball);

        fireball.scale(40, 70);
        fireball.crop(5, 5, 35, 65);
    }

    public void act(){

        double x = getX();
        double y = getY();

        setLocation(x, y + 1);
        if(isTouching(Cat.class)) {
            
            Cat c = (Cat) getOneIntersectingObject(Cat.class);
            c.decreaseLives(1);
        } 
    }
}
