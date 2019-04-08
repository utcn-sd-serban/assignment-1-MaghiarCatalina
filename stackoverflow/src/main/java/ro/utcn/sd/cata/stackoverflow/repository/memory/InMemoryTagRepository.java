package ro.utcn.sd.cata.stackoverflow.repository.memory;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.cata.stackoverflow.entity.Question;
import ro.utcn.sd.cata.stackoverflow.entity.Tag;
import ro.utcn.sd.cata.stackoverflow.repository.TagRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class InMemoryTagRepository implements TagRepository {
    private final Map<Integer, Tag> tagData = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(0);


    public Tag addTag(Tag tag, Question question){
        if (tag.getId() == null) {
            tag.setId(currentId.incrementAndGet());
        }
        tagData.put(tag.getId(), tag);
        question.getTag().add(tag);
        return tag;
    }

    public Optional<Tag> findByName(String name){
        Optional<Tag> found = Optional.empty();
        for(Tag tag: tagData.values()){
            if(tag.getName().equals(name)){
                found = Optional.of(tag);
            }
        }
        return found;
    }

    public Optional<Tag> findById(Integer id){
        return  Optional.ofNullable(tagData.get(id));
    }
}
