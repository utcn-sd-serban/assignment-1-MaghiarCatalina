package ro.utcn.sd.cata.stackoverflow.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.cata.stackoverflow.entity.User;
import ro.utcn.sd.cata.stackoverflow.repository.RepositoryFactory;
import ro.utcn.sd.cata.stackoverflow.repository.UserRepository;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserSeed implements CommandLineRunner {
    private final RepositoryFactory repositoryFactory;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        UserRepository userRepository = repositoryFactory.createUserRepository();
        if(userRepository.findAll().isEmpty()){
            userRepository.save(new User(1,"Cata","1234"));
        }
    }
}
