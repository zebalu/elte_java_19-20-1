package gr.function

import groovy.transform.Memoized
import groovy.transform.TailRecursive

class Functional {
	
	def factorial(n) {
		if(n==0) 1
		else n*factorial(n-1)
	}
	
	@TailRecursive
	def factorialTr(n, fac = 1) {
		if(n==0) fac
		else factorialTr(n-1, fac*n)
	}
	
	def fib(n) {
		if(n<2) 1
		else fib(n-1)+fib(n-2)
	}
	
	@Memoized
	def fibM(n) {
		if(n<2) 1
		else fibM(n-1)+fibM(n-2)
	}
	
}
