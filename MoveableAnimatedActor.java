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
    protected boolean hasShield;
    private Animation deflect;
    private boolean isDeflecting;
    private Timer parryTimer;

    public MoveableAnimatedActor() {

        direction = "right";
        hasShield = false;
        isDeflecting = false;
        parryTimer = new Timer(2000000000);
    }

    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }

    public void setDeflectAnimation(Animation ani){

        deflect = ani;
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
            setLocation(x + 2, y);
            if(isBlocked()) {
                setLocation(x, y);
            }
            newAction = "walkRight";
            direction = "right";
            
            if(isDeflecting){
            
                newAction = "deflect";
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            setLocation(x - 2, y);
            if(isBlocked()) {
                setLocation(x, y);
            }
            newAction = "walkLeft";
            direction = "left";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0) {

            if (isLadder() || hasShield)
            {
                setLocation(x, y - 5);
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < 600 - h) {
            setLocation(x, y + 1);

            if(isBlocked()) {
                setLocation(x, y);
            }
        } 
        else if (Mayflower.isKeyDown(Keyboard.KEY_SPACE) && hasShield){
          
            newAction = "deflect";
            
        }
        else 
        {
            newAction = "idle";
            if(direction != null && direction.equals("left")) 
            {
                newAction = "idleLeft";
            }
        }

        if(isFalling()) {
            newAction = "fall";

            if(direction != null && direction.equals("left")) {
                newAction = "fallLeft";
            }
            
            if(Mayflower.isKeyDown(Keyboard.KEY_SPACE) && hasShield){
                                
                  newAction = "deflect";
                
            }
        }

        if(newAction != null && !newAction.equals(currentAction)) {

            if(newAction.equals("idle")) {

                setAnimation(idle);
                isDeflecting = false;

            } else if(newAction.equals("idleLeft")) {
                
                setAnimation(idleLeft);
                isDeflecting = false;

            } else if(newAction.equals("fall")) {

                setAnimation(fall);
                isDeflecting = false;

            } else if(newAction.equals("fallLeft")) {

                setAnimation(fallLeft);
                isDeflecting = false;

            } else if(newAction.equals("walkRight")) {

                setAnimation(walkRight);
                isDeflecting = false;

            } else if(newAction.equals("walkLeft")) {

                setAnimation(walkLeft);
                isDeflecting = false;

            } else if (newAction.equals("deflect")){

                if (parryTimer.isDone()){
                    
                    parryTimer.reset();
                    setAnimation(deflect);
                    isDeflecting = true;
                }
            }
            
            currentAction = newAction;
        }
    }
    
    public boolean getIsDeflecting(){
    
        return isDeflecting;
    }
    
    public void setHasShield(boolean bool){

        hasShield = true;
    }
}
