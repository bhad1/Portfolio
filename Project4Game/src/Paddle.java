/* 
* [Class name here].java 
* Author: [Douglas Hadaway] 
* Submission Date: [7/24/2014] 
* 
* Purpose:Creats a paddle for a game of pong.
* 
* Statement of Academic Honesty: 
* 
* The following code represents my own work. I have neither 
* received nor given inappropriate assistance. I have not copied 
* or modified code from any source other than the course webpage 
* or the course textbook. I recognize that any unauthorized 
* assistance or plagiarism will be handled in accordance with 
* the University of Georgia's Academic Honesty Policy and the 
* policies of this course. I recognize that my work is based 
* on a programming project created by the Department of 
* Computer Science at the University of Georgia. Any publishing 
* of source code for this project is strictly prohibited without 
* written consent from the Department of Computer Science. 
*/ 
public class Paddle {

	//Declare instance variables
	int x=0;
	int width=100;
	int height=10;
	int speed=0;
	int direction=0;
	int courtWidth=700;
//must center paddle to the center of bottom wall
	public Paddle (int courtWidth)  {
		if(courtWidth<width)
		{
			courtWidth=this.courtWidth;
		}
		this.courtWidth=courtWidth;
		this.x=(courtWidth/2)-50;
		int speed=0;
		int direction=0;
	}

	public Paddle (int width, int courtWidth)  {
		if(width<0)
		{
			width=this.width;

		}
		else
		{
			this.width=width;
		}
		if(courtWidth<0||courtWidth<width)
		{
			courtWidth=this.courtWidth;
		}
		else
		{
			this.width=width;
		}
		this.height=10;
		this.speed=0;
		this.direction=0;
		this.x=(courtWidth/2)-50;
		
		
	
	}

	public int getX() { 
		return this.x;

	}  
	
	public int getDirection() {
		return this.direction;

	}
	
	public int getSpeed() {
		return speed;

	}

	public int getWidth() {
		return width;

	}
		
	public int getHeight() {
		return height;

	}  
	
	public void setDirection(int direction)   {
		if(!(direction>1||direction<-1))
		{
			this.direction=direction;
		}
		
	}
	
	public void setSpeed(int speed)   {
		if(speed>=1||speed<=5)
		{
			this.speed=speed;
		}

	}

	public void move() {
		if(x>0&&x+100<courtWidth)
			if(direction==1&&x+100+speed<courtWidth)
			{
				x+=speed;
			}
			else if(direction==-1&&x-speed>0)
			{
				x-=speed;
			}
			else if(direction==0)
			{
				
			}
			if(x==0)
			{
				x+=speed;
			}
			else if(x+100==courtWidth)
			{
				x-=speed;
			}
	}
	
	public boolean isCollision(Ball aBall) {
		if(aBall.y-aBall.radius<=height&&(aBall.x>=this.x&&aBall.x<=x+width))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	public void center()  {
		this.x=(courtWidth/2)-50;
	
	
	}

	public String toString() {
		String stringPaddle="The x is "+x+"The height is "+height+"The width is "+width;
		return stringPaddle;
	}

} 