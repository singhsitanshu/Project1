import mayflower.*;
/**
 * Write a description of class Animation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animation
{
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    
    public Animation(int framerate, String[] fileNames) {
        frames = new MayflowerImage[fileNames.length];
        for(int i = 0; i < fileNames.length; i++ ) {
            frames[i] = new MayflowerImage(fileNames[i]);
        }
        this.framerate = framerate;
        currentFrame = 0;
    }
    
    public int getFrameRate() {
        return framerate;
    }
    
    public MayflowerImage getNextFrame() {
        currentFrame %= frames.length;
        int cur = currentFrame;
        currentFrame++;
        
        return frames[cur];
    }
    
    public void scale(int w, int h) {
        for(int i = 0; i < frames.length; i++) {
            frames[i].scale(w, h);
        }
    }
    
    public void setTransparency(int percent) {
        for(int i = 0; i < frames.length; i++) {
            frames[i].setTransparency(percent);
        }
    }
    
    public void mirrorHorizontally() {
        for(int i = 0; i < frames.length; i++) {
            frames[i].mirrorHorizontally();
        }
    }
    
    public void setBounds(int x, int y, int w, int h) {
        for(int i  = 0; i < frames.length; i++) {
            frames[i].crop(x, y, w, h);
        }
    }
}
