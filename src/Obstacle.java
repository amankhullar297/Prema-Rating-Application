import java.lang.*;
import java.util.*;

class Pair {
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x;
	int y;
}

class Obstacle {
	static int n;

	public boolean traverse(int x, int y, int endx, int endy, char arr[][], boolean seen[][]) {

		if (x == endx && y == endy) {

			System.out.print("reached destination");

			return true;

		}

		if (x > n || x < 0)
			return false;

		if (y > n || x < 0)
			return false;

		seen[x][y] = true;

		if (x == 'R' || x == 'M') {

			if (!seen[x][y - 1] && traverse(x, y - 1, endx, endy, arr, seen)) {

				print_obstacles(x, y - 1, arr);

				return true;

			}

			// ... write this inner if for for x,y-1; x,y+1; x-1,y; x+1, y;
			// x+1,y+1; x+1, y-1; x-1,y-1; x-1, y+1;
		}
		return false;
	}

	public boolean traverse(int x, int y, int endx, int endy, char arr[][], boolean seen[][], List<Pair> results) {

		if (x == endx && y == endy) {

			System.out.print("reached destination");

			return true;
		}

		if (x > n || x < 0)
			return false;

		if (y > n || x < 0)
			return false;

		seen[x][y] = true;

		if (x == 'R' || x == 'M')

		{
			if (!seen[x][y - 1] && traverse(x, y - 1, endx, endy, arr, seen)) {

				// results.push(new Pair(x,y-1));
				results.add(new Pair(x, y - 1));

				return true;
			}
			if (!seen[x][y + 1] && traverse(x, y + 1, endx, endy, arr, seen)) {

				results.add(new Pair(x, y + 1));

				return true;
			}
			if (!seen[x - 1][y] && traverse(x - 1, y, endx, endy, arr, seen)) {

				results.add(new Pair(x - 1, y));

				return true;
			}
			if (!seen[x + 1][y] && traverse(x + 1, y, endx, endy, arr, seen)) {

				results.add(new Pair(x + 1, y));

				return true;
			}
			if (!seen[x + 1][y + 1] && traverse(x + 1, y + 1, endx, endy, arr, seen)) {

				results.add(new Pair(x + 1, y + 1));

				return true;
			}
			if (!seen[x + 1][y - 1] && traverse(x + 1, y - 1, endx, endy, arr, seen)) {

				results.add(new Pair(x + 1, y - 1));

				return true;
			}
			if (!seen[x - 1][y - 1] && traverse(x - 1, y - 1, endx, endy, arr, seen)) {

				results.add(new Pair(x - 1, y - 1));

				return true;
			}
			if (!seen[x - 1][y + 1] && traverse(x - 1, y + 1, endx, endy, arr, seen)) {

				results.add(new Pair(x - 1, y + 1));

				return true;
			}

			// write this inner if for for x,y-1; x,y+1; x-1,y; x+1, y; x+1,y+1;
			// x+1, y-1; x-1,y-1; x-1, y+1;
		}
		return false;
	}

	void print_obstacles(int x, int y, char arr[][])
{
  
    //iterate through arr[x][y] as x,y-1; x,y+1; x-1,y; x+1, y; x+1,y+1; x+1, y-1; x-1,y-1; x-1, y+1; 
//and store them in array excluding all values of 'R' and 'M'
//sort the array and print them in a line
  List<Character> list=new ArrayList<Character>();//????
  if(!(arr[x][y-1]=='R' || arr[x][y-1]=='M')){
  			list.add(arr[x][y-1]);
  				}
  if(!(arr[x][y+1]=='R' || arr[x][y+1]=='M')){
  			list.add(arr[x][y+1]);
  				}
  if(!(arr[x-1][y]=='R' || arr[x-1][y]=='M')){
  			list.add(arr[x-1][y]);
  				}
  if(!(arr[x+1][y]=='R' || arr[x+1][y]=='M')){
  			list.add(arr[x+1][y]);
  				}
  if(!(arr[x+1][y+1]=='R' || arr[x+1][y+1]=='M')){
  			list.add(arr[x+1][y+1]);
  				}
  if(!(arr[x+1][y-1]=='R' || arr[x+1][y-1]=='M')){
  			list.add(arr[x+1][y-1]);
  				}
  if(!(arr[x-1][y-1]=='R' || arr[x-1][y-1]=='M')){
  			list.add(arr[x-1][y-1]);
  				}
  if(!(arr[x-1][y+1]=='R' || arr[x-1][y+1]=='M')){
  			list.add(arr[x-1][y+1]);
  				}
  
}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int x=0, y=0, endx=0, endy=0;
		char[][] value = new char[n][n];
		boolean[][] status = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; i < n; i++) {
				value[i][j] = sc.next().charAt(0);
				// System.out.print(" ");
			}
			// System.out.println("");

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; i < n; i++) {
				if (value[i][j] == 'S'){
					x = i;
				y = j;
			}
			if (value[i][j] == 'A'){
				endx = i;
			endy = j;
			}
		}
	}

	Obstacle obs = new Obstacle();
	boolean b = obs.traverse(x, y, endx, endy, value, status);
}
}