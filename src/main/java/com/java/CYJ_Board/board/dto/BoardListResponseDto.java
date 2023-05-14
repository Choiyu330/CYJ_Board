package com.java.CYJ_Board.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoardListResponseDto {
    private String title;
    private LocalDateTime createdAt;
}
