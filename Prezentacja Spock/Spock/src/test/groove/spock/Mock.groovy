package spock;

import static org.junit.Assert.*
import spock.lang.*

import org.junit.Test

import spock.User
import spock.UserController
import spock.UserService

class Mock extends spock.lang.Specification{
	
	UserService userService
	UserController userController
	
	def setup() {
		userService = Mock()
		userController = new UserController(userService: userService)
	}
	
	def 'create new User with arguments'(){
		given:
			String name = "Jan"
			String last = "Kowalski"
		
		when:
			userController.createUser(name,last)
		
		then:
			1 * userService.createUser(name, last) >> { String e, String n -> new User(name: e, last: n)}
	}
	
	def 'mock user with arguments'(){
		given:
			String name = "Jan"
			String lastname = "Kowalski"
			User user = new User()
		
		when:
			userController.createUser(name,lastname)
		
		then:
			1 * userService.createUser(name, lastname) >> user
	}
}
