# My Recipe App

## Overview

This application is designed with a backend-focused architecture, utilizing **Spring Boot 3.1.0** to provide a scalable and efficient platform for managing recipes. The application leverages **JWT authentication** for secure user management and access control.

## Implemented Features

- **Controllers**:
  - **AuthController**: Manages user authentication and registration.
  - **RecipeController**: Handles CRUD operations for recipes and interaction with user submissions.
  - **UserController**: Manages user profile and related functionalities.

- **Services**:
  - **AuthenticationService**: Processes login and registration requests.
  - **RecipeService**: Contains business logic for managing recipe data.
  - **CommentService**: Facilitates comment functionalities on recipes.
  - **UserService**: Manages user data and operations.

- **Models**:
  - **Recipe**: Represents a recipe entity with details such as ingredients and instructions.
  - **User**: Represents a user entity containing user details and roles.
  - **Ingredient**: Represents ingredients used in recipes.
  - **Category**: Defines categories for organizing recipes.
  - **Comment** and **Reply**: Related models for user comments on recipes.
  - **Rating**: Represents user ratings for recipes.
  - **Collection**: Allows users to save favorite recipes.
  - **Meal** and **MealPlan**: Models for meal planning functionalities.
  - **Nutrition**: Handles nutritional information associated with recipes.
  - **Token**: Manages JWT tokens for authenticated sessions.

- **Auth Classes**:
  - **RegisterRequest**: Payload for user registration requests.
  - **AuthenticationRequest**: Payload for user login requests.
  - **AuthenticationResponse**: Response containing authentication status and JWT token.

## Conclusion

This architecture efficiently supports the application's needs, ensuring secure, robust, and user-friendly management of recipes and related functionalities.