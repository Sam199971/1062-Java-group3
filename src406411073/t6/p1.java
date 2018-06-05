package t6;

public class p1 {

	public static void main(String[] args) {
		hanoi(3,'1','2','3');
	}
	static void hanoi(int n ,char A , char B , char C){
		if(n==1){
			System.out.print(C + "->" + A);
			System.out.println();
		}
		else{
		hanoi(n-1,B,A,C);
		System.out.print(C + "->" + A);
		System.out.println();
		hanoi(n-1,A,C,B);
		}
	}
}
