package com.java.CYJ_Board.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RelatedBoardListResponseDto {
    // 연관 게시글 목록 ResponseDto
    private Long relatedId;
    private String title;
}
