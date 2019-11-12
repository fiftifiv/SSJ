package com.shkiddi_school.repos;


import com.shkiddi_school.domain.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article,Long> {
}
