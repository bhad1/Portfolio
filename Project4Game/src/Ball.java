/* 
* [Class name here].java 
* Author: [Douglas Hadaway] 
* Submission Date: [7/24/2014] 
* 
* Purpose:Creats balls for a game of pong
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

import java.util.Random;
public class Ball {
	int xDir=1;
	int	yDir=1;
	int	speed=1;
	int	courtWidth=700;
	int	courtHeight=300;
	int	x=courtWidth/2;
	int	y=courtHeight/2;
	Random r= new Random();
	int color=r.nextInt(6);
	int radius=r.nextInt(5)+15;
	public Ball(int x, int y,  int speed, int xDir, int yDir, int courtWidth, int courtHeight) {

		if(courtWidth<radius*2&&courtWidth>0)
		{
			courtWidth=this.courtWidth;
		}
		if(courtHeight<radius*2&&courtHeight>0)
		{
			courtHeight=this.courtHeight;
		}
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.xDir=xDir;
		this.yDir=yDir;
		this.courtWidth=courtWidth;
		this.courtHeight=courtHeight;
	}
	
	public Ball(int x, int y, int radius, int courtWidth, int courtHeight) {
		if(radius<15)
		{
			radius=15;
		}
		this.radius=radius;
		this.courtWidth=courtWidth;
		this.courtHeight=courtHeight;
		this.x=x;
		this.y=y;
		int xDir=1;
		int	yDir=1;
		int	speed=1;
	}
	
	public int  getRadius() {
		return this.radius;

	}
	
	public int  getX() {
		return x;

	}
	
	public int  getY() {
		return y;

	}
	
	public int getColor() {
		return this.color;

	}	
	
	public int getSpeed() {
		return this.speed;

	}
	
	public int getXDir() {
		return this.xDir;

	}
        
	public int getYDir() {
		return this.yDir;

	}
    
	public void setColor(int color) {
		if(color<=6&&color>0)
		{
			this.color=color;
		}
	
	}

	public void setX(int x) {
		if(x>0&&x<this.courtWidth)
		{
			this.x=x;
		}
	
	}
		
	public void setY(int y) {
		if(y>0&&y<this.courtHeight)
		{
			this.y=y;
		}
		
	
	}

	public void flipYDir() {
		if(yDir==1)
		{
			yDir=-1;
		}
		else if(yDir==-1)
		{
			yDir=1;
		}
	
	}
	
	public void flipXDir() {
		if(this.xDir==1)
		{
			this.xDir=-1;
		}
		else if(xDir==-1)
		{
			xDir=1;
		}
	
	}

	public void move() {
		if(x+radius==courtWidth||x+radius==radius*2)
		{
			flipXDir();
		}
		if(y+radius==courtHeight||(y+radius==radius*2))
		{
			flipYDir();
		}
		if(xDir==1)
		{
			x+=speed;
		}
		else if(xDir==-1)
		{
			x-=speed;
		}
		if(yDir==1)
		{
			y+=speed;
		}
		else if(yDir==-1)
		{
			y-=speed;
		}
	}
	
	public boolean isCollision(Ball anotherBall) {
		if(this.radius+anotherBall.radius>=(Math.sqrt(Math.pow(this.x-anotherBall.x, 2)+(Math.pow(this.y-anotherBall.y,2)))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void increaseSpeed() {
		if(speed<5)
		{
			speed++;
		}
	
	}
	
	public void decreaseSpeed() {	
		if(speed>1)
		{
			speed--;
		}
	
	}
	public String toString() {
		String stringBall="The ball's speed is: "+speed+"The ball's center is: "+x+","+y;
		return stringBall;
	}
    
}