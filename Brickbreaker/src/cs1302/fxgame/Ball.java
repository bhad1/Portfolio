package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import com.michaelcotterell.game.Updateable;
import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import javafx.scene.input.KeyCode;

/**
 *
 * @author douglashadaway
 */

/**
 *the ball that is used in the game.
 */
public class Ball extends Circle implements Updateable {
       
       public int dx=0;
       public int dy=0;
       private final Paddle paddle;
       public IntegerProperty p;
       public int lives=3;
       public int resetCounter=0;
       public int ballSpeed=3;
       
       public Ball(Paddle paddle){
              super(6);
              setFill(Color.GREEN);
              this.paddle=paddle;
           } // Ball
       /**
 *sets the speed of the ball
 */
       public void setDx(int dx){
       this.dx=dx;
       }
       public void setDy(int dy){
       this.dy=dy;
       } // end of speed setter methods
       
       /**
 * Sets the ball into the center of the scene
 */
       public void setCenter(){
              setCenterX(640/2);
              setCenterY(280);
       } // setCenter
       
       @Override
       public void update(Game game, GameTime gt) {
       
              //handle ball hitting ceiling
              if(getCenterY()+dy < 0){
                 dy=-dy;
                 setCenterY(getCenterY()+dy);
               } // if
               
               //handle ball hitting left and right wall
              if(getCenterX()+dx > 700||getCenterX()+dx < 0){
                  dx=-dx;
                  setCenterX(getCenterX()+dx);
               } // if
               
                 // handle ball missing paddle
                 if (getCenterY() > 480) {
                    setCenter();
                    lives--;
                 } // if
               
               // handle ball hitting paddle
               if(this.intersects(paddle.getBoundsInParent())){dy=-dy;}
               
               // update position
               setCenterX(getCenterX() + dx);
               setCenterY(getCenterY() + dy);
               
       } // update
       
} // Ball