package spock;

import spock.App
import spock.lang.*

class AppTest extends spock.lang.Specification{

	def "Proste wyszukiwanie binarne"() {
		given: "new App is created"
		def app = new App()

		when: "we create our binary list"
		int[] list = [1,2,4,7,8,9]
		
		then: "4 have index == 2"
		app.BinSearch(list, 4) == 2
	}
	
	def "Wyszukiwanie binarne liczby ujemne"() {
		given: "new App is created"
		def app = new App()

		when: "we create our binary list"
		int[] list = [-9,-8,-7,-6,-5,-4,-2,-1]
		
		then: "-4 have index == 2"
		app.BinSearch(list, -4) == 5
	}

}
