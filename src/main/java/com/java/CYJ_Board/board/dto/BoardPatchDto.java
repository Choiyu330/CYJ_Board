package com.java.CYJ_Board.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardPatchDto {
    private Long boardId;
    private String title;
    private String content;
}
