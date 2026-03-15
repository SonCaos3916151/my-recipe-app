package com.soncao.myrecipeapp.controller;

import com.soncao.myrecipeapp.dto.*;
import com.soncao.myrecipeapp.model.Comment;
import com.soncao.myrecipeapp.model.Recipe;
import com.soncao.myrecipeapp.service.CommentService;
import com.soncao.myrecipeapp.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final CommentService commentService;

    public RecipeController(RecipeService recipeService, CommentService commentService) {
        this.recipeService = recipeService;
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecipeThumbnailDTO>> getAllRecipes(@RequestParam(defaultValue = "10") int limit) {
        List<RecipeThumbnailDTO> recipes = recipeService.getAllRecipes(limit);
        return ResponseEntity.ok(recipes);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createRecipe(@Valid @RequestBody RecipeCreateDTO recipeCreateDTO, BindingResult bindingResult) {
        Recipe createdRecipe = recipeService.createRecipe(recipeCreateDTO, bindingResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<?> getRecipeById(@PathVariable Long recipeId) {
        RecipeDTO recipe = recipeService.getRecipeDtoById(recipeId);
        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/{recipeId}/rate")
    public ResponseEntity<?> addRatingToRecipe(@PathVariable("recipeId") Long recipeId, @RequestParam Long userId, @RequestParam int rating) {
        recipeService.rateRecipe(recipeId, userId, rating);
        return ResponseEntity.ok("Rating added successfully");
    }

    @PostMapping("/{recipeId}/comment")
    public ResponseEntity<?> addCommentToRecipe(@PathVariable("recipeId") Long recipeId, @RequestBody CommentAddDTO commentAddDTO) {
        Comment comment = commentService.saveComment(commentAddDTO, recipeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
