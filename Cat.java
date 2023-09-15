import mayflower.*;

public class Cat extends MoveableAnimatedActor
{
    private Animation idle;
    private Animation idleLeft;
    private Animation walkRight;
    private Animation walkLeft;
    private Animation fall;
    private Animation fallLeft;
    //test
    
    public Cat() 
    {
        String[] files = new String[10];
        for(int i = 0; i < 10; i++) {
            files[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        
        walkRight = new Animation(100000000, files);
        walkRight.scale(100, 87);
        walkRight.setBounds(18, 5, 54, 80);
        
        walkLeft = new Animation(100000000, files);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        
        for(int i = 0; i < 10; i++) {
            files[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        
        idle = new Animation(100000000, files);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        idleLeft = new Animation(100000000, files);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28, 5, 54, 80);
        
        files = new String[8];
        
        for(int i = 0; i < 8; i++) {
            files[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        
        fall = new Animation(100000000, files);
        fall.scale(100, 87);
        fall.setBounds(11, 5, 56, 80);
        
        fallLeft = new Animation(100000000, files);
        fallLeft.scale(100,87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(31, 5, 56, 80);
        
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleAnimation(idle);
        setIdleLeftAnimation(idleLeft);
        setFallAnimation(fall);
        setFallLeftAnimation(fallLeft);
    }
    
    public void act()
    {
        super.act();
    }
}
