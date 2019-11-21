package com.shkiddi_school.repos;

import com.shkiddi_school.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question,Long> {
}
