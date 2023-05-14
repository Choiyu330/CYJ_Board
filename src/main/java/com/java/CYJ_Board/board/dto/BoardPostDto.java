package com.java.CYJ_Board.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class BoardPostDto {
    @NotBlank(message = "게시글 제목을 입력해야 합니다")
    private String title;

    @NotBlank(message = "게시글 본문을 입력해야 합니다")
    private String content;
}
