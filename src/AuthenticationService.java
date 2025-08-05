import java.util.ArrayList;
import java.util.Objects;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // TODO Now: Add a constructor to initialize the users list with the default user
    public AuthenticationService() {
        users = new ArrayList<User>();
        users.add(new User("test", "test"));
    }


    // TODO Now: Implement the signUp method to add a new user to the list if the username is not taken and return the user; returns null otherwise
    @Override
    public User signUp(String username, String password) {
        // Check Username
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getUsername(), username)) {
                return null;
            }
        }

        // Add user
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    // TODO Now: Implement the logIn method to return the user if the username and password match, and null otherwise
    @Override
    public User logIn(String username, String password) {
        User tryUser = new User(username, password);
        for (int i = 0; i < users.size(); i++) {
            // Find Username
            if (Objects.equals(users.get(i), tryUser)) {
                return users.get(i);
            }
        }
        return null;
    }
}