package com.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

interface PerformOperation {
	int check(int num);
}

class Math {

	public int checker(PerformOperation op, int num) {
		return op.check(num);
	}

	PerformOperation isOdd() {
		PerformOperation p = (o) -> {
			return o % 2;
		};
		return p;
	}							//changes

	PerformOperation isPrime() {
		PerformOperation p = (o) -> {
			if (o == 1)
				return 1;
			for (int i = 2; i <= o / 2; ++i) {
				if ((o % i) == 0)
					return 1;
			}
			return 0;
		};
		return p;

	}

	PerformOperation isPalindrome() {
		PerformOperation p = (o1) -> {
		    String word = ""+o1;
            boolean isPalindrome = true;
            for(int i = 0;i<(int)word.length()/2;i++)
            {
                if(word.charAt(i) != word.charAt(word.length()-1-i)){
                    isPalindrome = false;
                    break;

                }
            }
            return isPalindrome?0:1;
		};
		return p;
	}

}

public class CheckingNumbers {

	public static void main(String[] args) throws IOException {
		Math ma = new Math();

		String ans = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// Scanner sc = new Scanner(System.in);
		PerformOperation op;
		int ret = 0;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ma.isOdd();
				ret = ma.checker(op, num);
				ans = (ret == 0) ? "EVEN" : "ODD";
			} else if (ch == 2) {
				op = ma.isPrime();
				ret = ma.checker(op, num);
				ans = (ret == 0) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ma.isPalindrome();
				ret = ma.checker(op, num);
				ans = (ret == 0) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}

	}
}
