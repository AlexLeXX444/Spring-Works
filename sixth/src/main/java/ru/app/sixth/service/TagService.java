package ru.app.sixth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.sixth.model.Tag;
import ru.app.sixth.repository.TagRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService implements CrudOptions<Tag>{

    private final TagRepository tagRepository;

    @Override
    public Tag create(Tag entity) {
        return tagRepository.save(entity);
    }

    @Override
    public Tag getById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag update(Tag entity) {
        if (tagRepository.existsById(entity.getId())) {
            return tagRepository.save(entity);
        }
        return null;
    }

    @Override
    public Tag deleteById(Long id) {
        Tag tag = tagRepository.findById(id).get();
        if (tagRepository.existsById(id) && !tag.getNotes().isEmpty()) {
            tagRepository.deleteById(id);
            return tag;
        }
        return null;
    }
}
