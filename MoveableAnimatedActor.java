import mayflower.*;
public class MoveableAnimatedActor extends AnimatedActor
{
    private Animation idle;
    private Animation idleLeft;
    private Animation walkRight;
    private Animation walkLeft;
    private Animation fall;
    private Animation fallLeft;
    private String currentAction;
    private String direction;
    
    public MoveableAnimatedActor() {
        direction = "right";
    }
    
    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }
    
    public void setIdleAnimation(Animation ani) {
        idle = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani) {
        idleLeft = ani;
    }
    
    public void setWalkRightAnimation(Animation ani) {
        walkRight = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani) {
        walkLeft = ani;
    }
    
    public void setFallAnimation(Animation ani) {
        fall = ani;
    }
    
    public void setFallLeftAnimation(Animation ani) {
        fallLeft = ani;
    }
    
    public void act() {
        super.act();
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        String newAction = null;
        
        if(currentAction == null) {
            newAction = "idle";
        }
        
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x < 800 - w) {
            setLocation(x + 1, y);
            if(isBlocked()) {
                setLocation(x, y);
            }
            newAction = "walkRight";
            direction = "right";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            setLocation(x - 1, y);
            if(isBlocked()) {
                setLocation(x, y);
            }
            newAction = "walkLeft";
            direction = "left";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0) {
            setLocation(x, y - 1);
            if(isBlocked()) {
                setLocation(x, y);
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < 600 - h) {
            setLocation(x, y + 1);
            if(isBlocked()) {
                setLocation(x, y);
            }
        } else {
            newAction = "idle";
            if(direction != null && direction.equals("left")) {
                newAction = "idleLeft";
            }
        }
        
        if(isFalling()) {
            newAction = "fall";
            if(direction != null && direction.equals("left")) {
                newAction = "fallLeft";
            }
        }
        
        
        if(newAction != null && !newAction.equals(currentAction)) {
            if(newAction.equals("idle")) {
                setAnimation(idle);
            } else if(newAction.equals("idleLeft")) {
                setAnimation(idleLeft);
            } else if(newAction.equals("fall")) {
                setAnimation(fall);
            } else if(newAction.equals("fallLeft")) {
                setAnimation(fallLeft);
            } else if(newAction.equals("walkRight")) {
                setAnimation(walkRight);
            } else if(newAction.equals("walkLeft")) {
                setAnimation(walkLeft);
            }
            currentAction = newAction;
        }
    }
    
}
