package ro.utcn.sd.cata.stackoverflow.repository.memory;

import ro.utcn.sd.cata.stackoverflow.entity.User;
import ro.utcn.sd.cata.stackoverflow.repository.UserRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {
    private final Map<Integer, User> userData = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(0);

    public User save(User user){
        if (user.getId() == null) {
            user.setId(currentId.incrementAndGet());
        }
        userData.put(user.getId(), user);
        return user;
    }

    public List<User> findAll(){
        return new ArrayList<>(userData.values());
    }

    public void remove(User user){
        userData.remove(user.getId());
    }

    public Optional<User> findById(Integer id){
        return Optional.ofNullable(userData.get(id));
    }

    public Optional<User> findByUsernameAndPassword(String username, String password){
        for(User u: userData.values()){
            if(u.getUsername().equals(username) && u.getPassword().equals(password))
                return Optional.of(u);
        }
        return Optional.empty();
    }
}

