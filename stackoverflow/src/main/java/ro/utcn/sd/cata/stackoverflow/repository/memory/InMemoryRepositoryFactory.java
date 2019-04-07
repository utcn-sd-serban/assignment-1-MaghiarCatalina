package ro.utcn.sd.cata.stackoverflow.repository.memory;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.utcn.sd.cata.stackoverflow.repository.*;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name="stackoverflow.repository-type", havingValue = "MEMORY")
public class InMemoryRepositoryFactory implements RepositoryFactory {

    private final InMemoryUserRepository userRepository = new InMemoryUserRepository();
    private final InMemoryQuestionRepository questionRepository = new InMemoryQuestionRepository();
    private final InMemoryTagRepository tagRepository = new InMemoryTagRepository();
    private final InMemoryAnswerRepository answerRepository = new InMemoryAnswerRepository();

    @Override
    public UserRepository createUserRepository() {
        return userRepository;
    }
    public QuestionRepository createQuestionRepository(){
        return questionRepository;
    }
    public TagRepository createTagRepository(){return tagRepository;}
    public AnswerRepository createAnswerRepository(){return answerRepository;}
}
