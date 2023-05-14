package com.java.CYJ_Board.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
