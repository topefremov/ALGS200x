package io.github.topefremov.maxpairwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class MaxPairWiseProduct {
	
	// algorithms implementations
	
	static long getMaxPairwiseProductNaive(int[] numbers) {
		long result = 0;
		int n = numbers.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if ((long) numbers[i] * numbers[j] > result) {
					result = (long) numbers[i] * numbers[j];
				}
			}
		}
		return result;
	}
	
	static long getMaxPairwiseProductFast(int[] numbers) {
		int index1 = 0;
		int length = numbers.length;
		for (int i = 1; i < length; i++)
			if (numbers[i] > numbers[index1])
					index1 = i;
		
		int index2;
		if (index1 == 0)
			index2 = 1;
		else
			index2 = 0;
		
		for (int i = 1; i < length; i++)
			if (i != index1 && numbers[i] > numbers[index2])
				index2 = i;
		return (long) numbers[index1] * numbers[index2];
	}
	
	// stress test
	
	static void stressTest(int n, int m) {
		int capacity;
		int[] numbers;
		long result1, result2;
		Random r = new Random();
		while (true) {
			capacity = r.nextInt(n-1) + 2;
			numbers = new int[capacity];
			for (int i = 0; i < capacity; i++)
				numbers[i] = r.nextInt(m+1);
			
			System.out.print("Current array: ");
			for (int i = 0; i < capacity; i++)
				System.out.print("[" + numbers[i] + "] ");
			System.out.println();
			
			result1 = getMaxPairwiseProductNaive(numbers);
			result2 = getMaxPairwiseProductFast(numbers);
			if (result1 == result2)
				System.out.println("OK");
		    else {
				System.out.println("Wrong answer! " 
						+ result1 + " " + result2);
				return;
			}
		}
	}

	public static void main(String[] args) {
//		FastScanner scanner = new FastScanner(System.in);
//		int n = scanner.nextInt();
//		int[] numbers = new int[n];
//		for (int i = 0; i < n; i++) {
//			numbers[i] = scanner.nextInt();
//		}
//		long result = getMaxPairwiseProductFast(numbers);
//		System.out.println(result);
//		
//		int capacity = 2 * (int) Math.pow(10, 5);
//		int[] largeDataset = new int[capacity];
//		for (int i = 0; i < capacity; i++) {
//			largeDataset[i] = i+1;
//		}
//		result = getMaxPairwiseProductFast(largeDataset);
//		System.out.println(result);
		
		stressTest(1000, 200000);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
