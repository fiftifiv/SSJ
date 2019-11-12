package com.shkiddi_school.repos;

import com.shkiddi_school.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
    List<Message> findByAuthor(long idAuthor);

}
