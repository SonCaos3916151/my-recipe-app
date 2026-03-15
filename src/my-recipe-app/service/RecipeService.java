package com.soncao.myrecipeapp.service;

import com.soncao.myrecipeapp.dto.RecipeCreateDTO;
import com.soncao.myrecipeapp.dto.RecipeDTO;
import com.soncao.myrecipeapp.dto.RecipeThumbnailDTO;
import com.soncao.myrecipeapp.model.Category;
import com.soncao.myrecipeapp.model.Recipe;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface RecipeService {
    List<RecipeThumbnailDTO> getRecipesByTitle(String title);

    List<RecipeThumbnailDTO> getRecipesByMaxCookingTime(int maxCookingTime);

    List<RecipeThumbnailDTO> getRecipesByCategories(List<Category> categories);

    List<RecipeThumbnailDTO> getRecipesByIngredient(Long ingredientID);

    List<RecipeThumbnailDTO> getTopRatedRecipes(int limit);

    RecipeDTO getRecipeDtoById(Long recipeId);

    Recipe createRecipe(RecipeCreateDTO recipeCreateDTO, BindingResult bindingResult);

    Recipe updateRecipe(Long recipeId, Map<String, Object> fields);

    void deleteRecipe(Long recipeId);

    void rateRecipe(Long recipeId, Long userId, int rating);

    List<RecipeThumbnailDTO> getUserFavoriteRecipes(Long userId);

    List<RecipeThumbnailDTO> getUserSubmittedRecipes(Long userId);

    List<RecipeThumbnailDTO> getAllRecipes(int limit);
}
