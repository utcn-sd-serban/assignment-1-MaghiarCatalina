package ro.utcn.sd.cata.stackoverflow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.cata.stackoverflow.entity.Question;
import ro.utcn.sd.cata.stackoverflow.entity.Tag;
import ro.utcn.sd.cata.stackoverflow.entity.User;
import ro.utcn.sd.cata.stackoverflow.exception.QuestionNotFoundException;
import ro.utcn.sd.cata.stackoverflow.repository.RepositoryFactory;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final RepositoryFactory repositoryFactory;

    @Transactional
    public Question addQuestion(String title, String text, User author){
        return  repositoryFactory.createQuestionRepository().save(new Question(title,text,LocalDateTime.now().toString(),author.getId()));
    }

    @Transactional
    public List<Question> findAllOrderByDate(){
        return  repositoryFactory.createQuestionRepository().findAllOrderByDate();
    }

   @Transactional
   public void remove(int id){
       repositoryFactory.createQuestionRepository().remove(repositoryFactory.createQuestionRepository().findById(id).orElseThrow(QuestionNotFoundException::new));
   }

    @Transactional
    public List<Question> findByTag(Tag tag){
        return repositoryFactory.createQuestionRepository().findByTag(tag);
    }

    @Transactional
    public List<Question> findByTitle(String title){
        return repositoryFactory.createQuestionRepository().findByTitle(title);
    }

}
