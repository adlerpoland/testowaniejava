package spock

import spock.Calculator
import spock.lang.*

class CalculatorTest extends spock.lang.Specification{
	def "Adding two numbers to return the sum"() {
		when: "a new calc class is created"
		def calc = new Calculator();

		then: "1 plus 1 is 2"
		calc.add(1, 1) == 2
	}
	
	def "Order of numbers does not matter"() {
		when: "a new calc class is created"
		def calc = new Calculator();

		then: "2 plus 3 is 5"
		calc.add(2, 3) == 5
		
		and: "3 plus 2 is also 5"
		calc.add(3, 2) == 5
	}
	
	def "Subtracting two numbers to return the sub"() {
		when: "a new calc class is created"
		def calc = new Calculator();

		then: "6 minus -3 is 9"
		calc.sub(6, -3) == 9
	}
	
	def "Multiplying two numbers to return the mul"() {
		when: "a new calc class is created"
		def calc = new Calculator();

		then: "3 multiply -4 is -12"
		calc.mul(3, -4) == -12
		
		and: "-4 multiply 3 is also -12"
		calc.mul(-4, 3) == -12
	}
	
	def "Dividing two numbers to return the div"() {
		when: "a new calc class is created"
		def calc = new Calculator();

		then: "6 divided by 2 is 3"
		calc.div(6, 2) == 3
		
		and: "10 divided by -2 is -5"
		calc.div(10, -2) == -5
	}
	
	def "Power of two numbers to return the pow"() {
		when: "a new calc class is created"
		def calc = new Calculator();

		then: "6 powered by 2 is 36"
		calc.pow(6, 2) == 36
		
		and: "2 powered by 5 is 32"
		calc.pow(2, 5) == 32
	}
	
	def "Power of two numbers (Data Table)"(int a,int b,int c) {
		given:
		def calc = new Calculator();

		expect:
		calc.pow(a, b) == c
		
		where:
		a | b || c
		2 | 1 || 2
		2 | 2 || 4
		2 | 3 || 8
		2 | 4 || 10
		2 | 5 || 32
		2 | 6 || 64
	}
}








