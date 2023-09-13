import mayflower.*;
/**
 * Write a description of class AnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor() {
        animationTimer = new Timer(1000);
    }
    
    public void setAnimation(Animation a) {
        animation = a;
        //animationTimer = new Timer(a.getFrameRate());
    }
    
    public void act() {
        super.act();
        
        if(animationTimer.isDone() && animation != null) {
            animationTimer.reset();
            setImage(animation.getNextFrame());
        }
    }
}
