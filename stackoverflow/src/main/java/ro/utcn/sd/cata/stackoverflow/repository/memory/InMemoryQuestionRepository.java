package ro.utcn.sd.cata.stackoverflow.repository.memory;

import ro.utcn.sd.cata.stackoverflow.entity.Question;
import ro.utcn.sd.cata.stackoverflow.entity.Tag;
import ro.utcn.sd.cata.stackoverflow.repository.QuestionRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryQuestionRepository implements QuestionRepository {

    private Map<Integer,Question> questionData = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(0);

    @Override
    public Question save(Question question) {

        if (question.getId() == null) {
            question.setId(currentId.incrementAndGet());
        }
        questionData.put(question.getId(), question);
        return question;
    }

    @Override
    public List<Question> findAll() {
        return new ArrayList<>(questionData.values());
    }

    @Override
    public void remove(Question question) {
        questionData.remove(question.getId());
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return Optional.ofNullable(questionData.get(id));
    }

    @Override
    public List<Question> findAllOrderByDate() {
        List<Question> questions = new ArrayList<>(questionData.values());
        Collections.reverse(questions);
        return questions;
    }

    public List<Question> findByTitle(String title){
        List<Question> foundQuestions = new ArrayList<>();
        for(Question question: questionData.values()){
            if(question.getTitle().contains(title))
                foundQuestions.add(question);
        }
        return foundQuestions;
    }

    public List<Question> findByTag(Tag tag){
        List<Question> foundQuestions = new ArrayList<>();
        for(Question question: findAll()){
            if(question.getTag().contains(tag)){
                foundQuestions.add(question);
            }
        }
       return foundQuestions;
    }

}
