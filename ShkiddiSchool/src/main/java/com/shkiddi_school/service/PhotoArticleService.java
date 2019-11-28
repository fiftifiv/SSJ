package com.shkiddi_school.service;

import com.shkiddi_school.domain.PhotoArticle;
import com.shkiddi_school.repos.PhotoArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoArticleService {
    @Autowired
    PhotoArticleRepo photoArticleRepo;

    public void save(PhotoArticle photoArticle){
        photoArticleRepo.save(photoArticle);
    }
}
