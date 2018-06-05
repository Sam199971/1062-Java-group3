#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(){
	int n,i,j;
	srand(time(NULL));
	int r = rand()%50;
	printf("Enter N: ");
	scanf("%d",&n);
	for(i=1;i<=n;i++){
		printf("%d %d %d %d %d %d\n",r,r,r,r,r,r);
		while(j++ < 6) {
		int r=(rand()%50)+1;
		cout << r<<" ";
	}
	printf("max:(%2d,%2d)",i,i);
}

