package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
private Worm worm;
private Apple apple;
    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);
worm = new Worm(width/2,height/2,Direction.DOWN);
this.apple = randomApple();
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     
        if (continues==true) {
        
           worm.move();
    
    if(worm.runsInto(apple)){
    worm.grow();
    setApple(randomApple());
    }
         
         if(worm.runsIntoItself()){
         continues=false;
         }
         
           if(hitBorder()){
         continues=false;
         }
         
         
         
         updatable.update();
         setDelay(1000 / worm.getLength());
         
          
        }
        
        
      
    
    

    }
    
    
    public Worm getWorm() {
    
    return this.worm;
    }
    
    public boolean hitBorder(){
    if(worm.getPieces().get(worm.getLength()-1).getX()==width || worm.getPieces().get(worm.getLength()-1).getY()==height ||
          worm.getPieces().get(worm.getLength()-1).getX()==-1  ||worm.getPieces().get(worm.getLength()-1).getY()==-1
            ){
    
    return true;
    }
    return false;
    }
    
    
    
public Apple randomApple(){
Random random = new Random();
Apple jablko;
while (true){
int x = random.nextInt(width-1 + 1 - 0) + 0;

int y = random.nextInt(height-1 + 1 - 0) + 0;
jablko = new Apple(x,y);
if (!worm.runsInto(jablko)){
    return jablko;


}

}


}


public void setWorm(Worm worm){

this.worm=worm;
}


public Apple getApple(){

return this.apple;
}



public void setApple(Apple apple) {

this.apple=apple;
}
}
