/* 
* Goomba.java 
* Author: [Doug Hadaway] 
* Submission Date:  
* 
* Purpose: This program creates a game in which pixels constantly 
* change between 2 values and create a visual pattern. 
* 
* Statement of Academic Honesty: 
* 
* The following code represents my own work. I have neither  
 
CSCI 1301: Introduction to Computing and Programming Summer 2014 
Project 3: Goomba (A Word Guessing Game) 
Page	9	of	9	
	
* received nor given inappropriate assistance. I have not copied 
* or modified code from any source other than the course webpage 
* or the course textbook. I recognize that any unauthorized 
* assistance or plagiarism will be handled in accordance with 
* the University of Georgia's Academic Honesty Policy and the 
* policies of this course. I recognize that my work is based 
* on an assignment created by the Department of Computer 
* Science at the University of Georgia. Any publishing 
* or posting of source code for this project is strictly 
* prohibited unless you have written consent from the Department 
* of Computer Science at the University of Georgia. 
*/


import java.util.Random;

public class Life {

	public static void main(String[] args) {
		int gridSize= 200;
		int cellSize= 3;
		Grid grid= new Grid(gridSize, cellSize, "The Game of Life");
		grid.setDelay(10);
		int aliveColor =1;
		int deadColor=0;
		int col=0;
		int row=0;
		int position=0;
		Random r= new Random();
		do
		{
		for(row=0;row<=(gridSize-1);row++)
			if(r.nextInt(100)>49)
			{
				grid.setPos(row, col, aliveColor);
			}
			else
			{
				grid.setPos(row, col, deadColor);
			}
		col ++;
		}while(col<=gridSize-1);
		grid.initialize();
		
	
	row=0;
	col=0;
	for( ;row>-1;)
	{
		col=0;
		for(;col<=gridSize-1;)
		{
		row=0;
		while(row<=gridSize-1)
		{
		position=grid.getPos(row, col);
		int neighbors=grid.matchingNeighbors(row,col,aliveColor);
			if(position==aliveColor && (neighbors==2 ||neighbors==3))
			{
				grid.setPos(row, col, aliveColor);
			}
			else if(position==aliveColor)
			{
				grid.setPos(row, col, deadColor);
			}
			else if(position==deadColor && neighbors==3)
			{
				grid.setPos(row,col,aliveColor);
			}
			else
			{
				grid.setPos(row, col, deadColor);
			}
		row++;
		}
		col++;
		}
		
		grid.update();
	}
	}
}
