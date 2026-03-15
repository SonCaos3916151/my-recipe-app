package com.soncao.myrecipeapp.repository;

import com.soncao.myrecipeapp.model.MealPlan;
import com.soncao.myrecipeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {
    MealPlan findByUser(User user);
}
