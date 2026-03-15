package com.soncao.myrecipeapp.repository;

import com.soncao.myrecipeapp.model.Rating;
import com.soncao.myrecipeapp.model.Recipe;
import com.soncao.myrecipeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("SELECT AVG(r.value) FROM Rating r WHERE r.recipe = :recipe")
    Double findAverageRatingByRecipe(Recipe recipe);

    Optional<Rating> findByRecipeAndUser(Recipe recipe, User user);
}
