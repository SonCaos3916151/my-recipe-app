package com.soncao.myrecipeapp.repository;

import com.soncao.myrecipeapp.model.Ingredient;
import com.soncao.myrecipeapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipesContaining(Recipe recipe);
}
