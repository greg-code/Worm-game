
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.game.WormGame;


public class DrawingBoard extends JPanel implements Updatable {
    private WormGame wormgame;
    private int pieceLength;

    public DrawingBoard(WormGame wormgame, int pieceLength) {
        this.wormgame = wormgame;
        this.pieceLength = pieceLength;
         super.setBackground(Color.GRAY);
    }
    
      @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        graphics.setColor(Color.RED);
            graphics.fillOval(wormgame.getApple().getX()*pieceLength, wormgame.getApple().getY()*pieceLength, pieceLength, pieceLength);
            
            for (int i=0;i<wormgame.getWorm().getLength();i++){
             graphics.setColor(Color.BLACK);
             int x =wormgame.getWorm().getPieces().get(i).getX();
             int y=wormgame.getWorm().getPieces().get(i).getY();
                graphics.fill3DRect(x*pieceLength, y*pieceLength, pieceLength, pieceLength,true);
            }
            
    }

    @Override
    public void update() {
    repaint();
    }
    
}
