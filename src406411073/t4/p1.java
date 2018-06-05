package t4;

import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		Scanner time = new Scanner(System.in);
		while (true) {
			System.out.printf("hours:");
			int hour = time.nextInt();
			System.out.printf("minutes:");
			int minute = time.nextInt();
			System.out.printf("seconds:");
			int second = time.nextInt();
			if (hour == -1|| minute == -1 || second == -1) {
				System.out.println("Exit");
				break;
			}
			else{
				System.out.printf("total %d seconds",hour*3600+minute*60+second);
				System.out.println();
			}
		}
	}

}
