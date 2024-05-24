#include <iostream>
using namespace std;

int Q3(int a[], int n, int f[100], int b[100]){
	int count = 0;
	int Max = 1;
	for(int i=1; i<=n; i++){
		f[i] = 1;
		
		for(int j=1; j<i; j++){
			

			if(a[i]>a[j]){
				if(f[j] + 1 > f[i]){
					f[i] = f[j] + 1;
				}
				
			}
			if(f[i]>Max) Max = f[i];
			
		}
		b[i] = Max-1;
		count = max(count, f[i]);
	}
	return count;
}

void TruyVet(int a[], int n, int f[100], int b[100]){
	Q3(a, n, f, b);
	 for(int i=1; i<=n; i++){
		cout<<a[i]<<"  ";
	}
	cout<<endl;
	for(int j=1; j<=n; j++){
		cout<<f[j]<<"  ";
	}
	cout<<endl;
	for(int j=1; j<=n; j++){
		cout<<b[j]<<"  ";
	}
	cout<<endl;
	
	int Max = 0;
	for(int i=1; i<=n; i++){
		if(a[i]>a[Max]){
			Max = i;
		}
	}
	
	while(true){
		int i = Max;
		cout<<a[i]<<" ";
		Max = b[i];
		if(b[Max]==0){
			cout<<a[Max]<<" ";
			break;
		}
	}
	
	
	
}

int main(){
	int n = 5;
	int a[n]= {0, 2,  3, 4, 1, 5};
	int f[100];  
	int b[100];  
	TruyVet(a, n, f, b);
}
