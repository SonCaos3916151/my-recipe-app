package com.soncao.myrecipeapp.repository;

import com.soncao.myrecipeapp.model.Nutrition;
import com.soncao.myrecipeapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionRepository extends JpaRepository<Nutrition, Long> {
    Nutrition findByRecipe(Recipe recipe);
}
