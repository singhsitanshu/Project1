import mayflower.*;

public class Level2 extends World
{
    
    private String[][] tiles;
    private Timer cycleTimer;
    private int cycleCount;
    
    public Level2() {
        setBackground("img/BG/BGWater.png");
        
        tiles = new String[6][8];
        cycleTimer = new Timer(1000000);
        cycleCount = 0;
        
        buildWorld();
    }
    
    public void buildWorld() {
        for(int i = 0; i < tiles[0].length; i++) {
            tiles[0][i] = "surface";
            addObject(new Water(waterType.SURFACE), i * 100, 0);
        }
        for(int i = 1; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = "depths";
                addObject(new Water(waterType.DEPTHS), j * 100, i * 100);
            }
        }
    }
    
    private void cycleWorld() {
        cycleCount++;
        
        for(int i = 0; i < tiles.length - 1; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = tiles[i + 1][j];
            }
        }
        
        spawnDMGWater();
        rebuildWorld();
    }
    
    private void rebuildWorld() {
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                switch(tiles[i][j]) {
                    case "depths":
                        addObject(new Water(waterType.DEPTHS), j * 100, i * 100);
                        break;
                    case "dmg":
                        addObject(new DMGWater(), j * 100, i * 100);
                        break;
                    case "floor":
                        addObject(new FloorWater(), j * 100, i * 100);
                        break;
                }
            }
        }
    }
    
    private void spawnDMGWater() {
        int spawnCooldown = 0;
        
        for(int i = 0; i < tiles[0].length; i++) {
            int check = (int)(Math.random() * 10) + 1;
            
            if(check <= 2 && spawnCooldown <= 0) {
                tiles[tiles.length - 1][i] = "dmg";
                spawnCooldown = 2;
            } else {
                tiles[tiles.length - 1][i] = "depths";
                spawnCooldown--;
            }
        }
    }
    
    public void checkAndFinishLevel2() {
        if(cycleCount <= 50) {
            return;
        }
        
        for(int i = 0; i < tiles[0].length; i++) {
            tiles[tiles.length - 1][i] = "floor";
        }
        rebuildWorld();
    }
    
    public void act() {
        if(cycleTimer.isDone() && cycleCount <= 50) {
            cycleTimer.reset();
            cycleWorld();
        }
        
        checkAndFinishLevel2();
    }
    
}
