package com.soncao.myrecipeapp.repository;

import com.soncao.myrecipeapp.model.Collection;
import com.soncao.myrecipeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    List<Collection> findByUser(User user);

    List<Collection> findByUserAndNameContaining(User user, String keyword);
}
