#include<bits/stdc++.h>
using namespace std;

void solve() {
	int n, ans;
	cin >> n;
	vector<int> arr(n + 1), per(n + 1);
	for(int i = 1; i <= n; i++) {
		cin >> arr[i];
		per[arr[i]] = 1;
	}
	//cout << " accumulate is " << accumulate(per.begin(), per.end(), 0) << endl;
	if(accumulate(per.begin(), per.end(), 0) == n) {
		int first, last;
		//cout << " I am in" << endl;
		for(int i = 1; i <= n; i++) {
			if(arr[i] == 1) {
				first = i;
			} else if(arr[i] == n) {
				last = i;
			}
		}
		cout << "? " << first << " " << last << endl;
		cin >> ans;
		if (ans == -1) {
			exit(0);
		}
		if(ans > n - 1) {
			cout << "! B" << endl;
		} else if(ans < n - 1) {
			cout << "! A" << endl;
		} else {
			cout << "? " << last << " " << first << endl;
			cin >> ans;
			if (ans == -1) {
				exit(0);
			}
			if(ans == n - 1) {
				cout << "! B" << endl;
			} else {
				cout << "! A" << endl;
			}
		}		
	} else {
		for(int i = 1; i <= n; i++) {
			if(!per[i]) {
				cout << "? " << i << " " << 1 + (i == 1) << endl;
				cin >> ans;
				if (ans == -1) {
					exit(0);
				}
				if(ans == 0) {
					cout << "! A" << endl;
				} else { 
					cout << "! B" << endl;
				}
				break;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
	int t;
	cin >> t;
	while(t--) {
		solve();
	}
}
