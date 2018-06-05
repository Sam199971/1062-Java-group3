package t7;

public class A {
	private int w;
	private int x;
	private int y;
	private int z;
	private int min = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE;
	public A(int w,int x,int y,int z){
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public A(){
		
	}
	public int sum(){
		return w+x+y+z;
	}
	public int min(){
		if(w<=min)min=w;
		if(x<=min)min=x;
		if(y<=min)min=y;
		if(z<=min)min=z;
		return min;
	}
	public int max(){
		if(w>=max)max=w;
		if(x>=max)max=x;
		if(y>=max)max=y;
		if(z>=max)max=z;
		return max;
	}
	
	public float average(){
		return (float) ((w+x+y+z)/4.0);
	}
}
