package spock;

class UserController {
    UserService userService = new UserService();

    void createUser(String name, String last) {
        User user = userService.createUser(name, last);
    }
}