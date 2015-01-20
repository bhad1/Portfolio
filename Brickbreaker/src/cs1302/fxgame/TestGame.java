package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import com.michaelcotterell.game.Updateable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class TestGame extends Game {
       
       private int level=0;
       private final KeyCode space=KeyCode.SPACE;
       private final KeyCode s=KeyCode.S;
       private long lastPressProcessed=0;
       
       //score when bricks die
       private IntegerProperty score = new SimpleIntegerProperty(0);
       
       //getter and setter for score
       public IntegerProperty getScore(){
       return score;
       }
       public void setScore(){
       this.score=score;
       } // end of getter/setter
       
       int x;
       int y;
        
    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 700, 480) {{ 
         setFill(Color.WHITE); 
    }};

    // some text to display the time
    private Text text = new Text() {{
         setTranslateX(10);
         setTranslateY(20);
         setFill(Color.YELLOWGREEN);
    }};
    
    // text when the game starts
    private Text startText=new Text() {{
         setTranslateX(262);
         setTranslateY(300);
         setFill(Color.GREEN);
         
    }};
    
    //text when round ends
    private Text nextLevelText=new Text() {{
         setTranslateX(262);
         setTranslateY(300);
         setFill(Color.TRANSPARENT);
    }};
    
    // text when player dies
    private Text deadText=new Text() {{
         setTranslateX(240);
         setTranslateY(300);
         setFill(Color.TRANSPARENT);
    }};
    
    
    //score of how many bricks dead
    private Text scoreText = new Text() {{
            
            textProperty().bind(score.asString());
            setTranslateX(700-30);
            setTranslateY(480/2);
            setFill(Color.BLUE);
    }}; // score as text
    
    private Paddle paddle = new Paddle(KeyCode.A, KeyCode.D){{
           
           setTranslateX(700/2 -getWidth()/2);
           setTranslateY(460);
           
    }}; // Paddle
    
    private Ball ball = new Ball(paddle){{
            setCenter();
    }};

    private Brick brick = new Brick( x,y,ball,score ){{
           
           x=40;
           y=30; 
           setTranslateX(40);
           setTranslateY(30);
           
    }};
    
    private Brick brick1 = new Brick( x,y,ball,score ){{
           
           x=120;
           y=30; 
           setTranslateX(120);
           setTranslateY(30);
           
    }};
    
    private Brick brick2 = new Brick( x,y,ball,score ){{
           
           x=200;
           y=30; 
           setTranslateX(200);
           setTranslateY(30);
           
    }};
    
    private Brick brick3 = new Brick( x,y,ball,score ){{
           
           x=280;
           y=30; 
           setTranslateX(280);
           setTranslateY(30);
           
    }};
    
    private Brick brick4 = new Brick( x,y,ball,score ){{
           
           x=360;
           y=30; 
           setTranslateX(360);
           setTranslateY(30);
           
    }};
    
    private Brick brick5 = new Brick( x,y,ball,score ){{
           
           x=440;
           y=30; 
           setTranslateX(440);
           setTranslateY(30);
           
    }};
    
    private Brick brick6 = new Brick( x,y,ball,score){{
           
           x=520;
           y=30; 
           setTranslateX(520);
           setTranslateY(30);
           
    }};
    
    private Brick brick7 = new Brick( x,y,ball,score){{
           
           x=600;
           y=30; 
           setTranslateX(600);
           setTranslateY(30);
           
    }};
    
    private Brick brick8 = new Brick( x,y,ball,score ){{
           
           x=40;
           y=90; 
           setTranslateX(40);
           setTranslateY(90);
           
    }};
    
    private Brick brick9 = new Brick( x,y,ball,score ){{
           
           x=120;
           y=90; 
           setTranslateX(120);
           setTranslateY(90);
           
    }};
    
    private Brick brick10 = new Brick( x,y,ball,score ){{
           
           x=200;
           y=90; 
           setTranslateX(200);
           setTranslateY(90);
           
    }};
    
    private Brick brick11 = new Brick( x,y,ball,score ){{
           
           x=280;
           y=90; 
           setTranslateX(280);
           setTranslateY(90);
           
    }};
    
    private Brick brick12 = new Brick( x,y,ball,score ){{
           
           x=360;
           y=90; 
           setTranslateX(360);
           setTranslateY(90);
           
    }};
    
    private Brick brick13 = new Brick( x,y,ball,score ){{
           
           x=440;
           y=90; 
           setTranslateX(440);
           setTranslateY(90);
           
    }};
    
    private Brick brick14 = new Brick( x,y,ball,score ){{
           
           x=520;
           y=90; 
           setTranslateX(520);
           setTranslateY(90);
           
    }};
    
    private Brick brick15 = new Brick( x,y,ball,score ){{
           
           x=600;
           y=90; 
           setTranslateX(600);
           setTranslateY(90);
           
    }};
    
    private Brick brick16 = new Brick( x,y,ball,score){{
           x=40;
           y=150; 
           setTranslateX(40);
           setTranslateY(150);
           
    }};
    
    private Brick brick17 = new Brick( x,y,ball,score ){{
           
           x=120;
           y=150; 
           setTranslateX(120);
           setTranslateY(150);
           
    }};
    
    private Brick brick18 = new Brick( x,y,ball,score ){{
           
           x=200;
           y=150; 
           setTranslateX(200);
           setTranslateY(150);
           
    }};
    
    private Brick brick19 = new Brick( x,y,ball,score){{
           
           x=280;
           y=150; 
           setTranslateX(280);
           setTranslateY(150);
           
    }};
    
    private Brick brick20 = new Brick( x,y,ball,score ){{
           
           x=360;
           y=150; 
           setTranslateX(360);
           setTranslateY(150);
           
    }};
    
    private Brick brick21 = new Brick( x,y,ball,score ){{
           
           x=440;
           y=150; 
           setTranslateX(440);
           setTranslateY(150);
           
    }};
    
    private Brick brick22 = new Brick( x,y,ball,score ){{
           
           x=520;
           y=150; 
           setTranslateX(520);
           setTranslateY(150);
           
    }};
    
    private Brick brick23 = new Brick( x,y,ball,score ){{
           
           x=600;
           y=150; 
           setTranslateX(600);
           setTranslateY(150);
           
    }};
    
    private Brick brick24 = new Brick( x,y,ball,score ){{
           
           x=40;
           y=210; 
           setTranslateX(40);
           setTranslateY(210);
           
    }};
    
    private Brick brick25 = new Brick( x,y,ball,score ){{
           
           x=120;
           y=210; 
           setTranslateX(120);
           setTranslateY(210);
           
    }};
    
    private Brick brick26 = new Brick( x,y,ball,score ){{
           
           x=200;
           y=210; 
           setTranslateX(200);
           setTranslateY(210);
           
    }};
    
    private Brick brick27 = new Brick( x,y,ball,score ){{
           
           x=280;
           y=210; 
           setTranslateX(280);
           setTranslateY(210);
           
    }};
    
    private Brick brick28 = new Brick( x,y,ball,score ){{
           
           x=360;
           y=210; 
           setTranslateX(360);
           setTranslateY(210);
           
    }};
    
    private Brick brick29 = new Brick( x,y,ball,score ){{
           
           x=440;
           y=210; 
           setTranslateX(440);
           setTranslateY(210);
           
    }};
    
    private Brick brick30 = new Brick( x,y,ball,score ){{
           
           x=520;
           y=210; 
           setTranslateX(520);
           setTranslateY(210);
           
    }};
    
    private Brick brick31 = new Brick( x,y,ball,score ){{
           
           x=600;
           y=210; 
           setTranslateX(600);
           setTranslateY(210);
           
    }};
    
    
    /**
     * Constructs a new test game.
     * @param stage the primary stage
     */
    public TestGame(Stage stage) {
        super(stage, "TestGame", 60, 700, 480);
        getSceneNodes().getChildren().addAll(bg, text);
        getSceneNodes().getChildren().addAll(scoreText);
        getSceneNodes().getChildren().addAll(paddle);
        getSceneNodes().getChildren().addAll(ball);
        startText.setText("Press Space to Play");
        nextLevelText.setText("Press S to Enter Next Level.");
        deadText.setText("Game over.Press space to start again.");
        getSceneNodes().getChildren().addAll(nextLevelText);
        getSceneNodes().getChildren().addAll(startText);
        getSceneNodes().getChildren().addAll(deadText);
        
        
        //adding bricks
        getSceneNodes().getChildren().addAll(brick);
        getSceneNodes().getChildren().addAll(brick1);
        getSceneNodes().getChildren().addAll(brick2);
        getSceneNodes().getChildren().addAll(brick3);
        getSceneNodes().getChildren().addAll(brick4);
        getSceneNodes().getChildren().addAll(brick5);
        getSceneNodes().getChildren().addAll(brick6);
        getSceneNodes().getChildren().addAll(brick7);
        getSceneNodes().getChildren().addAll(brick8);
        getSceneNodes().getChildren().addAll(brick9);
        getSceneNodes().getChildren().addAll(brick10);
        getSceneNodes().getChildren().addAll(brick11);
        getSceneNodes().getChildren().addAll(brick12);
        getSceneNodes().getChildren().addAll(brick13);
        getSceneNodes().getChildren().addAll(brick14);
        getSceneNodes().getChildren().addAll(brick15);
        getSceneNodes().getChildren().addAll(brick16);
        getSceneNodes().getChildren().addAll(brick17);
        getSceneNodes().getChildren().addAll(brick18);
        getSceneNodes().getChildren().addAll(brick19);
        getSceneNodes().getChildren().addAll(brick20);
        getSceneNodes().getChildren().addAll(brick21);
        getSceneNodes().getChildren().addAll(brick22);
        getSceneNodes().getChildren().addAll(brick23);
        getSceneNodes().getChildren().addAll(brick24);
        getSceneNodes().getChildren().addAll(brick25);
        getSceneNodes().getChildren().addAll(brick26);
        getSceneNodes().getChildren().addAll(brick27);
        getSceneNodes().getChildren().addAll(brick28);
        getSceneNodes().getChildren().addAll(brick29);
        getSceneNodes().getChildren().addAll(brick30);
        getSceneNodes().getChildren().addAll(brick31);
        
        
    } // TestGame

    @Override
    public void update(Game game, GameTime gameTime) {
   
        
        //press space to start the game
    if(getKeyManager().isKeyPressed(space)&&level==0)
    {
       ball.dx=3;
       ball.dy=3;
       startText.setFill(Color.TRANSPARENT);
       deadText.setFill(Color.TRANSPARENT);
    } // if
     //press S to enter next level
        if(getKeyManager().isKeyPressed(s))
        {
        	if(System.currentTimeMillis() - lastPressProcessed > 500) {
                //Do your work here...
                lastPressProcessed = System.currentTimeMillis();
                ball.dx=ball.ballSpeed+1;
                ball.dy=ball.ballSpeed+1;
                ball.ballSpeed++;
                nextLevelText.setFill(Color.TRANSPARENT);
            }           
        } // if
    
        text.setText("The time is " + gameTime.getTotalGameTime());
        if (game.getKeyManager().isKeyPressed(KeyCode.UP)) text.setTranslateY(text.getTranslateY() - 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.DOWN)) text.setTranslateY(text.getTranslateY() + 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.LEFT)) text.setTranslateX(text.getTranslateX() - 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT)) text.setTranslateX(text.getTranslateX() + 4);
        paddle.update(game, gameTime);
        ball.update(game, gameTime);
        brick.update(game, gameTime);
        brick1.update(game, gameTime);
        brick2.update(game, gameTime);
        brick3.update(game, gameTime);
        brick4.update(game, gameTime);
        brick5.update(game, gameTime);
        brick6.update(game, gameTime);
        brick7.update(game, gameTime);
        brick8.update(game, gameTime);
        brick9.update(game, gameTime);
        brick10.update(game, gameTime);
        brick11.update(game, gameTime);
        brick12.update(game, gameTime);
        brick13.update(game, gameTime);
        brick14.update(game, gameTime);
        brick15.update(game, gameTime);
        brick16.update(game, gameTime);
        brick17.update(game, gameTime);
        brick18.update(game, gameTime);
        brick19.update(game, gameTime);
        brick20.update(game, gameTime);
        brick21.update(game, gameTime);
        brick22.update(game, gameTime);
        brick23.update(game, gameTime);
        brick24.update(game, gameTime);
        brick25.update(game, gameTime);
        brick26.update(game, gameTime);
        brick27.update(game, gameTime);
        brick28.update(game, gameTime);
        brick29.update(game, gameTime);
        brick30.update(game, gameTime);
        brick31.update(game, gameTime);
        
        // if they run out of lives
        if(ball.lives==0)
        {
           ball.lives=3;
           ball.dx=0;
           ball.dy=0;
           deadText.setFill(Color.GREEN);
           score.set(0);
           ball.resetCounter=0;
        }
        //if they kill all bricks
        if(ball.resetCounter==32)
        {
          nextLevelText.setFill(Color.GREEN);
          ball.resetCounter=0;
          ball.setCenter();
          ball.dx=0;
          ball.dy=0;
          //redrawing bricks 
          brick.numHits=0;
          brick1.numHits=0;
          brick2.numHits=0;
          brick3.numHits=0;
          brick4.numHits=0;
          brick5.numHits=0;
          brick6.numHits=0;
          brick7.numHits=0;
          brick8.numHits=0;
          brick9.numHits=0;
          brick10.numHits=0;
          brick11.numHits=0;
          brick12.numHits=0;
          brick13.numHits=0;
          brick14.numHits=0;
          brick15.numHits=0;
          brick16.numHits=0;
          brick17.numHits=0;
          brick18.numHits=0;
          brick19.numHits=0;
          brick20.numHits=0;
          brick21.numHits=0;
          brick22.numHits=0;
          brick23.numHits=0;
          brick24.numHits=0;
          brick25.numHits=0;
          brick26.numHits=0;
          brick27.numHits=0;
          brick28.numHits=0;
          brick29.numHits=0;
          brick30.numHits=0;
          brick31.numHits=0;
          
        }
        
    } // update

} // TestGame