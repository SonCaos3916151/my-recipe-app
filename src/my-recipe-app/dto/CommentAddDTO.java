package com.soncao.myrecipeapp.dto;


public record CommentAddDTO(
        String content,
        String image,
        Long userId
) {
}
