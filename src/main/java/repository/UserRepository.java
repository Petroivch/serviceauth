package repository;

import enums.Authorities;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static enums.Authorities.*;

@Repository
public class UserRepository {

    public static final Map<String, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        users.put("admin", new User("admin", "admin", List.of(READ, WRITE, DELETE)));
        users.put("vipUser", new User("client", "client", List.of(READ, WRITE)));
        users.put("user", new User("user", "user", List.of()));
    }

    public List<Authorities> getUserAuthorities(String user) {
        if (users.containsKey(user)) {
            return users.get(user).getAuthorizations();
        } else {
            return null;
        }
    }
    public List<Authorities> getUserAuthoritiesPass(String user, String password) {
        if (users.containsKey(user) && users.get(user).getPassword().equals(password)) {
            return users.get(user).getAuthorizations();
        } else {
            return null;
        }
    }
}