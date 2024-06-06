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



#include <iostream>
#include <cstring>
using namespace std;

int A1(string s){
	if(s.length()%2!=0) return 0;
	else{
		int l = 0;
		int r = s.length() - 1;
		while(l<r){
			if(s[l]!=s[r]){
				return 0;
				break;
			} 
			l++;
			r--;
		}
	}
	return 1;
}

void A2(string s, int k){
	
	if(A1(s)==1){
		cout<<"s la xau dx"<<endl;
		for(int i=0; i<=s.length()-1; i++){
		    cout<<s[i];
	    }
    }
	else{
		int l = k-1;
		int r = k;
		string s1;
		while(l>0 || r<s.length()-1){
			if(s[l]!=s[r]){
				break;
				
			}else{
				cout<<s[l]<<"-"<<s[r]<<endl;
				l--;
				r++;
			}
		}
		
	    }
	}

int main(){
	string s = "sdffmoomsdfsd";
	A2(s, 6);
}


 #include <bits/stdc++.h>
using namespace std;

struct Quat{
	string tenHangSanXuat;
	long giaBan;
	string mauSac;
};

Quat d[]={{"LG",3750000,"trang"},
				{"Toshiba",1500000,"green"},
				{"Daikin",1350000,"gray"},
				{"Casper",950000,"black"},
				{"Sanaky",625000,"trang"},
				{"Sanyo",375000,"black"}}; 
				
bool ThamLam(Quat d[], int n, long p, int *S){
	for(int i=0;i<n; i++)
		S[i]=0;
	int i=0;
	while(p>0 && i<n){
		S[i]=p/d[i].giaBan; 
		p=p-S[i]*d[i].giaBan; 
		i++; 
	}
	if(p>0)
		return false;
	else return true;
}

//void ThamLam(Quat d[], int n, long p, int *S){
//	for(int i=0;i<n; i++)
//		S[i]=0;
//	int i=0;
//	while(p>0 && i<n){
//		S[i]=p/d[i].giaBan; cout<<S[i]<<" ";
//		p=p-S[i]*d[i].giaBan; cout<<p<<" ";
//		i++; cout<<i<<endl;
//	}
//}

int main(){
	int n=6;
	int p=2825000;
	int S[n];
	cout<<"So luong ban"<<setw(30)<<"Ten hang san xuat\t"<<setw(30)<<"Gia ban\t"<<endl;
	if(ThamLam(d,n,p,S)){
		for(int i=0; i<n; i++){
			if(S[i]!=0)
				cout<<S[i]<<setw(30)<<d[i].tenHangSanXuat<<setw(30)<<d[i].giaBan<<endl;
		}
	} else cout<<"Khong tim duoc so luong va danh sach cac quat can ban de duoc so tien dung bang "<<p<<endl;
//	ThamLam(d,n,p,S);
	return 0;
}
#include <iostream>
using namespace std;

struct Laptop {
    string brand;
    string config;
    int price;
};

int char_in_string(char c, string s) {
    int i = 0;
    while (i < s.length()) {
        if (s[i] == c) {
            return i;
        }
        i++;
    }
    return -1;
}

bool BMH(string P, string T) {
    int v = P.length(), i = v - 1;
    int x;

    while (i < T.length()) {
        int k = v - 1;
        int j = i;
        while (k > -1 && T[j] == P[k]) {
            j--; k--;
        }

        if (k < 0) return true;

        else {
            x = char_in_string(T[i], P);
            if (x < 0) i = i + v;
            else i = i + v - x - 1;
        }
    }

    return false;
}

int Dem(Laptop laptops[], int size) {
    string target = "16GB-SSD";
    int count = 0;
    for (int i = 0; i < size; ++i) {
        if (BMH(target, laptops[i].config)) {
            count++;
        }
    }
    return count;
}

int main() {
    const int n = 3;
    Laptop laptops[n] = {
        {"HP", "CPU 2.5GHz upto 3.5GHz-RAM 16GB-SSD 512GB", 15000000},
        {"ACER", "CPU 2.5GHz upto 3.5GHz-RAM 8GB-HDD 2TB", 12000000},
        {"DELL", "CPU 3.0GHz upto 4.0GHz-RAM 16GB-SSD 1TB", 20000000}
    };
    cout << Dem(laptops, n) << endl;
    return 0;
}
