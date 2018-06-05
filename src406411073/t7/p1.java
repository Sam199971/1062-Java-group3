package t7;

import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		int w;
		int x;
		int y;
		int z;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter w, x, y, z:");
		w = input.nextInt();
		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		A zzz = new A(w,x,y,z);
		System.out.printf("max = %d",zzz.max());
		System.out.println();
		System.out.printf("min = %d",zzz.min());
		System.out.println();
		System.out.printf("sum = %d",zzz.sum());
		System.out.println();
		System.out.printf("average = %.1f",zzz.average());
	}

}
