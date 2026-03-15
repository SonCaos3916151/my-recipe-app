package com.soncao.myrecipeapp.serviceImpl;

import com.soncao.myrecipeapp.dto.CommentAddDTO;
import com.soncao.myrecipeapp.exception.custom.NotFoundException;
import com.soncao.myrecipeapp.model.Comment;
import com.soncao.myrecipeapp.model.Recipe;
import com.soncao.myrecipeapp.model.User;
import com.soncao.myrecipeapp.repository.CommentRepository;
import com.soncao.myrecipeapp.repository.RecipeRepository;
import com.soncao.myrecipeapp.repository.UserRepository;
import com.soncao.myrecipeapp.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, RecipeRepository recipeRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public Comment saveComment(CommentAddDTO commentAddDTO, Long recipeId) {
        // Retrieve the recipe
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new NotFoundException("Recipe not found with id: " + recipeId));

        // Retrieve the user
        User user = userRepository.findById(commentAddDTO.userId())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + commentAddDTO.userId()));

        // Create a new comment
        Comment comment = new Comment();
        comment.setContent(commentAddDTO.content());
        comment.setImage(commentAddDTO.image());
        comment.setDate(new Date());
        comment.setRecipe(recipe);
        comment.setUser(user);

        // Save the comment
        return commentRepository.save(comment);
    }

}
