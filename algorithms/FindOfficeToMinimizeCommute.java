/**
find a intersection to build office so that the sum of all employees’ 
commute distances is minimum. （the map is represented as a m*n grid, you 
are given each employee’s coordination, they can only move in up-down and 
left-right directions）

**/

import java.util.Random;
public class FindOfficeToMinimizeCommute {
	
	public static void main(String args[]) {

		int k = 10;
		// k represents the number of employees
		int[][]  employee_pos = new int[k][2];

		int m=5, n=8;
		// generate random coordinates for employees
		Random ran = new Random();
		for (int i=0; i<k; i++) {
			int x = ran.nextInt(m);
			int y = ran.nextInt(n);
			employee_pos[i][0]=x;
			employee_pos[i][1]=y;
		}
		FindOfficeToMinimizeCommute test = new FindOfficeToMinimizeCommute();
		
		int[] office_pos = test.getOfficePos(employee_pos);


		System.out.println("office position  "+ office_pos[0]+","+office_pos[1]);



	}

	private int[] getOfficePos(int[][] employee_pos) {
		int  sum_of_x_pos = 0;
		for (int i=0; i< employee_pos.length; i++) {
			sum_of_x_pos+=employee_pos[i][0];	
		}
		
		int  sum_of_y_pos = 0;
		for (int i=0; i< employee_pos.length; i++) {
                        sum_of_y_pos+=employee_pos[i][1];
                }
		int n= employee_pos.length;
		int[] pos = {sum_of_x_pos/n, sum_of_y_pos/n};
		return pos;

	}

	
	
}
