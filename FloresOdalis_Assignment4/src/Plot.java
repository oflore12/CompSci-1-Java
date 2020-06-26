/*
 * Plot class 
 * 1.Instance variables to represent the x and y coordinates of the upper left corner of 
 * 	the location, and depth and width to represent the vertical and horizontal extents of 
 * 	the plot.
 * 2. A toString method to represent a Plot object
 * 3. Constructors
 * 4. A method named overlaps that takes a Plot instance and determines if it is overlapped
 * 	by the current plot.
 * 5. A method named encompasses that takes a Plot instance and determines if the current 
 * 	plot contains it.  Note that the determination should be inclusive, in other words, 
 * 	if an edge lies on the edge of the current plot, this is acceptable.
 * Name: Odalis R. Flores
 * Class: CMSC 203
 * CRN: 202030
 * Assignment 4
 * Professor: Robert Alexander
 * @author Odalis Flores
 */
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
		/**
		 * no argument plot constructor
		 * sets x and y to 0 and width and depth to 1
		 */
		public Plot () {
			x=0;
			y=0;
			width=1;
			depth=1;
		}
		/**
		 * copy constructor that creates a copy plot
		 * sets x, y, width and depth to plots x, y, width and depth
		 * @param p Plot p
		 */

		public Plot (Plot p) {
			x=p.x;
			y=p.y;
			width=p.width;
			depth=p.depth;
		}
		
		/**
		 * plot constructor that accepts 4 arguments
		 * it initializes private instances to parameters
		 * @param x parameter x to initialize x
		 * @param y parameter x to initialize y
		 * @param width parameter width to initialize width
		 * @param depth parameter depth to initialize depth
		 */
		public Plot(int x, int y, int width, int depth) {
			this.x=x;
			this.y=y;
			this.width=width;
			this.depth=depth;
		}
		/**
		 * test if plot object overlaps another plot
		 * @param plot Plot object
		 * @return false if the plots do not overlap, true if they do
		 */

		public boolean overlaps(Plot plot) {
			if(plot.x >= (x+width)|| (plot.x+plot.width)<=x)
				return false;
			if(plot.y >=(y+depth)|| (plot.y+plot.depth) <= y)
				return false;
			return true;
		}
		
		/**
		 * test if the plot is encompassed within the plot
		 * @param plot Plot object
		 * @return true if it is encompassed false if its not
		 */
		public boolean encompasses (Plot plot) {
			boolean encompX, encompY, encompWidth, encompDepth;
			if(x <= plot.x)
				encompX=true;
			else encompX= false;
			if(y <= plot.y)
				encompY=true;
			else encompY= false;
			if( (width+x) >= (plot.width+plot.x) )
				encompWidth=true;
			else encompWidth= false;
			if( (depth+y) >= (plot.depth+plot.y) )
				encompDepth=true;
			else encompDepth= false;
			return encompX && encompY && encompWidth && encompDepth;	
		}
		/**
		 * setX will set integer x to x
		 * @param x integer
		 */
		public void setX(int x) {
			this.x=x;
		}
		/**
		 * getX will get x
		 * @return value of x
		 */
		public int getX() {
			return x;
		}
		/**
		 * setY is a setter
		 * will set y to y
		 * @param y integer
		 */
		public void setY(int y) {
			this.y=y;
		}
		/**
		 * getY is y getter
		 * @return value of y
		 */
		public int getY() {
			return y;
		}
		/**
		 * setWidth setter
		 * sets width with width
		 * @param width integer
		 */
		public void setWidth(int width) {
			this.width=width;
		}
		/**
		 * getWidth getter
		 * gets width
		 * @return value of width
		 */
		public int getWidth() {
			return width;
		}
		/**
		 * setDepth setter
		 * sets depth to depth
		 * @param depth integer
		 */
		public void setDepth(int depth) {
			this.depth=depth;
		}
		/**
		 * getDepth getter
		 * gets depth
		 * @return value of depth
		 */
		public int getDepth() {
			return depth;
		}
		/**
		 * displays the plot 
		 * "Upper left: (x, y); Width: width Depth: depth
		 */
		public String toString() {
			String strg= "Upper left: ("+ x+","+y+"); Width: "+width+" Depth: "+depth;
			return strg;
		}

}
