import mayflower.*;

public class StartScreen extends World{
    private boolean isGameStarted;
    
    public StartScreen(){
        
        setBackground("img/BG/startscreen.png");
        isGameStarted = false;
    }
    
    public void act(){
        
        if (!isGameStarted && Mayflower.isKeyDown(Keyboard.KEY_ENTER)){
            
            isGameStarted = true;
        }
        
        if (isGameStarted)
            Mayflower.setWorld(new Level1());
    }
}
