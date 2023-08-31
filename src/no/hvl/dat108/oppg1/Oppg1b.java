package no.hvl.dat108.oppg1;

import java.util.function.BinaryOperator;

public class Oppg1b {
	public static void main(String[] args) {
		BinaryOperator<Integer> sumFn = (a, b) -> a + b;
		BinaryOperator<Integer> maksFn = (a, b) -> Math.max(a, b);
		BinaryOperator<Integer> maksFn2 = (a, b) -> a > b ? a : b;
		BinaryOperator<Integer> diffFn = (a, b) -> Math.abs(a - b);

		int sum = beregn(12, 13, sumFn);
		int maks = beregn(-5, 3, maksFn);
		int diff = beregn(54, 45, diffFn);

		System.out.println("Sum: " + sum + " Maks: " + maks + " Diff: " + diff);
	}

	public static int beregn(int a, int b, BinaryOperator<Integer> intFn) {
		return intFn.apply(a, b);
	}
}
