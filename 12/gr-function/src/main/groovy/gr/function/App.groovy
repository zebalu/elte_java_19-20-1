/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package gr.function

import java.time.Duration
import java.time.Instant

class App {

    static void main(String[] args) {
        Functional f = new Functional()
		measure("factor(10)") { f.factorial(10) }
		measure("factorTr(10)") { f.factorialTr(10) }
		hr()
		measure("factor(20)") { f.factorial(20) }
		measure("factorTr(20)") { f.factorialTr(20) }
		hr()
		measure("fib(10)") { f.fib(10) }
		measure("fibM(10)") { f.fibM(10) }
		hr()
		measure("fib(30)") { f.fib(30) }
		measure("fibM(30)") { f.fibM(30) }
    }
	
	static measure(String name, Closure task) {
		println("measuring ${name}")
		Instant start = Instant.now()
		def result = task.call()
		Instant end = Instant.now()
		println "${name} resulted: ${result}"
		println "${name} took: ${Duration.between(start, end).toMillis()} ms"
	}
	
	static void hr() {
		println "--------------------------------------"
	}
}
