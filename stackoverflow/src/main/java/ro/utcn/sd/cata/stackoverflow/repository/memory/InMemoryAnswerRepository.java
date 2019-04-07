package ro.utcn.sd.cata.stackoverflow.repository.memory;

import ro.utcn.sd.cata.stackoverflow.entity.Answer;
import ro.utcn.sd.cata.stackoverflow.entity.Question;
import ro.utcn.sd.cata.stackoverflow.repository.AnswerRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryAnswerRepository implements AnswerRepository {

    private Map<Integer,Answer> answerData = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(0);

    @Override
    public Answer save(Answer answer, Question question) {
        if(answer.getId()==null){
            answer.setId(currentId.incrementAndGet());
        }
        answerData.put(answer.getId(),answer);
        question.getAnswer().add(answer);
        return answer;
    }

    public List<Answer> findByQuestionId(int id){
        List<Answer> foundAnswers = new ArrayList<>();
        for(Answer answer: answerData.values()){
            if(answer.getQuestionId().equals(id)){
                foundAnswers.add(answer);
            }
        }
        return foundAnswers;
    }

    @Override
    public void remove(Answer answer) {
        answerData.remove(answer);
    }

    public Optional<Answer> findById(int id){
        Optional<Answer> found = Optional.empty();
        for(Answer answer: answerData.values()){
            if(answer.getId().equals(id)){
                found = Optional.of(answer);
            }
        }
        return found;
    }

}
