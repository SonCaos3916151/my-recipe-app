package com.soncao.myrecipeapp.repository;

import com.soncao.myrecipeapp.model.Meal;
import com.soncao.myrecipeapp.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByMealPlan(MealPlan mealPlan);

    List<Meal> findByMealPlanAndDateBetween(MealPlan mealPlan, Date startDate, Date endDate);
}
