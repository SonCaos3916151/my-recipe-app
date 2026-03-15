package com.soncao.myrecipeapp.repository;

import com.soncao.myrecipeapp.model.Comment;
import com.soncao.myrecipeapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRecipe(Recipe recipe);
}
