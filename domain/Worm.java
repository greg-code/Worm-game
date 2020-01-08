
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

public class Worm {
    private int originalX;
    private int originalY;
    private Direction originalDirection;        
private List<Piece> list;
private int max;
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.list=new ArrayList<Piece>();
        Piece piece = new Piece(originalX,originalY);
        this.list.add(piece);
        this.max=3;
    }
    
   public Direction getDirection() {
   
   return this.originalDirection;
   }
   
   public void setDirection(Direction dir){
   
   this.originalDirection=dir;
   }
   
   public int getLength(){
   return getPieces().size();
   }
   
   public List<Piece> getPieces(){
   return this.list;
   }
   
   public void move() {
   
 if(list.size()<max){
 movit();

 }
 else {
 movit();
 list.remove(0);
 
 }
 
   
   }
   
   public void grow(){
  if (list.size()>=3){
       max++;}
   
   }
   public void movit(){
              if(originalDirection==Direction.UP){
              this.originalY--;
           Piece piece = new Piece(originalX,originalY);
           list.add(piece);
       }
              
         if(originalDirection==Direction.DOWN){
              this.originalY++;
           Piece piece = new Piece(originalX,originalY);
           list.add(piece);
       }   if(originalDirection==Direction.RIGHT){
       this.originalX++;
           Piece piece = new Piece(originalX,originalY);
           list.add(piece);
          
       
           
       }   if(originalDirection==Direction.LEFT){
              this.originalX--;
           Piece piece = new Piece(originalX,originalY);
           list.add(piece);
       } 
       
       }



public boolean runsInto(Piece piece){

    for (Piece kus: list){
    if (kus.getX()==piece.getX()&& kus.getY()==piece.getY()){
    return true;
    }
    
    }

return false;
}



public boolean runsIntoItself(){
int i=0;


   for (Piece piece: list){
      
   if (i==list.size()-1){break;}
  i++;
   if (piece.getX()==list.get(list.size()-1).getX() && piece.getY()==list.get(list.size()-1).getY() ){
   return true;
   }
   
   }
    
   
    
    
return false;
}





}
