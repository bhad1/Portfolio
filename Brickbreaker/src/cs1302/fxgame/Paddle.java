package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import com.michaelcotterell.game.Updateable;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

       /**
 *the paddle in the class
 */
       public class Paddle extends Rectangle implements Updateable {
              
              private final double dx=7;
              private final KeyCode left;
              private final KeyCode right;
              
              public Paddle(KeyCode left, KeyCode right) {
                 
                 super(100,10);
                 setFill(Color.RED);
                 this.left=left;
                 this.right=right;
               } // Paddle
               
               
               public void update(Game game, GameTime gt) {
                      
                      // handling paddle movement
                      if(game.getKeyManager().isKeyPressed(left)){
                             double nx = getTranslateX() - dx;
                             if(nx < 0) nx=0;
                             setTranslateX(nx);
                         } // if
                      
                      if(game.getKeyManager().isKeyPressed(right)){
                             double nx = getTranslateX() + dx;
                             if(nx > 700 - getWidth()) nx=700 - getWidth();
                             setTranslateX(nx);
                         } // if
               } // update
               
       } // Paddle 