package com.first.generalPrograms;

public class PrimeNumber {

	public static void main(String[] args) {
		// A prime number is a number which is divisible only by itself and 1
		int number = 14;

		calculatePrimeNumber(number);
		generatePrimeNumber(number);
	}

	private static void generatePrimeNumber(int number) {
		if (number > 2) {
			System.out.println(2);
		}

		for (int i = 3; i < number; i++) {
			calculatePrimeNumber(i);
		}
	}

	private static boolean calculatePrimeNumber(int number) {
		int m = number / 2;
		boolean flag = false;

		if (number == 0 || number == 1) {
			System.out.println(number + " is not a prime number");
		} else {
			for (int i = 2; i <= m; i++) {
				if (number % i == 0) {
					System.out.println(number + " is not a prime number");
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.println(number + " is a prime number");
			}
		}
		return flag;
	}

}
