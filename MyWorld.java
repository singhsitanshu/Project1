import mayflower.*;


public class MyWorld extends World {

	private Cat cat;
	private Dog dog;
	private Ninja blevins;
	
    public MyWorld() 
    {
    	setBackground("img/BG/BG.png");
    	Mayflower.showBounds(true);
    	
    	cat = new Cat();
    	addObject(cat, 400, 100);
    	
    	/*dog = new Dog();
    	addObject(dog, 400, 400);
    	
    	blevins = new Ninja();
    	addObject(blevins, 300, 200);*/
    	
    	addObject(new Block(), 400, 500);
    	addObject(new Block(), 528, 372);
    }
    
    public void act()
    {
    }
    
}