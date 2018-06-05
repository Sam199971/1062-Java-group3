#include<stdio.h>

int main(){
	int h,m,s;
    while(1){
    	if(h==-1||m==-1||s==-1){
    		printf("Exit");
    		break;
    	}
    	else{
			printf("hours:");
			scanf("%d",&h);
			printf("minutes:");
			scanf("%d",&m);
			printf("seconds:");
			scanf("%d",&s);
			printf("total %d seconds\n",h*3600+m*60+s);
		}
	}
}
