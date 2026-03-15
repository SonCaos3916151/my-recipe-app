package com.soncao.myrecipeapp.service;

import com.soncao.myrecipeapp.dto.CommentAddDTO;
import com.soncao.myrecipeapp.model.Comment;

public interface CommentService {
    Comment saveComment(CommentAddDTO commentAddDTO, Long recipeId);
}
