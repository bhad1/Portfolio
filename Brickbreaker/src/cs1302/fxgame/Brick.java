package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.michaelcotterell.game.Updateable;
import javafx.scene.shape.Circle;
import java.awt.Graphics;


/**
 *the brick class that is instantiated 32 times in the TestGame class
 */
public class Brick extends Rectangle implements Updateable {

       public int numHits=0;
       public int x;
       public int y;
       public Ball ball;
       public IntegerProperty score;
       
       public Brick (int x, int y,Ball ball, IntegerProperty score) {
          
          super(60,40);
          setFill(Color.GOLD);
          this.x=x;
          this.y=y;
          this.ball=ball;
          this.score=score;
          
          
       } // Brick
       
       public void update(Game game, GameTime gt) {
       
         //handle resetting game if lives run out
         if(ball.lives==0)
         {
         numHits=0;
         }
         if(numHits<3)
         {

               //handle ball hitting left side of brick
               if(ball.getCenterX()+ball.getRadius() +ball.dx <= this.getTranslateX()+3 && ball.getCenterX() +ball.getRadius()+ball.dx >= this.getTranslateX() && ball.getCenterY() >= getTranslateY() && ball.getCenterY() <= getTranslateY() +this.getHeight())
               {
                  ball.setDx(-ball.dx);
                  numHits++;
               }
               
               //handle ball hitting right side of brick
               if(ball.getCenterX()-ball.getRadius() +ball.dx <= this.getTranslateX() +this.getWidth()+3 && ball.getCenterX() -ball.getRadius()+ball.dx >= this.getTranslateX() +this.getWidth()-5 && ball.getCenterY() >= getTranslateY() && ball.getCenterY() <= getTranslateY() +this.getHeight())
               {
                  ball.setDx(-ball.dx);
                  numHits++;
               }

               //handle ball hitting top of brick
               //must to y+1 cus for an unknown reason
               //it does nothing at all when just y
               if ((ball.getCenterY()+ball.dy<=this.getTranslateY()+20&&ball.getCenterY()+ball.dy>=y+3)&&((ball.getCenterX()+ball.dx<=x+getWidth())&&(ball.getCenterX()+ball.dx>=x)))
               {
                  ball.setDy(-ball.dy);
                  numHits++;
               }
//               //handle ball hitting bottom of brick
               if ((ball.getCenterY()+ball.dy<=this.getTranslateY()+this.getHeight()&&ball.getCenterY()+ball.dy>=this.getTranslateY())&&((ball.getCenterX()+ball.dx<=x+70)&&(ball.getCenterX()+ball.dx>=x)))
               {
                  ball.setDy(-ball.dy);
                  numHits++;
               }
         }//end if for brick physics
         
         //numHits reset to 0 when all lives are lost or when round is over
         if(numHits==0)
         {
             setFill(Color.GOLD);
         }
         //when brick dies
         if(numHits==3)
         {
             setFill(Color.TRANSPARENT);
             score.set(score.get() +1);
             numHits++;
             ball.resetCounter++;
         }
         // just for fixing a bug in which some bricks would not die
         if(numHits>3)
         {
             setFill(Color.TRANSPARENT);
         }
         //switching colors after hits
         if(numHits==1){
            
            setFill(Color.SILVER);
            
         } // if
         
         else if(numHits==2){
         
            setFill(Color.BROWN);
            
         } // if
         
       } // update
} // Brick