package com.dp.fibonacci;

import java.util.Scanner;

public class FibonacciSeries {
	public static int recursion(int n) {
		if(n <= 1) {
			return n;
		}
		return recursion(n-1) + recursion(n-2);
	}
	
	public static int topDownMemoization(int n, int[] dp) {
		if(n <= 1) { 
			return n;
		}
		if(dp[n]>0) {
			return dp[n];
		}
		
		return dp[n] = topDownMemoization(n-1, dp) + topDownMemoization(n-2, dp);
	}
	
	public static int bottomUpTabulation(int n, int[] dp) {
		if(n <= 1) { 
			return n;
		}
		if(dp[n]>0) {
			return dp[n];
		}
		
		return dp[n] = bottomUpTabulation(n-1, dp) + bottomUpTabulation(n-2, dp);
	}
	
	public static int SpaceOptimization(int n) {
		if(n <= 1) { 
			return n;
		}
		int num1 = 0, num2 = 1, ans = 0;
		for(int i=2; i<=n; i++) {
			ans = num1 + num2;
			num1 = num2;
			num2 = ans;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a number");
			int n = sc.nextInt();
			
			System.out.println("Enter your choice:\n1. recursion\n2. Top Down\n3. Bottom Up\n4. Space Optimization");
			int choice = sc.nextInt();
			
			int[] dp = new int[n+1];
			
			switch(choice) {
			case 1:
				System.out.println(recursion(n)); 
				break;
			case 2:
				System.out.println(topDownMemoization(n, dp));
				break;
			case 3:
				System.out.println(bottomUpTabulation(n, dp));
				break;
			case 4:
				System.out.println(SpaceOptimization(n));
				break;
				
				default:
					System.out.println("Invalid choice");
			}
		}
	}
}


// 0 1 1 2 3 5 8 13 ....

//recursion ->	T.C. = O(2^n)
//				S.C. = O(n)
//Top Down 	->  T.C. = O(n)
//				S.C. = O(n)
//Bottom Up ->  T.C. = O(n)
//				S.C. = O(n)
//Space Opt ->  T.C. = O(n)
//				S.C. = O(1)
