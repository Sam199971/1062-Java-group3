package t5;

import java.util.Random;
import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter N:");
		int N = input.nextInt();
		int max = 1;
		int[] c = new int[50];
		int[] t = new int[50];
		Random rand = new Random();

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= 49; i++) {
				c[i] = 0;
			}
			for (int i = 1; i <= 6; i++) {
				int z = rand.nextInt(49) + 1;
				if (c[z] == 0) {
					System.out.printf("%3d",z);
					c[z]++;
					t[z]++;
				} else {
					i--;
				}
			}
			System.out.println();
		}
		for (int i = 1; i <= 49; i++) {
			if (t[i] > max) {
				max = t[i];
			}
		}
		for (int i = 1; i <= 49; i++) {
			if (t[i] == max) {
				System.out.printf("Max: (%2d,%2d)", i, max);
				System.out.println();
			}
		}
	}
}
