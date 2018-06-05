#include <stdio.h>

void Honaitower(int n, char a, char b, char c){
  if(n==1)
    printf("%c -> %c\n", a,b);
  else{
    Honaitower(n-1,a,b,c);
    printf("%c -> %c\n", a,b);
    Honaitower(n-1,c,a,b);
    }
}

int main(){
	int n;
	printf("Enter n: ");
	scanf("%d",&n);
    Honaitower(n,'3','2','1');
}
