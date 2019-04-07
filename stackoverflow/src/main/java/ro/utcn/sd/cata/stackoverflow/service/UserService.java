package ro.utcn.sd.cata.stackoverflow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.cata.stackoverflow.entity.User;
import ro.utcn.sd.cata.stackoverflow.exception.UserNotFoundException;
import ro.utcn.sd.cata.stackoverflow.repository.RepositoryFactory;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RepositoryFactory repositoryFactory;

    @Transactional
    public User addUser(String username, String password){
        return repositoryFactory.createUserRepository().save(new User(username,password));
    }

    @Transactional
    public void removeUser(Integer id){
        repositoryFactory.createUserRepository().remove(repositoryFactory.createUserRepository().findById(id).orElseThrow(UserNotFoundException::new));
    }

     @Transactional
    public Optional<User> findUserByUsernamePassword(String username, String password){
       return repositoryFactory.createUserRepository().findByUsernameAndPassword(username,password);
    }

}
