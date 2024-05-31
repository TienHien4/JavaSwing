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


#include <iostream>
#include <cstring>
using namespace std;

int A3(string p, string s){
	int count2 = 0;
	int l1 = p.length();
	int l2 = s.length();
	for(int i=0; i<=l1-1; i++){
		int count1 = 0;
		for(int j=0; j<=l2-1; j++){		
			if(p[i+j] == s[j]){
				count1++;
			}
			else if(p[i+j] != s[j]) break;
		}
		if(count1==s.length()) count2++;
	}
	return count2;
	
}
void A4(string p, string t, string s){
	int dd[100] = {0};
	int l1 = p.length();
	cout<<l1<<endl;
	int l2 = s.length();
	int l3 = t.length();
	for(int i=0; i<=p.length(); i++){
		
		int count1 = 0;
		for(int j=0; j<=l2-1; j++){		
			if(p[i+j] == s[j]){
				count1++;
			}
			else if(p[i+j] != s[j]) break;
		}
		
		if(count1==s.length()){
			p.replace(i, l2, "hello");
		}
	}
	
	for(int i=0; i<=p.length(); i++){
		cout<<p[i];
	}
	cout<<endl;
	cout<<p.length();
}

int main(){
	string p = "hiadaisadhigdhgdfg";
	string t = "hello";
	string s = "hi";
	A4(p, t, s);
}
